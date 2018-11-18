<template>
  <v-dialog v-model="editDialog" max-width="980" :fullscreen="$vuetify.breakpoint.smAndDown" hide-overlay persistent transition="dialog-bottom-transition">
    <v-card>
      <v-toolbar dark color="primary">
        <v-btn icon dark @click.native="$emit('on-dialog-click')">
          <v-icon>close</v-icon>
        </v-btn>
        <v-toolbar-title>Edit a Project</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-toolbar-items>
          <v-btn dark flat @click.prevent="onProjectSave" id="save">Save</v-btn>
        </v-toolbar-items>
      </v-toolbar>

      <v-container fluid>
        <v-layout row wrap>
          <v-flex xs12><v-text-field
            label="Title"
            v-model="copyPropProject.title"
            dark
          ></v-text-field></v-flex>
          <v-flex xs12><v-text-field
            label="Project web address"
            v-model="copyPropProject.url"
            dark
          ></v-text-field></v-flex>
          <v-textarea
            v-model="copyPropProject.content"
            auto-grow
            box
            color="deep-purple"
            label="Content"
            rows="1"
          ></v-textarea>

        </v-layout>
      </v-container>
    </v-card>
  </v-dialog>
</template>

<script>
    export default {
        name: "edit-project",
        props: [
          'editDialog',
          'project'
        ],
        computed: {
          copyPropProject() {
            return this.project || { title: '', url: '', content: '' };
          }
        },

        methods: {
          onProjectSave() {
            this.$store.dispatch('projects/updateProjectById', this.copyPropProject).then(() => {

            })
          }
        }
    }
</script>

<style scoped>

</style>
