// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import store from './store/index'
import Viewer from 'v-viewer'
import Vuetify from 'vuetify'

require('vue2-animate/dist/vue2-animate.min.css');

import './stylus/main.styl'
import 'viewerjs/dist/viewer.css'


Vue.config.productionTip = false;

Vue.use(Vuetify, {
  theme: {
    primary: '#2196F3',
  },
  iconfont: 'fa',
  icons: {
    code: 'fas fa-code',
  }
});

Vue.use(Viewer, {
  defaultOptions: {
    zIndex: 9999
  }
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
});
