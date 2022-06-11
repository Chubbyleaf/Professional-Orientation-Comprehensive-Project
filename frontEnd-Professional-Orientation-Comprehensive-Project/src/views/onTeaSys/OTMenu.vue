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
            <el-menu-item index="/onlineTeach/index"> 介绍 </el-menu-item>
            <el-submenu index="1">
              <template slot="title"> 节奏 </template>
              <el-menu-item-group>
                <el-menu-item index="/onlineTeach/rhythm/whatSound"
                  >这是什么声音？</el-menu-item
                >
                <el-menu-item index="/onlineTeach/rhythm/beatTempo"
                  >节拍和速度</el-menu-item
                >
                <el-menu-item index="/onlineTeach/rhythm/tempoGenre"
                  >速度和曲风</el-menu-item
                >
                <el-menu-item index="/onlineTeach/rhythm/bar"
                  >小节</el-menu-item
                >
                <el-menu-item index="/onlineTeach/rhythm/rockHouse"
                  >摇滚和house</el-menu-item
                >
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="2">
              <template slot="title"> 音符和音阶 </template>
              <el-menu-item-group>
                <el-menu-item index="/onlineTeach/noteScale/exploreNote"
                  >探索音高</el-menu-item
                >
                <el-menu-item index="/onlineTeach/noteScale/harmonicScale"
                  >调和音阶</el-menu-item
                >
                <el-menu-item index="/onlineTeach/noteScale/addNote"
                  >添加更多音符</el-menu-item
                >
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="3">
              <template slot="title"> 和弦 </template>
              <el-menu-item-group>
                <el-menu-item index="/onlineTeach/chord/triad"
                  >三和弦</el-menu-item
                >
                <el-menu-item index="/onlineTeach/chord/GetUp,StandUp"
                  >“Get Up, Stand Up”</el-menu-item
                >
                <el-menu-item index="/onlineTeach/chord/MaryHadALittleLamb"
                  >“Mary Had a Little Lamb”</el-menu-item
                >
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="4">
              <template slot="title"> 贝斯 </template>
              <el-menu-item-group>
                <el-menu-item index="/onlineTeach/bass/bassCreate"
                  >贝斯创作</el-menu-item
                >
                <el-menu-item index="/onlineTeach/bass/GoodLife"
                  >“Good Life”</el-menu-item
                >
                <el-menu-item index="/onlineTeach/bass/AroundTheWorld"
                  >“Around the World”</el-menu-item
                >
                <el-menu-item index="/onlineTeach/bass/UnderMiSlengTeng"
                  >“Under Mi Sleng Teng”</el-menu-item
                >
                <el-menu-item index="/onlineTeach/bass/AroundTheWorld"
                  >“Never Tell You”</el-menu-item
                >
                <el-menu-item index="/onlineTeach/bass/Oblivion"
                  >“Oblivion”</el-menu-item
                >
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="5">
              <template slot="title"> 旋律 </template>
              <el-menu-item-group>
                <el-menu-item index="/onlineTeach/melody/melodyCreate"
                  >旋律创作</el-menu-item
                >
                <el-menu-item index="/onlineTeach/melody/LoveWillTearUsApart"
                  >“Love Will Tear Us Apart”</el-menu-item
                >
                <el-menu-item index="/onlineTeach/melody/TourDeFrance"
                  >“Tour de France”</el-menu-item
                >
                <el-menu-item index="/onlineTeach/melody/Praxis"
                  >“Praxis”</el-menu-item
                >
                <el-menu-item index="/onlineTeach/melody/Ride"
                  >“Ride”</el-menu-item
                >
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="6">
              <template slot="title">高级话题 </template>
              <el-menu-item-group>
                <el-menu-item
                  index="/onlineTeach/advancedTopic/establishMajorScale"
                  >建立大调音阶</el-menu-item
                >
                <el-menu-item index="/onlineTeach/advancedTopic/mode"
                  >调式</el-menu-item
                >
                <el-menu-item index="/onlineTeach/advancedTopic/pentatonicScale"
                  >五声音阶</el-menu-item
                >
                <el-menu-item index="/onlineTeach/advancedTopic/diatonicScale"
                  >全音阶</el-menu-item
                >
                <el-menu-item index="/onlineTeach/advancedTopic/octave"
                  >八度音阶</el-menu-item
                >
                <el-menu-item index="/onlineTeach/advancedTopic/IndonesianScale"
                  >印尼音阶</el-menu-item
                >
                <el-menu-item index="/onlineTeach/advancedTopic/19"
                  >19平均律</el-menu-item
                >

                <el-menu-item index="/onlineTeach/advancedTopic/seventh"
                  >七和弦</el-menu-item
                >
                <el-menu-item
                  index="/onlineTeach/advancedTopic/MommyWhatIsARecord"
                  >“Mommy What's a Record”</el-menu-item
                >
              </el-menu-item-group>
            </el-submenu>
            <el-menu-item index="/onlineTeach/end"> 科普结束 </el-menu-item>
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
  background: url("../../assets/12.jpg");
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