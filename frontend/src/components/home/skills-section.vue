<template>
  <v-jumbotron
    id="section-skills"
    dark
    height="auto">

    <v-container fluid>
      <v-layout row wrap>
        <v-flex xs12 class="pb-5">
          <h3 class="headline"><v-icon color="white" large class="pr-3">fas fa-cogs</v-icon>
            Technical Skills & Familiarity
          </h3>
        </v-flex>
        <v-flex offset-md2 md8 text-xs-center text-md-left xs12 class="mb-4">
          <v-card ripple raised class="card-side-border">
            <v-card-text>
              <p>Throughout University, work and my own fruition,
                I have been exposed to several different technologies.
                I have utilized some more than others. However, I have come to realize these
                technologies are tools to aide in getting work done and providing benefit. I am always open to exploring new technologies and using different tools for the job.</p>

              <p class="caption">These are some of the tools I have used over the course of University, personal projects, and on the job.</p>
            </v-card-text>
          </v-card>
        </v-flex>
      </v-layout>
      <v-layout row wrap justify-center align-center>
        <v-flex xs6 md3 offset-md1 lg2 offset-lg2 >
          <v-list dense class="no-background-color">
            <v-list-tile v-for="skill in skillsList" :key="skill.text" avatar>
              <v-list-tile-avatar v-if="skill.imageURL">
                <img :src="skill.imageURL">
              </v-list-tile-avatar>
              <v-list-tile-content >
                <v-list-tile-title>{{skill.text}}</v-list-tile-title>
              </v-list-tile-content>
            </v-list-tile>
          </v-list>
        </v-flex>
        <v-flex xs6 md3 offset-md1>
          <v-list dense class="no-background-color">
            <v-list-tile v-for="skill in skillsListTwo" :key="skill.text" avatar>
              <v-list-tile-avatar v-if="skill.imageURL">
                <img :src="skill.imageURL">
              </v-list-tile-avatar>
              <v-list-tile-content >
                <v-list-tile-title>{{skill.text}}</v-list-tile-title>
              </v-list-tile-content>
            </v-list-tile>
          </v-list>
        </v-flex>
        <v-flex xs6 md3 offset-md1>
          <v-list dense class="no-background-color">
            <v-list-tile v-for="skill in skillsListThree" :key="skill.text" avatar>
              <v-list-tile-avatar v-if="skill.imageURL">
                <img :src="skill.imageURL">
              </v-list-tile-avatar>
              <v-list-tile-content >
                <v-list-tile-title>{{skill.text}}</v-list-tile-title>
              </v-list-tile-content>
            </v-list-tile>
          </v-list>
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

            ],
            skillsListTwo: [
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


            ],
            skillsListThree: [
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



            ]
          }
        }
    }
</script>

<style scoped>

</style>
