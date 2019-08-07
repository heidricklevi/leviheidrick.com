<template>
  <div>
    <v-btn 
      v-if="hasHighestCredentials"
      icon
      dark
      @click.prevent="createDialogClick"
    >
      <v-icon>add</v-icon>
      Create
    </v-btn>

    <v-data-table
      :headers="headers"
      :items="about"
      :search="search"
      v-model="selected"
      item-key="title"
      select-all
      class="elevation-1"
      dark
    >

      <template 
        slot="headerCell" 
        slot-scope="props">
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
        slot="items"
        slot-scope="props"
        style="max-height: 200px;"
      >
        <td>
          <v-checkbox
            v-model="props.selected"
            primary
            hide-details
          />
        </td>
        <td>{{ props.item.mainTitle }}</td>
        <td class="text-xs-left">{{ props.item.imageUrl }}</td>
        <td class="text-xs-left admin__projects__td--content overflow-hidden">{{ props.item.content }}</td>
        <td class="text-xs-left overflow-hidden">{{ props.item.positionTitle }}</td>
        <!-- <td class="text-xs-left overflow-hidden">{{ props.item.techStack }}</td>
        <td class="text-xs-left overflow-hidden">{{ props.item.githubLink }}</td> -->

        <td>

          <v-menu 
            bottom 
            left>
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
                  <v-icon 
                    small 
                    class="blue-grey--text">edit</v-icon>
                </v-list-tile-action>
              </v-list-tile>
              <v-divider/>
              <v-list-tile @click="deleteProject(props.item)">
                <v-list-tile-content>
                  <v-list-tile-title>Delete</v-list-tile-title>
                </v-list-tile-content>
                <v-list-tile-action>
                  <v-icon 
                    small 
                    color="error">remove</v-icon>
                </v-list-tile-action>
              </v-list-tile>
            </v-list>
          </v-menu>
        </td>

      </template>
    </v-data-table>
    <edit-about 
      :about-details="aboutDetails" 
      :edit-dialog="editDialog" 
      @on-dialog-click="editDialogClick"
    />
    <!-- <create-project 
      :dialog="createDialog" 
      @on-save-project="saveProject" 
      @on-dialog-click="createDialogClick"/>
    
    <v-dialog
      v-model="alertDelete"
      width="500"
    >
      <v-card
        dark
        class="text-xs-center"
      >
        <v-card-title>
          <h5 class="headline">Are you sure you want to delete this project <span class="blue-grey--text">{{ projectToDelete.title }}</span></h5>
        </v-card-title>
        <v-card-actions>
          <v-spacer/>
          <v-btn 
            flat 
            outline 
            color="error" 
            @click.prevent="deleteProject(projectToDelete)">Yes</v-btn>
          <v-btn 
            flat 
            outline 
            color="warning" 
            @click.prevent="alertDelete = false">No</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog> -->
  </div>
</template>
<script>
  import { mapGetters } from 'vuex';
  import EditAbout from '../about/edit-about.vue';

  export default {
    name: 'AdminAbout',
    components: { EditAbout },
    data () {
      return {
        search: '',
        selected: [],
        headers: [
          {
            text: 'Main Title',
            align: 'left',
            sortable: false,
            value: 'title'
          },
          { text: 'Image Url', value: 'url' },
          { text: 'Content', value: 'content' },
          { text: 'Position Title', value: 'Position Title'},
          // { text: 'Tech Stack', value: 'Tech Stack'},
          // { text: 'Github Link', value: 'Github Link'},

          { text: 'Actions', value: 'Actions'}
        ],

        createDialog: false,
        editDialog: false,
        aboutDetails: {
          positionTitle: '',
          imageUrl: '',
          content: '',
          mainTitle: '',
        },

        projectToDelete: false,
        alertDelete: false,
      }
    },
    mounted() {
      this.$store.dispatch('about/fetchAboutDetails');
    },
    computed: {
      ...mapGetters('about/', [
        'about'
      ]),

      ...mapGetters('auth/', [
        'hasHighestCredentials'
      ]),
    },

    methods: {
      createDialogClick() {
        this.createDialog = !this.createDialog;
      },

      editProject(project) {
        this.editDialogClick();
      },

      editDialogClick(project) {
        this.aboutDetails = project;
        this.editDialog = !this.editDialog;
      },

      saveProject() {
        this.$store.dispatch('projects/submitProject').then((response) => {
        })
      },

      deleteProject(project) {
        if (!this.alertDelete) {
          this.alertDelete = true;
          this.projectToDelete = project;
        }
        else if (this.alertDelete) {
          this.$store.dispatch("projects/deleteProjectById", project.id);
          this.alertDelete = false;
        }
      },
    }



  }
</script>

<style scoped lang="stylus">
  .admin__projects {
    &__td {
      &--content {
        flex-basis 100%
        max-width 30px
        text-overflow ellipsis
        white-space nowrap
      }
    }
  }

</style>
