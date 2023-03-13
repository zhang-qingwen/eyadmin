package com.enyu.modules.system.service.mapstruct;

import com.enyu.base.BaseMapper;
import com.enyu.modules.system.domain.Job;
import com.enyu.modules.system.service.dto.JobDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author 
* @date 2019-03-29
*/
@Mapper(componentModel = "spring",uses = {DeptMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobMapper extends BaseMapper<JobDto, Job> {
}
