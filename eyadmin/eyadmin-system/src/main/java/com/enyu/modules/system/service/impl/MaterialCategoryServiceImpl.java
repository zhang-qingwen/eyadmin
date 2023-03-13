/*
*  Copyright 2019-2020 Zheng Jie
*
*  Licensed under the Apache License, Version 2.0 (the "License");
*  you may not use this file except in compliance with the License.
*  You may obtain a copy of the License at
*
*  http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software
*  distributed under the License is distributed on an "AS IS" BASIS,
*  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  See the License for the specific language governing permissions and
*  limitations under the License.
*/
package com.enyu.modules.system.service.impl;

import com.enyu.modules.system.domain.MaterialCategory;
import com.enyu.exception.EntityExistException;
import com.enyu.utils.ValidationUtil;
import com.enyu.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import com.enyu.modules.system.repository.MaterialCategoryRepository;
import com.enyu.modules.system.service.MaterialCategoryService;
import com.enyu.modules.system.service.dto.MaterialCategoryDto;
import com.enyu.modules.system.service.dto.MaterialCategoryQueryCriteria;
import com.enyu.modules.system.service.mapstruct.MaterialCategoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.enyu.utils.PageUtil;
import com.enyu.utils.QueryHelp;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
* @website 
* @description 服务实现
* @author Qingwen
* @date 2023-03-13
**/
@Service
@RequiredArgsConstructor
public class MaterialCategoryServiceImpl implements MaterialCategoryService {

    private final MaterialCategoryRepository materialCategoryRepository;
    private final MaterialCategoryMapper materialCategoryMapper;

    @Override
    public Map<String,Object> queryAll(MaterialCategoryQueryCriteria criteria, Pageable pageable){
        Page<MaterialCategory> page = materialCategoryRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(materialCategoryMapper::toDto));
    }

    @Override
    public List<MaterialCategoryDto> queryAll(MaterialCategoryQueryCriteria criteria){
        return materialCategoryMapper.toDto(materialCategoryRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public MaterialCategoryDto findById(Long materialCategoryId) {
        MaterialCategory materialCategory = materialCategoryRepository.findById(materialCategoryId).orElseGet(MaterialCategory::new);
        ValidationUtil.isNull(materialCategory.getMaterialCategoryId(),"MaterialCategory","materialCategoryId",materialCategoryId);
        return materialCategoryMapper.toDto(materialCategory);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MaterialCategoryDto create(MaterialCategory resources) {
        if(materialCategoryRepository.findByMaterialCategoryName(resources.getMaterialCategoryName()) != null){
            throw new EntityExistException(MaterialCategory.class,"material_category_name",resources.getMaterialCategoryName());
        }
        return materialCategoryMapper.toDto(materialCategoryRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(MaterialCategory resources) {
        MaterialCategory materialCategory = materialCategoryRepository.findById(resources.getMaterialCategoryId()).orElseGet(MaterialCategory::new);
        ValidationUtil.isNull( materialCategory.getMaterialCategoryId(),"MaterialCategory","id",resources.getMaterialCategoryId());
        MaterialCategory materialCategory1 = null;
        materialCategory1 = materialCategoryRepository.findByMaterialCategoryName(resources.getMaterialCategoryName());
        if(materialCategory1 != null && !materialCategory1.getMaterialCategoryId().equals(materialCategory.getMaterialCategoryId())){
            throw new EntityExistException(MaterialCategory.class,"material_category_name",resources.getMaterialCategoryName());
        }
        materialCategory.copy(resources);
        materialCategoryRepository.save(materialCategory);
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long materialCategoryId : ids) {
            materialCategoryRepository.deleteById(materialCategoryId);
        }
    }

    @Override
    public void download(List<MaterialCategoryDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (MaterialCategoryDto materialCategory : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("物料分类名称", materialCategory.getMaterialCategoryName());
            map.put("物料分类是否可以使用", materialCategory.getMaterialCategoryEnabled());
            map.put("物料分类备注一", materialCategory.getMaterialCategoryMemo1());
            map.put("物料分类备注二", materialCategory.getMaterialCategoryMemo2());
            map.put("创建者", materialCategory.getCreatedBy());
            map.put("更新者", materialCategory.getUpdatedBy());
            map.put("创建日期", materialCategory.getCreatedTime());
            map.put("更新时间", materialCategory.getUpdatedTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}
