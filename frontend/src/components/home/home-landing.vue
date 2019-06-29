<template>
  <div
    class="landing--wrap"
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

            <h1 
              :class="{ 'display-3': $vuetify.breakpoint.smAndUp, 'display-2': $vuetify.breakpoint.xsOnly }"
              class="playfair-font
                         playfair-font-bold
                         grey--text text--lighten-2
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
  </div>
</template>

<script>
  import {mapGetters} from 'vuex'
  export default {
    name: "HomeIntro",
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
  .landing--wrap {
    background-color: #0b0c10;
    height: 100% !important;
  }
  .home__intro {
    &-border {
      border-bottom: 10px solid;
      border-image: linear-gradient(to bottom, #30cfd0 0%, #330867 100%) 100;

     }
  }
  .fab-position {
    bottom 100px
    &-desktop {
      right 100px
    }

    &.v-btn--floating.v-btn--absolute {
      z-index 2
    }
  }

  div i.animated {
    animation-duration: 2.5s;
    animation-iteration-count: infinite;
  }
</style>
