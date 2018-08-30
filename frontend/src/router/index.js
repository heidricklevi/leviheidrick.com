import Vue from 'vue';
import Router from 'vue-router';
import Home from '../components/home/Home';
import Projects from '../components/projects/projects-section';
import Skills from '../components/home/skills-section';
import HomeIntro from '../components/home/home-intro';
import Login from '../components/auth/login';
import ProjectDetail from '../components/projects/project-detail';
import Admin from '../components/admin/admin';
import AdminProjects from '../components/admin/admin-projects'

/* eslint-disable */

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: HomeIntro,
      meta: {
        breadcrumb: [
          {
            text: "Home",
            url: "/",
            disabled: false,
          }
        ]
      }
    },

    {
      path: '/admin',
      name: 'admin',
      component: Admin,
      meta: {
        breadcrumb: [
          {
            text: "Home",
            url: "/",
            disabled: false,
          },
          {
            text: "Admin",
            url: "/admin",
            disabled: true,
          }
        ]
      },

      children: [
        {
          path: 'projects',
          component: AdminProjects,
          meta: {
            breadcrumb: [
              {
                text: "Home",
                url: "/",
                disabled: false,
              },
              {
                text: "Admin",
                url: "/admin",
                disabled: false,
              },
              {
                text: "Projects",
                url: "/admin",
                disabled: true,
              }
            ]
          }
        },

      ]
    },


    {
      path: '/login',
      name: 'login',
      component: Login
    },

    {
      path: '/projects',
      name: 'projects',
      component: Projects,
      meta: {
        breadcrumb: [
          {
            text: "Home",
            url: "/",
            disabled: false,
          },

          {
            text: "Projects",
            url: "/projects",
            disabled: true,
          }
        ]
      }
    },

    {
      name: 'project-details',
      path: '/projects/:name',
      component: ProjectDetail,
      meta: {
        breadcrumb: [
          {
            text: "Home",
            url: "/",
            disabled: false,
          },

          {
            text: "Projects",
            url: "/projects",
            disabled: false,
          },

          {
            text: "Details",
            url: "/projects/details",
            disabled: true,
          }
        ]
      }
    },

    {
      path: '/skills',
      name: 'skills',
      component: Skills,
      meta: {
        breadcrumb: [
          {
            text: "Home",
            url: "/",
            disabled: false,
          },
          {
            text: "Skills",
            url: "/skills",
            disabled: true,
          },
        ]
      }

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
