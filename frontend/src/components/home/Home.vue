<template>
  <v-content>
    <router-view></router-view>
  </v-content>
</template>

<script>
  import SkillsSection from "./skills-section.vue";
  import ProjectsSection from "./projects-section.vue";
  import HomeIntro from "./home-intro";


export default {
  name: 'Home',
  components: {
    HomeIntro,
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
  .flex .v-list.no-background-color {
    background-color: unset!important;
  }

  .uppercase {
    text-transform: uppercase!important;
  }

  .letter_spacing {
    letter-spacing: 1px!important;
  }

  .v-card.card-side-border {
    border-left: 1rem solid #485563;
  }

</style>
