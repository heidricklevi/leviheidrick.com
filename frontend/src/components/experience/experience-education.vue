<template>
  <v-layout 
    row 
    wrap 
    justify-center>
    <v-flex 
      xs12 
      xl8>
      <v-card class="experience__education experience__card ">
        <v-card-title>
          <v-icon>{{ educationProps.icon }}</v-icon>
          <h4 class="playfair-font text-uppercase extra-letter-spacing pl-1">Education</h4>
        </v-card-title>
        <v-flex xs12>
          <v-divider/>
        </v-flex>
        <v-card-text>
          <h3 class="headline font-weight-medium">{{ educationProps.universityName }} {{ educationProps.school }}</h3>
          <h5 class="subheading font-weight-light">{{ educationProps.major }}</h5>
          <div>
            <span class="caption font-italic font-weight-thin">
              {{ educationProps.gpaText }} {{ educationProps.gpaValue.split(',')[0] }}
              (overall) {{ educationProps.gpaValue.split(',')[1] }} (In Major)
            </span>
          </div>
        </v-card-text>
      </v-card>
    </v-flex>
  </v-layout>
</template>

<script>
  export default {
    name: "ExperienceEducation",
    props: [
      'educationProps',
      'isClicked',
    ],
  }
</script>

<style lang="stylus" scoped>
.experience {
  &__education {
    min-height 250px;

  }
}
</style>
