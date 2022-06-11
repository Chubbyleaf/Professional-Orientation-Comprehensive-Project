<template>
  <div class="all-bg">
    <vue-particles
      class="tea-bg"
      color="#80CBC4"
      :particleOpacity="0.7"
      :particlesNumber="80"
      shapeType="circle"
      :particleSize="4"
      linesColor="#80CBC4"
      :linesWidth="2"
      :lineLinked="true"
      :lineOpacity="0.4"
      :linesDistance="150"
      :moveSpeed="2"
      :hoverEffect="true"
      hoverMode="grab"
      :clickEffect="true"
      clickMode="push"
    ></vue-particles>
    <el-container style="margin-top: 5%">
      <el-aside width="110px">
        <div>
          <el-menu class="el-menu-vertical-demo" :collapse="true" router>
            <el-menu-item index="/onlineMake/index"> 开始 </el-menu-item>
            <el-menu-item index="/onlineMake/notation/index"> 简谱 </el-menu-item>
            <el-menu-item index="/onlineMake/pinao/index"> 钢琴 </el-menu-item>
            <el-menu-item index="/onlineMake/taptap/index"> 可视化鼓点 </el-menu-item>
            <el-menu-item index="/onlineMake/end"> 创作结束 </el-menu-item>
          </el-menu>
        </div>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>



<script>
export default {
  data() {
    return {
      isCollapse: true,
    };
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
  },
};
</script>


<style lang="scss" scoped>
.tea-bg {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  min-height: 100%;
  height: fit-content;
  z-index: -1;
  //height: fit-content;
  // min-height: 100%;

  //background-size: 100% 100%;
}
.all-bg {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  min-height: 100%;
  height: fit-content;
  z-index: -1;
  //height: fit-content;
  // min-height: 100%;
  background: url("../../assets/music_bg.jpg");
  //background-size: 100% 100%;
}
.el-menu-vertical-demo {
  width: 95%;
  margin-top: 100%;
  background-color: #fff;
  opacity: 0.7;
  border-radius: 5px;
}
</style>