<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="公告标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入公告标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="操作人员" prop="createBy">
        <el-input
          v-model="queryParams.createBy"
          placeholder="请输入操作人员"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <!-- <el-form-item label="类型" prop="noticeType">
        <el-select v-model="queryParams.noticeType" placeholder="公告类型" clearable>
          <el-option
            v-for="dict in dict.type.sys_notice_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item> -->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
        >删除</el-button>
      </el-col>
      <!-- <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar> -->
    </el-row>

    <el-table v-loading="loading" :data="noticeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="announceId" width="80" />
      <el-table-column
        label="公告标题"
        align="center"
        prop="title"
        width="280"
        :show-overflow-tooltip="true"
      />
      <!-- <el-table-column label="公告类型" align="center" prop="noticeType" width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_notice_type" :value="scope.row.noticeType"/>
        </template>
      </el-table-column> -->
      <!-- <el-table-column label="状态" align="center" prop="status" width="100">
        <template slot-scope="scope">
        <el-tag v-if="scope.row.status==0" type="danger">关闭</el-tag>
        <el-tag v-if="scope.row.status==1" type="success">正常</el-tag>
        </template> -->
        <!-- <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_notice_status" :value="scope.row.status"/>
        </template> -->
      <!-- </el-table-column> -->
      <!-- <el-table-column label="创建者" align="center" prop="createBy" width="100" /> -->
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.current"
      :limit.sync="queryParams.size"
      @pagination="getList"
    />
    <!-- <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    /> -->

    <!-- 添加或修改公告对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="780px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="公告标题" prop="title" required="">
              <el-input v-model="form.title" placeholder="请输入公告标题" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <!-- <el-form-item label="公告类型" prop="noticeType">
              <el-select v-model="form.noticeType" placeholder="请选择公告类型">
                <el-option
                  v-for="dict in dict.type.sys_notice_type"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item> -->
          </el-col>
          <!-- <el-col :span="24"> -->
            <!-- <el-form-item label="状态"> -->
              <!-- <el-radio-group v-model="form.status">
                <el-radio label="正常">正常</el-radio>
                <el-radio label="关闭">关闭</el-radio> -->
                <!-- <el-radio
                  v-for="dict in dict.type.sys_notice_status"
                  :key="dict.value"
                  :label="dict.value"
                >{{dict.label}}</el-radio> -->
              <!-- </el-radio-group> -->
            <!-- </el-form-item> -->
          <!-- </el-col> -->
          <el-col :span="24">
            <el-form-item label="内容">
              <el-input
                type="textarea"
                :rows="10"
                placeholder="请输入内容"
                v-model="form.content">
              </el-input>
              <!-- <editor v-model="form.content" :min-height="192"/> -->
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>

import Editor from "@/components/Editor"
import Pagination from "@/components/Pagination"
import qs from 'qs'
export default {
  name: "Notice",
  components:{
    'editor':Editor,
    'pagination':Pagination,
  },
  dicts: ['sys_notice_status', 'sys_notice_type'],
  data() {
    return {
      // 遮罩层
      loading: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 公告表格数据
      noticeList: [
        {
          createBy: "admin",
          createTime: "2021-09-09 17:27:23",
          noticeContent: "新版本内容",
          announceId: 1,
          noticeTitle: "温馨提醒：2018-07-01 新版本发布啦",
          params: {},
          remark: "管理员",
          searchValue: null,
          status: "1",
          updateBy: "",
          updateTime: null},
          {
          createBy: "admin",
          createTime: "2021-09-09 19:27:23",
          noticeContent: "好消息",
          announceId: 2,
          noticeTitle: "好消息，好消息！",
          params: {},
          remark: "管理员",
          searchValue: null,
          status: "1",
          updateBy: "",
          updateTime: null},
      ],//noticeType: "2"
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        current: 1,
        size: 10,
        title: undefined,

      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        title: [
          { required: true, message: "公告标题不能为空", trigger: "blur" }
        ],
       
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询公告列表 */
    getList() {
      // this.loading = true;
      var params=this.queryParams;

      this.$axios.get("http://localhost:9003/announce",{params})
      .then(res=>{
        this.noticeList=res.data.data.records;
        this.total = res.data.data.total;
      })
      
      // listNotice(this.queryParams).then(response => {
      //   this.noticeList = response.rows;
      //   this.total = response.total;
      //   this.loading = false;
      // });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        announceId: undefined,
        title: undefined,
        content: undefined,
      };
      // this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.announceId)
      this.single = selection.length!=1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加公告";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.open = true;
      this.$axios.get("http://localhost:9003/announce/"+row.announceId)
      .then(res=>{
        this.form = res.data.data;
      })
      // const announceId = row.announceId || this.ids
      const announceId = row.announceId
      // getNotice(announceId).then(response => {
      //   this.form = response.data;
      //   this.open = true;
      //   this.title = "修改公告";
      // });
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.announceId != undefined) {//修改
            this.$axios.put("http://localhost:9003/announce",this.form)
            .then(response => {
              this.$message({
                  message: "修改成功",
                  type: "success",
              });
              this.open = false;
              this.getList();
            })
            .catch(res=>{
              this.$message.error("修改失败");
            })
          } else {
             this.$axios.post("http://localhost:9003/announce",this.form)
            .then(response => {
              this.$message({
                  message: "新增成功",
                  type: "success",
              });
              this.open = false;
              this.getList();
            })
            .catch(res=>{
              this.$message.error("新增失败");
            })
            
            // addNotice(this.form).then(response => {
            //   this.$modal.msgSuccess("新增成功");
            //   this.open = false;
            //   this.getList();
            // });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      
      var list=[];
      if(row.announceId != undefined){//单条
        list.push(row.announceId);
      }
      else list=this.ids
      const announceIds = row.announceId || this.ids
      console.log(list)
      let params={
        "idList":list
      }
      this.$confirm('是否确认删除公告编号为"' + announceIds + '"的数据项？').then(res=> {
     this.$axios.delete("http://localhost:9003/announce",
     {params,paramsSerializer: params => {
      return qs.stringify(params, { indices: false })
    }})
     .then(res=>{
       this.$message({
                  message: "删除成功",
                  type: "success",
              });
              this.getList();
     })
     .catch(res=>{
              this.$message.error("删除失败");
            })
      })
    
    }
  }
}
</script>
