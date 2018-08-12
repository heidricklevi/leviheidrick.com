<template>
  <v-dialog v-model="dialog" max-width="980" :fullscreen="$vuetify.breakpoint.smAndDown" hide-overlay persistent transition="dialog-bottom-transition">
    <v-card>
      <v-toolbar dark color="primary">
        <v-btn icon dark @click.native="$emit('on-dialog-click')">
          <v-icon>close</v-icon>
        </v-btn>
        <v-toolbar-title>Create a Project</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-toolbar-items>
          <v-btn dark flat @click.prevent="onProjectSave" id="save">Save</v-btn>
        </v-toolbar-items>
      </v-toolbar>

      <v-container fluid>
        <v-layout row wrap>
              <v-flex xs12><v-text-field
                label="Title"
                v-model="project.title"
                dark
              ></v-text-field></v-flex>
          <v-flex xs12><v-text-field
              label="Project web address"
              v-model="project.url"
              dark
          ></v-text-field></v-flex>
            <v-textarea
              v-model="project.content"
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
      props: ['dialog'],
      name: "create-project",
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
          let project = Object.assign({}, this.project);
          this.$store.commit('projects/projectUpdate', project);
          this.$emit('on-save-project');
        }
      }
    }
</script>

<style scoped>

</style>
