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
        justify-center
      >
        <v-flex
          xs12
          md4
          lg4
          layout
          justify-space-around
        >
          <v-avatar
            size="256"
            class="elevation-15"
          >
            <v-img
              src="/static/levi-heidrick1.png"
            >
            </v-img>
          </v-avatar>
        </v-flex>

        <v-flex
          xs12
          lg8
          layout
          :class="{ 'justify-start': $vuetify.breakpoint.mdAndUp, 'justify-space-around': $vuetify.breakpoint.smAndDown }"
        >

          <div class="text-xs-center text-md-center">
            <h5 class="display-3 playfair-font text-uppercase blue-grey--text text--lighten-3">Personal Profile</h5>
            <p class="text-xs-center title playfair-font font-italic blue-grey--text text--lighten-1">Software Developer</p>
            <p class="text-xs-center caption playfair-font font-italic blue-grey--text text--lighten-1">Levi Heidrick</p>
          </div>
        </v-flex>
        <v-flex xs12>
          <v-divider dark></v-divider>
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

  .border--right__dark {
    border-right: #7f7f7f 2px solid;
  }

  .about--me__heading {
    text-transform: uppercase;
    font-weight: 300;
    font-size: 3.5rem;
  }

  .playfair-font {
    font-family: 'Playfair Display', serif!important;
  }
</style>
