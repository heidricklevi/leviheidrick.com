import router from '../../router/index.js'

const state = {
  breadcrumbs: [{
    text: 'Home',
    url: '/',
    disabled: false,
  }],
};

const getters = {
  breadcrumbs: (state, commit) => {}
};

const mutations = {
  breadcrumbsUpdate(state, breadcrumbs) {
    state.breadcrumbs = breadcrumbs;
  }
};

const actions = {};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
