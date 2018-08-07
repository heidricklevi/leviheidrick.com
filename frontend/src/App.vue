<template>
  <v-app dark>

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
