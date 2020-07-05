<template>
  <v-container
    fluid
    fill-height
    pa-0
    class="about--wrap"

  >
    <v-layout
      row
      wrap
      justify-center
    >
      <v-flex
        v-if="aboutDetails"
        xs12
        align-self-center
        text-xs-center
        text-md-center
        md3
        offset-md2
        my-5
      >
        <v-avatar
          size="200"
          class="elevation-15"
        >
          <v-img
            v-if="aboutDetails.imageUrl"
            :src="aboutDetails.imageUrl"
          />
        </v-avatar>
      </v-flex>

      <v-flex
        v-if="aboutDetails"
        :justify-start="$vuetify.breakpoint.mdAndUp"
        :justify-center="$vuetify.breakpoint.smAndDown"
        xs12
        md6
        layout
        align-center
      >
        <div class="text-xs-center text-md-center">
          <h5
            v-if="aboutDetails.mainTitle"
            class="playfair-font text-uppercase blue-grey--text text--lighten-3 display-3"
          > {{ aboutDetails.mainTitle }}</h5>
          <p 
            v-if="aboutDetails.positionTitle" 
            class="text-xs-center title playfair-font font-italic blue-grey--text text--lighten-1">{{ aboutDetails.positionTitle }}</p>
        </div>
      </v-flex>
      <v-flex
        xs12
      >
        <v-divider dark/>
      </v-flex>
      <v-flex
        v-if="aboutDetails"
        xs11 
        md8 
        offset-md1 
        lg6 
        my-5 
        offset-lg0>
        <div class="about__desc grey--text text--lighten-1 py-3">
          <content-render 
            v-if="aboutDetails && aboutDetails.content" 
            :content="aboutDetails.content"
          />
        </div>
      </v-flex>
      <v-flex xs12>
        <experience />

      </v-flex>
      <v-flex xs12>
        <skills-section :items="techSkills"/>
      </v-flex>
    </v-layout>

  </v-container>
</template>

<script>
  import SkillsSection from "../home/skills-section.vue"
  import Experience from "../experience/experience.vue";
  import ContentRender from '../helper/content-render.vue';
  import { mapActions, mapGetters } from 'vuex';

  export default {
    name: "About",
    components: {
      SkillsSection,
      Experience,
      ContentRender,
    },
    computed: {
      ...mapGetters('techSkills/', [
        'techSkills',
      ]),
      aboutDetails() {
        return this.$store.getters['about/aboutActive'];
      }
    },
    mounted() {
      this.fetchTechSkills();
      this.fetchAboutDetails();
    },
    methods: {
      ...mapActions('techSkills/', [
        'fetchTechSkills',
      ]),
      ...mapActions('about/', [
        'fetchAboutDetails',
      ])

    },

  }
</script>

<style lang="stylus">

  .about__desc {
    font-family: 'Lato', sans-serif;
    font-size: 1.7rem;

    a {
      text-decoration: none;
    }
  }
  .about--wrap {
    background-color: #0b0c10;


  }
  .border--left__dark {
    border-left: #183c7f 4px solid;
  }

  .playfair-font {
    font-family: 'Playfair Display', serif!important;
  }
</style>
