package com.stevesoltys.movieglu.net;

import com.stevesoltys.movieglu.model.nowshowing.NowShowingResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Steve Soltys
 */
public interface MoviegluService {

    @GET("filmsNowShowing/")
    Call<NowShowingResponse> getNowShowing(@Query("n") int count);

}
