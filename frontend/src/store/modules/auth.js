import axios from 'axios';
import router from '../../router/index.js';
import jwt_decode from 'jwt-decode';
import Utils from '../../lib/utils';

const state = {
  auth: {
    isSuperAdmin: false,
    user: false,
    isAuthenticated: false
  }
};

const getters = {
  auth: state => state.auth,
  hasHighestCredentials: state => {
    return state.auth.isAuthenticated && state.auth.isSuperAdmin;
  }
};

const mutations = {
  authUpdate(state, auth) {
    state.auth = auth;
  }
};

const actions = {
  async fetchUserMe({commit, state, getters}) {
    await axios.get('/api/users/me').then((response) => {
      let auth = Utils.getCopyOf(getters.auth);
      auth.isAuthenticated = true;
      response.data.roles.forEach(role => {
        if (role.id === 4 && role.name === "ROLE_SUPER_ADMIN" ) {
          auth.isSuperAdmin = true;
        }
      });
      auth.user = response.data;
      commit('authUpdate', auth)
    }).catch((err) => {
      console.log(err);
   })
  },
  async login({commit, getters, dispatch}, credentials) {
    let auth = Utils.getCopyOf(getters.auth);
    return axios.post('/api/auth/signin', credentials).then((response) => {

      sessionStorage.setItem('Bearer', response.data.accessToken);
      axios.defaults.headers.common['Authorization'] = `${response.data.tokenType} ${response.data.accessToken}`;

      auth.isAuthenticated = true;
      commit('authUpdate', auth);
      dispatch('fetchUserMe').then(() => {
        router.push({name: 'Home'});
      })
    }).catch((err) => {
      console.log(err);
    })
  },
  logout({commit, getters, dispatch}) {
    let k;
    let auth = Utils.getCopyOf(getters.auth);
    for (k in auth) {
      auth[k] = false;
    }

    sessionStorage.removeItem('Bearer');
    commit('authUpdate', false);
  },

  async checkAuth({commit, getters, dispatch}) {
    let token = sessionStorage.getItem("Bearer")? sessionStorage.getItem("Bearer"): false;
    if (token) {
      let decodedToken = jwt_decode(token);
      let isExpired = !(decodedToken.exp > (Date.now() / 1000));

      if (isExpired) {
        commit('authUpdate', false);
      }
      else if (!isExpired) {
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
        await dispatch('fetchUserMe');
      }

    }

  }
};


export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
