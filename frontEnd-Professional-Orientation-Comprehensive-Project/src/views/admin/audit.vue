<template>
    <div>
         <el-form :model="queryParams" ref="queryForm"  size="small" :inline="true"  label-width="68px">
             <el-form-item label="审核状态" prop="status">
                 <el-select v-model="queryParams.status" placeholder="请选择">
                     <el-option label="未审核" value="2"></el-option>
                     <el-option label="审核通过" value="0"></el-option>
                     <el-option label="审核未通过" value="1"></el-option>
                    </el-select>
            </el-form-item>
            <!-- <el-form-item label="时间范围" prop="dateRange">
                <el-date-picker
                v-model="queryParams.dateRange"
                style="width: 240px"
                value-format="yyyy-MM-dd"
                type="daterange"
                range-separator="-"
                start-placeholder="开始日期"
                end-placeholder="结束日期"
                ></el-date-picker>
            </el-form-item> -->
            <el-form-item label="用户id" prop="apubAuthorId">
                <el-input
                v-model="queryParams.apubAuthorId"
                placeholder="请输入用户id"
                clearable
                @keyup.enter.native="handleQuery"
                />
            </el-form-item>
            <el-form-item label="音乐id" prop="audioId">
                <el-input
                v-model="queryParams.audioId"
                placeholder="请输入音乐id"
                clearable
                @keyup.enter.native="handleQuery"
                />
            </el-form-item>
            <el-form-item label="音乐名称" prop="audioName">
                <el-input
                v-model="queryParams.audioName"
                placeholder="请输入音乐名称"
                clearable
                @keyup.enter.native="handleQuery"
                />
            </el-form-item>
            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
            </el-form-item>
         </el-form>

         <el-table v-loading="loading" :data="dataList">
      <!-- <el-table-column type="selection" width="55" align="center" /> -->
      <el-table-column label="音乐id"  width="70" align="center" prop="audioId" />
      <el-table-column label="音乐名称" align="center" prop="audioName" :show-overflow-tooltip="true" />
      <el-table-column label="作者id" align="center" prop="apubAuthorId" />
      <el-table-column label="审核状态" align="center" prop="status">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.status==2" type="warning">未审核</el-tag>
        <el-tag v-if="scope.row.status==0" type="success">通过</el-tag>
        <el-tag v-if="scope.row.status==1" type="danger">未通过</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="审核意见" align="center" prop="comment" :show-overflow-tooltip="true" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center"  width="280">
        <template slot-scope="scope">
            <el-button
            size="mini"
            @click="toDetail(scope.row)"
          >详情</el-button>
          <el-button
            size="mini"
            type="success"
            :disabled="scope.row.status==0"
            @click="handleUpdate(scope.row,0)"
          >通过</el-button>
          <el-button
            size="mini"
            type="danger"
            :disabled="scope.row.status==1"
            @click="handleUpdate(scope.row,1)"
          >驳回</el-button>
          <el-button
            size="mini"
            type="warning"
            @click="handleDelete(scope.row.audioId)"
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
    <el-dialog :title="currentAudio[0].name" :visible.sync="dialog_detail" width="780px" append-to-body>
      <aplayer :audio="currentAudio"></aplayer>
        <div style="width:100%;margin:30px 0px;">
            {{currentAudio[0].des}}
        </div>
        
         <div slot="footer" class="dialog-footer">
        <!-- <el-button type="primary" @click="submitForm()">确 定</el-button> -->
        <el-button @click="cancel">返 回</el-button>
      </div>
    </el-dialog>
    <el-dialog :title="currentAudio[0].name" :visible.sync="dialog_comment" width="780px" append-to-body>
      <el-input
        type="textarea"
        :autosize="{ minRows: 2, maxRows: 6}"
        placeholder="请输入审核意见"
        v-model="comment">
      </el-input>
      <div slot="footer" class="dialog-footer">
        <el-button v-if="attitude==0" type="success" @click="submitForm">通 过</el-button>
        <el-button v-else type="danger" @click="submitForm">驳 回</el-button>
        <el-button @click="cancel_comment">取 消</el-button>
      </div>
      </el-dialog>
    </div>
</template>

<script>
import APlayer from '@moefe/vue-aplayer';
import Pagination from "@/components/Pagination"
export default {
    components: { APlayer ,'pagination':Pagination,},
   
    data(){
        return{
          auditAudio:'',
            queryParams: {
                current: 1,
                size: 10,
                apubAuthorId: undefined,
                audioId: undefined,
                audioName: undefined,

            },
            loading: false,
            dataList:[
                {audioId:'1',
                audioName:'冥想者',
                length:'2:30',
                apubAuthorId:'123',
                authorName:'李佳颖',
                status:'1',
                comment:'通过',
                createTime:'2070-01-01 17:27:23',
                url: 'http://downsc.chinaz.net/Files/DownLoad/sound1/201906/11582.mp3',
                des:'路飞躺在在三角钢琴上，枕着脑袋，望着天花板，静静的听布鲁克弹唱这首歌，歌声结束时候路飞说“来我的船上吧”布鲁克没有任何犹豫回答了“好”。',
                img_url:'https://tse1-mm.cn.bing.net/th/id/R-C.f65e69d0e798cd7d560ac05e1364ee40?rik=RAYCqHwEZBONHA&riu=http%3a%2f%2fimage.bamen.bbs.bamenzhushou.com%2fe6ac0b28-cadc-4ed2-9daa-cd5237c41381.jpg&ehk=9QIlZ6kR%2fZG2uS6UhrKgfekc%2f9r1H%2foqaM4%2bE71COX8%3d&risl=&pid=ImgRaw&r=0'
                },
                {audioId:'2',
                audioName:'懂得都懂',
                length:'2:30',
                apubAuthorId:'123',
                authorName:'李佳颖',
                status:'0',
                comment:'含暴力片段',
                createTime:'2070-01-02 17:27:23',
                url: 'http://downsc.chinaz.net/Files/DownLoad/sound1/201906/11582.mp3',
                des:'路飞躺在在三角钢琴上，枕着脑袋，望着天花板，静静的听布鲁克弹唱这首歌，歌声结束时候路飞说“来我的船上吧”布鲁克没有任何犹豫回答了“好”。',
                img_url:'https://tse1-mm.cn.bing.net/th/id/R-C.f65e69d0e798cd7d560ac05e1364ee40?rik=RAYCqHwEZBONHA&riu=http%3a%2f%2fimage.bamen.bbs.bamenzhushou.com%2fe6ac0b28-cadc-4ed2-9daa-cd5237c41381.jpg&ehk=9QIlZ6kR%2fZG2uS6UhrKgfekc%2f9r1H%2foqaM4%2bE71COX8%3d&risl=&pid=ImgRaw&r=0'
                },
            ],
            currentAudio:[
              {name: '',
              artist: '',
              url: '',
              cover: '', // prettier-ignore
              lrc: '',}
            ],
            dialog_detail:false,
            dialog_comment:false,
            comment:'',
            attitude:'',
        }
    },
    created(){
      this.getList();
    },
    methods:{
      getList() {
      // this.loading = true;
      let params=this.queryParams;
      this.$axios.get("http://localhost:9003/audioPublic",{params})
      .then(res=>{
        this.dataList=res.data.data.records;
        this.total = res.data.data.total;
      })
      },
        toDetail(audio){
          
            this.currentAudio[0].artist=audio.apubAuthorId;
            this.currentAudio.id=audio.audioId;
            this.currentAudio[0].name=audio.audioName;
            this.currentAudio[0].cover=audio.imgUrl;
            this.currentAudio[0].url=audio.audioUrl;
            this.currentAudio[0].des=audio.des;
            // console.log(this.currentAudio)
            this.dialog_detail=true;
        },
        cancel() {
          this.dialog_detail = false;
          // this.reset();
        },
        cancel_comment(){
          this.dialog_comment = false;
        },
         resetQuery() {
          this.resetForm("queryForm");
          this.handleQuery();
        },
        handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
         handleUpdate(audio,attitude) {
           this.auditAudio=audio;
           this.currentAudio[0].artist=audio.authorName;
            this.currentAudio.id=audio.audioId;
            this.currentAudio[0].name=audio.audioName;
            this.currentAudio[0].cover=audio.img_url;
            this.currentAudio[0].url=audio.url;
            this.currentAudio[0].des=audio.des;
           this.attitude=attitude;
           this.dialog_comment=true;

          // this.reset();
          // const noticeId = row.noticeId || this.ids
          // getNotice(noticeId).then(response => {
          //   this.form = response.data;
          //   this.open = true;
          //   this.title = "修改公告";
          // });
    },
    /** 提交按钮 */
    submitForm() {
      console.log(this.auditAudio);
      var updateAudio=this.auditAudio;
      updateAudio.comment=this.comment;
          if (this.attitude==0) {//通过
          updateAudio.status=0;//通过
          this.$axios.put("http://localhost:9003/audioPublic",updateAudio)
          .then(response => {
              this.$message({
                  message: "通过成功",
                  type: "success",
              });
              this.dialog_comment = false;
              this.getList();
            })
            .catch(res=>{
              this.$message.error("通过失败");
              this.dialog_comment = false;
            })
            // updateNotice(this.form).then(response => {
            //   this.$modal.msgSuccess("修改成功");
            //   this.open = false;
            //   this.getList();
            // });
          } else if(this.attitude==1){//驳回
          updateAudio.status=1;//驳回
          this.$axios.put("http://localhost:9003/audioPublic",updateAudio)
          .then(response => {
              this.$message({
                  message: "驳回成功",
                  type: "success",
              });
              this.dialog_comment = false;
              this.getList();
            })
            .catch(res=>{
              this.$message.error("驳回失败");
              this.dialog_comment = false;
            })
            // addNotice(this.form).then(response => {
            //   this.$modal.msgSuccess("新增成功");
            //   this.open = false;
            //   this.getList();
            // });
          }
        
     
    },
    /** 删除按钮操作 */
    handleDelete(id) {
      this.$axios.delete("http://localhost:9003/audioPublic?idList="+id)
      .then((res)=>{
        this.$message({
                    message: "删除成功",
                    type: "success",
        });
        this.getList();
      })
      .catch(() => {this.$message.error("删除失败");});
        
     
      // const noticeIds = row.noticeId || this.ids
      // this.$modal.confirm('是否确认删除公告编号为"' + noticeIds + '"的数据项？').then(function() {
      //   return delNotice(noticeIds);
      // }).then(() => {
      //   this.getList();
      //   this.$modal.msgSuccess("删除成功");
      // }).catch(() => {});
    }
  
    }
}
</script>