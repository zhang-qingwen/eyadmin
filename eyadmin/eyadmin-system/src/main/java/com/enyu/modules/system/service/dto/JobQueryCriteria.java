package com.enyu.modules.system.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.enyu.annotation.Query;

import java.sql.Timestamp;
import java.util.List;

/**
* @author
* @date 2019-6-4 14:49:34
*/
@Data
@NoArgsConstructor
public class JobQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    @Query
    private Boolean enabled;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
