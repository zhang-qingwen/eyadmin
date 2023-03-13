package com.enyu.service.mapstruct;

import com.enyu.base.BaseMapper;
import com.enyu.domain.LocalStorage;
import com.enyu.service.dto.LocalStorageDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author 
* @date 2019-09-05
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocalStorageMapper extends BaseMapper<LocalStorageDto, LocalStorage> {

}
