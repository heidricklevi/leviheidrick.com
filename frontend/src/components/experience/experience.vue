<template>
  <v-container
    id="experience-container"
  >
   <v-layout
     row
     wrap
   >
     <v-flex xs12 text-xs-center text-md-left class="my-5">
       <h3 class="playfair-font playfair-font-bold display-1 text-uppercase extra-letter-spacing">
         Experience & Education
       </h3>
     </v-flex>
   </v-layout>
    <v-layout
      container
      row
      wrap
    >
      <v-flex xs12 xl8 offset-xl2>
        <v-flex xs12 layout justify-space-between>
          <template v-for="item in items">
            <v-flex
              xs4
              xl1
              md2
              text-xs-center
              class="pb-2 experience__timeline--item__container"
              :class="{ selected: selected === item }"
            >
              <v-btn icon ripple @click.prevent="onTimeLineItemClicked($event, item)">
                <v-icon>{{ item.icon }}</v-icon>
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
        <transition
          name="flipper"
          mode="out-in"
        >
        <experience-terminal
          v-if="!isEducation"
          :is-clicked="isClicked"
          :optional-props="experienceTerminalDetails"
          :key="Math.floor(Math.random() * (+1 - +99)) + +1"
        >
        </experience-terminal>
        <experience-education
          v-else
          :is-clicked="isClicked"
          :education-props="experienceTerminalDetails"
        />
        </transition>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
    import ExperienceTerminal from './experience-terminal';
    import ExperienceEducation from './experience-education'
    export default {
      name: "experience",
      components: {
        ExperienceTerminal,
        ExperienceEducation,
      },
      mounted () {
        this.selected = this.items[this.items.length - 1];
      },
      computed: {
        experienceTerminalDetails () {
          return this.positionDetails || this.items[this.items.length - 1]; // show most recent by default
        }
      },
      methods: {
        onTimeLineItemClicked(e, val) {
          this.isClicked = true;
          this.isEducation = val.isEducation;
          this.selected = val;
          this.positionDetails = val;
        }
      },
      data() {
        return {
          isEducation: false,
          selected: false,
          isClicked: false,
          key: 0,
          positionDetails: false,

          items: [
            {
              isEducation: false,
              icon: 'fas fa-briefcase',
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
              isEducation: true,
              icon: 'school',
              timelineHeading: 'May 2018',
              major: 'Bachelors of Science, Information Technology',
              universityName: 'The University of Kansas,',
              school: 'School of Engineering',

              gradDate: 'May 2018',
              gpaText: 'GPA: ',
              gpaValue: '3.6, 4.0',
              techStack: '',
            },
            {
              isEducation: false,
              icon: 'fas fa-briefcase',
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

<style lang="stylus">

  .flipper-enter-active {
    transition: all .2s cubic-bezier(0.55, 0.085, 0.68, 0.53); //ease-in-quad
  }

  .flipper-leave-active {
    transition: all .25s cubic-bezier(0.25, 0.46, 0.45, 0.94); //ease-out-quad
  }

  .flipper-enter, .flipper-leave-to {
    transform: scaleY(0) translateZ(0);
    opacity: 0;
  }

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
            z-index: 2;
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
