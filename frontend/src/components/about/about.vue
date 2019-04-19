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
            xs12
            align-self-center
            text-xs-center
            text-md-center
            md3
            offset-md2
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
            md6
            layout
            :justify-start="$vuetify.breakpoint.mdAndUp"
            :justify-center="$vuetify.breakpoint.smAndDown"
            align-center
          >
            <div class="text-xs-center text-md-center">
              <h5
                class="playfair-font text-uppercase blue-grey--text text--lighten-3 display-3"
              > Levi Heidrick</h5>
              <p class="text-xs-center title playfair-font font-italic blue-grey--text text--lighten-1">Full-Stack Web Developer</p>
            </div>
          </v-flex>
          <v-flex
            xs12
          >
            <v-divider dark></v-divider>
          </v-flex>
          <v-flex xs11 md8 offset-md1 lg7 offset-lg0>
            <div class="about__desc grey--text text--lighten-1">
              <p>Hey there, I am <span style="border-bottom: 2px solid orange">Levi</span>. I am a full stack web developer here in the Kansas City Metro.
                I recently graduated from the University of Kansas' Engineering School with a Bachelors of Science in Information Technology (2018).</p>

              <p>
                I have a passion for writing software on the web. I love building web applications encompassing all parts of the tech stack.
                Working with new tech and continuing to learn different ways to solve problems is something I enjoy.
                For me, writing software to solve problems is most rewarding and drives my motivation.
              </p>
              <p>
                I also enjoy spending time with my amazing wife, our dog and two cats.
              </p>
              <p>
                <router-link to="/contact">Reach out</router-link> if you want to talk tech, have a project in mind, or just want to chat.
              </p>
            </div>
          </v-flex>
          <!--<v-layout-->
            <!--row-->
            <!--wrap-->
            <!--align-center-->
            <!--justify-center-->
          <!--&gt;-->

            <!--<v-flex-->
              <!--xs12-->
              <!--lg6-->
            <!--&gt;-->
              <!---->
            <!--</v-flex>-->
            <!--<v-flex-->
              <!--v-if="tools"-->
              <!--class="pt-4"-->
              <!--xs12-->
              <!--offset-lg3-->
              <!--lg6-->
            <!--&gt;-->
              <!--<h5 class="py-2 text-xs-center text-md-left headline text-uppercase extra-letter-spacing font-weight-medium grey&#45;&#45;text text&#45;&#45;lighten-2"-->
              <!--&gt;-->
                <!--Some Tool favorites-->
              <!--</h5>-->
              <!--<template v-for="(tool, index) in tools">-->
                <!--<v-chip-->
                  <!--:key="index"-->
                  <!--:color="tool.color"-->
                  <!--:text-color="tool.textColor"-->
                <!--&gt;-->
                  <!--<v-avatar>-->
                    <!--<v-icon>build</v-icon>-->
                  <!--</v-avatar>-->
                  <!--{{ tool.text }}-->
                <!--</v-chip>-->
              <!--</template>-->
            <!--</v-flex>-->
          </v-layout>
        <!--</v-layout>-->
    </v-container>
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

<style lang="stylus">

  .about__desc {
    font-family: 'Lato', sans-serif;
    font-size: 1.7rem;

    a {
      text-decoration: none;
    }
  }
  .about--wrap {
    background: linear-gradient(0deg, rgb(0, 1, 2), 50%, rgb(1, 9, 18));

  }
  .border--left__dark {
    border-left: #183c7f 4px solid;
  }

  .playfair-font {
    font-family: 'Playfair Display', serif!important;
  }
</style>
