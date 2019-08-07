import axios from "axios";

const state = {
  responseStatus: false,
  about: [],
  aboutActive: false,
};

const getters = {
  responseStatus: state => state.responseStatus,
  about: state => state.about,
  aboutActive: state => state.aboutActive,
  getActiveAboutSection: state => state.about.find(k => k.isActive),
};

const mutations = {
  responseStatusUpdate(state, data) {
    state.responseStatus = data;
  },

  aboutUpdate(state, about) {
    state.about = about;
  },

  aboutActiveUpdate(state, about) {
    state.aboutActive = about;
  }
};

const actions = {
  async fetchAboutDetails({getters, commit}) {
    commit('loading/loadingUpdate', null, { root: true });
    commit('responseStatusUpdate', false);

    try {
      const res = await axios.get('/api/about/');
      commit('loading/loadingUpdate', null, { root: true });
      if (
        res
        && res.data
        && Array.isArray(res.data)
        && res.data.length > 0
      ) {
        commit('aboutUpdate', res.data);
        commit('aboutActiveUpdate', getters.getActiveAboutSection);
      }
    } catch (e) {
      commit('loading/loadingUpdate', null, { root: true });
      commit('responseStatusUpdate', e.response.data);
    }
  },

  updateAboutById({getters, commit}, aboutDetails) {
    commit('loading/loadingUpdate', null, { root: true });
    commit('responseStatusUpdate', false);

    return axios.put(`/api/about/${aboutDetails.id}`, aboutDetails).then((response) => {
      commit('aboutUpdate', response.data);
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
