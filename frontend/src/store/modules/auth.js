import axios from 'axios';
import router from '../../router/index.js';
import jwt_decode from 'jwt-decode';

const state = {
  isAuthenticated: false,
  isSuperAdmin: false,
  user: false
};

const getters = {
  auth: state => state,
};

const mutations = {
  authUpdate(state, auth) {
    state = auth;
  }
};

const actions = {
  fetchUserMe({commit, state, getters}) {
   return axios.get('/api/users/me').then((response) => {
      let auth = state;

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
    let auth = getters.auth;
    return axios.post('/api/auth/signin', credentials).then((response) => {
      console.log(response);
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
    let auth = getters.auth;
    for (k in auth) {
      auth[k] = false;
    }

    sessionStorage.removeItem('Bearer');
    commit('authUpdate', false);
  },

  checkAuth({commit, getters, dispatch}) {
    let auth = getters.auth;
    let token = sessionStorage.getItem("Bearer")? sessionStorage.getItem("Bearer"): false;
    if (token) {
      let decodedToken = jwt_decode(token);
      let isExpired = !(decodedToken.exp > (Date.now() / 1000));

      if (isExpired) {
        commit('authUpdate', false);
      }
      else if (!isExpired) {
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
        auth.isAuthenticated = true;
        commit("authUpdate", auth);
        dispatch('fetchUserMe');
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
