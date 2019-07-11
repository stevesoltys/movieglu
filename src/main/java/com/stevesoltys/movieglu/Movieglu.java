package com.stevesoltys.movieglu;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.stevesoltys.movieglu.model.MoviegluResponse;
import com.stevesoltys.movieglu.model.nowshowing.NowShowingResponse;
import com.stevesoltys.movieglu.net.MoviegluService;
import lombok.Builder;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

/**
 * @author Steve Soltys
 */
public class Movieglu {

    private static final String API_VERSION = "v200";

    private final MoviegluService moviegluService;

    @Builder
    public Movieglu(@NonNull String apiEndpoint, @NonNull String username, @NonNull String apiKey,
                    @NonNull String territory, @NonNull String deviceDateTime, @NonNull String authorization) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiEndpoint)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .client(buildHttpClient(username, apiKey, territory, deviceDateTime, authorization))
                .build();

        moviegluService = retrofit.create(MoviegluService.class);
    }

    /**
     * Builds the HTTP client.
     */
    private OkHttpClient buildHttpClient(String username, String apiKey, String territory, String deviceTime,
                                         String authorization){

        return new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .addHeader("client", username)
                            .addHeader("x-api-key", apiKey)
                            .addHeader("territory", territory)
                            .addHeader("device-datetime", deviceTime)
                            .addHeader("Authorization", authorization)
                            .addHeader("api-version", API_VERSION)
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                })
                .build();
    }

    /**
     * Gets films now playing in theatres.
     * <p>
     * {@see https://developer.movieglu.com/v2/api-index/filmsnowshowing/}
     *
     * @param count The number to return.
     * @return The now showing response.
     */
    public NowShowingResponse getNowShowing(int count) {
        return execute(moviegluService.getNowShowing(count));
    }

    /**
     * Executes a retrofit call.
     *
     * @param call The call.
     * @param <T>  The response type.
     * @return The response.
     * @throws MoviegluException If an error occurs.
     */
    private <T extends MoviegluResponse> T execute(Call<T> call) throws MoviegluException {
        Response<T> response;

        try {
            response = call.execute();

        } catch (IOException e) {
            throw new MoviegluException(e);
        }

        if (response.isSuccessful()) {
            return response.body();

        } else {
            throw new MoviegluException(response);
        }
    }
}
