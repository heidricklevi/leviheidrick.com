<template>
  <v-jumbotron
    id="section-skills"
    dark
    gradient="0, #000102, 50%, #010912"
    height="auto">

    <v-container>
      <v-layout row wrap>
        <v-flex xs12 class="pb-4" text-xs-center text-md-left>
          <h3 class="title"><v-icon color="white" class="pr-3">fas fa-cogs</v-icon>
            Some Tech I've Used
          </h3>
        </v-flex>
      </v-layout>
      <v-layout row wrap :justify-center="$vuetify.breakpoint.smAndDown">
        <v-flex class="text-xs-center" xs4 md2 xlg1 v-for="skill in skillsList" :key="skill.text">
          <v-chip ripple>
            <v-avatar v-if="skill.imageURL">
              <img :src="skill.imageURL">
            </v-avatar>
            {{skill.text}}
          </v-chip>
        </v-flex>
      </v-layout>
    </v-container>
  </v-jumbotron>
</template>

<script>
  export default {
        name: "skills-section",
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
  #section-skills {
    margin-top: 10vh;
  }
</style>
