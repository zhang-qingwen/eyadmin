package com.enyu.modules.system.service.dto;

import lombok.Data;
import com.enyu.annotation.Query;

/**
 * @author
 * 公共查询类
 */
@Data
public class DictQueryCriteria {

    @Query(blurry = "name,description")
    private String blurry;
}
