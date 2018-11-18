// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Vuetify from 'vuetify'
import store from './store/index'
import Viewer from 'v-viewer'

import './stylus/main.styl'
import 'viewerjs/dist/viewer.css'
require('vue2-animate/dist/vue2-animate.min.css');


Vue.config.productionTip = false;

Vue.use(Vuetify, {
  theme: {
    primary: '#485563',
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
