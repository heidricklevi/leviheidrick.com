import Vue from 'vue'
import Vuex from 'vuex'

// modules
import auth from './modules/auth'
import projects from './modules/projects'
import loading from './modules/loading'
import admin from './modules/admin';

Vue.use(Vuex);

const debug = process.env.NODE_ENV !== 'production';

export default new Vuex.Store({
  modules: {
    auth,
    projects,
    loading,
    admin,
  },
  strict: debug,
})
