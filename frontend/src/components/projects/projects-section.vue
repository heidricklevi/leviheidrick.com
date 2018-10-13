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
            <v-btn v-if="hasHighestCredentials" @click.prevent="onDialogClick" icon dark><v-icon>add</v-icon>Create</v-btn>
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
              <v-card-title class="pb-0">
                <div>
                  <p class="caption pb-0 mb-0 mt-2">Initial concept: Spr 2017.</p>
                  <p class="caption">Project adopted: Fall 2017.</p>
                </div>
              </v-card-title>
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
        <create-project @on-save-project="saveProject" @on-dialog-click="onDialogClick" :dialog="dialog"></create-project>
        <edit-project @on-edit-dialog-click="editDialogClick" :edit-dialog="editDialog"></edit-project>
        <v-dialog
          v-model="alertDelete"
          width="500"
        >
          <v-card
            dark
            class="text-xs-center"
          >
            <v-card-title>
              <h5 class="headline">Are you sure you want to delete this project <span class="blue-grey--text">{{projectToDelete.title}}</span></h5>
            </v-card-title>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn flat outline color="error" @click.prevent="deleteProject(projectToDelete)">Yes</v-btn>
              <v-btn flat outline color="warning" @click.prevent="alertDelete = false">No</v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-container>
    </v-jumbotron>
</template>

<script>
  import CreateProject from './create-project.vue';
  import EditProject from './edit-project.vue';
  import { mapActions, mapGetters } from 'vuex';

  export default {
        name: "ProjectsSection",
        components: {EditProject, CreateProject, },
        created() {
          this.$store.dispatch('projects/fetchProjects');
        },
        data() {
          return {
            viewDescription: false,
            dialog: false,
            isSaveDisabled: false,
            submissionStatus: '',
            alertDelete: false,
            projectToDelete: false,
            editDialog: false,

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
          onDialogClick(e) {
            this.dialog = !this.dialog;

          },
          saveProject() {
            this.$store.dispatch('projects/submitProject').then((response) => {
              console.log('response', response);
            })
          },

          viewDetails(project) {
            this.$store.commit('projects/projectUpdate', project)
          },

          deleteProject(project) {
            if (!this.alertDelete) {
              this.alertDelete = true;
              this.projectToDelete = project;
            }
            else if (this.alertDelete) {
              this.$store.dispatch("projects/deleteProjectById", project.id);
              this.alertDelete = false;
            }
          },

          editProject(project) {
            this.editDialogClick();
          },

          editDialogClick() {
            this.editDialog = !this.editDialog;
          }
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
