<template>
  <v-container
    fluid
  >
    <v-layout
      row
      wrap
      justify-center
      align-center
    >
      <v-flex
        xs12
        sm6
      >
        <v-card
          class="elevation-10"
        >
          <v-card-title>
            <h5 class="playfair-font headline">Need to get in touch?</h5>
          </v-card-title>
          <v-divider dark></v-divider>
          <v-card-text>
            <v-form v-model="valid">
              <v-flex
                xs12
                md6
                class="my-2"
              >
                <v-text-field
                  append-icon="person"
                  solo
                  clearable
                  v-model="name"
                  label="Your Name"></v-text-field>
              </v-flex>
              <v-flex xs12 md6 class="my-2">
                <v-text-field
                  append-icon="mail"
                  solo
                  clearable
                  v-model="email"
                  label="Your email"></v-text-field>
              </v-flex>
              <v-flex xs12 md6 class="my-2">
                <v-textarea
                  append-icon="edit"
                  solo
                  box
                  auto-grow
                  v-model="content"
                  label="Your Message"></v-textarea>
              </v-flex>
              <v-flex xs12 md6>
                <vue-recaptcha sitekey="6LfO73IUAAAAALmRXi6dpEBIPDPu1HBtY-9ItT_c"></vue-recaptcha>
              </v-flex>
            </v-form>
          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
    
</template>

<script>
    import VueRecaptcha from 'vue-recaptcha'
    export default {
      name: "contact",
      components: { VueRecaptcha },
      data() {
        return {
          valid: false,

          name: '',
          email: '',
          content: ''
        }
      },

      computed: {

      },

      methods: {

      },

    }
</script>

<style scoped>

</style>
