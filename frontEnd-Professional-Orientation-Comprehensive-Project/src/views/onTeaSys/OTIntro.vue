<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">介绍</h1>
    </el-row>
    <el-row>
      <h1 class="title1">开始音乐创作之旅</h1>
      <b class="title2"
        >你将通过这些科普学习到音乐创作的基础知识。无需任何经验或设备，
        你将在浏览器中完成所有工作。</b
      >
      <b class="title2">
        让我们从下面的方格开始。每一方格都录入了一段音乐，点击方格来播放或停止。</b
      >
    </el-row>
    <el-row style="margin-top: 5%; width: 400px; margin-left: 20%">
      <el-row>
        <el-col :span="6" class="music-font"> 鼓</el-col>
        <el-col :span="6" class="music-font"> 鼓</el-col>
        <el-col :span="6" class="music-font"> 鼓</el-col>
        <el-col :span="6" class="music-font"> 鼓</el-col>
      </el-row>
    </el-row>
    <el-row style="width: 400px; margin-left: 18%">
      <el-row>
        <el-col :span="6">
          <AudioPlayer
            v-if="isShow == true"
            ref="audio"
            :fileurl="audioUrl1"
          ></AudioPlayer></el-col
        ><el-col :span="6">
          <AudioPlayer
            v-if="isShow == true"
            ref="audio"
            :fileurl="audioUrl2"
          ></AudioPlayer></el-col
        ><el-col :span="6">
          <AudioPlayer
            v-if="isShow == true"
            ref="audio"
            :fileurl="audioUrl3"
          ></AudioPlayer
        ></el-col>
        <el-col :span="6">
          <AudioPlayer
            v-if="isShow == true"
            ref="audio"
            :fileurl="audioUrl4"
          ></AudioPlayer
        ></el-col>
      </el-row>
    </el-row>

    <b class="title2"
      >在播放了一遍所有小方格之后你会发现某些格子的音乐组合起来很好听。
      许多音乐的创作过程便是如此 —
      将一小段音乐想法拼接和混搭起来创造出有趣的结合，并随着时间的进行变化多样。</b
    >
    <b class="title2">
      现在你已尝试了拼接现成的音乐素材。下一步，你可以试着自己创作一些音乐素材。</b
    >
    />
    <el-button class="button-next" @click="toNext"
      >下一个：这是什么声音 ></el-button
    >
  </div>
</template>

<script>
import AudioPlayer from "../component/AudioIntro.vue";
export default {
  components: { AudioPlayer },
  data() {
    return {
      audioUrl1: "http://rbz8c5rhq.hd-bkt.clouddn.com/y799.mp3",
      audioUrl2: "http://rbz8c5rhq.hd-bkt.clouddn.com/y841.mp3",
      audioUrl3: "http://rbz8c5rhq.hd-bkt.clouddn.com/15061.mp3",
      audioUrl4: "http://rbz8c5rhq.hd-bkt.clouddn.com/9385.mp3",
      isShow: true,
    };
  },

  methods: {
    toNext() {
      this.$router.push({
        path: "/onlineTeach/rhythm/whatSound",
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
  margin-top: 5%;
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
.button-next {
  margin-top: 3%;
  width: 100%;
  height: 100px;
  background: rgba(255, 255, 255, 0.158);
  font-size: 30px;
  font-family: "Microsoft JhengHei";
  color: white;
}
</style>