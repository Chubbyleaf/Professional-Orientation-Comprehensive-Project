<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">1/9：高级话题</h1>
    </el-row>
    <el-row>
      <h1 class="title1">建立大调音阶</h1>
    </el-row>
    <el-row>
      <h2 class="title2">
        一个音阶的声音形态是由该音阶中特定模式的音程关系所决定的。
        大调和小调音阶是最常见的两种音阶，它们经常被运用到各种不同的音乐中。除了这两种音阶以外还有许多其他类型的音阶。
      </h2>
      <h2 class="title2">
        大调音阶包含七个音符，它由半音(相邻两音) 和全音(相隔两个半音)
        的特定模式组成。
      </h2>
      <h2 class="title2">
        这样的全音半音的特定组合模式可以用来定义任意一个大调音阶，并且不受音阶起始音的影响：
      </h2>
      <h2 class="title2">全 - 全 - 半 - 全 - 全 - 全 - 半</h2>
      <h2 class="title2">
        （注意：那些从未接触过钢琴的人可能会对白键与黑键音高之间的关系感到困惑。
        例如，E和F（以及B和C）都是白键，但是是半音关系）：
      </h2>
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="2"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C# Db"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="D"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="D# Eb"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="F"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="F# Gb"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="G"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="G# Ab"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="A"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="A# Bb"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="B"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C"
        ></AudioPlayerWhite
      ></el-col>
    </el-row>
    <el-row>
      <h2 class="title3">音名的标记法</h2>
      <h2 class="title2">
        当你在改变主音时，是否注意到音阶中的一些音符有时附加了升号，有时是降号？这里有几个简单的规则来解释如何正确书写大调音阶中的音。
      </h2>
      <li class="title4">
        半音全音的排列模式永远是全 - 全 - 半 - 全 - 全 - 全 - 半
      </li>
      <li class="title4">
        为了保持这个半音和全音模式，在大调音阶中一些音符需要使用到 ♭ 或 ♯
        （除了C 大调以外）。
      </li>
      <li class="title4">
        每一音名字母只会被使用到一次。例如，一个大调音阶里不可能同时包含 A♭ 和
        A。
      </li>
      <li class="title4">音名字母始终按字母顺序排列，G之后再次从A开始。</li>

      <h2 class="title3">从一个黑键开始</h2>
      <h2 class="title2">
        由于每一个黑键有两个名字（例如 D♭ 或
        C♯），我们如何来决定哪一个作为音阶主音呢？在本科普中，我们选择相比之下含有升降号尽可能少的音阶。例如：
      </h2>
      <h2 class="title2">D♭ 大调有五个降号：</h2>
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Db"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Eb"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="F"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Gb"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Ab"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Bb"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Db"
        ></AudioPlayerBlack
      ></el-col>
    </el-row>
    <el-row>
      <b class="title2">但是 C♯ 大调有七个升号： </b>
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C#"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="D#"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="E#"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="F#"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="G#"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="A#"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="B#"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C#"
        ></AudioPlayerBlack
      ></el-col>
    </el-row>
    <el-row>
      <b class="title2">所以 D♭ 会作为我们的选择。 </b>
      <b class="title3">你注意到了吗？ </b>
      <b class="title2"
        >如该示例所示，升号或降号有时也可以指代“白键”。 一些音阶（如上方 C♯
        大调所示）使用音名如 E♯ 和
        B♯，这也许看起来有些奇怪，但为什么这些音符不能简单地写成 F 和 C 呢？
      </b>
      <b class="title2"
        >案在于前面解释到的音名标记法。
        由于每一个音名字母在大调音阶中仅被允许使用一次，所以根据音阶的需求，有些音名会使用到不常见的音名符号。
        在 C♯ 大调中，E 和 B 的“槽”
        需要升号来表示琴键上的音高（以保持一致的全音半音关系模式），同样的 F♯ 和
        C♯ 也是根据标记法来确定的音符名。</b
      >
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：调式 ></el-button
        >
      </el-col>
    </el-row>
  </div>
</template>

<script>
import AudioPlayerWhite from "../../component/AudioPlayWhite.vue";
import AudioPlayerBlack from "../../component/AudioPlayBlack.vue";
export default {
  components: { AudioPlayerWhite, AudioPlayerBlack },
  data() {
    return {
      audioUrl1: "http://rbz8c5rhq.hd-bkt.clouddn.com/y799.mp3",
    };
  },

  methods: {
    toLast() {
      this.$router.push({
        path: "/onlineTeach/melody/Ride",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/advancedTopic/mode",
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
.button-play-white {
  width: 100%;
  height: 250px;
  background: rgba(255, 255, 255, 0.35);
  font-size: 21px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
  border-color: rgb(0, 0, 0);
}
.button-play-black {
  width: 100%;
  height: 250px;
  background: rgba(255, 255, 255, 0.2);
  font-size: 21px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
  border-color: rgb(155, 154, 154);
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