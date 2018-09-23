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
    <v-toolbar v-if="!$route.path.includes('admin')" app fixed clipped-left class="elevation-0" color="primary">
      <v-avatar to="/" size="56"><img src="/static/levi-heidrick1.png"></v-avatar>
      <v-toolbar-title class="headline">Levi Heidrick</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-toolbar-side-icon v-if="$vuetify.breakpoint.smAndDown" @click.prevent="drawer = !drawer"></v-toolbar-side-icon>
      <div v-if="auth.user">
        <h4 class="subheading">Hello, {{auth.user.name}}</h4>
      </div>
      <v-btn v-if="auth.isAuthenticated" @click.prevent="logout" flat color="error" dark>Logout</v-btn>
      <v-btn v-if="hasHighestCredentials" :to="{ path: 'admin/' }" color="warning">admin</v-btn>
    </v-toolbar>
    <home/>
    <v-footer app height="auto" class="footer-color">
      <v-layout row wrap justify-center align-center class="pa-2">
        <v-flex xs12 text-xs-center>
          <span>&copy; 2018 Levi Heidrick</span>
        </v-flex>
        <v-flex xs12 text-xs-center>
          <div class="caption">
            <span>09/23/2018</span>
            <span>v0.2.1</span>
          </div>
        </v-flex>
      </v-layout>
    </v-footer>
  </v-app>
</template>

<script>

import Home from "../src/components/home/Home.vue"
import Loading from "../src/components/global/loading.vue"
import { mapGetters } from "vuex";


export default {
  name: 'App',
  components: { Home, Loading },
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

<style>
  .footer-color {
    background-color: #29323c!important;
  }

  .uppercase {
    text-transform: uppercase!important;
  }

  .letter_spacing {
    letter-spacing: 1px;
  }

</style>
