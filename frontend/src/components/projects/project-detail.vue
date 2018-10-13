<template>
  <v-layout justify-center>
    <v-flex xl8 lg10 sm12>
    <v-card v-if="!isLoading" class="elevation-5" :class="{'ma-4': $vuetify.breakpoint.smAndUp}">

      <v-layout row wrap>
      <v-flex xs12 lg3>
        <v-card-title class="display-1 playfair-font">{{project.title}}</v-card-title>
      </v-flex>
      <v-flex xs12><v-divider dark></v-divider></v-flex>
      <v-flex xs12>
        <v-spacer></v-spacer>

        <v-card-text v-html="project.content" class="body-1">
            {{project.content}}
        </v-card-text>
      </v-flex>
      <v-card-actions>

      </v-card-actions>
      </v-layout>
    </v-card>
    </v-flex>
  </v-layout>
</template>

<script>
    import { mapActions, mapGetters } from 'vuex';
    export default {
      name: "project-detail",
      props: ['dialog'],
      beforeRouteEnter(to, from, next) {
        next(self => {
          self.fetchProjectByTitle(self.$route.params.name).then(() => {});
        })
      },
      data() {
        return {

        }
      },
      methods: {
        ...mapActions('projects/', ['fetchProjectByTitle'])
      },
      computed: {
        ...mapGetters('projects/', [
          'responseStatus',
        ]),
        ...mapGetters('loading/', [
          'isLoading',
        ]),

        project() {
          return this.$store.getters['projects/project'];
        }
      }
    }
</script>

<style scoped>

</style>
