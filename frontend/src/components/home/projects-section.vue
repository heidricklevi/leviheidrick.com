<template>
    <v-jumbotron
      id="projects-section"
      height="100%"
      gradient="to bottom, #29323c, #485563"
      >
      <v-container fluid>
        <v-layout row wrap>
          <v-flex xs12>
            <h3 class="headline pb-3">
              <v-avatar size="56" tile class="pr-3">
                <img src="/static/innovation.svg" alt="">
              </v-avatar>
              Projects
            </h3>
          </v-flex>
        </v-layout>
        <v-layout row wrap>
          <v-flex xs12 sm6 md3 lg2>
            <v-card
              raised
              ripple
              dark>
              <v-card-media
                src="/static/WMW2.png"
                class="background-shift-y"
                height="200">
                <v-container fluid fill-height>
                  <v-layout fill-height>
                    <v-flex xs12 align-center text-xs-center>
                      <a href="https://dev.whatsmyworkout.co" class="light-blue--text text--darken-2"> <h3 class="headline font-weight-medium font-italic" >What's My Workout?</h3></a>
                    </v-flex>
                  </v-layout>
                </v-container>
              </v-card-media>
              <v-card-title class="pb-0">
                <div>
                  <p class="caption pb-0 mb-0 mt-2">Initial concept: Spr 2017.</p>
                  <p class="caption">Project adopted: Fall 2017.</p>
                </div>
              </v-card-title>
              <v-divider></v-divider>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn icon dark primary @click="viewDescription = !viewDescription">
                  <v-icon class="white--text" v-if="viewDescription">keyboard_arrow_down</v-icon>
                  <v-icon class="white--text" v-else>keyboard_arrow_up</v-icon>
                </v-btn>
              </v-card-actions>
              <v-card-text v-if="viewDescription">
              </v-card-text>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-jumbotron>
</template>

<script>
    export default {
        name: "ProjectsSection",
        data() {
          return {
            viewDescription: false,
          }
        }
    }
</script>

<style scoped lang="stylus">

  .v-card {
    .v-card__media {
      >>> .v-card__media__background {
        background-position-y: 30px !important;
      }
    }
  }

  a {
    text-decoration none!important;
  }

  a:hover {
    color: #64B5F6!important;
  }



</style>
