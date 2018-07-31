import Vue from 'vue'
import Router from 'vue-router'
import Home from '../components/home/Home'
import Projects from '../components/home/projects-section'
import Skills from '../components/home/skills-section'
import HomeIntro from '../components/home/home-intro'


/* eslint-disable */

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: HomeIntro
    },

    {
      path: '/projects',
      name: 'projects',
      component: Projects
    },

    {
      path: '/skills',
      name: 'skills',
      component: Skills
    },


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
