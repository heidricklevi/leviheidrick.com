<template>
<v-flex xs12 text-xs-center>
  <v-layout row wrap justify-center align-center class="mt-5">
    <!--<v-flex xs12 style="position: relative; width: 100vw">-->

    <v-flex xs12 id="projectDetailsContainer" ref="projectDetailsContainer">
      <v-layout row wrap justify-center>
        <v-flex xs12 align-center class="project-detail__heading-wrapper" id="headingWrapper" ref="headingWrapper">
          <div v-if="project" class="project-detail__heading my-4 mx-2">
            <h3>
              {{ project.title }}
            </h3>
          </div>
        </v-flex>
        <v-flex v-if="project" xs11 text-sm-left md8 class="mb-5 project-detail__content-wrapper" id="contentWrapper" ref="contentWrapper">
          <div class="project-detail__content">
            {{ project.content }}
          </div>
        </v-flex>
      </v-layout>
    </v-flex>
    <!--</v-flex>-->

    <v-flex xs12 style="background-color: white">
      <v-layout wrap align-center justify-center>
        <v-flex xs12 style="position: relative">
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" preserveAspectRatio="none" id="contentSeparator">
            <polygon fill="white" points="0,100 100,0 100,100"/>
          </svg>
        </v-flex>
        <v-flex xs12 lg8>
          <v-card light flat>
            <v-container grid-list-lg fluid>
              <viewer @inited="inited" :images="project.files" class="viewer" ref="viewer">
                <v-layout row wrap>
                  <v-flex xs12 lg6 v-for="file in project.files" v-if="!file.isBacksplash">
                    <v-card hover ripple tile>
                      <img
                        :src="file.fileUrl"
                        class="viewer__img"
                      >
                      <v-img
                        height="400px"
                        :src="file.fileUrl"
                        cover
                      ></v-img>
                    </v-card>
                  </v-flex>
                </v-layout>
              </viewer>
            </v-container>
          </v-card>

        </v-flex>

      </v-layout>
    </v-flex>
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
          self.fetchProjectByTitle(self.$route.params.name).then(() => {});
        })
      },
      data() {
        return {

        }
      },
      async mounted() {
        await this.$nextTick();
        this.setContentHeight();
      },
      methods: {
        ...mapActions('projects/', ['fetchProjectByTitle']),
        inited(viewer) {
          this.$viewer = viewer;
        },
        setContentHeight() {
          const projectContainer = document.getElementById('projectDetailsContainer');
          const content = document.getElementById('contentWrapper');
          const heading = document.getElementById('headingWrapper');
          const svg = document.getElementById('contentSeparator');
          const shape = svg.getBoundingClientRect();
          if (content && heading && projectContainer) {
            console.log(content.offsetHeight, heading.offsetHeight, shape.height)
            projectContainer.style.minHeight = `${content.offsetHeight + heading.offsetHeight + shape.height}px`;
          }
        }
      },

      computed: {
        ...mapGetters('projects/', [
          'responseStatus',
          'project'
        ]),
        ...mapGetters('loading/', [
          'isLoading',
        ]),
      },
      watch: {
        async project() {
          console.log('project');
          await this.$nextTick();
          this.setContentHeight();
        }
      }
    }
</script>

<style scoped lang="stylus">
  svg {
    position: absolute;
    bottom: 0;
    width: 100vw;
    height: 20vh;
    left: 0
    /* set height to pixels if you want angle to change with screen width */
  }
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

    &__img {
      position absolute
      max-width 100%
      z-index 99
      opacity 0
      height: 400px
      top: 0
      left: 0
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
