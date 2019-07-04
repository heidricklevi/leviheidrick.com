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
            v-if="project" 
            id="contentWrapper" 
            ref="contentWrapper" 
            xs12
            text-sm-left 
            md8 
            class="mb-5 project-detail__content-wrapper">
            <v-card 
              elevation="6"
              class="pa-4" 
              color="#0b0c12">
              <v-flex 
                id="headingWrapper" 
                ref="headingWrapper" 
                xs12  
                class="project-detail__heading-wrapper">
                <div 
                  v-if="project" 
                  class="project-detail__heading my-4"
                >
                  <h3>
                    {{ project.title }}
                  </h3>
                </div>
              </v-flex>
              <v-card-text 
                class="project-detail__content pa-0">
                <content-render 
                  :content="project.content" 
                  class="content-render" />
              </v-card-text>
              <v-flex 
                xs12 
                text-xs-right
                class="px-3 py-2">
                <v-btn
                  v-if="project.githubLink"
                  :href="project.githubLink"
                  class="mx-3"
                  target="_blank"
                  icon 
                  right><v-icon large>fab fa-github</v-icon></v-btn>
                <v-btn
                  v-if="project.url"
                  :href="project.url"
                  class="ml-3"
                  target="_blank"
                  icon 
                  right><v-icon large>fas fa-external-link-alt</v-icon></v-btn>
              </v-flex>
            </v-card>
            <v-card 
              v-if="project.techStack && project.techStack.length > 0"
              elevation="6"
              class="pa-4 my-3 project-detail__content--stacks-list--wrapper" 
              color="#0b0c14">
              <v-card-text >
                <v-layout 
                  justify-center 
                  align-center
                  wrap
                >
                  <v-flex
                    align-center
                    align-self-center
                    text-xs-center 
                    md6 
                    xs12>
                    <h3 class="header-tech"><v-icon color="orange lighten-2">fas fa-terminal</v-icon>
                      Tech
                    </h3>
                  </v-flex>
                  <v-flex 
                    align-self-center
                    align-center
                    text-xs-center
                    xs12 
                    md6>
                    <ul class="project-detail__content project-detail__content--stacks-list">
                      <li
                        v-for="item in project.techStack"
                        :key="item" 
                        class="text--lighten-1 grey--text">
                        #{{ item }}
                      </li>
                    </ul>
                  </v-flex>
                </v-layout>
              </v-card-text>
            </v-card>
          </v-flex>
        </v-layout>
      </v-flex>
      <v-flex 
        v-if="project.files && Array.isArray(project.files) && project.files.length > 0"
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
                        />
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
  import ContentRender from '../helper/content-render.vue';
  import { mapActions, mapGetters } from 'vuex';
  export default {
    name: "ProjectDetail",
    components: { Viewer, ContentRender },
    props: ['dialog'],
    beforeRouteEnter(to, from, next) {
      next(self => {
        self.fetchProjectByTitle(self.$route.params.name).then(() => {});
      })
    },
    beforeRouteUpdate: function(to, from, next) {
      this.fetchProjectByTitle(to.params.name).then(() => {});
      next();
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
        const shape = svg ? svg.getBoundingClientRect() : false;
        if (content && heading && projectContainer && shape) {
          projectContainer.style.minHeight = `${content.offsetHeight + heading.offsetHeight + shape.height}px`;
        }
      }
    },
  }
</script>

<style  lang="scss">

  .content-render {
    &__list {
      list-style-type: none;
      color: rgba(255,255,255,0.7);
      font-size: 16px;
      padding: 0;
      margin-bottom: 2rem;

      li {
        display: flex;
        align-items: center;
        margin: 0.5rem 0 0 1rem;
      }
    }
  }
  svg {
    position: absolute;
    bottom: 0;
    width: 100vw;
    height: 20vh;
    left: 0
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
      color: #ebebeb;

      &--stacks-list {
        padding: 0;
        margin: 1rem;
        list-style-type: none;
        font-style: italic;

        &--wrapper {
          padding: 2rem;
          border: 1px solid white;
        }
      }
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
