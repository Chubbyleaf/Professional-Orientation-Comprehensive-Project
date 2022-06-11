<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">1/3：和弦</h1>
    </el-row>
    <el-row>
      <h1 class="title1">三和弦</h1>
      <h2 class="title2">
        在之前的科普中，你已经学习到了如何使用多个音符创建音阶。
        现在让我们来看一看如何使用多个音符创建和弦。
        一个和弦指的是一组不同音高的音符一起同时发声。
      </h2>
      <h2 class="title3">大三和弦</h2>
      <h2 class="title2">
        三和弦 是最常用的和弦。它由起始音（或根音）以上叠加三音和五音而构成。
        例如，在C大调中，C三和弦的构成包括：
      </h2>
      <li class="title4">C（根音）</li>
      <li class="title4">E（C上方第三音；通常称为“三音”）</li>
      <li class="title4">G（C上方第五音；通常称为“五音”）</li>
      <h2 class="title2">这个和弦便称为C大三和弦。</h2>
      <h2 class="title2">大调音阶通常给人以“快乐” 或 “积极”的听感。</h2>

      <h2 class="title3">小三和弦</h2>
      <h2 class="title2">在C小调中，C小三和弦的构建法相同：</h2>
      <li class="title4">C（根音）</li>
      <li class="title4">E♭（C上方第三音；通常称为“三音”）</li>
      <li class="title4">G（C上方第五音；通常称为“五音”）</li>
      <h2 class="title2">这个和弦便称为C小三和弦。</h2>
      <h2 class="title2">小调音阶通常给人以“悲伤”或“黑暗”的听感。</h2>
      <h2 class="title2">
        现在你已了解了如何编写常用和弦，下面让我们来看看和弦在歌曲中的运用。
      </h2>
    </el-row>

    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：“Get Up, Stand Up” ></el-button
        >
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },

  methods: {
    toLast() {
      this.$router.push({
        path: "/onlineTeach/noteScale/addNote",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/chord/GetUp,StandUp",
      });
    },
  },
  mounted() {},
};
</script>

<style lang="scss" scoped>
.index-font {
  font-size: 25px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
  // margin-bottom: 5%;
}
.title1 {
  font-size: 45px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
}
.title2 {
  font-size: 26px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
  margin-right: 50%;
  margin-top: 3.5%;
  text-align: left;
}
.title3 {
  font-size: 34px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
  margin-right: 60%;
  margin-top: 5%;
}
.title4 {
  font-size: 26px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
  margin-right: 60%;
}

.button-intro {
  width: 100px;
  height: 100px;
  background: rgba(255, 255, 255, 0.7);
  font-size: 50px;
  font-family: "Microsoft JhengHei";
}
.music-font {
  font-size: 25px;
  font-family: "Microsoft JhengHei";
  color: rgba(255, 255, 255, 0.76);
}
.button-play1 {
  width: 30%;
  height: 50px;
  background: rgba(255, 255, 255, 0.7);
  font-size: 30px;
  font-family: "Microsoft JhengHei";
  float: left;
}
.button-play2 {
  width: 100%;
  height: 250px;
  background: rgba(255, 255, 255, 0.35);
  font-size: 21px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
}
.button-next {
  margin-top: 3%;
  width: 100%;
  height: 100px;
  background: rgba(255, 255, 255, 0.158);
  font-size: 30px;
  font-family: "Microsoft JhengHei";
  color: #fff;
}
.button-last {
  margin-top: 3%;
  width: 100%;
  height: 100px;
  background: rgba(255, 255, 255, 0);
  font-size: 30px;
  font-family: "Microsoft JhengHei";
  color: #fff;
  border: 5px solid rgba(255, 255, 255, 0);
}
.image {
  position: relative;
  left: 10px;
}
</style>