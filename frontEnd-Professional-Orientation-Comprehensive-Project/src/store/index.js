import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    isSignIn: sessionStorage.getItem("userId") > 0,
  },
  mutations: {
  },
  actions: {
  },
  modules: {
  }
})
