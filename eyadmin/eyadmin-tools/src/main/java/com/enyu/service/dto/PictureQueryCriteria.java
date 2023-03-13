package com.enyu.service.dto;

import lombok.Data;
import com.enyu.annotation.Query;

import java.sql.Timestamp;
import java.util.List;

/**
 * sm.ms图床
 *
 * @author
 * @date 2019-6-4 09:52:09
 */
@Data
public class PictureQueryCriteria{

    @Query(type = Query.Type.INNER_LIKE)
    private String filename;

    @Query(type = Query.Type.INNER_LIKE)
    private String username;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
