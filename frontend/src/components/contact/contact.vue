<template>
  <v-container
    class="contact__container"
    fluid
    fill-height
    justify-center
    align-center >
    <v-layout
      row
      wrap
      justify-center
      align-center

    >

      <div
        :class="{'pa-4': $vuetify.breakpoint.mdAndUp}"
        class="elevation-10"
      >
        <v-layout 
          row 
          wrap 
          class="py-3">
          <v-flex 
            xs12 
            text-xs-center 
            text-md-left>
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
          <v-flex 
            xs12 
            class="py-2 text-xs-center">
            <h5 class="playfair-font headline extra-letter-spacing">levi@leviheidrick.com</h5>
            <span class="caption font-italic grey--text text--lighten-2"> OR </span>

          </v-flex>
          <v-flex 
            xs12 
            justify-center 
            layout 
            row 
            wrap>
            <v-form 
              ref="contactForm" 
              v-model="valid" 
              lazy-validation 
              @submit.prevent="onContactFormSubmit">
              <v-flex
                xs12
                md8
                class="my-2"
              >
                <v-text-field
                  :rules="[rules.required, rules.length(100)]"
                  v-model="name"
                  required
                  append-icon="person"
                  outline
                  clearable
                  label="Name"/>
              </v-flex>
              <v-flex
                xs12
                md8
                class="my-2"
              >
                <v-text-field
                  :rules="[rules.required, rules.length(100), rules.email]"
                  v-model="email"
                  required
                  dark
                  append-icon="mail"
                  outline
                  clearable
                  label="Email"
                />
              </v-flex>
              <v-flex
                xs12
                md8
                class="my-2"
              >
                <v-textarea
                  :rules="[rules.required, rules.length(2000)]"
                  v-model="content"
                  required
                  counter="2000"
                  append-icon="edit"
                  outline
                  auto-grow
                  label="Message"/>
              </v-flex>
              <v-flex
                xs12
                md8
              >
                <vue-recaptcha
                  theme="dark"
                  required
                  sitekey="6LfO73IUAAAAALmRXi6dpEBIPDPu1HBtY-9ItT_c"
                  class="g-recaptcha"
                  @expired="recaptchaExpired"
                  @verify="recaptchaVerified"
                />
                <div 
                  v-if="!gResponse && contactFormSubmitted" 
                  class="v-messages theme--dark error--text">
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
                  :disabled="!valid"
                  class="blue--text"
                  type="submit"
                  outline
                  large

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
        :color="snackColor"
        top
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
    name: "Contact",
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
    background-color: #0b0c10;
    height: 100%!important;
  }
  .g-recaptcha {
    transform:scale(0.77);
    -webkit-transform:scale(0.77);
    transform-origin:0 0;
    -webkit-transform-origin:0 0;
  }
</style>
