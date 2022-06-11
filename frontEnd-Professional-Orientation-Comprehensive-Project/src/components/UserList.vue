<template>
    <div>
        <div 
        v-for="(item,index) in users"
        :key="index+100"
        class="item">
        <div class="icon">
            <img 
            class="img_1"
            :src="item.avatarUrl?item.avatarUrl:'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png'" alt="">
        </div>
        <div @click="toUser(item.userId)" style="height:100%;float:left;min-width:250px;cursor:pointer;">
            <div style="width:250px;min-width:250px;height:100%;float:left;text-align:left;margin-left:10px">
                <span style="font-size:23px;font-weight:bold;">{{item.userName}}</span>
            </div>
        </div>
            <div style="float:right;margin:auto;line-height:60px">
                <el-button plain 
                icon="el-icon-check" 
                v-if="item.ifFollow"  
                @click="unfollow(item.userId)"
                style="padding:0px 13px;background-color:white;color:#2c3e50">已关注</el-button>
                <el-button v-else icon="el-icon-plus" @click="followSomeone(item.userId)" >关注</el-button>
                
            </div>
            

        
           
        </div>
         <pagination
      v-show="total>0"
      :total="total"
      :page.sync="current"
      :limit.sync="size"
      @pagination="updateList"
    />
    </div>
</template>
<style scoped>
.item{
    height: 60px;
    width: 90%;
    padding: 5px 5px;
    /* display: flex; */
    border-bottom: 1px solid rgb(197, 193, 193);
    flex-direction: space-between;
}
.icon{
width:50px;
height: 50px;
min-width: 50px;
float:left;
border-radius: 4px;
background: white;
}
.img_1{
    object-fit:cover;
    width: 100%;
    height: 100%;
}
.el-button{
    height: 40px;
    background-color:#2c3e50;
    color: white;
}
</style>

<script>
import Pagination from "@/components/Pagination"
export default {
    name: 'UserList',
  props: ['users','total'],
   components: { 'pagination':Pagination },
  data: () => ({
      ifFollow:[],
      size:10,
      current:1,
  }),
   methods:{
      ret_img(img_url){
          if(img_url)return img_url;
          else return '';
          
      },
    followSomeone(id) {
      this.axios({
        method: "post",
        url: "http://localhost:9001/user/followSomeone",
        data: {
          meId: sessionStorage.getItem("userId"),
          myFollowId: id,
        },
      }).then((res) => {
        console.log("followSomeone", res);
        switch (res.data.code) {
          case 200:
           this.$message({
                message: "关注成功",
                type: "success",
            });
            var json=JSON.stringify(this.users);
            this.users=JSON.parse(json);
            break;
          case 2004:
            this.$message.error(res.data.message);
        }
      })
      .catch(res=>{
        this.$message.error("关注失败");
      })
      ;
      
    },
    unfollow(id){
      this.axios({
        method: "post",
        url: "http://localhost:9001/user/cancelFollowSomeone",
        data: {
          meId: sessionStorage.getItem("userId"),
          myFollowId: id,
        },
      }).then((res) => {
        console.log("followSomeone", res);
        switch (res.data.code) {
          case 200:
           this.$message({
                message: "取关成功",
                type: "success",
            });
            var json=JSON.stringify(this.users);
            this.users=JSON.parse(json);
            break;
          default:
            this.users=JSON.parse(json);
        }
      })
      .catch(res=>{
        this.$message.error("取关失败");
      })
    },
     updateList(){
        let obj={};
        obj.size=this.size;
        obj.current=this.current;
        obj.total=this.total;
        this.$emit('pagePara',obj);
    },
    toUser(id) {
      this.$router.push({
        path: "/user",
        query: {
          userId: id,
        },
      });
    },
   },
   watch:{
     users:{
       handler(newValue,oldValue){
         let len=this.users.length;
         for(let i=0;i<len;i++){
           var params= {
              meId: sessionStorage.getItem("userId"),
              myFollowId: this.users[i].userId,
            };
           this.$axios.post("http://localhost:9001/user/isFollow",params)
           .then(res=>{
              console.log(i);
             this.users[i].ifFollow=res.data.data;
             this.$forceUpdate();
           })
         }
       }
     }
   }
}
</script>