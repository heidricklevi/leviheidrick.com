<template>
  <v-layout justify-center>
    <v-flex 
      xs12 
      xl8>
      <v-card
        raised
        class="experience__card terminal__nav"
      >

        <div class="terminal__nav__buttons terminal__nav__buttons--close"/>
        <div class="terminal__nav__buttons terminal__nav__buttons--minimize"/>
        <div class="terminal__nav__buttons terminal__nav__buttons--zoom"/>

        <v-card-text class="terminal__main">

          <p class="line1 line-title blue-grey--text font-weight-bold">[~/work] $ ./position-details.sh</p>
          <p class="line2">
            <span 
              v-if="positionDetails.company" 
              class="line2 my-1"><v-icon small>fas fa-briefcase</v-icon> | {{ positionDetails.company }}</span>
            <br>
            <span 
              v-if="positionDetails.companyLocation" 
              class="line2 my-1"><v-icon small>location_city</v-icon> | {{ positionDetails.companyLocation }}</span>
            <br>
            <span 
              v-if="positionDetails.title" 
              class="line2 my-1"><v-icon small>person</v-icon> | {{ positionDetails.title }}</span>
            <br>
            <span 
              v-if="positionDetails.timespan" 
              class="line2 my-1"><v-icon small>timelapse</v-icon> | {{ positionDetails.timespan }}</span>
          </p>
          <p class="line3 white--text font-weight-bold mt-5">
            <i>Key roles and responsibilities</i>
          </p>
          <ul class="line3">
            <template v-for="role in positionDetails.positionRoles">
              <li class="line3 blue-grey--text text--lighten-2 pb-1">{{ role }}</li>
            </template>
          </ul>
          <p class="line4">><span class="cursor4">_</span></p>

        </v-card-text>
      </v-card>
    </v-flex>
  </v-layout>
</template>

<script>
  export default {
    name: "ExperienceTerminal",
    props: [
      'optionalProps'
    ],
    computed: {
      positionDetails () {
        return this.optionalProps;
      }
    },
  }
</script>

<style lang="stylus" scoped>
  .terminal__nav {
    background-color: #bbb;
    margin: 0 auto;
    border-top-right-radius: 5px;
    border-top-left-radius: 5px;

    &__buttons {
      margin-bottom: 5px;
      height: 10px;
      width: 10px;
      border-radius: 50%;
      border: 1px solid #000;
      position: relative;
      top: 6px;
      left: 6px;
      background-color: #ff3b47;
      border-color: #9d252b;
      display: inline-block;

      &--zoom {
        left: 16px;
        background-color: #00d742;
        border-color: #049931;
      }

      &--minimize {
        left: 11px;
        background-color: #ffc100;
        border-color: #9d802c;
      }
    }
  }

  .terminal__main {
    background-color: #151515;
    border-bottom-left-radius: 5px;
    border-bottom-right-radius: 5px;
    height: auto;
    min-height 250px;
    max-height auto;

    & p, ul, li {
      font-size: 1.25rem;
      font-family: monospace;
      white-space: normal;
      overflow: visible;
      width: 100%;
    }

    & .line-title {
      font-size 1.5rem
    }

    & span {
      color: #fff;
      font-weight: bold;
    }

    & .line1 {
      color: #9CD9F0;
    }

    & .line2 {
      color: #CDEE69;
    }

    & .line3 {
      color: #E09690;
    }

    & .line4 {
      color: #fff;
      -webkit-animation: type .5s .75s steps(20, end) forwards;
      -moz-animation: type .5s .75s steps(20, end) forwards;
      -o-animation: type .5s .75s steps(20, end) forwards;
      animation: type .5s .75s steps(20, end) forwards;
    }

    & .cursor4 {
      -webkit-animation: blink 1s .5s infinite;
      -moz-animation: blink 1s .5s infinite;
      -o-animation: blink 1s .5s infinite;
      animation: blink 1s .5s infinite;
    }
  }


  @-webkit-keyframes blink {
    0% {
      opacity: 0;
    }
    40% {
      opacity: 0;
    }
    50% {
      opacity: 1;
    }
    90% {
      opacity: 1;
    }
    100% {
      opacity: 0;
    }
  }

  @-moz-keyframes blink {
    0% {
      opacity: 0;
    }
    40% {
      opacity: 0;
    }
    50% {
      opacity: 1;
    }
    90% {
      opacity: 1;
    }
    100% {
      opacity: 0;
    }
  }

  @-o-keyframes blink {
    0% {
      opacity: 0;
    }
    40% {
      opacity: 0;
    }
    50% {
      opacity: 1;
    }
    90% {
      opacity: 1;
    }
    100% {
      opacity: 0;
    }
  }

  @keyframes blink {
    0% {
      opacity: 0;
    }
    40% {
      opacity: 0;
    }
    50% {
      opacity: 1;
    }
    90% {
      opacity: 1;
    }
    100% {
      opacity: 0;
    }
  }

  @-webkit-keyframes type {
    to {
      overflow visible
      width: 100%;
    }
  }

  @-moz-keyframes type {
    to {
      overflow visible
      width: 100%;
    }
  }

  @-o-keyframes type {
    to {
      overflow visible
      width: 100%;
    }
  }

  @keyframes type {
    to {
      overflow visible
      width: 100%;
    }
  }
</style>
