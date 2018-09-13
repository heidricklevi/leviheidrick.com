<template>
  <v-toolbar
    color="red"
    dense
    fixed
    clipped-left
    app
  >
    <v-toolbar-side-icon @click="$emit('drawer-toggle', $event)"></v-toolbar-side-icon>
      <v-toolbar-title class="mr-5 align-center">
      <span class="title">Admin</span>
    </v-toolbar-title>
    <v-spacer></v-spacer>
  </v-toolbar>
</template>

<script>
  export default {
      name: "admin-toolbar",
    }
</script>

<style scoped>

</style>
