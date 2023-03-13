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
package com.enyu.modules.system.rest;

import com.enyu.annotation.Log;
import com.enyu.modules.system.domain.MaterialCategory;
import com.enyu.modules.system.service.MaterialCategoryService;
import com.enyu.modules.system.service.dto.MaterialCategoryQueryCriteria;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @website 
* @author Qingwen
* @date 2023-03-13
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "materialcategory管理")
@RequestMapping("/api/materialCategory")
public class MaterialCategoryController {

    private final MaterialCategoryService materialCategoryService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('materialCategory:list')")
    public void exportMaterialCategory(HttpServletResponse response, MaterialCategoryQueryCriteria criteria) throws IOException {
        materialCategoryService.download(materialCategoryService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询materialcategory")
    @ApiOperation("查询materialcategory")
    @PreAuthorize("@el.check('materialCategory:list')")
    public ResponseEntity<Object> queryMaterialCategory(MaterialCategoryQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(materialCategoryService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增materialcategory")
    @ApiOperation("新增materialcategory")
    @PreAuthorize("@el.check('materialCategory:add')")
    public ResponseEntity<Object> createMaterialCategory(@Validated @RequestBody MaterialCategory resources){
        return new ResponseEntity<>(materialCategoryService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改materialcategory")
    @ApiOperation("修改materialcategory")
    @PreAuthorize("@el.check('materialCategory:edit')")
    public ResponseEntity<Object> updateMaterialCategory(@Validated @RequestBody MaterialCategory resources){
        materialCategoryService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Log("删除materialcategory")
    @ApiOperation("删除materialcategory")
    @PreAuthorize("@el.check('materialCategory:del')")
    public ResponseEntity<Object> deleteMaterialCategory(@RequestBody Long[] ids) {
        materialCategoryService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
