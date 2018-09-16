<template>
    <v-container fluid>
      <v-layout row wrap>
        <v-flex lg5 md4 sm12 :class="{ 'mb-3': $vuetify.breakpoint.smAndDown }">
          <v-card>
            <v-card-title>
              <a :href="resume.url" target="_blank">
                  <h5 class="headline blue--text">
                    Resume
                  </h5>
              </a>
              <v-spacer></v-spacer>
              <p class="subheading green--text">
                Live
              </p>
            </v-card-title>
            <v-divider></v-divider>
            <v-card-text>
              <v-list dark two-line>
                  <v-list-tile>
                    <v-list-tile-content class="blue-grey--text darken-3">ID</v-list-tile-content>
                    <v-list-tile-content class="align-end">{{ resume.id }}</v-list-tile-content>
                  </v-list-tile>
                  <v-list-tile >
                    <v-list-tile-content class="blue-grey--text darken-3">URL</v-list-tile-content>
                    <v-list-tile-content class="align-end">{{ resume.url.split('/').slice(-1)[0] }}</v-list-tile-content>
                  </v-list-tile>
                  <v-list-tile >
                    <v-list-tile-content class="blue-grey--text darken-3">Updated</v-list-tile-content>
                    <v-list-tile-content class="align-end">{{ resume.updated | dateAndTime }}</v-list-tile-content>
                  </v-list-tile>
                  <v-list-tile >
                    <v-list-tile-content class="blue-grey--text darken-3">Created</v-list-tile-content>
                    <v-list-tile-content class="align-end">{{ resume.created | dateAndTime }}</v-list-tile-content>
                  </v-list-tile>
              </v-list>
              <input type="file" hidden ref="resumeFileInput" @change="onResumeFileChange">
            </v-card-text>
            <v-card-actions>
              <v-btn flat color="warning" @click.prevent="chooseFile">
                Update
                <v-icon right dark>cloud_upload</v-icon>
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-flex>
        <v-flex sm12 offset-lg1 lg6 offset-md1 md7>
          <pdf :key="resume.updated + resume.url" :src="resume.url" />
        </v-flex>
      </v-layout>
    </v-container>
</template>

<script>
    import pdf from 'vue-pdf'
    import moment from 'moment'
    import { mapGetters } from 'vuex';

    export default {
      name: "admin-resume",
      components: { pdf },
      created() {
        this.$store.dispatch('resume/fetchResume')
      },
      filters: {
        dateAndTime(date) {
          return moment(date).format('MMMM Do YYYY, h:mm:ss a');
        }
      },
      computed: {
        ...mapGetters('resume/', ['resume'])
      },
      methods: {
        chooseFile() {
          this.$refs.resumeFileInput.click();
        },

        onResumeFileChange() {
          if (this.$refs.resumeFileInput.files.length > 0) {
            const resumeFile = this.$refs.resumeFileInput.files[0];
            const folderName = "leviheidrick.com";
            const urlFileName = resumeFile.name.split('.')[0];
            const id = this.resume.id;

            
          }
        }
      }
    }
</script>

<style scoped>

</style>
