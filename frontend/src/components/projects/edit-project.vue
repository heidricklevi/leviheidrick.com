<template>
  <v-dialog 
    v-model="editDialog" 
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
        <v-toolbar-title>Edit a Project</v-toolbar-title>
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
            v-model="copyPropProject.title"
            label="Title"
            dark
          /></v-flex>
          <v-flex xs12><v-text-field
            v-model="copyPropProject.url"
            label="Project web address"
            dark
          /></v-flex>
          <v-textarea
            v-model="copyPropProject.content"
            auto-grow
            box
            color="deep-purple"
            label="Content"
            rows="1"
          />
          <v-flex xs12><v-combobox
            v-model="selectedTechStackList"
            :items="copyPropProject.techStack"
            label="Add Tech Stacks to this list or remove"
            multiple
          /></v-flex>

        </v-layout>
      </v-container>
    </v-card>
  </v-dialog>
</template>

<script>
  export default {
    name: "EditProject",
    // eslint-disable-next-line vue/require-prop-types
    props: [
      'editDialog',
      'project'
    ],
    data() {
      return {
        selectedTechStackList: [],
      }
    },
    computed: {
      copyPropProject() {
        return this.project || { title: '', url: '', content: '', techStack: [] };
      }
    },
    mounted() {
      this.selectedTechStackList = this.copyPropProject.techStack
    },

    methods: {
      onProjectSave() {
        const updatedProject = Object.assign({}, this.copyPropProject);
        updatedProject.techStack = this.selectedTechStackList;
        this.$store.dispatch('projects/updateProjectById', updatedProject).then(() => {

        })
      }
    }
  }
</script>

<style scoped>

</style>
