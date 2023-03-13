package com.enyu.modules.system.service.mapstruct;

import com.enyu.base.BaseMapper;
import com.enyu.modules.system.domain.Dict;
import com.enyu.modules.system.service.dto.DictDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author 
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictMapper extends BaseMapper<DictDto, Dict> {

}
