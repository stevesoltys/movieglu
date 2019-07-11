package com.stevesoltys.movieglu.model.nowshowing;

import com.stevesoltys.movieglu.model.MoviegluResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Steve Soltys
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NowShowingResponse extends MoviegluResponse {

    private List<NowShowingFilm> films;
}
