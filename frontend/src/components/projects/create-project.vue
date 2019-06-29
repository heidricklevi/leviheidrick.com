<template>
  <v-dialog 
    v-model="dialog" 
    :fullscreen="$vuetify.breakpoint.smAndDown" 
    max-width="980" 
    hide-overlay 
    persistent 
    transition="dialog-bottom-transition">
    <v-card>
      <v-toolbar 
        dark 
        color="primary">
        <v-btn 
          icon 
          dark 
          @click.native="$emit('on-dialog-click')">
          <v-icon>close</v-icon>
        </v-btn>
        <v-toolbar-title>Create a Project</v-toolbar-title>
        <v-spacer/>
        <v-toolbar-items>
          <v-btn 
            id="save" 
            dark 
            flat 
            @click.prevent="onProjectSave">Save</v-btn>
        </v-toolbar-items>
      </v-toolbar>

      <v-container fluid>
        <v-layout 
          row 
          wrap>
          <v-flex xs12><v-text-field
            v-model="project.title"
            label="Title"
            dark
          /></v-flex>
          <v-flex xs12><v-text-field
            v-model="project.url"
            label="Project web address"
            dark
          /></v-flex>
          <v-textarea
            v-model="project.content"
            auto-grow
            box
            color="deep-purple"
            label="Content"
            rows="1"
          />
        </v-layout>
      </v-container>
    </v-card>
  </v-dialog>
</template>

<script>
  import Utils from "../../lib/utils";
  export default {
    name: "CreateProject",
    props: ['dialog'],
    data() {
      return {
        valid: false,
        project: {
          title: '',
          url: '',
          content: '',
        },
      }
    },
    methods: {
      onProjectSave() {
        let project = Utils.getCopyOf(this.project);
        this.$store.commit('projects/projectUpdate', project);
        this.$emit('on-save-project');
      }
    }
  }
</script>

<style scoped>

</style>
