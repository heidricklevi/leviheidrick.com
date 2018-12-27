<template>
  <v-container
    light
    id="experience-container"
    fluid
  >
   <v-layout
     row
     wrap
   >
     <v-flex xs12 text-xs-center text-md-left class="my-5">
       <h3 class="playfair-font display-2 text-uppercase extra-letter-spacing">
         <v-icon large>fas fa-code-branch</v-icon>
         Experience
       </h3>
     </v-flex>
   </v-layout>
    <v-layout
      container
      row
      wrap
    >
      <v-flex xs12>
        <v-flex xs12 md6 offset-md3 text-xs-right layout justify-space-between>
            <v-btn icon @click.prevent="positionDetails = digitalLagoonDetails">
              <v-icon>fas fa-code</v-icon>
            </v-btn>
          <div class="d-inline-block experience__timeline--item__container">
            <v-btn icon @click.prevent="positionDetails = garminDetails">
              <v-icon>fas fa-code</v-icon>
            </v-btn>
            <div class="experience__timeline--item__heading text-xs-center">
              <h5 class="caption text-uppercase">May 2018 - Present</h5>
            </div>
          </div>
        </v-flex>
        <v-divider></v-divider>
      </v-flex>
      <v-flex xs6 text-xs-right class="experience__border">
        <hr class="v-divider v-divider--vertical theme--dark">
      </v-flex>
      <v-flex xs12>
        <experience-terminal :key="Math.floor(Math.random() * (+1 - +99)) + +1" :optional-props="experienceTerminalDetails" />
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
    import ExperienceTerminal from './experience-terminal';
    export default {
      name: "experience",
      components: {
        ExperienceTerminal,
      },
      computed: {
        experienceTerminalDetails () {
          return this.positionDetails || this.garminDetails;
        }
      },
      data() {
        return {
          key: 0,
          positionDetails: false,
          digitalLagoonDetails: {
            company: 'Digital Lagoon',
            title: 'Contract Software Developer',
            timespan: 'Dec. 2017 - Feb. 2018',
            companyLocation: 'Overland Park, KS',
            positionRoles: [
              'Develop new features/functionality for existing projects',
              'Integrate, test and provide custom code changes for migrating to a new e-commerce solution',
              'Provide custom coupon codes and subscription services for an existing project integrating with a custom CMS.',
              'Integrate third party APIs throughout existing projects',
              'Utilize modern development methodologies and tooling for implementations on a project basis touching all parts of the web stack. '
            ],
            techStack: '',
          },
          garminDetails: {
            company: 'Garmin International',
            title: 'IT Software Engineer I',
            timespan: 'May 2018 - Present',
            companyLocation: 'Olathe, KS',
            positionRoles: [
              'Implement business & stakeholder requirements into software',
              'Communicate effectively across various teams to utilize various solutions',
              'Take ownership & provide guidance to other team members regarding certain solutions. For example, migration to a new backend CMS solution.',
              'Develop highly flexible, complex and scalable web applications with an emphasis on reuse. '
            ],
            techStack: '',
          },
          items: [
            {
              color: 'red lighten-2',
              icon: 'mdi-star'
            },
            {
              color: 'purple darken-1',
              icon: 'mdi-book-variant'
            },
            {
              color: 'green lighten-1',
              icon: 'mdi-airballoon'
            },
            {
              color: 'indigo',
              icon: 'mdi-buffer'
            }
          ]
        };
      },
    }
</script>

<style scoped lang="stylus">
  #experience-container {
    height auto
  }

  .experience {
    &__border {
      min-height 6rem
    }

    &__timeline {
      &--item {
        &__container {
          position: relative
          &:before {
            content: "";
            display: flex;
            position: absolute;
            /* top: 0; */
            bottom: -29px;
            left: 49.8%;
            width: .5px;
            background-color rgba(255,255,255,0.12)
            height: 100%;
            max-height 2rem
            z-index: 1000000;
          }
        }
        &__heading {
          margin: 0 auto;
          margin-top: 20px;
          position absolute
          top: 4rem

        }
      }
    }
  }
</style>
