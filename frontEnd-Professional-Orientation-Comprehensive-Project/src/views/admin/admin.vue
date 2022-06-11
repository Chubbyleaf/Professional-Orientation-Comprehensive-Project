<template>
    <div class="bg">
        <div class="title">
            <div class="collapse-btn" @click="collapseChage">
            <i v-if="!collapse" class="el-icon-s-fold"></i>
            <i v-else class="el-icon-s-unfold"></i>
        </div> 
        <div style="line-height: 70px;">
        后台管理系统</div>
        </div>
        <!-- <div class="main"> -->

        
        <div class="sidebar"
        :style="{
          width:collapse?'64px':'150px'
        }"
        >
    <el-menu
      class="sidebar-el-menu"
      :default-active="this.$route.path"
      :collapse="collapse"
      :collapse-transition="false"
      background-color="#324157"
      text-color="#bfcbd9"
      active-text-color="#20a0ff"
      router
    >
      <template v-for="item in items">
        <template v-if="item.subs">
          <el-submenu :index="item.index" :key="item.index">
            <template #title>
              <i :class="item.icon"></i>
              <span>{{ item.title }}</span>
            </template>
            <template v-for="subItem in item.subs">
              <el-submenu
                v-if="subItem.subs"
                :index="subItem.index"
                :key="subItem.index"
              >
                <template #title>{{ subItem.title }}</template>
                <el-menu-item
                  v-for="(threeItem, i) in subItem.subs"
                  :key="i"
                  :index="threeItem.index"
                >
                  {{ threeItem.title }}</el-menu-item
                >
              </el-submenu>
              <el-menu-item v-else :index="subItem.index" :key="subItem.index"
                >{{ subItem.title }}
              </el-menu-item>
            </template>
          </el-submenu>
        </template>
        <template v-else>
          <el-menu-item :index="item.index" :key="item.index">
            <i :class="item.icon"></i>
            <template #title>{{ item.title }}</template>
          </el-menu-item>
        </template>
      </template>
    </el-menu>
  </div>
        <div class="main" 
        :style="{
          left:collapse?'64px':'150px',

        }">
            <router-view></router-view>
        </div>
        </div>
    <!-- </div> -->
</template>
<script>
export default {
    data(){
        return{
          collapse:true,
            items:[
      {
        icon: "el-icon-bell",
        index: "/admin/bulletin",
        title: "公告管理",
      },
      {
        icon: "el-icon-document-checked",
        index: "/admin/audit",
        title: "审核管理",
      },
     {
        icon: "el-icon-price-tag",
        index: "/admin/tag",
        title: "标签管理",
      },
    ]
        }
    },
    methods:{
      collapseChage () {
        this.collapse=!this.collapse;
        // this.$store.state.handleCollapse=!collapse.value;
            // useStore().commit("handleCollapse", !collapse.value);
        },
    }
}
</script>
<style scoped>
.bg {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1;
  background:white;
  overflow-y: scroll;
}
.main{
  margin:10px 60px 10px 10px;
  position: relative;
  top:70px;
  /* right: 0; */
}
.sidebar {
  display: block;
  position: fixed; 
  left: 0;
  top: 70px;
  /* width: 150px; */
  min-width: 150px;
  bottom: 0;
  overflow-y: scroll;
  text-align: left;
}
.sidebar::-webkit-scrollbar {
  width: 0;
}

.sidebar > ul {
  height: 100%;
}
.title{
    width: 100%;
    padding-left: 5px;
    height: 70px;
    background-color: #242f42;
    color: white;
    font-size: 28px;
    font-weight: 300px;
    text-align: left;
    display: flex;
    position: fixed;
    z-index: 2;
}
.el-menu:not(.el-menu--collapse) {
      width: 150px;
 }
 /* 设置侧边栏宽度时，必须将.el-menu--collapse排除，否则动画效果出现BUG */
 .collapse-btn{
   cursor: pointer;
  line-height: 70px;
  padding-left:10px;
  width: 50px;
 }
 .collapse-btn:hover{
    background: rgb(40,52,70);
}
</style>