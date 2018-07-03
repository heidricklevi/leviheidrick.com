<template>
    <v-jumbotron
      id="projects-section"
      height="auto"
      dark>
      <v-container fluid>
        <v-layout row wrap>
          <v-flex xs12>
            <h3 class="headline pb-3">
              <v-avatar size="56" tile class="pr-3">
                <img src="/static/innovation.svg">
              </v-avatar>
              Projects
            </h3>
          </v-flex>
        </v-layout>
        <v-layout row wrap>
          <v-flex xs12 md4>
            <v-card
              dark>
              <v-card-media
                style="opacity: 0.5"
                src="/static/project_wmw.png"
                height="400">
              </v-card-media>
              <v-card-title primary-title>
                <div>
                  <h3 class="headline">What's My Workout?</h3>
                  <p class="caption pb-0 mb-0 mt-2">Initial concept: Spr 2017.</p>
                  <p class="caption">Project adopted: Fall 2017.</p>
                </div>
              </v-card-title>


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

          }
        }
    }
</script>

<style scoped>

</style>
