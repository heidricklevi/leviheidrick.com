<template>
  <div v-if="hasHighestCredentials">
    <admin-nav-drawer @admin-nav-item-click="navItemClick" />
    <v-content>
      <v-container fluid>
        <router-view/>
      </v-container>
    </v-content>
  </div>
</template>

<script>
  import { mapGetters } from 'vuex';
  import AdminNavDrawer from './admin-nav-drawer.vue';


  export default {
    name: "Admin",
    components: {
      AdminNavDrawer,
    },
    computed: {
      ...mapGetters('auth/', [
        'hasHighestCredentials'
      ]),

      ...mapGetters('projects/', [
        'projects'
      ]),

      ...mapGetters('loading/', [
        'isLoading'
      ]),

    },

    methods: {
      navItemClick(url) {
        this.$router.push({ path: url })
      }
    }
  }
</script>

<style scoped>

</style>
