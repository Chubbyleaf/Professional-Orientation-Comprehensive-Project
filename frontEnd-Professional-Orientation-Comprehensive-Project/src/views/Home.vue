<template>
  <div class="home">
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

    <el-carousel
      :interval="5000"
      arrow="always"
      :height="bannerHeight"
      style="border-radius: 10px; margin-bottom: 2%; margin-top: 0.5%"
    >
      <el-carousel-item v-for="item in carImage" :key="item.id">
        <el-row>
          <el-col :span="24"><img :src="item.su" class="banner_img" /></el-col>
        </el-row>
      </el-carousel-item>
    </el-carousel>

    <span
      style="
        font-size: 30px;
        font-weight: bold;
        margin: 10px 10px;
        float: left;
        text-align: left;
        width: 100%;
      "
    >
      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="26"
        height="26"
        fill="currentColor"
        class="bi bi-tags-fill"
        viewBox="0 0 16 16"
      >
        <path
          d="M2 2a1 1 0 0 1 1-1h4.586a1 1 0 0 1 .707.293l7 7a1 1 0 0 1 0 1.414l-4.586 4.586a1 1 0 0 1-1.414 0l-7-7A1 1 0 0 1 2 6.586V2zm3.5 4a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z"
        />
        <path
          d="M1.293 7.793A1 1 0 0 1 1 7.086V2a1 1 0 0 0-1 1v4.586a1 1 0 0 0 .293.707l7 7a1 1 0 0 0 1.414 0l.043-.043-7.457-7.457z"
        />
      </svg>
      标签</span
    >
    <div style="width: 100%; min-width: 600px; height: 300px">
      <swiper class="swiper" ref="mySwiper" :options="swiperOption">
        <swiper-slide v-for="item in tagList" :key="item.tagId">
          <div class="tag" @click="toTag(item)">
            {{ item.tagName }}
          </div>
        </swiper-slide>

        <div class="swiper-button-prev" slot="button-prev"></div>
        <div class="swiper-button-next" slot="button-next"></div>
      </swiper>
    </div>

    <div style="display: flex">
      <div
        style="
          min-width: 400px;
          width: 600px;
          background-color: rgba(255, 255, 255, 0.75);
          text-align: left;
          display: flex;
          flex-direction: column;
        "
      >
        <span style="font-size: 30px; font-weight: bold; padding: 30px 10px">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="26"
            height="26"
            fill="currentColor"
            class="bi bi-music-note-list"
            viewBox="0 0 16 16"
          >
            <path
              d="M12 13c0 1.105-1.12 2-2.5 2S7 14.105 7 13s1.12-2 2.5-2 2.5.895 2.5 2z"
            />
            <path fill-rule="evenodd" d="M12 3v10h-1V3h1z" />
            <path
              d="M11 2.82a1 1 0 0 1 .804-.98l3-.6A1 1 0 0 1 16 2.22V4l-5 1V2.82z"
            />
            <path
              fill-rule="evenodd"
              d="M0 11.5a.5.5 0 0 1 .5-.5H4a.5.5 0 0 1 0 1H.5a.5.5 0 0 1-.5-.5zm0-4A.5.5 0 0 1 .5 7H8a.5.5 0 0 1 0 1H.5a.5.5 0 0 1-.5-.5zm0-4A.5.5 0 0 1 .5 3H8a.5.5 0 0 1 0 1H.5a.5.5 0 0 1-.5-.5z"
            />
          </svg>
          今日排行</span
        >

        <MusicItems :musics="musics" :rank="true"></MusicItems>
      </div>
      <div
        style="
          min-width: 300px;
          width: 500px;
          background-color: rgba(255, 255, 255, 0.75);
          text-align: left;
          display: flex;
          flex-direction: column;
          margin: 0px 30px;
        "
      >
        <span style="font-size: 30px; font-weight: bold; padding: 30px 10px">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="26"
            height="26"
            fill="currentColor"
            class="bi bi-stars"
            viewBox="0 0 16 16"
          >
            <path
              d="M7.657 6.247c.11-.33.576-.33.686 0l.645 1.937a2.89 2.89 0 0 0 1.829 1.828l1.936.645c.33.11.33.576 0 .686l-1.937.645a2.89 2.89 0 0 0-1.828 1.829l-.645 1.936a.361.361 0 0 1-.686 0l-.645-1.937a2.89 2.89 0 0 0-1.828-1.828l-1.937-.645a.361.361 0 0 1 0-.686l1.937-.645a2.89 2.89 0 0 0 1.828-1.828l.645-1.937zM3.794 1.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387A1.734 1.734 0 0 0 4.593 5.69l-.387 1.162a.217.217 0 0 1-.412 0L3.407 5.69A1.734 1.734 0 0 0 2.31 4.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387A1.734 1.734 0 0 0 3.407 2.31l.387-1.162zM10.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732L9.1 2.137a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L10.863.1z"
            />
          </svg>
          精选作者</span
        >
        <div style="margin-left: 20px; width: 100%">
          <UserList :users="users"></UserList>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
// @ is an alias to /src
import TagList from "@/components/TagList.vue";
import MusicItems from "@/components/MusicItems.vue";
import UserList from "@/components/UserList.vue";
import { Swiper, SwiperSlide, directive } from "vue-awesome-swiper";

// import style (>= Swiper 6.x)
import "swiper/swiper-bundle.css";
// 引入SwiperCore和需要的模块
import SwiperCore, { Autoplay, Navigation, Pagination } from "swiper";
// 注册模块
SwiperCore.use([Autoplay, Navigation, Pagination]);
export default {
  components: {
    TagList,
    MusicItems,
    UserList,
    Swiper,
    SwiperSlide,
  },
  directives: {
    swiper: directive,
  },

  data() {
    return {
      musics: [
        {
          audioId: "1",
          audioName: "冥想者",
          length: "2:30",
          authorName: "李佳颖",
          img_url:
            "https://tse1-mm.cn.bing.net/th/id/R-C.f65e69d0e798cd7d560ac05e1364ee40?rik=RAYCqHwEZBONHA&riu=http%3a%2f%2fimage.bamen.bbs.bamenzhushou.com%2fe6ac0b28-cadc-4ed2-9daa-cd5237c41381.jpg&ehk=9QIlZ6kR%2fZG2uS6UhrKgfekc%2f9r1H%2foqaM4%2bE71COX8%3d&risl=&pid=ImgRaw&r=0",
        },
        {
          audioId: "2",
          audioName: "222我",
          length: "2:30",
          authorName: "tyyywww",
          img_url: "",
        },
        {
          audioId: "3",
          audioName: "胎教音乐",
          length: "2:30",
          authorName: "世界上最美丽的熊祯琪",
          img_url: "",
        },
      ],
      bannerHeight: "",
      screenWidth: 0,
      carImage: [
        {
          id: 0,
          su: "http://rbz8c5rhq.hd-bkt.clouddn.com/img-78e1802ea3f96f7de6630856bfd3ddf5.jpg",
        },
        {
          id: 1,
          su: "http://rbz8c5rhq.hd-bkt.clouddn.com/img-7b831697a74fab6646c0a55e031882ed.jpg",
        },
        {
          id: 2,
          su: "http://rbz8c5rhq.hd-bkt.clouddn.com/Konachan.com%20-%20184293%20sample.jpg",
        },
        {
          id: 3,
          su: "https://cdn.vuetifyjs.com/images/cards/sunshine.jpg",
        },
      ],
      audio_image: "https://cdn.vuetifyjs.com/images/cards/docks.jpg",

      audioList: [
        {
          audioId: "1",
          name: "name",
          des: "des",
        },
      ],
      tagList: [
        {
          id: "1",
          name: "自然",
        },
        {
          id: "2",
          name: "爵士",
        },
        {
          id: "3",
          name: "钢琴",
        },
        {
          id: "4",
          name: "蓝调",
        },
        {
          id: "5",
          name: "baby",
        },
        {
          id: "6",
          name: "伴奏",
        },
        {
          id: "7",
          name: "打击",
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
      // swiperOptions: {
      //     // 分页器
      //     pagination: {
      //       el: '.swiper-pagination',   // 分页器元素
      //       clickable: true   // 点击分页器切换
      //     },
      //     // Some Swiper option/callback...
      //   }

      swiperOption: {
        preventClicks: false,
        loop: false,
        slidesPerView: 5,
        spaceBetween: 30,
        direction: "horizontal",
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
        // on: {
        //   click: function(){
        //     vm.toTag()

        //     alert('你点了Swiper');
        //   },
        //   resize: () => {
        //     this.$refs.mySwiper.$swiper.changeDirection(
        //       window.innerWidth <= 960
        //         ? 'vertical'
        //         : 'horizontal'
        //     )
        //   }
        // }
      },
    };
  },
  // created() {
  //       vm = this;
  //   },
  computed: {
    // 计算属性拿到swiper实例
    swiper() {
      // this.$refs.mySwiper拿到Swiper vue组件实例，
      // 而它身上挂载的$swiper就是swiper实例，可以通过swiper实例来操作slider。
      return this.$refs.mySwiper.$swiper;
    },
  },
  methods: {
    // setSize: function () {
    //   // 通过浏览器宽度(图片宽度)计算高度
    //   this.bannerHeight = (400 / 1920) * this.screenWidth;
    // },
    toTag(item) {
      console.log("tag");
      this.$router.push({ path: "/search", query: { tag: item.tagId } });
    },
  },
  computed: {},

  mounted() {
    this.$axios
      .get("http://localhost:9003/audioPublic/topAudio")
      .then((response) => {
        this.musics = response.data.data;
      });
    this.$axios.get("http://localhost:9003/user/topUser").then((response) => {
      this.users = response.data.data;
    });

    this.$axios.get("http://localhost:9003/tag").then((response) => {
      this.tagList = response.data.data.records;
    });
    this.$refs.mySwiper.$swiper.slideTo(0, 1000, false);
  },
};
</script>
<style  scoped>
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
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.home {
  margin-left: 5%;
  margin-right: 5%;
  border-radius: 10px;
}
.banner_img {
  /*设置图片宽度和浏览器宽度一致*/
  width: 100%;
  height: inherit;
}
.el-scrollbar__wrap {
  overflow-x: hidden;
  overflow-y: hidden;
}
.back {
  margin-left: 10%;
  margin-right: 10%;
  border-radius: 20px;
}
.setHeight {
  overflow: hidden;

  -webkit-line-clamp: 1;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  text-overflow: ellipsis;
}
.tag {
  width: 100%;
  height: 100%;
  color: white;
  background-image: url("../assets/music_bg.jpg");
  cursor: pointer;
  line-height: 200px;
}

.el-carousel__item--card.is-in-stage {
  height: 100px;
  width: 100px;
}
</style>
<style lang="scss" scoped>
// @import '../styles/base.scss';
$font-size-huge: 20px;

.swiper {
  height: 200px;
  width: 100%;

  .swiper-slide {
    display: flex;
    // justify-content: center;
    // align-items: center;
    // text-align: center;
    font-weight: bold;
    font-size: $font-size-huge * 2;
    cursor: pointer;

    // background-image: url("../assets/music_bg.jpg");
  }
}
$container-width: 300px;
@media (max-width: $container-width) {
  .swiper-button-next {
    right: 20px;
    transform: rotate(90deg);
  }

  .swiper-button-prev {
    left: 20px;
    transform: rotate(90deg);
  }
}
</style>