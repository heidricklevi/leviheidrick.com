<template>
  <v-content/>
</template>

<script>
  import Breadcrumbs from "../../components/global/breadcrumbs.vue";
  import Experience from "../experience/experience";

  export default {
    name: 'Home',
    components: {
      Experience,
      Breadcrumbs
    },
    data () {
      return {
        drawer: false,

      }
    },
    computed: {
      auth() {
        return this.$store.getters['auth/auth'];
      }
    },
    created() {
      this.$store.dispatch('auth/checkAuth');
    },

    methods: {
      logout() {
        this.$store.dispatch('auth/logout');
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
  .flex .v-list.no-background-color {
    background-color: unset!important;
  }

  .uppercase {
    text-transform: uppercase!important;
  }

  .letter_spacing {
    letter-spacing: 1px!important;
  }

  .v-card.card-side-border {
    border-left: 1rem solid #485563;
  }

  #warn-super-admin {
    position: absolute;
    top: 45px;
    right: 60px;
  }
</style>
