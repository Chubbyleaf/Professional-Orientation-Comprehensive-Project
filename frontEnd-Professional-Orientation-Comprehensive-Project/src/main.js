import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import VueAMap from 'vue-amap'
import VueParticles from 'vue-particles'
import axios from 'axios'
import VueAxios from 'vue-axios'

import { parseTime, resetForm } from "@/utils/tool"
import APlayer from '@moefe/vue-aplayer'
Vue.use(APlayer, {
  defaultCover: 'https://github.com/u3u.png',
  productionTip: true,
});
Vue.use(VueParticles)
Vue.use(ElementUI)
Vue.use(VueAMap)
Vue.use(VueAxios, axios)
Vue.prototype.parseTime = parseTime
Vue.prototype.resetForm = resetForm
Vue.config.productionTip = false
// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
Vue.prototype.$axios = axios
VueAMap.initAMapApiLoader({
  // 高德的key
  key: 'f7e629b24af1fc3bd70700a0cefc0c0a',
  uiVersion: '1.0.11',// 版本号
  // 插件集合
  plugin: ['AMap.Geocoder', 'AMap.Autocomplete', 'AMap.PlaceSearch', 'AMap.Scale', 'AMap.OverView', 'AMap.Geolocation', 'AMap.ToolBar', 'AMap.MapType', 'AMap.PolyEditor', 'AMap.CircleEditor'],
  // 高德 sdk 版本，默认为 1.4.4
  v: '1.4.4'

});

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
