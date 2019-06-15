<template>
  <v-flex 
    xs12 
    text-xs-center>
    <v-layout 
      row 
      wrap 
      justify-center 
      align-center 
      class="mt-5">
      <v-flex 
        id="projectDetailsContainer" 
        ref="projectDetailsContainer" 
        xs12>
        <v-layout 
          row 
          wrap 
          justify-center>
          <v-flex 
            id="headingWrapper" 
            ref="headingWrapper" 
            xs12 
            align-center 
            class="project-detail__heading-wrapper">
            <div 
              v-if="project" 
              class="project-detail__heading my-4 mx-2"
            >
              <h3>
                {{ project.title }}
              </h3>
            </div>
          </v-flex>
          <v-flex 
            v-if="project" 
            id="contentWrapper" 
            ref="contentWrapper" 
            xs11 
            text-sm-left 
            md8 
            class="mb-5 project-detail__content-wrapper">
            <div class="project-detail__content">
              {{ project.content }}
            </div>
          </v-flex>
        </v-layout>
      </v-flex>
      <v-flex 
        xs12 
        style="background-color: white">
        <v-layout 
          wrap 
          align-center 
          justify-center>
          <v-flex 
            xs12 
            style="position: relative">
            <svg 
              id="contentSeparator" 
              xmlns="http://www.w3.org/2000/svg" 
              viewBox="0 0 100 100" 
              preserveAspectRatio="none">
              <polygon 
                fill="white" 
                points="0,100 100,0 100,100"/>
            </svg>
          </v-flex>
          <v-flex 
            xs12 
            lg8>
            <v-card 
              light 
              flat>
              <v-container 
                grid-list-lg 
                fluid>
                <viewer 
                  ref="viewer" 
                  :images="project.files" 
                  class="viewer" 
                  @inited="inited">
                  <v-layout 
                    row 
                    wrap>
                    <v-flex 
                      v-for="file in project.files" 
                      v-if="!file.isBacksplash" 
                      xs12 
                      lg6>
                      <v-card 
                        hover 
                        ripple 
                        tile>
                        <img 
                          :src="file.fileUrl" 
                          class="viewer__img"
                        >
                        <v-img
                          :src="file.fileUrl"
                          height="400px"
                          cover
                        >
                          <!-- <div style="position: absolute; top: 0; right: 0">
                            <div class="icon-container">
                              <v-icon 
                                bottom 
                                light>
                                remove_red_eye
                              </v-icon>
                            </div>
                          </div>
                          <div
                            class="d-flex transition-fast-in-fast-out black lighten-4 v-card--reveal"
                            style="height: 100%;"
                          /> -->
                        </v-img>
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
    name: "ProjectDetail",
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
        await this.$nextTick();
        this.setContentHeight();
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
          projectContainer.style.minHeight = `${content.offsetHeight + heading.offsetHeight + shape.height}px`;
        }
      }
    },
  }
</script>

<style scoped lang="scss">
  $r: 4em;

  // .v-card--reveal {
  //   align-items: center;
  //   bottom: 0;
  //   justify-content: center;
  //   opacity: .5;
  //   position: absolute;
  //   width: 100%;
  // }
  //   .icon-container {
  //     position: relative;
  //     max-width: 15em;
  //     min-height: 10em;

  //     &:before {
  //       position: absolute;
  //       padding: $r;
  //       background: #95a;
  //       opacity: 1;
  //       content: '';
  //       border-radius: 50%;
  //       margin: -$r;
  //       z-index: -1;
  //     }
  //   }
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
    flex-wrap: wrap;

    &__heading {
      > h3 {
        font-size: 2.5rem;
        font-weight: lighter;
        text-transform: uppercase;
        letter-spacing: 2px;
      }
    }
    &__content {
      font-size: 1.5rem;
      font-family: 'Lato', sans-serif;

    }
  }
  .viewer {
     img {
      max-width: 100%
    }

    &__img {
      position: absolute;
      width: 100%;
      z-index: 99;
      opacity: 0;
      height: 400px;
      top: 0;
      left: 0;
    }
  }

  .card__gallery__img {
    max-height: 200px;

    &__height {
      img {
        min-height: 200px;
        max-height: 200px;
      }
    }
    &__cover {
      img {
        object-fit: cover;
      }
    }

  }

</style>
