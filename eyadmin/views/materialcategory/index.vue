<template>
  <div class="app-container">
    <!--工具栏-->
    <div class="head-container">
      <div v-if="crud.props.searchToggle">
        <!-- 搜索 -->
        <label class="el-form-item-label">物料分类名称</label>
        <el-input v-model="query.materialCategoryName" clearable placeholder="物料分类名称" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">物料分类备注一</label>
        <el-input v-model="query.materialCategoryMemo1" clearable placeholder="物料分类备注一" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">物料分类备注二</label>
        <el-input v-model="query.materialCategoryMemo2" clearable placeholder="物料分类备注二" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">创建者</label>
        <el-input v-model="query.createdBy" clearable placeholder="创建者" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">更新者</label>
        <el-input v-model="query.updatedBy" clearable placeholder="更新者" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <rrOperation :crud="crud" />
      </div>
      <!--如果想在工具栏加入更多按钮，可以使用插槽方式， slot = 'left' or 'right'-->
      <crudOperation :permission="permission" />
      <!--表单组件-->
      <el-dialog :close-on-click-modal="false" :before-close="crud.cancelCU" :visible.sync="crud.status.cu > 0" :title="crud.status.title" width="500px">
        <el-form ref="form" :model="form" :rules="rules" size="small" label-width="80px">
          <el-form-item label="物料分类名称" prop="materialCategoryName">
            <el-input v-model="form.materialCategoryName" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="物料分类是否可以使用" prop="materialCategoryEnabled">
            <el-radio v-model="form.materialCategoryEnabled" v-for="item in dict.cate_status" :key="item.id" :label="item.value">{{ item.label }}</el-radio>
          </el-form-item>
          <el-form-item label="物料分类备注一">
            <el-input v-model="form.materialCategoryMemo1" :rows="3" type="textarea" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="物料分类备注二">
            <el-input v-model="form.materialCategoryMemo2" :rows="3" type="textarea" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="创建者">
            <el-input v-model="form.createdBy" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="更新者">
            <el-input v-model="form.updatedBy" style="width: 370px;" />
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="text" @click="crud.cancelCU">取消</el-button>
          <el-button :loading="crud.status.cu === 2" type="primary" @click="crud.submitCU">确认</el-button>
        </div>
      </el-dialog>
      <!--表格渲染-->
      <el-table ref="table" v-loading="crud.loading" :data="crud.data" size="small" style="width: 100%;" @selection-change="crud.selectionChangeHandler">
        <el-table-column type="selection" width="55" />
        <el-table-column prop="materialCategoryId" label="物料分类编号" />
        <el-table-column prop="materialCategoryName" label="物料分类名称" />
        <el-table-column prop="materialCategoryEnabled" label="物料分类是否可以使用">
          <template slot-scope="scope">
            {{ dict.label.cate_status[scope.row.materialCategoryEnabled] }}
          </template>
        </el-table-column>
        <el-table-column prop="materialCategoryMemo1" label="物料分类备注一" />
        <el-table-column prop="materialCategoryMemo2" label="物料分类备注二" />
        <el-table-column prop="createdBy" label="创建者" />
        <el-table-column prop="updatedBy" label="更新者" />
        <el-table-column prop="createdTime" label="创建日期" />
        <el-table-column prop="updatedTime" label="更新时间" />
        <el-table-column v-if="checkPer(['admin','materialCategory:edit','materialCategory:del'])" label="操作" width="150px" align="center">
          <template slot-scope="scope">
            <udOperation
              :data="scope.row"
              :permission="permission"
            />
          </template>
        </el-table-column>
      </el-table>
      <!--分页组件-->
      <pagination />
    </div>
  </div>
</template>

<script>
import crudMaterialCategory from '@/api/materialCategory'
import CRUD, { presenter, header, form, crud } from '@crud/crud'
import rrOperation from '@crud/RR.operation'
import crudOperation from '@crud/CRUD.operation'
import udOperation from '@crud/UD.operation'
import pagination from '@crud/Pagination'

const defaultForm = { materialCategoryId: null, materialCategoryName: null, materialCategoryEnabled: null, materialCategoryMemo1: null, materialCategoryMemo2: null, createdBy: null, updatedBy: null, createdTime: null, updatedTime: null }
export default {
  name: 'MaterialCategory',
  components: { pagination, crudOperation, rrOperation, udOperation },
  mixins: [presenter(), header(), form(defaultForm), crud()],
  dicts: ['cate_status'],
  cruds() {
    return CRUD({ title: 'materialcategory', url: 'api/materialCategory', idField: 'materialCategoryId', sort: 'materialCategoryId,desc', crudMethod: { ...crudMaterialCategory }})
  },
  data() {
    return {
      permission: {
        add: ['admin', 'materialCategory:add'],
        edit: ['admin', 'materialCategory:edit'],
        del: ['admin', 'materialCategory:del']
      },
      rules: {
        materialCategoryName: [
          { required: true, message: '物料分类名称不能为空', trigger: 'blur' }
        ],
        materialCategoryEnabled: [
          { required: true, message: '物料分类是否可以使用不能为空', trigger: 'blur' }
        ]
      },
      queryTypeOptions: [
        { key: 'materialCategoryName', display_name: '物料分类名称' },
        { key: 'materialCategoryMemo1', display_name: '物料分类备注一' },
        { key: 'materialCategoryMemo2', display_name: '物料分类备注二' },
        { key: 'createdBy', display_name: '创建者' },
        { key: 'updatedBy', display_name: '更新者' }
      ]
    }
  },
  methods: {
    // 钩子：在获取表格数据之前执行，false 则代表不获取数据
    [CRUD.HOOK.beforeRefresh]() {
      return true
    }
  }
}
</script>

<style scoped>

</style>
