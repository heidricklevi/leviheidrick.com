<template>
  <v-container
    fluid
  >
    <v-layout
      row
      wrap
      justify-center
    >
      <v-flex xl8 lg10 sm12>
        <v-card v-if="!isLoading" class="elevation-5" :class="{'ma-4': $vuetify.breakpoint.smAndUp}">
          <v-layout row wrap>
            <v-flex xs12 lg3>
              <v-card-title class="display-1 playfair-font">{{project.title}}</v-card-title>
            </v-flex>
            <v-flex xs12><v-divider dark></v-divider></v-flex>
            <v-flex xs12>
              <v-spacer></v-spacer>
              <v-card-text v-html="project.content" class="body-1">
                {{project.content}}
              </v-card-text>
            </v-flex>
          </v-layout>
        </v-card>
      </v-flex>
      <v-container
        fluid
        grid-list-sm
        fill-height
      >
        <v-layout
          row
          wrap
          justify-center
        >
          <v-flex
            sm11
            xl7
            lg10
            class="mb-2"
          >
            <h3 class="headline playfair-font">
              Gallery
            </h3>
            <p class="caption font-italic mb-1">Tip: click an image to see viewing options.</p>
            <v-divider></v-divider>
          </v-flex>

            <v-flex
              xl7
              lg10
              sm11
              v-if="project.files && project.files.length > 0 && !isLoading"
            >

              <viewer @inited="inited" :images="project.files" class="viewer" ref="viewer">
                <v-flex xs6 md4 v-for="(img, index) in project.files">
                  <v-card
                    hover
                    flat
                    tile
                    ripple
                  >
                    <img
                      :src="img.fileUrl"
                      :key="index"
                    >

                  </v-card>
                </v-flex>
              </viewer>
            </v-flex>
        </v-layout>
      </v-container>
    </v-layout>
  </v-container>
</template>

<script>
    import Viewer from 'v-viewer/src/component.vue';
    import { mapActions, mapGetters } from 'vuex';
    export default {
      name: "project-detail",
      components: { Viewer, },
      props: ['dialog'],
      beforeRouteEnter(to, from, next) {
        next(self => {
          self.fetchProjectByTitle(self.$route.params.name).then(() => {});
        })
      },
      data() {
        return {

        }
      },
      methods: {
        ...mapActions('projects/', ['fetchProjectByTitle']),
        inited(viewer) {
          this.$viewer = viewer;
        },

        showViewer() {
          this.$viewer.show();
        }
      },
      computed: {
        ...mapGetters('projects/', [
          'responseStatus',
        ]),
        ...mapGetters('loading/', [
          'isLoading',
        ]),

        project() {
          return this.$store.getters['projects/project'];
        }
      }
    }
</script>

<style scoped lang="stylus">
  .viewer {
     img {
      max-width 100%
    }
  }

</style>
