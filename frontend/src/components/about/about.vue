<template>
  <div
    style="min-height: 85vh"
    class="background__gradient--deepspace"
  >
    <v-container
      fluid
    >
        <v-layout
          class="py-3"
          row
          wrap
          justify-center
        >
          <v-flex
            xs12
            md4
            lg4
            layout
            justify-space-around
          >
            <v-avatar
              size="200"
              class="elevation-15"
            >
              <v-img
                src="/static/levi-heidrick1.png"
              >
              </v-img>
            </v-avatar>
          </v-flex>

          <v-flex
            xs12
            lg8
            layout
            :class="{ 'justify-start': $vuetify.breakpoint.mdAndUp, 'justify-space-around': $vuetify.breakpoint.smAndDown }"
          >
            <div class="text-xs-center text-md-center">
              <h5
                class="playfair-font text-uppercase blue-grey--text text--lighten-3"
                :class="{ 'display-3': $vuetify.breakpoint.mdAndUp, 'display-1': $vuetify.breakpoint.smAndDown }"
              > Professional Profile</h5>
              <p class="text-xs-center title playfair-font font-italic blue-grey--text text--lighten-1">Software Developer</p>
              <p class="text-xs-center caption playfair-font font-italic blue-grey--text text--lighten-1">Levi Heidrick</p>
            </div>
          </v-flex>
          <v-flex
            xs12
            class="my-3"
          >
            <v-divider dark></v-divider>
          </v-flex>
        </v-layout>

      <v-layout
        row
        wrap
        align-center
        align-content-center
      >

        <v-flex
          xs12
          lg6
          offset-lg3

        >
          <v-card
            class="border--left__dark"
          >
            <v-card-text class="">
              <p>Hey there, I am Levi. I am a full stack web developer here in the Kansas City Metro.
                I recently graduated from the University of Kansas' Engineering School with a Bachelors of Science in Information Technology (2018).</p>

              <p>I am passionate about technology. I love to learn about how things work and think differently on how improvements can be made. Prior to graduating from school,
                 I recognized this as a field I wanted to get into. The lectures on Stacks, Queues and BSTs weren't doing it for me. At that point,
                I recognized I needed to do extra learning on my own if I wanted to find out more about web development and really software development in general.
              </p>

              <p>
                Over the course of a few years, I garnished exposure to several different technologies.
              </p>
            </v-card-text>
          </v-card>
        </v-flex>
        <v-flex
          v-if="tools"
          class="pt-4"
          xs12
          offset-lg3
          lg6
        >
          <h5 class="py-2 text-xs-center text-md-left headline text-uppercase extra-letter-spacing font-weight-medium grey--text text--lighten-2"
          >
            Some Tool favorites
          </h5>
          <template v-for="(tool, index) in tools">
            <v-chip
              :key="index"
              :color="tool.color"
              :text-color="tool.textColor"
            >
              <v-avatar>
                <v-icon>build</v-icon>
              </v-avatar>
              {{ tool.text }}
            </v-chip>
          </template>
        </v-flex>
      </v-layout>
    </v-container>
  </div
    style="min-height: 100vh">
</template>

<script>
    export default {
      name: "about",
      data () {
        return {
          tools: [
            {
              color: 'blue',
              textColor: 'white',
              text: 'VueJS'
            },
            {
              color: 'indigo',
              textColor: 'white',
              text: 'NodeJS'
            },
            {
              color: 'orange',
              textColor: 'white',
              text: 'JavaScript'
            },
            {
              color: 'indigo',
              textColor: 'white',
              text: 'Python'
            },
            {
              color: 'blue',
              textColor: 'white',
              text: 'Django'
            },
            {
              color: 'orange',
              textColor: 'white',
              text: 'Java'
            },
            {
              color: 'blue',
              textColor: 'white',
              text: 'Spring'
            },
            {
              color: 'indigo',
              textColor: 'white',
              text: 'Jenkins'
            },
          ]
        }
      },

    }
</script>

<style>
  .background__gradient--deepspace {
    background: #000000;  /* fallback for old browsers */
    background: -webkit-linear-gradient(to right, #434343, #000000);  /* Chrome 10-25, Safari 5.1-6 */
    background: linear-gradient(to right, #434343, #000000); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  }

  .border--right__dark {
    border-right: #7f7f7f 2px solid;
  }

  .border--left__dark {
    border-left: #183c7f 4px solid;
  }

  .playfair-font {
    font-family: 'Playfair Display', serif!important;
  }
</style>
