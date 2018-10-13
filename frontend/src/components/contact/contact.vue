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
            <h5 class="playfair-font display-1">Need to get in touch?</h5>
          </v-card-title>
          <v-divider dark></v-divider>
          <v-card-text>
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
                  required
                  :rules="[rules.required, rules.length(100), rules.email]"
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
                  required
                  counter="2000"
                  :rules="[rules.required, rules.length(2000)]"
                  append-icon="edit"
                  solo
                  box
                  auto-grow
                  v-model="content"
                  label="Your Message"></v-textarea>
              </v-flex>
              <v-flex
                md5
                sm5
                xs10
              >
                <vue-recaptcha
                  theme="dark"
                  required
                  @expired="recaptchaExpired"
                  @verify="recaptchaVerified"
                  sitekey="6LfO73IUAAAAALmRXi6dpEBIPDPu1HBtY-9ItT_c"
                >

                </vue-recaptcha>
                <div class="v-messages theme--dark error--text" v-if="!gResponse && contactFormSubmitted">
                  <div class="v-messages__wrapper">
                    <div class="v-messages__message">This field is required</div>
                  </div>
                </div>
              </v-flex>
              <v-flex
                class="mt-4"
                xs10
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
                  Submit
                  <v-icon right>send</v-icon>
                </v-btn>
              </v-flex>
            </v-form>
          </v-card-text>
        </v-card>
      </v-flex>
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

            this.$store.dispatch('contact/sendEmail', payload);
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

</style>
