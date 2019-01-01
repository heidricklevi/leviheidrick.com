<template>
  <v-layout row wrap justify-center>
    <v-flex xs12 xl8>
      <v-card class="experience__education">
        <v-card-title>
          <v-icon>{{ educationProps.icon }}</v-icon>
          <h4 class="playfair-font text-uppercase extra-letter-spacing pl-1">Education</h4>
        </v-card-title>
        <v-flex xs12>
          <v-divider></v-divider>
        </v-flex>
        <v-card-text>
          <h3 class="title font-weight-medium">{{ educationProps.universityName }} {{ educationProps.school }}</h3>
          <p class="subheading">{{ educationProps.major }}</p>
        </v-card-text>
      </v-card>
    </v-flex>
  </v-layout>
</template>

<script>
    export default {
      name: "experience-education",
      props: [
        'educationProps'
      ],

      data() {
        return {

        };
      }
    }
</script>

<style lang="stylus" scoped>
.experience {
  &__education {
    min-height 250px;

  }
}
</style>
