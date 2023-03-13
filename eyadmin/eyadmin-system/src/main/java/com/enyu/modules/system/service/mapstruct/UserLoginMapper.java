package com.enyu.modules.system.service.mapstruct;

import com.enyu.base.BaseMapper;
import com.enyu.modules.system.domain.User;
import com.enyu.modules.system.service.dto.UserLoginDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring",uses = {RoleMapper.class, DeptMapper.class, JobMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserLoginMapper extends BaseMapper<UserLoginDto, User> {
}
