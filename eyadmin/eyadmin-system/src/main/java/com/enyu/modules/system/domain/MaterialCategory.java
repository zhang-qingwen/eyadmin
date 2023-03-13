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
package com.enyu.modules.system.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website 
* @description /
* @author Qingwen
* @date 2023-03-13
**/
@Entity
@Data
@Table(name="sys_material_category")
public class MaterialCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`material_category_id`")
    @ApiModelProperty(value = "物料分类编号")
    private Long materialCategoryId;

    @Column(name = "`material_category_name`",unique = true,nullable = false)
    @NotBlank
    @ApiModelProperty(value = "物料分类名称")
    private String materialCategoryName;

    @Column(name = "`material_category_enabled`",nullable = false)
    @NotNull
    @ApiModelProperty(value = "物料分类是否可以使用")
    private Boolean materialCategoryEnabled;

    @Column(name = "`material_category_memo1`")
    @ApiModelProperty(value = "物料分类备注一")
    private String materialCategoryMemo1;

    @Column(name = "`material_category_memo2`")
    @ApiModelProperty(value = "物料分类备注二")
    private String materialCategoryMemo2;

    @Column(name = "`created_by`")
    @ApiModelProperty(value = "创建者")
    private String createdBy;

    @Column(name = "`updated_by`")
    @ApiModelProperty(value = "更新者")
    private String updatedBy;

    @Column(name = "`created_time`")
    @CreationTimestamp
    @ApiModelProperty(value = "创建日期")
    private Timestamp createdTime;

    @Column(name = "`updated_time`")
    @UpdateTimestamp
    @ApiModelProperty(value = "更新时间")
    private Timestamp updatedTime;

    public void copy(MaterialCategory source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
