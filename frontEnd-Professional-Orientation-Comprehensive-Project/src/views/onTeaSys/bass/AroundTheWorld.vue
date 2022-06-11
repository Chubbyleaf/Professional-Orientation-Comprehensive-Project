<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">3/6：贝斯</h1>
    </el-row>
    <el-row>
      <h1 class="title1">Daft Punk - “Around the World”</h1>
      <a
        href="https://www.bilibili.com/video/av42290625/"
        target="_blank"
        class="title5"
        >Daft Punk - Around The World （1997）</a
      >

      <h2 class="title3">贝斯的音色是什么？</h2>
      <h2 class="title2">
        由于Daft Punk
        没有详细披露过音乐创作的细节，所以我们并不确定这首歌的贝斯是由什么乐器演奏的。
        贝斯的演奏风格似乎与funk贝司手演奏贝斯吉他的方式一致，但其实这也可以通过合成器完成。
      </h2>

      <h2 class="title3">贝斯旋律是如何创作的？</h2>
      <h2 class="title2">
        这个贝斯的旋律走向比较有趣：先是如同“爬楼梯”一样重复三次，然后顺着音阶再“爬”下来。
        使用三个重复变化的乐句之后提出一个新想法的思路是一种常见的作曲技巧。
      </h2>
      <h2 class="title2">
        让我们来尝试创作一些贝斯旋律，你可以借鉴原曲的鲜明特点：精细编排的节奏，经过音和重复三次并带来新想法的乐句。
      </h2>
      <h2 class="title2">
        即便这段没有任何和弦的演奏，但你可以通过贝斯旋律中的音符判断有可能性的伴奏和弦（方法类似于"Mary
        Had A Little Lamb" 的例子).
      </h2>
    </el-row>

    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：“Under Mi Sleng Teng” ></el-button
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
        path: "/onlineTeach/bass/GoodLife",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/bass/UnderMiSlengTeng",
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
  margin-right: 50%;
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
.title5 {
  font-size: 20px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
  margin-right: 50%;
  margin-top: 2%;
  text-align: left;
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