<template>
  <div>
    <v-navigation-drawer
      v-model="drawer"
      fixed
      clipped
      app
    >
      <v-list dense>
        <v-list-tile 
          v-for="item in items" 
          :key="item.text" 
          :to="item.url">
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
    <admin-toolbar @drawer-toggle="drawerToggle" />
  </div>
</template>

<script>
  import AdminToolbar from './admin-toolbar.vue';

  export default {
    name: "AdminNav",
    components: {
      AdminToolbar
    },
    data() {
      return {
        drawer: false,
        items: [
          { icon: 'attachment', text: 'Resume', url: '/admin/resume' },
          { icon: 'folder', text: 'Projects', url: '/admin/projects' },
          { icon: 'history', text: 'History' },
          { icon: 'featured_play_list', text: 'Playlists' },
          { icon: 'watch_later', text: 'Watch Later' }
        ],
      }
    },
    methods: {
      drawerToggle() {
        this.drawer = !this.drawer;
      }
    }
  }
</script>

<style scoped>

</style>
