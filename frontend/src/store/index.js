import Vue from 'vue'
import Vuex from 'vuex'

// modules
import auth from './modules/auth'
import projects from './modules/projects'
import loading from './modules/loading'
import admin from './modules/admin';
import resume from './modules/resume';
import contact from './modules/contact';
import techSkills from './modules/techSkills';
import about from './modules/about';


Vue.use(Vuex);

const debug = process.env.NODE_ENV !== 'production';

export default new Vuex.Store({
  modules: {
    auth,
    projects,
    loading,
    admin,
    resume,
    contact,
    techSkills,
    about,
  },
  strict: debug,
})
