<template>
  <v-toolbar
    color="red"
    dense
    fixed
    clipped-left
    app
  >
    <v-toolbar-side-icon @click="$emit('drawer-toggle', $event)"/>
    <v-toolbar-title class="mr-5 align-center">
      <span class="title">Admin</span>
    </v-toolbar-title>
    <v-spacer/>
  </v-toolbar>
</template>

<script>
  export default {
    name: "AdminToolbar",
  }
</script>

<style scoped>

</style>
