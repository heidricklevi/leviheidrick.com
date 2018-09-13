<template>
    <v-container>
      <v-layout justify-center align-center>

        <v-flex text-xs-center lg5>
          <v-card>
            <v-card-title>
              <h5 class="headline blue-grey--text">
                Resume
              </h5>
            </v-card-title>
          </v-card>
          {{resume}}
        </v-flex>
      </v-layout>
    </v-container>
</template>

<script>
    import {mapGetters} from 'vuex';

    export default {
      name: "admin-resume",
      created() {
        this.$store.dispatch('resume/fetchResume')
      },
      data() {
        return {

        }
      },

      computed: {
        ...mapGetters('resume/', ['resume'])
      }
    }
</script>

<style scoped>

</style>
