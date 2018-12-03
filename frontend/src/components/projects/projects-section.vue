<template>
    <v-jumbotron
      id="projects-section"
      height="100%"
      gradient="to bottom, #29323c, #485563"
      >
      <v-container fluid v-if="!isLoading">
        <v-layout row wrap>
          <v-flex xs12>
            <h3 class="headline pb-3">
              <v-avatar size="56" tile class="pr-3">
                <img src="/static/innovation.svg" alt="">
              </v-avatar>
              Projects
            </h3>
            <v-spacer></v-spacer>
          </v-flex>
        </v-layout>
        <v-layout row wrap>
          <template v-for="project in projects">
          <v-flex :key="project.id" xs12 sm6 md4 lg3 class="ml-2 mt-2">
            <v-card
              raised
              ripple
              dark
            >
              <div
                >
                <v-container fluid fill-height>
                  <v-layout fill-height>
                    <v-flex xs12 align-center text-xs-center>
                      <a :href="project.url" class="light-blue--text text--darken-2">
                        <h3 class="display-1 font-weight-medium" >{{project.title}}</h3>
                      </a>
                      <v-flex v-if="hasHighestCredentials" text-xs-right xs12 class="force-top-right">
                        <v-btn to="/admin/projects" small icon flat color="primary"><v-icon small color="error">remove_red_eye</v-icon></v-btn>
                      </v-flex>
                    </v-flex>
                  </v-layout>
                </v-container>
                <v-img
                  src="/static/WMW2.png"
                  aspect-ratio="2.33"
                  ></v-img>
              </div>
              <v-divider></v-divider>
              <v-card-actions>
                <h5>
                  View Details
                </h5>
                <v-spacer></v-spacer>
                <v-btn icon
                       dark
                       primary
                       @click.prevent="viewDetails(project)"
                       :to="{name: 'project-details', params: { name: project.title }}"
                >
                  <v-icon class="white--text">arrow_right</v-icon>
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-flex>
          </template>
        </v-layout>
      </v-container>
    </v-jumbotron>
</template>

<script>
  import { mapGetters } from 'vuex';

  export default {
        name: "ProjectsSection",
        created() {
          this.$store.dispatch('projects/fetchProjects');
        },
        data() {
          return {
            viewDescription: false,
          }
        },
        computed: {
          ...mapGetters('loading/', [
            'isLoading'
          ]),
          ...mapGetters('auth/', [
            'hasHighestCredentials'
          ]),

          projects() {
            return this.$store.getters['projects/projects'];
          }
        },
        methods: {
          viewDetails(project) {
            this.$store.commit('projects/projectUpdate', project)
          },
        },
    }
</script>

<style scoped lang="stylus">

  a {
    text-decoration none!important;
  }

  a:hover {
    color: #64B5F6!important;
  }

  .force-top-right {
    position: absolute;
    top: 0;
    right: 0;
  }


</style>
