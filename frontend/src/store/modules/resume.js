import axios from 'axios';

const state = {
  resume: false,
};

const getters = {
  resume: state => state.resume,
};

const mutations = {
  resumeUpdate(state, resume) {
    state.resume = resume;
  }

};

const actions = {
  fetchResume({state, getters, commit}) {
    commit('loading/loadingUpdate', null, { root: true });
    axios.get("/api/resume").then((res) => {
      commit('resumeUpdate', res.data[0]);
      commit('loading/loadingUpdate', null, { root: true });
    }).catch((err) => {
      commit('loading/loadingUpdate', null, { root: true });
      console.log(err)
    })

  },

  updateResume({state, getters, commit}, {data: data, params: params}) {
    commit('loading/loadingUpdate', null, { root: true });
    const config = {
      headers: {
        'content-type': 'multipart/form-data'
      }
    };
    axios.put(`/api/resume/edit/${params.urlFileName}/${params.id}`, data, config).then((res) => {
      commit('resumeUpdate', res.data);
      commit('loading/loadingUpdate', null, { root: true });
    }).catch((err) => {
      console.log(err);
      commit('loading/loadingUpdate', null, { root: true });
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
