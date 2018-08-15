import Vue from 'vue';
import Router from 'vue-router';
import Home from '../components/home/Home';
import Projects from '../components/projects/projects-section';
import Skills from '../components/home/skills-section';
import HomeIntro from '../components/home/home-intro';
import Login from '../components/auth/login';
import ProjectDetail from '../components/projects/project-detail';



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
      path: '/login',
      name: 'login',
      component: Login
    },

    {
      path: '/projects',
      name: 'projects',
      component: Projects
    },

    {
      name: 'project-details',
      path: '/projects/:name',
      component: ProjectDetail,
      props: { dialog: true }
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
