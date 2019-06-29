<template>
  <v-breadcrumbs class="pl-0">
    <v-icon slot="divider">forward</v-icon>

    <v-breadcrumbs-item
      v-for="(item, index) in items"
      :key="item.text"
      :to="item.url"
      :class="{
        'v-breadcrumbs__item': index < items.length - 1,
        'disabled': index === items.length - 1,
      }"
      active-class=""
    >
      {{ item.text }}
    </v-breadcrumbs-item>
  </v-breadcrumbs>
</template>

<script>
  export default {
    name: "Breadcrumbs",
    data() {
      return {
        breadcrumbs: false
      }
    },
    computed: {
      items() {
        return this.breadcrumbs;
      }
    },

    watch: {
      '$route'(to, from) {
        this.breadcrumbs = this.$route.meta.breadcrumb;
      }
    },
    mounted() {
      this.breadcrumbs = this.$route.meta.breadcrumb;
    },



  }
</script>

<style scoped lang="stylus">
  .disabled {
    text-transform uppercase;
    pointer-events: none;


  }
  .disabled .v-breadcrumbs__item a{
    color: lightgray !important;
  }
</style>
