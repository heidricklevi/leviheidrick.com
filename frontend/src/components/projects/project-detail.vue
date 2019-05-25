<template>
<v-flex xs12 text-xs-center>
  <v-layout row wrap justify-center align-center class="mt-5">
    <v-flex xs12 align-center>
      <div class="project-detail__heading my-3">
        <h3>
          {{ project.title }}
        </h3>
      </div>
    </v-flex>
    <v-flex xs11 text-sm-left md8 class="mb-5">
      <div class="project-detail__content">
        {{ project.content }}
      </div>
    </v-flex>
    <!--<v-flex xs12 md8 lg6>-->
      <!--<template v-for="file in project.files">-->
        <!--<div class="pa-2">-->
          <!--<v-img v-if="!file.isBacksplash" :src="file.fileUrl"  cover contain></v-img>-->
        <!--</div>-->
      <!--</template>-->
    <!--</v-flex>-->
    <v-flex xs12 lg8>
      <v-card dark>
        <v-container grid-list-lg fluid>
          <v-layout row wrap>
            <v-flex xs12 lg6 v-for="file in project.files" v-if="!file.isBacksplash">
              <v-card hover ripple tile>
                <v-img
                  height="400px"
                  :src="file.fileUrl"
                  cover
                  ></v-img>
              </v-card>
            </v-flex>
          </v-layout>
        </v-container>
      </v-card>

    </v-flex>
      <!--<v-flex xl8 lg10 sm12>-->
        <!--<v-card v-if="!isLoading" class="elevation-5" :class="{'ma-4': $vuetify.breakpoint.smAndUp}">-->
          <!--<v-layout row wrap>-->
            <!--<v-flex xs12 lg3>-->
              <!--<v-card-title class="display-1 playfair-font">{{project.title}}</v-card-title>-->
            <!--</v-flex>-->
            <!--<v-flex xs12><v-divider dark></v-divider></v-flex>-->
            <!--<v-flex xs12>-->
              <!--<v-spacer></v-spacer>-->
              <!--<v-card-text v-html="project.content" class="body-1">-->
                <!--{{project.content}}-->
              <!--</v-card-text>-->
            <!--</v-flex>-->
          <!--</v-layout>-->
        <!--</v-card>-->
      <!--</v-flex>-->
      <!--<v-container-->
        <!--fluid-->
        <!--grid-list-sm-->
        <!--fill-height-->
        <!--v-if="!isLoading"-->
      <!--&gt;-->
        <!--<v-layout-->
          <!--row-->
          <!--wrap-->
          <!--justify-center-->
        <!--&gt;-->
          <!--<v-flex-->
            <!--sm11-->
            <!--xl7-->
            <!--lg10-->
            <!--class="mb-2"-->
          <!--&gt;-->
            <!--<h3 class="headline playfair-font">-->
              <!--Gallery-->
            <!--</h3>-->
            <!--<p class="caption font-italic mb-1">Tip: select an image to see viewing options.</p>-->
            <!--<v-divider></v-divider>-->
          <!--</v-flex>-->

    <!--<v-flex-->
      <!--xs12-->
      <!--md8-->
      <!--v-if="project.files && project.files.length > 0"-->
    <!--&gt;-->

      <!--<viewer @inited="inited" :images="project.files" class="viewer" ref="viewer">-->
        <!--<v-layout row wrap>-->
          <!--<v-flex-->
            <!--xs1 -->
            <!--v-for="(img, index) in project.files">-->
            <!--<v-card-->
              <!--v-if="!img.isBacksplash"-->
              <!--hover-->
              <!--flat-->
              <!--tile-->
              <!--ripple-->
              <!--class="card__gallery__img__height card__gallery__img__cover card__gallery__img"-->
            <!--&gt;-->
              <!--<img-->
                <!--:src="img.fileUrl"-->
                <!--:key="index"-->
              <!--&gt;-->

            <!--</v-card>-->
          <!--</v-flex>-->
        <!--</v-layout>-->
      <!--</viewer>-->
    <!--</v-flex>-->
        <!--</v-layout>-->
      <!--</v-container>-->
  </v-layout>
</v-flex>
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
          console.log(self.$route.params.name)
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
  .project-detail {
    display: flex;
    flex-wrap wrap

    &__heading {
      > h3 {
        font-size 2.5rem;
        font-weight lighter
        text-transform uppercase
        letter-spacing 2px
      }
    }
    &__content {
      font-size 1.5rem
      font-family: 'Lato', sans-serif;

    }
  }
  .viewer {
     img {
      max-width 100%
    }
  }

  .card__gallery__img {
    max-height 200px

    &__height {
      img {
        min-height 200px
        max-height 200px
      }
    }
    &__cover {
      img {
        object-fit cover
      }
    }

  }

</style>
