<template>
  <v-app dark>
    <loading v-if="$store.getters['loading/isLoading']"></loading>

    <v-navigation-drawer
      v-if="$vuetify.breakpoint.smAndDown"
      v-model="drawer"
      fixed
      clipped-right
      app
    >
      <v-list>
        <template v-for="item in navItems">
          <v-list-tile v-if="!item.selector && item.url" :key="item.text" :to="item.url">
            <v-list-tile-action>
              <v-icon>{{ item.icon }}</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>
                {{ item.text }}
              </v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
          <v-list-tile v-else-if="item.selector" @click.prevent="goTo(item.selector)" :key="item.text">
            <v-list-tile-action>
              <v-icon>{{ item.icon }}</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>
                {{ item.text }}
              </v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
        </template>
        <v-list-tile v-if="resume && resume.url" :href="resume.url" target="_blank">
          <v-list-tile-action>
            <v-icon>cloud_download</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>
              Resume.pdf
            </v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-navigation-drawer>
      <v-toolbar
        v-if="!$route.path.includes('admin')"
        class="px-0 main-hover"
        app
        flat
        fixed
        :absolute="$vuetify.breakpoint.smAndDown"
        clipped-left
        color="rgb(0, 1, 2)"
        height="52"
      >
        <router-link class="header__logo-wrap main-hover d-flex" to="/">
          <span class="header__logo-wrap--text">
            LH
          </span>
          <span class="header__logo-wrap--name" :class="{'d-block': $vuetify.breakpoint.smAndUp}">
            Levi Heidrick
          </span>
        </router-link>
        <v-container class="py-0" id="toolbarContainer">
          <v-layout row wrap align-center>
            <!--<v-avatar size="56"><img src="/static/levi-heidrick1.png"></v-avatar>-->
            <!--<v-toolbar-title class="headline">Levi Heidrick</v-toolbar-title>-->
            <v-spacer></v-spacer>
            <!--<v-toolbar-side-icon v-if="$vuetify.breakpoint.smAndDown" @click.prevent="drawer = !drawer"></v-toolbar-side-icon>-->
            <!--<v-btn v-if="auth.isAuthenticated" @click.prevent="logout" flat color="error" dark>Logout</v-btn>-->
            <!--<v-btn v-if="hasHighestCredentials" :to="{ path: '/admin/' }" color="warning">admin</v-btn>-->
            <!--<v-btn v-if="$vuetify.breakpoint.mdAndUp" :to="{ path: '/contact' }" flat dark>Contact</v-btn>-->
            <!--<v-btn v-if="$vuetify.breakpoint.mdAndUp" to="/about" dark flat>About</v-btn>-->
            <!--<v-btn v-if="$vuetify.breakpoint.mdAndUp" :to="{ path: '/' }" @click.prevent="goTo('#section-skills')" dark flat>Skills</v-btn>-->
            <!--<v-btn v-if="$vuetify.breakpoint.mdAndUp" to="/projects" dark flat>Projects</v-btn>-->
          <!--<v-btn v-if="$vuetify.breakpoint.mdAndUp" :href="resume.url" dark flat target="_blank">Resume.pdf</v-btn>-->
          </v-layout>

        </v-container>
      </v-toolbar>
    <v-content>
      <router-view />
      <experience v-if="$route.fullPath === '/'" />
      <skills-section v-if="$route.fullPath === '/'" />
    </v-content>
    <v-footer
      app
      height="auto"
      color="#000102"
      absolute
      class="footer__border-top"
    >
      <v-layout
        row
        wrap
        justify-center
        align-center
        class="pa-2"
      >
        <v-flex xs12 text-xs-center>
          <span>&copy; 2019 Levi Heidrick</span>
        </v-flex>
        <v-flex xs12 text-xs-center>
          <div class="caption">
            <span>03/23/2019</span>
            <span>v0.9.3</span>
            <span class="font-italic orange--text text--lighten-2">
              Full Launch Coming Soon
            </span>
          </div>
        </v-flex>
      </v-layout>
    </v-footer>
  </v-app>
</template>

<script>

import SkillsSection from "../src/components/home/skills-section.vue"
import Breadcrumbs from "../src/components/global/breadcrumbs.vue";
import Experience from "../src/components/experience/experience.vue";

import Loading from "../src/components/global/loading.vue"
import { mapGetters } from "vuex";


export default {
  name: 'App',
  components: { SkillsSection, Loading, Breadcrumbs, Experience },
  async created() {
    await this.$store.dispatch('auth/checkAuth');
    this.$store.dispatch('resume/fetchResume').then(() => {});
  },

  data () {
    return {
      drawer: false,
      show: false,
      navItems: [
        // { text: 'Projects', icon: '', url: '/projects'},
        // { text: 'Skills', icon: '', selector: '#section-skills'},
        // { text: 'About', icon: 'fa fa-question', url: '/about'},
        // { text: 'Contact', icon: 'info', url: '/contact'},
      ],

      resumeItem: {
        text: 'Resume.pdf',
        icon: 'cloud_download',
        url: false
      }
    }
  },

  computed: {

    ...mapGetters('auth/',[
      'hasHighestCredentials'
    ]),

    ...mapGetters('resume/', ['resume']),

    auth() {
      return this.$store.getters['auth/auth'];
    },

  },
  methods: {
    goTo(selector) {
      this.$vuetify.goTo(selector);
    },
    logout() {
      this.$store.dispatch('auth/logout');
    }
  }
}
</script>

<style lang="stylus">

  .main-hover:hover {
    .header__logo-wrap--name {
      transform: translate3d(80px, 0px, 0px);
      transition: all 0.3s cubic-bezier(0.165, 0.84, 0.44, 1) 0s;
    }
  }
  .header__logo-wrap {
    &--text {
      text-transform: uppercase;
      font-weight: 900;
      letter-spacing: 1px;
      color: rgb(17, 17, 17);
      position: relative;
      z-index: 10;
      font-size: 26px;
      height: 52px;
      width: 52px;
      display: block;
      background: rgb(255, 183, 77);
      padding: 10px;
      overflow: hidden;

      &::before {
        content: "";
        left: 0px;
        height: 52px;
        width: 200px;
        position: absolute;
        display: block;
        z-index: -1;
        transform: translate3d(52px, 0px, 0px);
        background-image: linear-gradient(90deg, rgb(22, 160, 133) 33.333%, rgb(231, 76, 60) 33.333%, rgb(231, 76, 60) 66.667%, rgb(41, 128, 185) 66.667%);
        background-size: 156px 52px;
        transition: all 0.3s cubic-bezier(0.86, 0, 0.07, 1) 0s;
      }
    }

    &--name {
      top: 0px;
      position: absolute;
      display: none;
      z-index: 5;
      transform: translate3d(-100%, 0px, 0px);
      text-transform: uppercase;
      letter-spacing: 5px;
      font-size: 24px;
      font-weight: 900;
      line-height: 52px;
      color: rgb(255, 255, 255);
      margin: 0px;
      text-decoration: none;
      transition: all 0.3s cubic-bezier(0.895, 0.03, 0.685, 0.22) 0s;
    }
  }
  #toolbarContainer {
    margin: auto!important;
  }
  .footer {
    &__border {
      &-top {
        border-top-color #354D6D
      }
    }
  }

  .uppercase {
    text-transform: uppercase!important;
  }

  .letter_spacing {
    letter-spacing: 1px;
  }

</style>
