<template>
  <v-jumbotron
    dark
    color="#232D3A"
    height="100vh"

  >
    <v-container
      fill-height
    >
      <v-layout
        row
        wrap
        align-center
        justify-center
      >
        <v-flex
          xs12
          text-xs-center
        >
          <div>

              <h1 class="playfair-font
                         playfair-font-bold
                         grey--text text--lighten-2
                         extra-letter-spacing-intro
                         py-2
                         d-inline-block
                         text-uppercase"
                  :class="{ 'display-3': $vuetify.breakpoint.smAndUp, 'display-2': $vuetify.breakpoint.xsOnly }"
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

          <v-btn
            :class="{
              'fab-position': $vuetify.breakpoint.mdAndUp,
              'fab-position-mobile': $vuetify.breakpoint.smAndDown
            }"
            absolute
            outline
            fab
            dark
            large
            color="#E59E61"

          >
              <v-icon ref="fab--arrow" dark class="animated bounce">arrow_downward</v-icon>
          </v-btn>
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
  .fab-position {
    bottom 100px
    right 100px
    &-mobile {
      bottom: 100px
    }
  }

  div i.animated {
    animation-duration: 2.5s;
    animation-iteration-count: infinite;
  }
</style>
