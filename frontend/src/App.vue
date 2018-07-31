<template>
  <v-app dark>
    <v-toolbar app fixed clipped-left class="elevation-0" color="primary">
      <v-avatar size="56"><img src="/static/levi-heidrick1.png"></v-avatar>
      <v-toolbar-title class="headline">Levi Heidrick</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn outline>About</v-btn>
      <v-btn flat outline>Login</v-btn>
      <v-btn to="/projects" flat outline>Projects</v-btn>

    </v-toolbar>
    <!--<v-navigation-drawer-->
      <!--v-model="drawer"-->
      <!--clipped-->
      <!--fixed-->
      <!--app-->
    <!--&gt;-->
      <!--<v-list dense>-->
        <!--<v-list-tile @click="">-->
          <!--<v-list-tile-action>-->
            <!--<v-icon>dashboard</v-icon>-->
          <!--</v-list-tile-action>-->
          <!--<v-list-tile-content>-->
            <!--<v-list-tile-title>Dashboard</v-list-tile-title>-->
          <!--</v-list-tile-content>-->
        <!--</v-list-tile>-->
        <!--<v-list-tile @click="">-->
          <!--<v-list-tile-action>-->
            <!--<v-icon>settings</v-icon>-->
          <!--</v-list-tile-action>-->
          <!--<v-list-tile-content>-->
            <!--<v-list-tile-title>Settings</v-list-tile-title>-->
          <!--</v-list-tile-content>-->
        <!--</v-list-tile>-->
      <!--</v-list>-->
    <!--</v-navigation-drawer>-->
      <home/>
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
  </v-app>
</template>

<script>

import Home from "../src/components/home/Home.vue"

export default {
  name: 'App',
  components: { Home },
  data () {
    return {
      drawer: false,
      show: false,
    }
  },
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
