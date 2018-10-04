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
        lg8
      >
        <v-card
          class="elevation-10"
          :class="{'pa-4': $vuetify.breakpoint.mdAndUp}"
        >
          <v-card-title>
            <h5 class="playfair-font headline">Need to get in touch?</h5>
          </v-card-title>
          <v-divider dark></v-divider>
          <v-card-text>
            <v-form v-model="valid">
              <v-flex
                xs12
                md8
                class="my-2"
              >
                <v-text-field
                  append-icon="person"
                  solo
                  clearable
                  v-model="name"
                  label="Your Name"></v-text-field>
              </v-flex>
              <v-flex
                xs12
                md8
                class="my-2"
              >
                <v-text-field
                  append-icon="mail"
                  solo
                  clearable
                  v-model="email"
                  label="Your email"
                ></v-text-field>
              </v-flex>
              <v-flex
                xs12
                md8
                class="my-2"
              >
                <v-textarea
                  append-icon="edit"
                  solo
                  box
                  auto-grow
                  v-model="content"
                  label="Your Message"></v-textarea>
              </v-flex>
            </v-form>
          </v-card-text>
          <v-layout
            row
            wrap
            class="pt-5"
          >
              <v-flex
                offset-xs1
                md5
                sm5
                xs10
              >
                <vue-recaptcha
                  theme="dark"
                  @verify="recaptchaVerified"
                  sitekey="6LfO73IUAAAAALmRXi6dpEBIPDPu1HBtY-9ItT_c"
                ></vue-recaptcha>
              </v-flex>
              <v-flex
                xs10
                sm5
                md5
                offset-xs1
              >
                <v-btn
                  :class="{'v-btn--top': $vuetify.breakpoint.mdAndUp,
                            'my-3': $vuetify.breakpoint.smAndDown,
                            'v-btn--block': $vuetify.breakpoint.smAndDown
                          }"
                  class="blue--text"
                  type="submit"
                  outline
                  large
                  @click.prevent="onContactFormSubmit"
                >
                  Submit
                  <v-icon right>send</v-icon>
                </v-btn>
              </v-flex>
          </v-layout>
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
          content: '',
          gResponse: ''
        }
      },

      computed: {

      },

      methods: {
        onContactFormSubmit() {

        },

        recaptchaVerified(response) {
          console.log(response);
        }
      },

    }
</script>

<style scoped>
  .playfair-font {
    font-family: 'Playfair Display', serif!important;
  }

</style>
