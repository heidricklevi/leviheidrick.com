<template>
  <v-container 
    justify-center 
    fill-height>
    <v-layout 
      row 
      wrap 
      justify-center 
      align-center>
      <v-flex 
        xs12 
        md6>
        <v-card dark>
          <v-card-title>
            Login to manage content as administrator
          </v-card-title>
          <v-divider dark/>
          <v-form 
            dark 
            class="py-3">
            <v-flex 
              xs10 
              md8 
              offset-md1>
              <v-text-field 
                v-model="usernameOrEmail" 
                prepend-icon="person" 
                dark 
                label="Username/Email" 
                type="text"/>
            </v-flex>
            <v-flex 
              xs10 
              md8 
              offset-md1>
              <v-text-field 
                v-model="password" 
                dark 
                label="Password" 
                prepend-icon="lock" 
                type="password"/>
            </v-flex>
            <v-flex 
              xs12 
              text-xs-right><v-btn 
                :disabled="isDisabled" 
                dark 
                @click.prevent="login">Submit</v-btn></v-flex>
          </v-form>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
  export default {
    name: "Login",
    data() {
      return {
        isLoading: false,
        password: '',
        usernameOrEmail: '',
        isDisabled: false,
      }
    },
    methods: {
      login() {
        let credentials = {};
        credentials.usernameOrEmail = this.usernameOrEmail;
        credentials.password = this.password;

        this.isDisabled = true;
        this.$store.dispatch('auth/login', credentials).then(() => {
          this.isDisabled = false;
        });
      }
    },


  }
</script>

<style scoped>

</style>
