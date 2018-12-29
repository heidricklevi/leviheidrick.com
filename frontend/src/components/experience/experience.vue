<template>
  <v-container
    id="experience-container"
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
        <v-flex xs12 md7 offset-md2 text-xs-right layout justify-space-between>
          <template v-for="item in items">
            <v-flex
              xs4
              text-xs-center
              class="pb-2 experience__timeline--item__container"
              :class="{ selected: selected === item }"
            >
              <v-btn icon ripple @click.prevent="onTimeLineItemClicked($event, item)">
                <v-icon >fas fa-briefcase</v-icon>
              </v-btn>
              <h5 class="font-weight-thin">{{ item.timelineHeading }}</h5>
            </v-flex>
          </template>
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
      mounted () {
        this.selected = this.items[this.items.length - 1];
      },
      computed: {
        experienceTerminalDetails () {
          return this.positionDetails || this.items[this.items.length - 1]; // reverse chron. order show most recent by default
        }
      },
      methods: {
        onTimeLineItemClicked(e, val) {
          this.selected = val;
          this.positionDetails = val;

          this.$vuetify.goTo('.terminal__main')

        }
      },
      data() {
        return {
          selected: false,
          key: 0,
          positionDetails: false,

          items: [
            {
              timelineHeading: 'Dec. 2017 - Feb. 2018',
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
            {
              timelineHeading: 'May 2018 - Present',
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
      min-height 4rem
    }

    &__timeline {
      &--item {
        &__container {
          position: relative
          &:after {
            content: "";
            display: flex;
            position: absolute;
            /* top: 0; */
            bottom: 0px;
            left: 49.8%;
            width: .5px;
            background-color rgba(255,255,255,0.12)
            height: 100%;
            max-height calc(.5 * 1rem)
            z-index: 1000000;
          }
          &.selected {
            border-bottom-color rgb(229, 158, 97);
            border-bottom-width .5px
            border-bottom-style solid
            &:after{
              background-color: rgb(229, 158, 97);
            }
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
