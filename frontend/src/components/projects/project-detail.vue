<template>
    <v-card v-if="!isLoading" class="elevation-5" :class="{'ma-4': $vuetify.breakpoint.smAndUp}">

      <v-layout row wrap>
      <v-flex xs12 lg3>
        <h5 class="ma-3"><v-icon small>details</v-icon>Project details</h5>
        <v-card-title class="headline">{{project.title}}</v-card-title>
        <v-card-media>
          <!--<v-avatar tile size="280"><img src="/static/WMW2.png"></v-avatar>-->
        </v-card-media>
      </v-flex>
      <v-flex xs12><v-divider dark></v-divider></v-flex>
      <v-flex xs12>
        <v-spacer></v-spacer>

        <v-card-text>
            {{project.content}}
          </v-card-text>
      </v-flex>
      <v-card-actions>

      </v-card-actions>
      </v-layout>
    </v-card>
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
