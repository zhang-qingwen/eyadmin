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
package com.enyu.modules.system.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website 
* @description /
* @author Qingwen
* @date 2023-03-13
**/
@Data
public class MaterialCategoryDto implements Serializable {

    /** 物料分类编号 */
    private Long materialCategoryId;

    /** 物料分类名称 */
    private String materialCategoryName;

    /** 物料分类是否可以使用 */
    private Boolean materialCategoryEnabled;

    /** 物料分类备注一 */
    private String materialCategoryMemo1;

    /** 物料分类备注二 */
    private String materialCategoryMemo2;

    /** 创建者 */
    private String createdBy;

    /** 更新者 */
    private String updatedBy;

    /** 创建日期 */
    private Timestamp createdTime;

    /** 更新时间 */
    private Timestamp updatedTime;
}
