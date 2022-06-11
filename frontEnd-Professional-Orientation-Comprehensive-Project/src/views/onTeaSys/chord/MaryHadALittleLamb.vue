<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">3/3：和弦</h1>
    </el-row>
    <el-row>
      <h1 class="title1">“Mary Had a Little Lamb”</h1>
      <h2 class="title2">
        这是一首非常著名的儿童歌曲，以其旋律
        （一组单音进行的音符，通常作为歌唱的部分）而闻名。以下是F大调的主旋律。
      </h2>
    </el-row>
    <el-row>
      <AudioPlayer1 ref="audio" :fileurl="audioUrl1"></AudioPlayer1>
    </el-row>
    <el-row>
      <h2 class="title2">
        如果将旋律与和弦一同合作（和声），音乐会听起来更丰富。
        下面所示是一个很简单的和弦进行
        。和弦进行指的是一组和弦按照特定的排列组合演奏。
        在许多音乐类型中，和弦进行的运用通过离开主音又回到主音的过程营造出紧张和缓和的氛围。
      </h2>
    </el-row>
    <el-row>
      <AudioPlayer1 ref="audio" :fileurl="audioUrl1"></AudioPlayer1>
    </el-row>
    <el-row>
      <h2 class="title3">这首歌由什么和弦构成呢？</h2>
      <h2 class="title2">
        在这个例子中我们使用了F大三和弦
        和C大三和弦作为伴奏。那么为什么我们选择这两个和弦呢？
      </h2>
      <h2 class="title2">
        如果你观察一下旋律，你可以看到旋律中最常出现的音符同时也出现在伴奏和弦中。
        例如，在第一小节里，F和A都是构成F大三和弦的一部分 —
        这些音符被称为和弦音。 G则是非和弦音，但它起到“连接”
        F和A的作用。两个相邻和弦音之间的非和弦音被称为经过音。
      </h2>
      <h2 class="title2">
        换句话说，有一种选择和弦的方法是找到包含旋律音符的和弦。
      </h2>
      <h2 class="title2">
        需要另外注意的是这些和弦由音阶中的主音和五音（F和C）构成。
        这两个和弦分别称为1 和弦及5 和弦。
        1和弦与5和弦的交替进行产生强烈的远离与回归感以及紧张与缓和感。
        我们可以比较一下，1和弦听起来比较“稳定”和“主导”；而5和弦给人以“紧张”和“未完成”的感觉。
      </h2>
      <h2 class="title2">试着找一找不同的和弦，并变换节奏来演奏这些和弦。</h2>
    </el-row>

    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：贝斯创作 ></el-button
        >
      </el-col>
    </el-row>
  </div>
</template>

<script>
import AudioPlayer1 from "../../component/AudioPlay1.vue";

export default {
  components: { AudioPlayer1 },
  data() {
    return {
      audioUrl1: "http://rbz8c5rhq.hd-bkt.clouddn.com/y799.mp3",
    };
  },

  methods: {
    toLast() {
      this.$router.push({
        path: "/onlineTeach/chord/GetUp,StandUp",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/bass/bassCreate",
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