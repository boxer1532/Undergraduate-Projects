import 'vue-material/dist/vue-material.min.css'

import VueMaterial from 'vue-material';
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import Vuetify from 'vuetify'
import VueSession from 'vue-session'
import Bars from 'vuebars'


//Use session
Vue.use(VueSession,{persist:true});
Vue.use(VueMaterial);
Vue.use(Vuetify, {
    iconfont: 'mdi'
});
Vue.use(Bars)

Vue.config.productionTip = false
Vue.prototype.$http = axios

new Vue({
    el: '#app',
    router,
    render: h => h(App)
})
