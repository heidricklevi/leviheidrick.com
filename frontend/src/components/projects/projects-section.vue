<template>
  <div
    id="projectsSection"
    ref="projectSection"
    class="projects"
  >
    <v-container 
      fluid 
      fill-height 
      pl-0 
      pr-0>
      <v-bottom-sheet 
        v-if="$vuetify.breakpoint.smAndDown && $route.fullPath !== '/projects'" 
        v-model="drawer" 
        lazy>
        <v-btn 
          outline 
          icon 
          absolute 
          right 
          @click="drawer = !drawer">
          <v-icon>{{ drawer ? 'close' : 'add' }}</v-icon>
        </v-btn>
        <v-list class="mt-4 text-xs-center">
          <v-list-tile
            v-for="project in projects"
            :key="project.id"
            :class="{'router-link-exact-active': encodeURIComponent(project.title) === encodeURIComponent($route.params.name)}"
            class="nav--link pa-0 mx-0 my-4"
            @click.prevent="onProjectRouteView(project)"
          >
            <v-list-tile-title class="text-xs-center">
              {{ project.title }}
            </v-list-tile-title>
          </v-list-tile>
        </v-list>
      </v-bottom-sheet>
      <v-btn 
        v-if="$vuetify.breakpoint.mdAndUp" 
        outline 
        large 
        icon 
        fixed 
        class="nav--btn-out" 
        @click="drawer = !drawer">
        <v-icon large>fa fa-angle-double-right</v-icon>
      </v-btn>
      <v-navigation-drawer
        v-if="$route.fullPath === '/projects' || (!$vuetify.breakpoint.smAndDown && $route.fullPath !== '/projects')"
        v-model="drawer"
        :fixed="$route.fullPath !== '/projects'"
        :permanent="$route.fullPath === '/projects'"
        :width="calcNavWidth"
      >

        <v-toolbar 
          flat 
          class="transparent text-xs-center">

          <v-list class="text-xs-center">
            <v-list-tile
              :to="{path: '/projects'}"
              class="nav--link pa-0 mx-0"
            >

              <v-list-tile-title class="text-xs-center">
                Projects
              </v-list-tile-title>
            </v-list-tile>
          </v-list>
          <v-btn 
            v-if="$route.fullPath !== '/projects'" 
            outline 
            absolute 
            right 
            icon 
            class="align-self-start" 
            @click="drawer = !drawer">
            <v-icon >close</v-icon>
          </v-btn>


        </v-toolbar>
        <v-divider/>
        <v-list class="mt-4 text-xs-center">
          <v-list-tile
            v-for="project in projects"
            :class="{'router-link-exact-active': encodeURIComponent(project.title) === encodeURIComponent($route.params.name)}"
            :key="project.id"
            class="nav--link pa-0 mx-0 my-4"
            @click.prevent="onProjectRouteView(project)"
          >
            <v-list-tile-title class="text-xs-center">
              {{ project.title }}
            </v-list-tile-title>
          </v-list-tile>
        </v-list>
      </v-navigation-drawer>
      <v-layout 
        row 
        wrap>
        <PageTransition>
          <router-view name="projectDetails"/>
        </PageTransition>
        <!--<template v-for="project in projects">-->
        <!--<v-flex :key="project.id" xs12 sm6 md4 lg3 class="ml-2 mt-2">-->
        <!--<v-card-->
        <!--raised-->
        <!--ripple-->
        <!--dark-->
        <!--&gt;-->
        <!--<div-->
        <!--&gt;-->
        <!--<v-container fluid fill-height>-->
        <!--<v-layout fill-height>-->
        <!--<v-flex xs12 align-center text-xs-center>-->
        <!--<a :href="project.url" class="light-blue&#45;&#45;text text&#45;&#45;darken-2">-->
        <!--<h3 class="display-1 font-weight-medium" >{{project.title}}</h3>-->
        <!--</a>-->
        <!--<v-flex v-if="hasHighestCredentials" text-xs-right xs12 class="force-top-right">-->
        <!--<v-btn to="/admin/projects" small icon flat color="primary"><v-icon small color="error">remove_red_eye</v-icon></v-btn>-->
        <!--</v-flex>-->
        <!--</v-flex>-->
        <!--</v-layout>-->
        <!--</v-container>-->
        <!--<template-->
        <!--v-for="(img, index) in project.files">-->
        <!--<v-img-->
        <!--:key="index"-->
        <!--v-if="img.isBacksplash"-->
        <!--:src="img.fileUrl"-->
        <!--aspect-ratio="2.33"-->
        <!--&gt;</v-img>-->
        <!--</template>-->
        <!--</div>-->
        <!--<v-divider></v-divider>-->
        <!--<v-card-actions>-->
        <!--<h5>-->
        <!--View Details-->
        <!--</h5>-->
        <!--<v-spacer></v-spacer>-->
        <!--<v-btn icon-->
        <!--dark-->
        <!--primary-->
        <!--@click.prevent="viewDetails(project)"-->
        <!--:to="{name: 'project-details', params: { name: project.title }}"-->
        <!--&gt;-->
        <!--<v-icon class="white&#45;&#45;text">arrow_right</v-icon>-->
        <!--</v-btn>-->
        <!--</v-card-actions>-->
        <!--</v-card>-->
        <!--</v-flex>-->
        <!--</template>-->
        <v-btn 
          v-if="$vuetify.breakpoint.smAndDown && $route.fullPath !== '/projects'" 
          style="z-index: 10" 
          outline 
          icon 
          fixed 
          bottom 
          right 
          mb-2 
          @click="drawer = !drawer">
          <v-icon>add</v-icon>
        </v-btn>
      </v-layout>
    </v-container>
  </div>
</template>

<script>
  import { mapGetters } from 'vuex';
  import PageTransition from "../page-transition/PageTransition.vue";

  export default {
    name: "ProjectsSection",
    components: { PageTransition },
    data() {
      return {
        drawer: false,
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


      calcNavWidth() {
        return this.$route.fullPath === '/projects' ? window.document.getElementById('app').getBoundingClientRect().width : '300'
      },

      projects() {
        return this.$store.getters['projects/projects'];
      }
    },
    created() {
      this.$store.dispatch('projects/fetchProjects');
    },
    methods: {
      viewDetails(project) {
        this.$store.commit('projects/projectUpdate', project)
      },
      onProjectRouteView(project) {
        this.drawer = false;
        this.$router.push({
          path: `/projects/${encodeURIComponent(project.title)}`,
          params: { name: encodeURIComponent(project.title) }
        });
      }
    },
  }
</script>

<style scoped lang="stylus">
  .nav {
    &--btn-out {
      top: 10%;
    }
  }
  .projects {
    height: 100%;
    background-color: rgb(0, 1, 2);

    & .nav--link {
      font-size: 1.2rem
    }
  }

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
