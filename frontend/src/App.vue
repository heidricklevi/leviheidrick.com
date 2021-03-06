<template>
  <v-app dark>
    <loading v-if="$store.getters['loading/isLoading']"/>

    <v-navigation-drawer
      v-if="$vuetify.breakpoint.smAndDown"
      v-model="drawer"
      fixed
      clipped-right
      app
    >
      <v-list>
        <v-list-tile 
          to="/" 
          class="nav--link mx-0">
          <v-list-tile-action v-if="$route.fullPath !== '/'">
            <v-icon>fa fa-long-arrow-alt-left</v-icon>
          </v-list-tile-action>

          <v-list-tile-content>
            <v-list-tile-title>Levi Heidrick</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
      <v-divider/>
      <v-list>
        <template v-for="item in navItems">
          <v-list-tile 
            v-if="!item.selector && item.url" 
            :key="item.text" 
            :to="item.url" 
            class="nav--link mx-0">
            <v-list-tile-content>
              <v-list-tile-title>
                {{ item.text }}
              </v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
        </template>
        <v-list-tile 
          v-if="resume && resume.url" 
          :href="resume.url" 
          target="_blank" 
          class="nav--link mx-0">
          <v-list-tile-content>
            <v-list-tile-title>
              Resume
              <v-icon 
                small 
                class="nav--link--icon">fa fa-external-link-alt</v-icon>
            </v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-navigation-drawer>
    <v-toolbar
      v-if="!$route.path.includes('admin')"
      :absolute="$vuetify.breakpoint.smAndDown"
      class="px-0 main-hover"
      app
      flat
      fixed
      clipped-left
      color="#0b0c10"
      height="52"
    >
      <router-link 
        class="header__logo-wrap main-hover d-flex" 
        to="/">
        <span class="header__logo-wrap--text">
          LH
        </span>
        <span 
          :class="{'d-block': $vuetify.breakpoint.smAndUp}" 
          class="header__logo-wrap--name">
          Levi Heidrick
        </span>
      </router-link>
      <v-container 
        id="toolbarContainer" 
        fluid 
        class="py-0 mx-0">
        <v-layout 
          row 
          wrap 
          align-center>
          <v-spacer/>
          <v-toolbar-side-icon 
            v-if="$vuetify.breakpoint.smAndDown" 
            @click.prevent="drawer = !drawer"/>
          <v-btn 
            v-if="auth.isAuthenticated" 
            flat 
            color="error" 
            dark 
            @click.prevent="logout">Logout</v-btn>
          <v-btn 
            v-if="hasHighestCredentials" 
            :to="{ path: '/admin/' }" 
            color="warning">admin</v-btn>
          <router-link 
            v-if="$vuetify.breakpoint.mdAndUp" 
            class="nav--link" 
            to="/contact">contact</router-link>
          <router-link 
            v-if="$vuetify.breakpoint.mdAndUp" 
            class="nav--link" 
            to="/about">about</router-link>
          <router-link 
            v-if="$vuetify.breakpoint.mdAndUp" 
            class="nav--link" 
            to="/projects">projects</router-link>
            <!--<v-btn v-if="$vuetify.breakpoint.mdAndUp" :href="resume.url" dark flat target="_blank">Resume.pdf</v-btn>-->
        </v-layout>

      </v-container>
    </v-toolbar>
    <v-content>
      <page-transition>
        <router-view />
      </page-transition>
    </v-content>
    <v-footer
      app
      height="auto"
      color="#0b0c10"
      absolute
      class="footer__border-top pt-4"
    >
      <v-layout
        row
        wrap
        justify-center
        align-center
        class="pa-2"
      >
        <v-flex 
          xs12 
          text-xs-center>
          <v-btn
            v-if="footerLinks.linkedInLink"
            :href="footerLinks.linkedInLink"
            class="ma-2"
            target="_blank"
            icon 
          ><v-icon>fab fa-linkedin-in</v-icon></v-btn>
          <v-btn
            v-if="footerLinks.githubLink"
            :href="footerLinks.githubLink"
            class="ma-2"
            target="_blank"
            icon 
          ><v-icon>fab fa-github</v-icon></v-btn>
          <v-btn
            v-if="footerLinks.emailLink"
            :href="footerLinks.emailLink"
            class="ma-2"
            icon 
          ><v-icon>fas fa-envelope</v-icon></v-btn>
        </v-flex>
        <v-flex 
          xs12 
          text-xs-center>
          <span class="font-italic grey--text text--lighten-2">&copy; 2019 Levi Heidrick</span>
          <div>
            <span class="font-italic grey--text text--lighten-2 caption">v1.0.0</span>
          </div>
        </v-flex>
        
      </v-layout>
    </v-footer>
  </v-app>
</template>

<script>
  import SkillsSection from "../src/components/home/skills-section.vue"
  import Breadcrumbs from "../src/components/global/breadcrumbs.vue";
  import Experience from "../src/components/experience/experience.vue";
  import PageTransition from "../src/components/page-transition/PageTransition.vue";
  import Loading from "../src/components/global/loading.vue";
  import { mapGetters } from "vuex";


  export default {
    name: 'App',
    components: { SkillsSection, Loading, Breadcrumbs, Experience, PageTransition },

    data () {
      return {
        drawer: false,
        show: false,
        navItems: [
          { text: 'Projects', icon: '', url: '/projects'},
          { text: 'Skills', icon: '', selector: '#section-skills'},
          { text: 'About', icon: 'fa fa-question', url: '/about'},
          { text: 'Contact', icon: 'info', url: '/contact'},
        ],

        resumeItem: {
          text: 'Resume.pdf',
          icon: 'cloud_download',
          url: false
        },
        footerLinks: {
          githubLink: 'https://github.com/heidricklevi',
          linkedInLink: 'https://www.linkedin.com/in/leviheidrick/',
          emailLink: 'mailto:levi@leviheidrick.com',
        }
      }
    },
    async created() {
      await this.$store.dispatch('auth/checkAuth');
      this.$store.dispatch('resume/fetchResume').then(() => {});
    },

    computed: {

      ...mapGetters('auth/',[
        'hasHighestCredentials'
      ]),

      ...mapGetters('resume/', ['resume']),

      auth() {
        return this.$store.getters['auth/auth'];
      },

    },
    methods: {
      goTo(selector) {
        this.$vuetify.goTo(selector);
      },
      logout() {
        this.$store.dispatch('auth/logout');
      }
    }
  }
</script>

<style lang="stylus">
  @import url('https://fonts.googleapis.com/css?family=Lato|Open+Sans:300,400,500,600,700');
  .nav--link {
    text-decoration none;
    text-transform uppercase;
    color: whitesmoke;
    font-size 1rem;
    font-weight: 600;
    font-family: 'Lato', sans-serif;
    letter-spacing 5px;
    margin 0 1rem;
    padding: 10px;

    &:hover, &.router-link-exact-active {
      border-bottom 2px solid orange
    }

    &--icon.v-icon {
      vertical-align top
    }
  }

  .main-hover:hover {
    .header__logo-wrap--name {
      transform: translate3d(80px, 0px, 0px);
      transition: all 0.3s cubic-bezier(0.165, 0.84, 0.44, 1) 0s;
    }
  }
  .header__logo-wrap {
    &--text {
      text-transform: uppercase;
      font-weight: 900;
      letter-spacing: 1px;
      color: rgb(17, 17, 17);
      position: relative;
      z-index: 10;
      font-size: 26px;
      height: 52px;
      width: 52px;
      display: block;
      background: rgb(255, 183, 77);
      padding: 10px;
      overflow: hidden;

      &::before {
        content: "";
        left: 0px;
        height: 52px;
        width: 200px;
        position: absolute;
        display: block;
        z-index: -1;
        transform: translate3d(52px, 0px, 0px);
        background-image: linear-gradient(90deg, rgb(22, 160, 133) 33.333%, rgb(231, 76, 60) 33.333%, rgb(231, 76, 60) 66.667%, rgb(41, 128, 185) 66.667%);
        background-size: 156px 52px;
        transition: all 0.3s cubic-bezier(0.86, 0, 0.07, 1) 0s;
      }
    }

    &--name {
      top: 0px;
      position: absolute;
      display: none;
      z-index: 5;
      transform: translate3d(-100%, 0px, 0px);
      text-transform: uppercase;
      letter-spacing: 5px;
      font-size: 24px;
      font-weight: 900;
      line-height: 52px;
      color: rgb(255, 255, 255);
      margin: 0px;
      text-decoration: none;
      transition: all 0.3s cubic-bezier(0.895, 0.03, 0.685, 0.22) 0s;
    }
  }
  #toolbarContainer {
    margin: auto!important;
  }
  .footer {
    &__border {
      &-top {
        border-top-color #0b0c10;
      }
    }
    &__copy {
      border-right 1px solid white;  
    }
  }

  .uppercase {
    text-transform: uppercase!important;
  }

  .letter_spacing {
    letter-spacing: 1px;
  }

</style>
