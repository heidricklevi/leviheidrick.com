<template>
  <v-container
    class="contact__container"
    fluid
    fill-height
  >
    <v-layout
      row
      wrap
      justify-center
      align-center

    >

        <div
          class="elevation-10"
          :class="{'pa-4': $vuetify.breakpoint.mdAndUp}"
        >
          <v-layout row wrap class="py-3">
            <v-flex xs12 text-xs-center text-md-left>
              <h3 class="header-tech"><v-icon color="orange lighten-2">fas fa-terminal</v-icon>
                Contact
              </h3>
            </v-flex>
          </v-layout>
          <v-layout
            container
            row
            wrap
            align-center
            justify-center
          >
            <v-flex xs12 class="py-2 text-xs-center">
              <h5 class="playfair-font display-2">Need to get in touch?</h5>
              <span class="caption font-italic grey--text text--lighten-2"> Reach out below or shoot me an email at levi@leviheidrick.com</span>

            </v-flex>
            <v-flex xs12 justify-center layout row wrap>
            <v-form ref="contactForm" @submit.prevent="onContactFormSubmit" v-model="valid" lazy-validation>
              <v-flex
                xs12
                md8
                class="my-2"
              >
                <v-text-field
                  required
                  :rules="[rules.required, rules.length(100)]"
                  append-icon="person"
                  outline
                  clearable
                  v-model="name"
                  label="Name"></v-text-field>
              </v-flex>
              <v-flex
                xs12
                md8
                class="my-2"
              >
                <v-text-field
                  required
                  dark
                  :rules="[rules.required, rules.length(100), rules.email]"
                  append-icon="mail"
                  outline
                  clearable
                  v-model="email"
                  label="Email"
                ></v-text-field>
              </v-flex>
              <v-flex
                xs12
                md8
                class="my-2"
              >
                <v-textarea
                  required
                  counter="2000"
                  :rules="[rules.required, rules.length(2000)]"
                  append-icon="edit"
                  outline
                  auto-grow
                  v-model="content"
                  label="Message"></v-textarea>
              </v-flex>
              <v-flex
                xs12
                md8
              >
                <vue-recaptcha
                  theme="dark"
                  required
                  @expired="recaptchaExpired"
                  @verify="recaptchaVerified"
                  sitekey="6LfO73IUAAAAALmRXi6dpEBIPDPu1HBtY-9ItT_c"
                  class="g-recaptcha"
                >

                </vue-recaptcha>
                <div class="v-messages theme--dark error--text" v-if="!gResponse && contactFormSubmitted">
                  <div class="v-messages__wrapper">
                    <div class="v-messages__message">This field is required</div>
                  </div>
                </div>
              </v-flex>
              <v-flex
                class="mt-4 text-xs-right"
                xs12
                md8
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
                  :disabled="!valid"

                >
                  Send
                  <v-icon right>send</v-icon>
                </v-btn>
              </v-flex>
            </v-form>
              </v-flex>
          </v-layout>
        </div>
      <v-snackbar
        v-model="snackbar"
        top
        :color="snackColor"
      >
        {{ snackMessage }}
      </v-snackbar>
    </v-layout>
  </v-container>
    
</template>

<script>
    import VueRecaptcha from 'vue-recaptcha';
    import { mapGetters } from 'vuex';

    export default {
      name: "contact",
      components: { VueRecaptcha },
      data() {
        return {
          valid: false,
          nameRules: [v => !!v || 'This field is required', v => v.length <= 100 || "Requires length less than 100"],
          contentRules: [v => !!v || 'This field is required', v => v.length <= 100 || "Requires length less than 100"],

          rules: {
            required: v => !!v || 'This field is required',
            length: len => v => (v || '').length <= len || `Field requires fewer than ${len} chars.`,
            email: v => /.+@.+/.test(v) || 'E-mail must be valid',
          },

          name: '',
          email: '',
          content: '',
          gResponse: false,

          contactFormSubmitted: false,

          snackbar: false,
          snackMessage: '',
          snackColor: 'success',

        }
      },

      computed: {
        ...mapGetters('contact/', [
          'responseStatus'
        ])
      },

      methods: {
        onContactFormSubmit() {
          this.contactFormSubmitted = true;
          if (this.$refs.contactForm.validate() && this.gResponse) {
            // valid

            const payload = {
              fromEmail: this.email,
              senderName: this.name,
              message: this.content,
              gResponse: this.gResponse
            };

            this.$store.dispatch('contact/sendEmail', payload).then(() => {
              this.snackbar = true;
              this.snackMessage = this.responseStatus.message;
              this.snackColor = this.responseStatus.success? 'success': 'error';
            });
          }
        },

        recaptchaVerified(response) {
          this.gResponse = response;
        },

        recaptchaExpired() {
          this.gResponse = false;
        }
      },

    }
</script>

<style scoped>
  form {
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
  }
  .contact__container {
    background-color: rgb(0, 1, 2);
  }
  .g-recaptcha {
    transform:scale(0.77);
    -webkit-transform:scale(0.77);
    transform-origin:0 0;
    -webkit-transform-origin:0 0;
  }
</style>
