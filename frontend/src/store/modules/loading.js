const state = {
  isLoading: false,
};

const getters = {
  isLoading: state => state.isLoading,
};

const mutations = {
  loadingUpdate(state) {
    state.isLoading = !state.isLoading;
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
