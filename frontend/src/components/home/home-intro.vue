<template>
  <v-jumbotron
    dark
    gradient="to top, #29323c, #485563"
    height="100%"

  >
    <v-container
      fill-height
    >
      <v-layout
        row
        wrap
        align-center
      >
        <v-flex
          xs12
          text-xs-center
        >
          <div>

              <h1 class="playfair-font-bold
                         grey--text text--lighten-2
                         display-3
                         extra-letter-spacing-intro
                         py-2
                         d-inline-block
                         text-uppercase"
              >

                software Developer.
              </h1>
            </div>
            <div class="py-3">
              <v-btn
                :to="{ path: '/contact' }"
                dark
                flat
                large
                outline
                color="grey"
              >
                Get in touch
              </v-btn>
            </div>
        </v-flex>
      </v-layout>
    </v-container>
  </v-jumbotron>
</template>

<script>
    import {mapGetters} from 'vuex'
    export default {
        name: "home-intro",
        data() {
          return {

          }
        },
      computed: {
        ...mapGetters('resume/', ['resume'])
      }
    }
</script>

<style lang="stylus" scoped>
  .home__intro {
    &-border {
      border-bottom: 10px solid;
      border-image: linear-gradient(to bottom, #30cfd0 0%, #330867 100%) 100;

     }
  }
</style>
