// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Vuetify from 'vuetify'
import store from './store/index'


require('vue2-animate/dist/vue2-animate.min.css');


Vue.config.productionTip = false;

Vue.use(Vuetify, {
  theme: {
    primary: '#485563',
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
