<template>
  <v-jumbotron
    dark
    height="auto"
  >

    <v-container>
      <v-layout 
        row 
        wrap 
        class="my-5">
        <v-flex 
          xs12 
          text-xs-center>
          <h3 class="header-tech extra-letter-spacing"><v-icon color="orange lighten-2">fas fa-terminal</v-icon>
            Tech
          </h3>
        </v-flex>
      </v-layout>
      <v-layout 
        :justify-center="$vuetify.breakpoint.smAndDown" 
        row 
        wrap 
        class="py-4">
        <v-flex 
          v-for="skill in skillsList" 
          :key="skill.text" 
          class="text-xs-center" 
          xs4 
          md2 
          xlg1>
          <v-chip ripple>
            <v-avatar v-if="skill.imageURL">
              <img :src="skill.imageURL">
            </v-avatar>
            {{ skill.text }}
          </v-chip>
        </v-flex>
      </v-layout>
    </v-container>
  </v-jumbotron>
</template>

<script>
  export default {
    name: "SkillsSection",
    data() {
      return {
        skillsList: [
          {
            text: 'C++',
            imageURL: "/static/c++.png",
          },
          {
            text: 'PHP',
            imageURL: '/static/php.png',
          },
          {
            text: 'HTML',
            imageURL: '/static/html5.png',
          },
          {
            text: 'CSS',
            imageURL: "/static/css31.jpg",
          },
          {
            text: 'JavaScript',
            imageURL: "/static/js.png",
          },
          {
            text: 'Apache',
            imageURL: "/static/apache.png",
          },

          {
            text: 'AWS',
            imageURL: "/static/aws.png",
          },
          {
            text: 'Linux',
            imageURL: "/static/linux.png",
          },
          {
            text: 'MySQL',
            imageURL: "/static/mysql.png",
          },
          {
            text: 'Postgres',
            imageURL: "/static/postgres.png",
          },
          {
            text: 'Java',
            imageURL: '/static/javaa.png',
          },
          {
            text: 'Python',
            imageURL: "/static/python.png",
          },

          {
            text: 'VueJS',
            imageURL: "/static/vuejs.png",
          },
          {
            text: 'Django',
            imageURL: "/static/django.png",
          },
          {
            text: 'Flask',
            imageURL: '/static/flask.jpg',
          },
        ]
      }
    },
  }
</script>

<style scoped lang="stylus">
  .header-tech {
    font-family: 'Lato', sans-serif;
    font-size 2rem
    text-transform uppercase
    letter-spacing 5px
    font-weight 300
  }

</style>
