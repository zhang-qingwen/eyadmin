package com.enyu.modules.system.service.dto;

import lombok.Getter;
import lombok.Setter;
import com.enyu.base.BaseDTO;

import java.io.Serializable;
import java.util.List;

/**
* @author 
* @date 2019-04-10
*/
@Getter
@Setter
public class DictDto extends BaseDTO implements Serializable {

    private Long id;

    private List<DictDetailDto> dictDetails;

    private String name;

    private String description;
}
