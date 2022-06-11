import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    //音乐大厅
    path: '/test',
    name: 'Test',
    component: () => import('../views/Test.vue')
  },
  {
    //音乐大厅
    path: '/hall',
    name: 'Hall',
    component: () => import('../views/Hall.vue')
  },
  {
    path: '/login',
    name: 'Login',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/userInfoSys/Login.vue')
  },
  {
    //测试用 无用页面
    path: '/test',
    name: 'Test',
    component: () => import(/* webpackChunkName: "about" */ '../views/Test.vue')
  },
  {
    //个人主页
    path: '/user',
    name: 'User',
    component: () => import(/* webpackChunkName: "about" */ '../views/userInfoSys/User.vue')
  },
  {
    //创作
    path: '/composeZone',
    name: 'ComposeZone',
    component: () => import(/* webpackChunkName: "about" */ '../views/ComposeZone.vue')
  },
  {
    //查看关注和粉丝页面
    path: '/follow',
    name: 'Follow',
    component: () => import(/* webpackChunkName: "about" */ '../views/userInfoSys/Follow.vue')
  },
  {
    //查看关注和粉丝页面
    path: '/follower',
    name: 'Follower',
    component: () => import(/* webpackChunkName: "about" */ '../views/userInfoSys/Follower.vue')
  },

  {
    //消息中心
    path: '/message',
    name: 'Message',
    component: () => import(/* webpackChunkName: "about" */ '../views/userInfoSys/Message.vue')
  },
  {
    //消息中心
    path: '/announce',
    name: 'Announce',
    component: () => import(/* webpackChunkName: "about" */ '../views/userInfoSys/Announce.vue')
  },
  {
    //在线教学
    path: '/onlineTeach',
    name: 'OnlineTeach',
    component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/OTMenu.vue'),
    children: [
      {
        path: '/onlineTeach/index',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/OTIntro.vue')
      },

      //节奏
      {
        path: '/onlineTeach/rhythm/whatSound',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/rhythm/WhatSound.vue')
      },
      {
        path: '/onlineTeach/rhythm/beatTempo',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/rhythm/BeatTempo.vue')
      },
      {
        path: '/onlineTeach/rhythm/tempoGenre',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/rhythm/TempoGenre.vue')
      },
      {
        path: '/onlineTeach/rhythm/bar',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/rhythm/Bar.vue')
      },
      {
        path: '/onlineTeach/rhythm/rockHouse',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/rhythm/RockHouse.vue')
      },

      //音符和音阶
      {
        path: '/onlineTeach/noteScale/exploreNote',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/noteScale/ExploreNote.vue')
      },
      {
        path: '/onlineTeach/noteScale/harmonicScale',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/noteScale/HarmonicScale.vue')
      },
      {
        path: '/onlineTeach/noteScale/addNote',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/noteScale/AddNote.vue')
      },

      //和弦
      {
        path: '/onlineTeach/chord/triad',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/chord/Triad.vue')
      },
      {
        path: '/onlineTeach/chord/GetUp,StandUp',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/chord/GetUp,StandUp.vue')
      },
      {
        path: '/onlineTeach/chord/MaryHadALittleLamb',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/chord/MaryHadALittleLamb.vue')
      },


      //贝斯
      {
        path: '/onlineTeach/bass/bassCreate',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/bass/BassCreate.vue')
      },
      {
        path: '/onlineTeach/bass/GoodLife',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/bass/GoodLife.vue')
      },
      {
        path: '/onlineTeach/bass/AroundTheWorld',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/bass/AroundTheWorld.vue')
      },
      {
        path: '/onlineTeach/bass/UnderMiSlengTeng',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/bass/UnderMiSlengTeng.vue')
      },
      {
        path: '/onlineTeach/bass/NeverTellYou',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/bass/NeverTellYou.vue')
      },
      {
        path: '/onlineTeach/bass/Oblivion',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/bass/Oblivion.vue')
      },

      //旋律
      {
        path: '/onlineTeach/melody/melodyCreate',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/melody/MelodyCreate.vue')
      },
      {
        path: '/onlineTeach/melody/LoveWillTearUsApart',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/melody/LoveWillTearUsApart.vue')
      },
      {
        path: '/onlineTeach/melody/TourDeFrance',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/melody/TourDeFrance.vue')
      },
      {
        path: '/onlineTeach/melody/Praxis',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/melody/Praxis.vue')
      },
      {
        path: '/onlineTeach/melody/Ride',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/melody/Ride.vue')
      },
      {
        path: '/onlineTeach/melody/LoveWillTearUsApart',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/melody/LoveWillTearUsApart.vue')
      },

      //高级话题
      {
        path: '/onlineTeach/advancedTopic/establishMajorScale',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/advancedTopic/EstablishMajorScale.vue')
      },
      {
        path: '/onlineTeach/advancedTopic/mode',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/advancedTopic/Mode.vue')
      },
      {
        path: '/onlineTeach/advancedTopic/pentatonicScale',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/advancedTopic/PentatonicScale.vue')
      },
      {
        path: '/onlineTeach/advancedTopic/diatonicScale',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/advancedTopic/DiatonicScale.vue')
      },
      {
        path: '/onlineTeach/advancedTopic/octave',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/advancedTopic/Octave.vue')
      },
      {
        path: '/onlineTeach/advancedTopic/IndonesianScale',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/advancedTopic/IndonesianScale.vue')
      },
      {
        path: '/onlineTeach/advancedTopic/19',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/advancedTopic/19.vue')
      },
      {
        path: '/onlineTeach/advancedTopic/seventh',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/advancedTopic/Seventh.vue')
      },
      {
        path: '/onlineTeach/advancedTopic/MommyWhatIsARecord',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/advancedTopic/MommyWhatIsARecord.vue')
      },

      //科普结束
      {
        path: '/onlineTeach/end',
        component: () => import(/* webpackChunkName: "about" */ '../views/onTeaSys/OTEnd.vue')
      },

    ],
  },
  //搜索
  {
    path: '/search',
    name: 'Search',
    component: () => import('../views/Search.vue'),
  },
  //音乐详情
  {
    path: '/music',
    name: 'Music',
    component: () => import('../views/Music.vue'),
  },

  {
    //管理员
    path: '/admin',
    name: 'Admin',
    component: () => import('../views/admin/admin.vue'),

    children: [
      {
        path: '/admin/bulletin',
        component: () => import('../views/admin/bulletin.vue')
      },
      {
        path: '/admin/audit',
        component: () => import('../views/admin/audit.vue')
      },
      {
        path: '/admin/tag',
        component: () => import('../views/admin/tag.vue')
      },
    ]
  },


  {
    //在线创作
    path: '/onlineMakeSys',
    name: 'OnlineMake',
    component: () => import(/* webpackChunkName: "about" */ '../views/onlineMakeSys/OTMenu.vue'),
    children: [
      {
        path: '/onlineMake/index',
        component: () => import(/* webpackChunkName: "about" */ '../views/onlineMakeSys/OTIntro.vue')
      },
      //简谱创作
      {
        path: '/onlineMake/notation/index',
        component: () => import(/* webpackChunkName: "about" */ '../views/onlineMakeSys/notation/index.vue')
      },
      // 钢琴创作
      {
        path: '/onlineMake/pinao/index',
        component: () => import(/* webpackChunkName: "about" */ '../views/onlineMakeSys/pinao/index.vue')
      },
      // 鼓点创作
      {
        path: '/onlineMake/taptap/index',
        component: () => import(/* webpackChunkName: "about" */ '../views/onlineMakeSys/taptap/index.vue')
      },
      //科普结束
      {
        path: '/onlineMake/end',
        component: () => import(/* webpackChunkName: "about" */ '../views/onlineMakeSys/OTEnd.vue')
      },

    ],
  },
]

const router = new VueRouter({
  routes
})

export default router
