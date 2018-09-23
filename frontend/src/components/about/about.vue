<template>
  <v-container
    fill-height
    fluid
    class="background__gradient--deepspace"
  >
      <v-layout
        class="py-3"
        row
        wrap
        justify-center>
        <v-flex xs12 lg3 md4>
          <v-avatar
            size="256"
            class="elevation-15"
          >
            <v-img
              src="/static/levi-heidrick1.png">
            </v-img>
          </v-avatar>
          <v-divider
            dark
            inset
            vertical
          >
          </v-divider>
        </v-flex>

      </v-layout>
  </v-container>
</template>

<script>
    export default {
      name: "about",
      data () {
        return {

        }
      },

    }
</script>

<style scoped>
  .background__gradient--deepspace {
    background: #000000;  /* fallback for old browsers */
    background: -webkit-linear-gradient(to right, #434343, #000000);  /* Chrome 10-25, Safari 5.1-6 */
    background: linear-gradient(to right, #434343, #000000); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  }
</style>
