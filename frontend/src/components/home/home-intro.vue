<template>
  <v-jumbotron
    dark
    gradient="to top, #29323c, #485563"
    height="100%"

  >
    <v-container fill-height>
      <v-layout row wrap align-center>
        <v-flex xs12 text-xs-center>
          <div class="mb-5 text-xs-right hidden-sm-and-down">
            <transition
              appear
              name="bounce"
              enter-active-class="bounceInLeft"
              leave-active-class="bounceOutRight"
            >
              <v-btn to="/projects" dark flat outline>Projects</v-btn>
            </transition>

            <transition
              appear
              name="bounce"
              enter-active-class="bounceInLeft"
              leave-active-class="bounceOutRight"
            >
              <v-btn class="mt-4 ml-4" to="/skills" dark flat outline>Skills</v-btn>
            </transition>
          </div>

          <h2 class="title letter_spacing">Hello,</h2>
          <transition
            appear
            name="bounce"
            enter-active-class="bounceInLeft"
            leave-active-class="bounceOutRight"
          >
            <h3 class="headline letter_spacing" >My name is Levi.</h3>
          </transition>
          <h4 class="title letter_spacing">I am Passionate about technology and software development.</h4>

          <div class="mt-5 text-xs-left hidden-sm-and-down">
            <transition
              appear
              name="bounce"
              enter-active-class="bounceInLeft"
              leave-active-class="bounceOutRight"
            >
              <v-btn to="/projects" dark flat outline>About</v-btn>
            </transition>

            <transition
              appear
              name="bounce"
              enter-active-class="bounceInLeft"
              leave-active-class="bounceOutRight"
              v-if="resume"
            >
              <v-btn class="mt-4 ml-4" :href="resume.url" dark flat outline target="_blank">Resume.pdf <v-icon right >cloud_download</v-icon></v-btn>
            </transition>
          </div>
        </v-flex>
      </v-layout>
    </v-container>
  </v-jumbotron>
</template>

<script>
    import {mapGetters} from 'vuex'
    export default {
        name: "home-intro",
        data() {
          return {

          }
        },
      computed: {
        ...mapGetters('resume/', ['resume'])
      }
    }
</script>

<style scoped>

</style>
