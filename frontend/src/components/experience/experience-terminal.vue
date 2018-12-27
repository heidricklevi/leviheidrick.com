<template>
  <v-layout justify-center>
    <v-flex xs12 md6>
      <v-card
        raised
        class="terminal__nav"
      >
        <div class="terminal__nav__buttons terminal__nav__buttons--close"></div>
        <div class="terminal__nav__buttons terminal__nav__buttons--minimize"></div>
        <div class="terminal__nav__buttons terminal__nav__buttons--zoom"></div>

        <v-card-text class="terminal__main">

          <p class="line1 line-title blue-grey--text font-weight-bold">[~/work] $ ./position-details.sh<span class="cursor1">_</span></p>
          <p class="line2">
            <span class="line2 my-1"><v-icon small>fas fa-briefcase</v-icon> | {{ positionDetails.company }}</span>
            <br>
            <span class="line2 my-1"><v-icon small>location_city</v-icon> | {{ positionDetails.companyLocation }}</span>
            <br>
            <span class="line2 my-1"><v-icon small>person</v-icon> | {{ positionDetails.title }}</span>
            <br>
            <span class="line2 my-1"><v-icon small>timelapse</v-icon> | {{ positionDetails.timespan }}</span>
            <span class="cursor2">_</span>
          </p>
          <p class="line3 white--text font-weight-bold mt-5">
            <i>Key roles and responsibilities</i>
            <span class="cursor3">_</span>
          </p>
          <ul class="line3">
            <template v-for="role in positionDetails.positionRoles">
              <li class="line3 blue-grey--text text--lighten-2 pb-1">{{ role }}</li>
            </template>
            <span class="cursor3">_</span>
          </ul>
          <p class="line4">><span class="cursor4">_</span></p>

        </v-card-text>
      </v-card>
    </v-flex>
  </v-layout>
</template>

<script>
    export default {
      name: "experience-terminal",
      props: [
        'optionalProps',
      ],

      data: () => ({

      }),

      computed: {
        positionDetails () {
          return this.optionalProps;
        }
      },

      methods: {

      }
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
    padding: 20px;
    border-bottom-left-radius: 5px;
    border-bottom-right-radius: 5px;
    height: auto;
    min-height 250px;
    max-height auto;

    & p, ul, li {
      font-size: 1.25rem;
      font-family: monospace;
      white-space: normal;
      overflow: hidden;
      width: 0;
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
      -webkit-animation: type .5s 1s steps(20, end) forwards;
      -moz-animation: type .5s 1s steps(20, end) forwards;
      -o-animation: type .5s 1s steps(20, end) forwards;
      animation: type .5s 1s steps(20, end) forwards;
    }

    & .cursor1 {
      -webkit-animation: blink 1s 2s 2 forwards;
      -moz-animation: blink 1s 2s 2 forwards;
      -o-animation: blink 1s 2s 2 forwards;
      animation: blink 1s 2s 2 forwards;
    }

    & .line2 {
      color: #CDEE69;
      -webkit-animation: type .5s 4.25s steps(20, end) forwards;
      -moz-animation: type .5s 4.25s steps(20, end) forwards;
      -o-animation: type .5s 4.25s steps(20, end) forwards;
      animation: type .5s 4.25s steps(20, end) forwards;
    }

    & .cursor2 {
      -webkit-animation: blink 1s 5.25s 2 forwards;
      -moz-animation: blink 1s 5.25s 2 forwards;
      -o-animation: blink 1s 5.25s 2 forwards;
      animation: blink 1s 5.25s 2 forwards;
    }

    & .line3 {
      color: #E09690;
      -webkit-animation: type .5s 7.5s steps(20, end) forwards;
      -moz-animation: type .5s 7.5s steps(20, end) forwards;
      -o-animation: type .5s 7.5s steps(20, end) forwards;
      animation: type .5s 7.5s steps(20, end) forwards;
    }

    & .cursor3 {
      -webkit-animation: blink 1s 8.5s 2 forwards;
      -moz-animation: blink 1s 8.5s 2 forwards;
      -o-animation: blink 1s 8.5s 2 forwards;
      animation: blink 1s 8.5s 2 forwards;
    }

    & .line4 {
      color: #fff;
      -webkit-animation: type .5s 10.75s steps(20, end) forwards;
      -moz-animation: type .5s 10.75s steps(20, end) forwards;
      -o-animation: type .5s 10.75s steps(20, end) forwards;
      animation: type .5s 10.75s steps(20, end) forwards;
    }

    & .cursor4 {
      -webkit-animation: blink 1s 11.5s infinite;
      -moz-animation: blink 1s 8.5s infinite;
      -o-animation: blink 1s 8.5s infinite;
      animation: blink 1s 8.5s infinite;
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
