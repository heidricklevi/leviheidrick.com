<template>
  <v-content>
    <v-toolbar app fixed clipped-left class="elevation-0" color="primary">
      <v-avatar to="/" size="56"><img src="/static/levi-heidrick1.png"></v-avatar>
      <v-toolbar-title class="headline">Levi Heidrick</v-toolbar-title>
      <v-spacer></v-spacer>
      <div v-if="auth.user" >
        <h4 class="subheading">Hello, {{auth.user.name}}</h4>
      </div>
      <v-btn v-if="auth.isAuthenticated" @click.prevent="logout" flat color="error" dark>Logout</v-btn>
      <div id="warn-super-admin"><v-btn icon v-if="auth.isSuperAdmin" flat color="error" dark small><v-icon small class="pr-1">warning </v-icon>Super Admin</v-btn></div>
    </v-toolbar>
    <router-view></router-view>
    <v-footer app height="auto" class="footer-color">
      <v-layout row wrap justify-center align-center class="pa-2">
        <v-flex xs12 text-xs-center>
          <span>&copy; 2018 Levi Heidrick</span>
        </v-flex>
        <v-flex xs12 text-xs-center>
          <div class="caption">
            <span>08/07/2018</span>
            <span>v0.0.5</span>
          </div>
        </v-flex>
        <v-flex xs12 md6 lg3 offset-lg9 offset-md6 text-xs-center>
          <div class="caption">Some icons made by <a href="https://www.flaticon.com/authors/eucalyp" title="Eucalyp">Eucalyp</a> from
            <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a> is licensed by
            <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a>
          </div>
        </v-flex>
      </v-layout>
    </v-footer>
  </v-content>
</template>

<script>
  import SkillsSection from "./skills-section.vue";
  import ProjectsSection from "./projects-section.vue";
  import HomeIntro from "./home-intro";


export default {
  name: 'Home',
  components: {
    HomeIntro,
    SkillsSection,
    ProjectsSection,
  },
  created() {
    this.$store.dispatch('auth/checkAuth');
  },
  computed: {
    auth() {
      return this.$store.getters['auth/auth'];
    }
  },
  data () {
    return {
      drawer: false,

    }
  },

  methods: {
    logout() {
      this.$store.dispatch('auth/logout');
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
  .flex .v-list.no-background-color {
    background-color: unset!important;
  }

  .uppercase {
    text-transform: uppercase!important;
  }

  .letter_spacing {
    letter-spacing: 1px!important;
  }

  .v-card.card-side-border {
    border-left: 1rem solid #485563;
  }

  #warn-super-admin {
    position: absolute;
    top: 45px;
    right: 60px;
  }
</style>
