<template>
  <v-navigation-drawer
    v-if="$vuetify.breakpoint.smAndDown"
    v-model="drawer"
    fixed
    clipped-right
    app
  >
    <v-list>
      <v-list-tile v-for="item in navItems" :key="item.text" :to="item.url">
        <v-list-tile-action>
          <v-icon>{{ item.icon }}</v-icon>
        </v-list-tile-action>
        <v-list-tile-content>
          <v-list-tile-title>
            {{ item.text }}
          </v-list-tile-title>
        </v-list-tile-content>
      </v-list-tile>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
    export default {
        name: "nav-bar",
        data() {
          return {
            drawer: false,
            navItems: [
              { text: 'Projects', icon: '', url: '/projects'},
              { text: 'Skills', icon: '', url: '/skills'},
              // { text: 'About', icon: '', url: '/skills'},
              { text: 'Resume', icon: 'cloud_download', url: this.$store.getters.resume? this.$store.getters.resume.url: ''  }
            ]
          }
        }
    }
</script>

<style scoped>

</style>
