<template>
  <div>
    <v-data-table
      :headers="headers"
      :items="projects"
      :search="search"
      v-model="selected"
      item-key="title"
      select-all
      class="elevation-1"
      dark
    >
      <template slot="headerCell" slot-scope="props">
        <v-tooltip bottom>
          <span slot="activator">
            {{ props.header.text }}
          </span>
          <span>
            {{ props.header.text }}
          </span>
        </v-tooltip>
      </template>
      <template
        style="max-height: 200px;"
        slot="items"
        slot-scope="props"
      >
        <td>
          <v-checkbox
            v-model="props.selected"
            primary
            hide-details
          ></v-checkbox>
        </td>
        <td>{{ props.item.title }}</td>
        <td class="text-xs-center">{{ props.item.url }}</td>
        <td class="text-xs-left overflow-hidden">{{ props.item.content }}</td>
        <td class="text-xs-left overflow-hidden">{{ props.item.files }}</td>
        <td>

          <v-menu bottom left>
            <v-btn
              slot="activator"
              dark
              icon
            >
              <v-icon>more_vert</v-icon>
            </v-btn>

            <v-list dense>
              <v-list-tile @click="editDialogClick(props.item)">
                <v-list-tile-content>
                  <v-list-tile-title>Edit</v-list-tile-title>
                </v-list-tile-content>
                <v-list-tile-action>
                  <v-icon small class="blue-grey--text">edit</v-icon>
                </v-list-tile-action>
              </v-list-tile>
              <v-divider></v-divider>
              <v-list-tile @click="onDeleteClick">
                <v-list-tile-content>
                  <v-list-tile-title>Delete</v-list-tile-title>
                </v-list-tile-content>
                <v-list-tile-action>
                  <v-icon small color="error">remove</v-icon>
                </v-list-tile-action>
              </v-list-tile>
            </v-list>
          </v-menu>
        </td>

      </template>
      </v-data-table>
    <edit-project @on-dialog-click="editDialogClick" :project="project" :edit-dialog="editDialog"></edit-project>
  </div>
</template>
<script>
  import { mapGetters } from 'vuex';
  import EditProject from '../projects/edit-project.vue';

  export default {
    name: 'admin-projects',
    components: { EditProject },
    mounted() {
      this.$store.dispatch('projects/fetchProjects');
    },
    data () {
      return {
        search: '',
        selected: [],
        headers: [
          {
            text: 'Project Name',
            align: 'left',
            sortable: false,
            value: 'title'
          },
          { text: 'URL', value: 'url' },
          { text: 'Content', value: 'content' },
          { text: 'File URLs', value: 'File Urls'},
          { text: 'Actions', value: 'Actions'}
        ],

        editDialog: false,
        project: {
          title: '',
          url: '',
          content: '',
        },
      }
    },
    computed: {
      ...mapGetters('projects/', [
          'projects'
        ])
    },

    methods: {
      onDeleteClick(project) {

      },

      editProject(project) {
        this.editDialogClick();
      },

      editDialogClick(project) {
        this.project = project;
        this.editDialog = !this.editDialog;
      }
    }



  }
</script>

<style scoped>

</style>
