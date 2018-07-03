import Vue from 'vue'
import Router from 'vue-router'
import Home from '../components/home/Home'

/* eslint-disable */

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    }
  ],

  scrollBehavior (to, from, savedPosition) {
    if (savedPosition){
      return savedPosition;
    }
    else {
      return { x: 0, y: 0};
    }
  }
})
