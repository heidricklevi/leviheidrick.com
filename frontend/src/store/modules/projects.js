import axios from 'axios';

const state = {
  project: false,
  projects: [],
  responseStatus: null,
};

const getters = {
  project: state => state.project,
  projects: state => state.projects,
  responseStatus: state => state.responseStatus,
};

const mutations = {
  projectUpdate(state, project) {
    state.project = project;
  },

  projectsUpdate(state, projects) {
    state.projects = projects;
  },

  responseStatusUpdate(state, mesg) {
    state.responseStatus = mesg;
  }
};

const actions = {
  fetchProjects({getters, commit}) {
    commit('loading/loadingUpdate', null, { root: true });
    commit('responseStatusUpdate', false);

    return axios.get("/api/projects").then((response) => {
      commit('projectsUpdate', response.data);
      commit('loading/loadingUpdate', null, { root: true });
    }).catch((err) => {
      console.trace(err);
      commit('loading/loadingUpdate', null, { root: true });
      commit('responseStatusUpdate', err.response.data);
    })
  },

  submitProject({getters, commit}) {
    commit('loading/loadingUpdate', null, { root: true });
    commit('responseStatusUpdate', false);

    return axios.post('/api/projects/submit', getters.project).then((res) => {
      commit('responseStatusUpdate', res.data);
      commit('loading/loadingUpdate', null, { root: true });
    }).catch((err) => {
      commit('loading/loadingUpdate', null, { root: true });
      commit('responseStatusUpdate', err.response.data);
    });
  },

  fetchProjectByTitle({getters, commit}, title) {
    commit('loading/loadingUpdate', null, { root: true });
    commit('responseStatusUpdate', false);

    return axios.get(`/api/projects/${encodeURIComponent(title)}`).then((response) => {
            commit('projectUpdate', response.data);
            commit('loading/loadingUpdate', null, { root: true });
          }).catch((err) => {
            commit('loading/loadingUpdate', null, { root: true });
            console.log(err.response.data.error);
            commit('responseStatusUpdate', err.response.data)
          });
  },

  deleteProjectById({getters, commit}, id) {
    commit('loading/loadingUpdate', null, { root: true });
    commit('responseStatusUpdate', false);

    return axios.delete(`/api/projects/${id}`, { params: {id: id}}).then((response) => {
      commit('projectsUpdate', response.data);
      commit('loading/loadingUpdate', null, { root: true });
    }).catch((err) => {
      commit('loading/loadingUpdate', null, { root: true });
      console.log(err.response.data.error);
      commit('responseStatusUpdate', err.response.data)
    });
  },

  updateProjectById({getters, commit}, project) {
    commit('loading/loadingUpdate', null, { root: true });
    commit('responseStatusUpdate', false);

    return axios.put(`/api/projects/edit/${project.id}`, project).then((response) => {
      commit('projectsUpdate', response.data);
      commit('loading/loadingUpdate', null, { root: true });
    }).catch((err) => {
      commit('loading/loadingUpdate', null, { root: true });
      console.log(err.response.data.error);
      commit('responseStatusUpdate', err.response.data)
    });
  }

};


export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
