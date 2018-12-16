<template>
    <div v-if="items.length > 1" class="mt-1">
      <div >
        <v-breadcrumbs>
          <v-icon slot="divider">forward</v-icon>

          <v-breadcrumbs-item
            v-for="(item, index) in items"
            :key="item.text"
            :to="item.url"
            active-class=""
            :class="{'v-breadcrumbs__item': index < items.length - 1}"
          >
            {{ item.text }}
          </v-breadcrumbs-item>
        </v-breadcrumbs>
      </div>
      <v-divider></v-divider>
    </div>
</template>

<script>
    export default {
        name: "breadcrumbs",
        mounted() {
          this.breadcrumbs = this.$route.meta.breadcrumb;
        },
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
        }



    }
</script>

<style scoped>

</style>
