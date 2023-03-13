package com.enyu.service.dto;

import lombok.Data;
import com.enyu.annotation.Query;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author
 * @date 2019-6-4 09:54:37
 */
@Data
public class QiniuQueryCriteria{

    @Query(type = Query.Type.INNER_LIKE)
    private String key;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
