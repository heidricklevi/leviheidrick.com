<template>
  <v-content>
    <v-toolbar app fixed clipped-left class="elevation-0" color="primary">
      <v-avatar to="/" size="56"><img src="/static/levi-heidrick1.png"></v-avatar>
      <v-toolbar-title class="headline">Levi Heidrick</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn v-if="$store.getters['auth/auth'].isAuthenticated" @click.prevent="$store.dispatch('auth/logout')" flat color="error" dark>Logout</v-btn>
    </v-toolbar>
    <router-view></router-view>
    <v-footer app height="auto" class="footer-color">
      <v-layout row wrap justify-center align-center class="pa-2">
        <v-flex xs12 text-xs-center>
          <span>&copy; 2018 Levi Heidrick</span>
        </v-flex>
        <v-flex xs12 text-xs-center>
          <div class="caption">
            <span>07/18/2018</span>
            <span>v0.0.2</span>
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
  data () {
    return {
      drawer: false,

    }
  },
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

</style>
