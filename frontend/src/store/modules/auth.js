import axios from 'axios';

const state = {
  auth: {
    isAuthenticated: false,
    isSuperAdmin: false,
    user: false
  }

};

const getters = {
  auth: state => state.auth,
};

const mutations = {
  authUpdate(state, auth) {
    state.auth = auth;
  }
};

const actions = {
  login({commit, state}, credentials) {
    let auth = state.auth;
    return axios.post('/api/auth/signin', credentials).then((response) => {
      axios.defaults.headers.common['Authorization'] = `${response.tokenType} ${response.accessToken}`;

      auth.isAuthenticated = true;
      auth.user = true;

      commit('authUpdate', auth);
    }).catch((err) => {
      console.log(err);
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
