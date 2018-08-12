import axios from 'axios';
import router from '../../router/index.js';
import jwt_decode from 'jwt-decode';

const state = {
  project: false,
  projects: []
};

const getters = {
  project: state => state.project,
  projects: state => state.projects,
};

const mutations = {
  projectUpdate(state, project) {
    state.project = project;
  },
  projectsUpdate(state, projects) {
    state.projects = projects;
  }
};

const actions = {
  fetchProjects({getters, commit}) {
    axios.get("/api/projects").then((response) => {
      commit('projectsUpdate', response.data);
    }).catch((err) => {
      console.trace(err);
    })
  }
};


export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
