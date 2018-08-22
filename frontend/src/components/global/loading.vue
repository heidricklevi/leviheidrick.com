<template>
  <v-container fluid fill-height justify-center align-center class="overlay">
    <img src="/static/loading.svg">
  </v-container>
</template>

<script>
    export default {
        name: "loading",
    }
</script>

<style>
  .overlay {
    height: 100vh;
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    z-index: 99999;
    background-color: rgba(0, 0, 0, 0.6);
    opacity: 0.7;
    -webkit-transition: opacity 400ms ease-in;
    -moz-transition: opacity 400ms ease-in;
    -ms-transition: opacity 400ms ease-in;
    -o-transition: opacity 400ms ease-in;
    transition: opacity 400ms ease-in;

  }

</style>
