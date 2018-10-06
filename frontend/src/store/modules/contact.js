import axios from "axios";

const state = {
  responseStatus: false,
};

const getters = {
  responseStatus: state => state.responseStatus,
};

const mutations = {
  responseStatusUpdate(state, data) {
    state.responseStatus = data;
  }
};

const actions = {
  sendEmail({getters, commit}, payload) {
    commit('loading/loadingUpdate', null, { root: true });
    commit('responseStatusUpdate', false);

    return axios.post('/api/contact/send', payload).then((res) => {
      commit('responseStatusUpdate', res.data);
      commit('loading/loadingUpdate', null, { root: true });
    }).catch((err) => {
      commit('loading/loadingUpdate', null, { root: true });
      commit('responseStatusUpdate', err.response.data);
    });
  },
};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
