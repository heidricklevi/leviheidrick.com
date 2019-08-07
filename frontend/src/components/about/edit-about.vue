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
        <v-toolbar-title>Edit About</v-toolbar-title>
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
            v-model="copyPropAbout.mainTitle"
            label="mainTitle"
            dark
          /></v-flex>
          <v-flex xs12><v-text-field
            v-model="copyPropAbout.imageUrl"
            label="imageUrl"
            dark
          /></v-flex>
          <v-textarea
            v-model="copyPropAbout.content"
            auto-grow
            box
            color="deep-purple"
            label="Content"
            rows="1"
          />
          <v-flex xs12><v-text-field
            v-model="copyPropAbout.positionTitle"
            label="positionTitle"
            dark
          /></v-flex>
          <v-flex xs12><v-switch
            v-model="copyPropAbout.isActive"
            label="positionTitle"
            dark
          /></v-flex>
        </v-layout>
      </v-container>
    </v-card>
  </v-dialog>
</template>

<script>
  export default {
    name: "EditAbout",
    // eslint-disable-next-line vue/require-prop-types
    props: [
      'editDialog',
      'aboutDetails'
    ],
    computed: {
      copyPropAbout() {
        return this.aboutDetails || { mainTitle: '', imageUrl: '', content: '', positionTitle: '', isActive: false};
      }
    },

    methods: {
      onProjectSave() {
        const updatedProject = Object.assign({}, this.copyPropAbout);
        this.$store.dispatch('about/updateAboutById', updatedProject);
      }
    }
  }
</script>

<style scoped>

</style>
