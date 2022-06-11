<template>
  <div>
    <vue-particles
      class="user-bg"
      color="#fff"
      :particleOpacity="0.7"
      :particlesNumber="80"
      shapeType="circle"
      :particleSize="4"
      linesColor="#fff"
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
    <el-container style="margin-left: 5%; margin-right: 5%">
      <el-main style="width: 90%">
        <el-row
          style="
            margin-top: 2%;
            padding: 2%;
            background: rgba(255, 255, 255, 0.5);
            border-radius: 10px;
          "
        >
          <div style="text-align: left; margin-left: 20px">
            <div
              style="
                width: 90%;
                height: 60px;
                display: flex;
                justify-content: center;
                align-items: center;
              "
            >
              <el-select v-model="tag" placeholder="标签" value-key="tagId">
                <el-option label="所有" :value="-1">所有</el-option>

                <el-option
                  v-for="item in tagList"
                  :key="item.tagId"
                  :label="item.tagName"
                  :value="item.tagId"
                >
                </el-option>
              </el-select>
              <el-input
                placeholder="请输入内容"
                v-model="search"
                style="width: 70%"
              >
                <el-button
                  slot="append"
                  icon="el-icon-search"
                  @click="toSearch"
                ></el-button>
              </el-input>
            </div>
            <br />
            <div style="width: 95%; margin: auto">
              <span v-if="activeName == 'music'"
                >搜索到{{ musics.length }}条音乐</span
              >
              <span v-if="activeName == 'user'"
                >搜索到{{ users.length }}个用户</span
              >
            </div>
            <el-tabs v-model="activeName" @tab-click="handleClick">
              <el-tab-pane label="音乐" name="music">
                <!-- <div class="divider"></div> -->
                <MusicItems
                  :musics="musics"
                  :total="totalM"
                  @pagePara="PageMusic"
                ></MusicItems>
              </el-tab-pane>
              <el-tab-pane label="用户" name="user">
                <UserList
                  :users="users"
                  :total="totalU"
                  @pagePara="PageUser"
                ></UserList>
              </el-tab-pane>
            </el-tabs>
          </div>
        </el-row>
      </el-main>
      <!-- <el-aside width="20%" style="margin-top: 5%">
        <el-card color="#385F73" dark class="back"> -->
      <!-- <el-table
              :data="audioList"
              style="width: 100%; margin-left: 2%; margin-right: 5%"
          >
            <el-table-column prop="audioName" label="所有音频">
              <template slot-scope="scope"
              ><el-link @click="toAudio(scope.row)">{{
                  scope.row.audioName
                }}</el-link>
              </template></el-table-column
            >
          </el-table> -->
      <!-- </el-card>
      </el-aside> -->
    </el-container>
  </div>
</template>

<script>
import TagList from "@/components/TagList.vue";
import MusicItems from "@/components/MusicItems.vue";
import UserList from "@/components/UserList.vue";

export default {
  components: {
    MusicItems,
    TagList,
    UserList,
  },
  data() {
    return {
      currentM: 1,
      sizeM: 10,
      totalM: "",
      currentU: 1,
      sizeU: 10,
      totalU: "",
      search: "",
      tag: "",
      activeName: "music",
      musics: [
        {
          audioId: "1",
          audioName: "冥想者",
          length: "2:30",
          apubAuthorId: "123",
          authorName: "李佳颖",
          img_url:
            "https://tse1-mm.cn.bing.net/th/id/R-C.f65e69d0e798cd7d560ac05e1364ee40?rik=RAYCqHwEZBONHA&riu=http%3a%2f%2fimage.bamen.bbs.bamenzhushou.com%2fe6ac0b28-cadc-4ed2-9daa-cd5237c41381.jpg&ehk=9QIlZ6kR%2fZG2uS6UhrKgfekc%2f9r1H%2foqaM4%2bE71COX8%3d&risl=&pid=ImgRaw&r=0",
        },
        {
          audioId: "2",
          audioName: "222我",
          length: "2:30",
          apubAuthorId: "233",
          authorName: "颖佳李",
          img_url: "",
        },
      ],
      users: [
        {
          id: "1",
          name: "李佳颖",
          img_url:
            "https://tse1-mm.cn.bing.net/th/id/R-C.acd9f2c78fae3c156705201f575172fa?rik=QgJxactB%2fHuh6g&riu=http%3a%2f%2fimage.bamen.bbs.bamenzhushou.com%2f41b8bdd8-ee3d-49b6-957a-e35141af8d61.jpg&ehk=JDC%2fO6zFqUhes3vx%2bXJgAHGfAyg509NZnDa%2fjOE%2b29E%3d&risl=&pid=ImgRaw&r=0",
        },
        { id: "2", name: "颖佳李", img_url: "" },
      ],
      audio_cover: require("../assets/1.jpg"),
      audioList: [
        {
          id: "1",
          name: "name",
        },
        {
          id: "2",
          name: "name",
        },
        {
          id: "3",
          name: "name",
        },
        {
          id: "4",
          name: "name",
        },
        {
          id: "5",
          name: "name",
        },
      ],
      tagList: [],
      searchList: [],
    };
  },
  methods: {
    handleClick(tab, event) {
      // console.log(tab, event);
    },
    toSearch() {
      //this.getData();
      this.$router.push({
        path: "/search",
        query: { keywords: this.search, tag: this.tag },
      }) + new Date();
    },
    getMusic() {
      this.search = this.$route.query.keywords;
      this.tag = Number(this.$route.query.tag);
      if (!this.tag) this.tag = -1;
      // let url = "http://localhost:9003/audioPublic?audioName="+this.search;
      let url = "http://localhost:9003/audioPublic/selectByNameAndTag";
      let params = {};
      if (this.search) params.name = this.search;
      console.log(this.tag);
      if (this.tag && this.tag != -1) params.tagId = this.tag;
      if (this.currentM) params.current = this.currentM;
      if (this.sizeM) params.size = this.sizeM;
      console.log(params);
      this.$axios.get(url, { params }).then((response) => {
        this.musics = response.data.data.records;
        this.totalM = response.data.data.total;
        console.log(this.musics);
      });
    },
    getUser() {
      let url2 = "http://localhost:9003/user/selectUser";
      let params = {};
      if (this.search) params.name = this.search;
      if (this.currentU) params.current = this.currentU;
      if (this.sizeU) params.size = this.sizeU;
      this.$axios.get(url2, { params }).then((response) => {
        this.users = response.data.data.records;
        this.totalU = response.data.data.total;
        // console.log(this.users)
      });
    },
    getData() {
      this.$axios.get("http://localhost:9003/tag").then((response) => {
        this.tagList = response.data.data.records;

        console.log(this.tagList);
        this.$forceUpdate();
      });
    },
    PageMusic(obj) {
      this.currentM = obj.current;
      this.sizeM = obj.size;
      this.getMusic();
    },
    PageUser(obj) {
      this.currentU = obj.current;
      this.sizeU = obj.size;
      this.getUser();
    },
  },

  mounted() {
    this.getData();
    this.getMusic();
    this.getUser();
  },
  watch: {
    $route(to, from) {
      this.getData();
      this.getMusic();
      this.getUser();
    },
  },
};
</script>

<style scoped>
.user-bg {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  min-height: 100%;
  height: fit-content;
  z-index: -1;
  background: url("../assets/bg.jpeg");
}
.E-card-back {
  margin-left: 10%;
  margin-right: 10%;
  border-radius: 15px;

  background-color: rgba(255, 255, 255, 0.6);
}
.card-image {
  height: 150px;
  width: auto;
  border-radius: 10px;
  box-shadow: 5px 5px 5px #888888;
}
.time-font {
  font-size: 13px;
  color: #999;
}
.title-font {
  font-size: 22px;
  color: black;
}
.divider {
  position: relative;
  margin: 10px auto;
  width: auto;
  height: 1px;
  background-color: #d4d4d4;
  text-align: center;
  font-size: 16px;
  color: #475669;
}
.back {
  margin-left: 10%;
  margin-right: 10%;
  border-radius: 20px;
}
/deep/ .el-tabs__item.is-active {
  color: #888888;
}
/deep/ .el-tabs__active-bar {
  background-color: #888888;
}
/deep/ .el-tabs__item:hover {
  color: #888888;
}
</style>
