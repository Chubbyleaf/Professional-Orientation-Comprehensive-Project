<template>
    <div>
        <div class="search">
            <span style="font-size:15px;width:80px;margin-top:10px;">标签名称</span>
            
            <el-input placeholder="请输入标签标题" style="width:70%;" v-model="search" clearable="true">

            </el-input>
            <el-button slot="append" icon="el-icon-search" @click="searchByName()"></el-button>
        </div>
        <el-tag
            :key="tag.tagId"
            v-for="tag in dynamicTags"
            closable
            :disable-transitions="false"
            @close="handleClose(tag)">
            {{tag.tagName}}
            </el-tag>
            <el-input
            class="input-new-tag"
            v-if="inputVisible"
            v-model="inputValue"
            ref="saveTagInput"
            size="small"
            @keyup.enter.native="handleInputConfirm"
            @blur="handleInputConfirm"
            >
            </el-input>
            <el-button v-else class="button-new-tag" size="small" @click="showInput">+ New Tag</el-button>

                </div>
</template>

<style>
.search{
display: flex;
width: 100%;
/* height: 80px; */
padding: 10px 20px;;
}
.el-tag + .el-tag {
margin-left: 10px;
}
.button-new-tag {
margin-left: 10px;
height: 32px;
line-height: 30px;
padding-top: 0;
padding-bottom: 0;
}
.input-new-tag {
width: 90px;
margin-left: 10px;
vertical-align: bottom;
}
</style>

<script>
  export default {
    data() {
      return {
        search:'',
        dynamicTags: [],
        inputVisible: false,
        inputValue: ''
      };
    },
    methods: {
        getList(){
        this.$axios.get("http://localhost:9003/tag?tagName="+this.search)
        .then(res=>{
            this.dynamicTags=res.data.data.records;
        })
        },
        searchByName(){
            this.getList();
        },
      handleClose(tag) {
          this.$axios.delete("http://localhost:9003/tag?idList="+tag.tagId)
          .then(()=>{
              this.$message({
                  message: "删除成功",
                  type: "success",
              });
              this.getList();
          })
          .catch(()=>{
              this.$message.error("删除失败");
            })
      
      },

      showInput() {
        this.inputVisible = true;
        this.$nextTick(_ => {
          this.$refs.saveTagInput.$refs.input.focus();
        });
      },

      handleInputConfirm() {
        let inputValue = this.inputValue;
        if (inputValue) {
            let params={"tagName":inputValue};
            this.$axios.post("http://localhost:9003/tag",params)
            .then(()=>{
              this.$message({
                  message: "新增成功",
                  type: "success",
              });
              this.getList();
          })
          .catch(()=>{
              this.$message.error("新增失败");
            })

          
        }
        this.inputVisible = false;
        this.inputValue = '';
      }
    },
    mounted(){
       this.getList();
    }
  }
</script>