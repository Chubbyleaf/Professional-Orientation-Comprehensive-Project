<template>
  <div>
    <div v-for="(item, index) in musics" :key="index + 2000" class="item">
      <div v-if="rank" class="rank">
        {{ index + 1 }}
        <i class="el-icon-caret-top" style="color: red"></i>
      </div>
      <!-- <div class="icon"
        :style="{
          backgroundImage: 'url('+ret_img(item.imgUrl)+')',
          backgroundSize: 'cover',
          backgroundRepeat: 'no-repeat',
        }" 
        > -->

      <div style="min-width: 250px">
        <div class="icon">
          <aplayer :audio="audio[index]" mini />

          <!-- <div class="playorpause"
        @mouseover="cursor=index"
        @mouseout="cursor=-1"
        @click="change_status(index)"
        :class="{
            'hover_icon':index==cursor||index==focus,
            }"
        >
            <i v-if="(index==cursor&&index!=focus)||(index==focus&&focus_status==1)" class="el-icon-video-play"></i>
            <i v-if="index==focus&&focus_status==0" class="el-icon-video-pause"></i>
        </div> -->
        </div>
        <div style="height: 100%; width: 500px; min-width: 300px">
          <div class="titleandauthor" @click="ToDetail(item.audioId)">
            <span
              style="font-size: 25px; font-weight: bold; margin-right: 20px"
              >{{ item.audioName }}</span
            >
            <el-tag
              v-for="(tag, index) in item.tagList"
              :key="index + 1000"
              style="
                margin: 0px 5px;
                padding: 0px 5px;
                height: 20px;
                line-height: 20px;
              "
            >
              {{ tag.tagName }}
            </el-tag>
            <br />
            <span style="font-size: 15px; font-weight: 100; color: #a7a8bd">{{
              item.authorName
            }}</span>
          </div>
        </div>

        </div>
        <div
          style="
            display: flex;
            float: right;
            margin: 10px 0px;
            line-height: 70px;
          "
        >
          <el-dropdown>
            <div
              class="like"
              :style="{ color: ifLike[index] == 1 ? '#FFD700' : 'white' }"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="16"
                height="16"
                fill="currentColor"
                class="bi bi-star-fill"
                viewBox="0 0 16 16"
              >
                <path
                  d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"
                />
              </svg>
            </div>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item
                v-for="collection in myCollect"
                :key="collection.id"
                :disabled="judgeDisabled(index, collection.id)"
                @click.native="addAudioToCollect(item.audioId, collection.id)"
              >
                {{ collection.collectionName }}
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <div class="like" v-if="item.identity==0">
        
          <svg
            xmlns="http://www.w3.org/2000/svg"
            @click="download(item.audioUrl, item.audioName)"
            width="16"
            height="16"
            fill="white"
            class="bi bi-download"
            viewBox="0 0 16 16"
          >
            <path
              d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5z"
            />
            <path
              d="M7.646 11.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V1.5a.5.5 0 0 0-1 0v8.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3z"
            />
          </svg>
        </div>
        <div style="margin: 0px 10px; font-size: 15px">
          <!-- {{item.length}} -->
        </div>
      </div>
    </div>
    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="current"
      :limit.sync="size"
      @pagination="updateList"
    />
  </div>
</template>

<style scoped>
.item {
  height: 80px;
  width: 90%;
  padding: 10px 10px;
  display: flex;
  justify-content: space-between;
  border-bottom: 1px solid rgb(197, 193, 193);
}
.icon {
  width: 70px;
  height: 70px;
  min-width: 70px;
  float: left;
  border-radius: 4px;
  background: transparent;
  cursor: pointer;
  /* line-height: 50px; */
}
.like {
  margin-left: 15px;
  margin-top: 20px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  width: 32px;
  height: 32px;
  border-radius: 8px;
  /* background-color: rgba(12, 70, 43, 0.5); */
  background-color: #2c3e50;
  cursor: pointer;
}
.img_1 {
  width: 80px;
  height: 80px;
  object-fit: cover;
}
.playorpause {
  width: 100%;
  height: 100%;
  font-size: 50px;
  line-height: 80px;
  text-align: center;
  overflow: hidden;
}
.titleandauthor {
  width: 400px;
  min-width: 200px;
  height: 100%;
  float: left;
  text-align: left;
  margin-left: 10px;
  cursor: pointer;
}
.hover_icon {
  opacity: 0.7;
  background-color: gray;
}
.rank {
  line-height: 80px;
  font-size: 20px;
  font-weight: bold;
  margin-right: 10px;
  min-width: 40px;
}
/* .aplayer.aplayer-narrow{
    width: 70px;
} */
</style>
<script>
import APlayer from "@moefe/vue-aplayer";
import Pagination from "@/components/Pagination";
export default {
  components: { APlayer, pagination: Pagination },
  name: "MusicItems",
  props: ["musics", "rank", "total"],
  data: () => ({
    focus_status: 1,
    focus: -1,
    cursor: -1,
    ifLike: [],
    audio: [],
    myCollect: [],
    userId: "",
    collection_info: [],
    size: 10,
    current: 1,
  }),
  computed: {},
  mounted() {
    this.userId = sessionStorage.getItem("userId");
    this.$axios
      .get("http://localhost:8088/Collection/GetByOwner", {
        params: { ownerId: this.userId },
        crossDomain: true,
      })
      .then((response) => {
        console.log("myCollection", response.data);
        this.myCollect = response.data;
      });
  },

  mounted() {
    this.userId = sessionStorage.getItem("userId");
    this.$axios
      .get("http://localhost:8088/Collection/GetByOwner", {
        params: { ownerId: this.userId },
        crossDomain: true,
      })
      .then((response) => {
        //   console.log("myCollection", response.data);
        this.myCollect = response.data;
      });
  },
  methods: {
    ret_img(imgUrl) {
      if (imgUrl) return imgUrl;
      else return require("../assets/music-note.svg");
    },

    change_status(index) {
      // console.log(this.musics)
      // if(this.focus_status==0&&this.focus!=index)this.focus_status=1;//正在播放，却点了其他的，就暂停刚刚那个
      // this.focus=index;
      // if(this.focus_status==1)this.focus_status=0;
      // else this.focus_status=1;
      // console.log("focus:"+this.focus);
      // console.log("focus_status:"+this.focus_status);
    },
    like(index) {
      if (this.ifLike[index]) this.$set(this.ifLike, index, 0);
      else this.$set(this.ifLike, index, 1);
    },
    download(url, name) {
      const a = document.createElement("a");
      fetch(url)
        .then((res) => res.blob())
        .then((blob) => {
          // 将链接地址字符内容转变成blob地址
          a.href = URL.createObjectURL(blob);
          console.log(a.href);
          a.download = `${name}.mp3`;
          document.body.appendChild(a);
          a.click();
        });
    },
    ToDetail(id) {
      this.$router.push({ path: "/music", query: { id: id } });
    },
    addAudioToCollect(audioId, collectId) {
      this.$axios
        .post("http://localhost:8088/Collection/AddMusic", {
          acAudioId: audioId,
          acCollectionId: collectId,
        })
        .then((res) => {
          console.log(res);
          if (res.data.status == 1) {
            this.$message({
              message: "收藏成功",
              type: "success",
            });
            //this.collectDialog = false;
          } else this.$message.error("歌曲已存在");

          var json = JSON.stringify(this.musics);
          this.musics = JSON.parse(json);
        })
        .catch((res) => {
          this.$message.error("收藏失败");
        });
    },
    judgeDisabled(index, id) {
      var items = this.collection_info[index];
      for (var i = 0; i < items.length; i++) {
        if (id == items[i].collectionId) return true;
      }
      return false;
    },

    judgeDisabled(index, id) {
      var items = this.collection_info[index];
      for (var i = 0; i < items.length; i++) {
        if (id == items[i].collectionId) return true;
      }
      return false;
    },
    updateList() {
      let obj = {};
      obj.size = this.size;
      obj.current = this.current;
      obj.total = this.total;
      this.$emit("pagePara", obj);
      // let json=JSON.stringify(this.musics);
      // this.musics=JSON.parse(json);
    },
    async updateinfo() {
      console.log(this.total);
      this.collection_info = [];
      for (let i = 0; i < this.musics.length; i++) {
        //查询Collection
        await this.$axios
          .get(
            "http://localhost:9003/audioPublic/findCollectionByAudioIdAndUserId?audioId=" +
              this.musics[i].audioId +
              "&userId=" +
              this.userId
          )
          .then((response) => {
            this.collection_info.push(response.data.data);
            if (response.data.data.length > 0) this.$set(this.ifLike, i, 1);
          });
        //查询作者名
        let url = "http://localhost:9003/user/" + this.musics[i].apubAuthorId;
        this.$axios.get(url).then((response) => {
          let name = response.data.data.userName;
          this.musics[i].authorName = name;
          this.$forceUpdate();
        });
        this.ifLike.push(0);
        var obj = {
          url: this.musics[i].audioUrl,
          cover: this.musics[i].imgUrl
            ? this.musics[i].imgUrl
            : "https://tse4-mm.cn.bing.net/th/id/OIP-C.ZkStbVGg090MvZjs5KlGuwHaFJ",
          artist: "name",
          name: "name",
        };
        this.audio.push(obj);
      }
      //   console.log(this.audio)
    },
  },
  watch: {
    musics: {
      handler(newValue, oldValue) {
        this.updateinfo();
      },
    },
  },
};
</script>