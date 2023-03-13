package com.enyu.service.dto;

import lombok.Data;
import com.enyu.annotation.Query;

import java.sql.Timestamp;
import java.util.List;

/**
* @author 
* @date 2019-09-05
*/
@Data
public class LocalStorageQueryCriteria{

    @Query(blurry = "name,suffix,type,createBy,size")
    private String blurry;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
