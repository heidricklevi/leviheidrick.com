import axios from 'axios';

const state = {
  techSkills: [],
  responseStatus: null,
};

const getters = {
  techSkills: state => state.techSkills,
  responseStatus: state => state.responseStatus,
};

const mutations = {
  setTechSkills(state, techSkills) {
    state.techSkills = techSkills;
  },

  responseStatusUpdate(state, mesg) {
    state.responseStatus = mesg;
  }
};

const actions = {
  fetchTechSkills({commit}) {
    commit('loading/loadingUpdate', null, { root: true });
    commit('responseStatusUpdate', false);

    return axios.get("/api/techSkills").then((response) => {
      commit('setTechSkills', response.data);
      commit('loading/loadingUpdate', null, { root: true });
    }).catch((err) => {
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

  deleteProjectById({commit}, id) {
    commit('loading/loadingUpdate', null, { root: true });
    commit('responseStatusUpdate', false);

    return axios.delete(`/api/projects/${id}`, { params: {id: id}}).then((response) => {
      commit('projectsUpdate', response.data);
      commit('loading/loadingUpdate', null, { root: true });
    }).catch((err) => {
      commit('loading/loadingUpdate', null, { root: true });
      // eslint-disable-next-line no-console
      console.log(err.response.data.error);
      commit('responseStatusUpdate', err.response.data)
    });
  },

  updateTechSkillsById({commit}, techSkill) {
    commit('loading/loadingUpdate', null, { root: true });
    commit('responseStatusUpdate', false);

    return axios.put(`/api/techSkills/edit/${techSkill.id}`, techSkill).then((response) => {
      commit('projectsUpdate', response.data);
      commit('loading/loadingUpdate', null, { root: true });
    }).catch((err) => {
      commit('loading/loadingUpdate', null, { root: true });
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
