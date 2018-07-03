<template>
  <v-content>
    <v-jumbotron
      dark
      gradient="to top, #29323c, #485563"
      style="min-height: 400px;">
      <v-container fill-height>
        <v-layout align-center>
          <v-flex text-xs-center>
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
          </v-flex>
        </v-layout>
      </v-container>
    </v-jumbotron>
    <skills-section></skills-section>
    <projects-section></projects-section>

  </v-content>
</template>

<script>
  import SkillsSection from "./skills-section.vue";
  import ProjectsSection from "./projects-section.vue";


export default {
  name: 'Home',
  components: {
    SkillsSection,
    ProjectsSection,
  },
  data () {
    return {
      drawer: false,

    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
  .flex .list.no-background-color {
    background-color: unset!important;
  }

  .uppercase {
    text-transform: uppercase!important;
  }

  .letter_spacing {
    letter-spacing: 1px!important;
  }

  .card.card-side-border {
    border-left: 1rem solid #485563;
  }

</style>
