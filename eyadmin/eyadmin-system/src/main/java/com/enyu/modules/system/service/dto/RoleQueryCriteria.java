package com.enyu.modules.system.service.dto;

import lombok.Data;
import com.enyu.annotation.Query;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author
 * 公共查询类
 */
@Data
public class RoleQueryCriteria {

    @Query(blurry = "name,description")
    private String blurry;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
