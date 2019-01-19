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
          <v-list-tile  :key="item.text" :to="item.url">
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
        class="py-2"
        app
        fixed
        :absolute="$vuetify.breakpoint.smAndDown"
        clipped-left
        color="#1E232A"
      >
        <v-container class="py-0" id="toolbarContainer">
          <v-layout row wrap align-center>
            <v-avatar size="56"><img src="/static/levi-heidrick1.png"></v-avatar>
            <v-toolbar-title class="headline">Levi Heidrick</v-toolbar-title>
            <v-spacer></v-spacer>
            <v-toolbar-side-icon v-if="$vuetify.breakpoint.smAndDown" @click.prevent="drawer = !drawer"></v-toolbar-side-icon>
            <v-btn v-if="auth.isAuthenticated" @click.prevent="logout" flat color="error" dark>Logout</v-btn>
            <v-btn v-if="hasHighestCredentials" :to="{ path: '/admin/' }" color="warning">admin</v-btn>
            <v-btn v-if="$vuetify.breakpoint.mdAndUp" :to="{ path: '/contact' }" flat dark>Contact</v-btn>
            <v-btn v-if="$vuetify.breakpoint.mdAndUp" to="/about" dark flat>About</v-btn>
            <v-btn v-if="$vuetify.breakpoint.mdAndUp" to="/skills" dark flat>Skills</v-btn>
            <v-btn v-if="$vuetify.breakpoint.mdAndUp" to="/projects" dark flat>Projects</v-btn>
          <!--<v-btn v-if="$vuetify.breakpoint.mdAndUp" :href="resume.url" dark flat target="_blank">Resume.pdf</v-btn>-->
          </v-layout>

        </v-container>
      </v-toolbar>
    <v-content>
      <breadcrumbs />
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
          <span>&copy; 2018 Levi Heidrick</span>
        </v-flex>
        <v-flex xs12 text-xs-center>
          <div class="caption">
            <span>01/19/2019</span>
            <span>v0.9.1</span>
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
        { text: 'Projects', icon: '', url: '/projects'},
        { text: 'Skills', icon: '', url: '/skills'},
        { text: 'About', icon: 'fa fa-question', url: '/about'},
        { text: 'Contact', icon: 'info', url: '/contact'},
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
    logout() {
      this.$store.dispatch('auth/logout');
    }
  }
}
</script>

<style lang="stylus">
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
