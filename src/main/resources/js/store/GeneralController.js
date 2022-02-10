import Vue from 'vue'
import axios from "axios";
import VueAxios from "vue-axios";
import router from '../routes.js'
Vue.use(VueAxios, axios)
//Сергей
// const resource_url = 'http://127.0.0.1:8888/ods/query'
// const resource_file_url = 'http://127.0.0.1:8888/ods/upload'
// const resource_inbox_url = 'http://127.0.0.1:8888/ods/inbox'
// const resource_file_download = 'http://127.0.0.1:8888/ods/download'
// const resource_file_delete = 'http://127.0.0.1:8888/ods/delete'
// const resource_print = 'http://127.0.0.1:8888/ods/print'
// тест
const resource_url = 'http://25.133.210.152:8888/ods/query'
const resource_file_url = 'http://25.133.210.152:8888/ods/upload'
const resource_inbox_url = 'http://25.133.210.152:8888/ods/inbox'
const resource_file_download = 'http://25.133.210.152:8888/ods/download'
const resource_file_delete = 'http://25.133.210.152:8888/ods/delete'
const resource_print = 'http://25.133.210.152:8888/ods/print'
// бой
// const resource_url = 'http://192.168.254.14:8080/ods/query'
// const resource_file_url = 'http://192.168.254.14:8080/ods/upload'
// const resource_inbox_url = 'http://192.168.254.14:8080/ods/inbox'
// const resource_file_download = 'http://192.168.254.14:8080/ods/download'
// const resource_file_delete = 'http://192.168.254.14:8080/ods/delete'
// const resource_print = 'http://192.168.254.14:8080/ods/print'

export default {
    state: {
        gateUrl:'',
        error: null,

    },
    mutations: {
        SET_ERROR(state, payload) {
            state.error = payload
        },
        CLEAN_ERROR(state) {
            state.error = null
        },
    }
    , actions: {

        SEND_REQUEST_POST({commit,dispatch, state}, payload) {
            // console.log('main payload',payload)
            return new Promise((resolve, reject) => {
                Vue.axios.post(state.currentServer.resource_url, payload)
                    .then(resp => {
                        commit('CLEAN_ERROR')
                        console.log('get Response ', resp.data)
                        if (resp.data.header.status == 'OK') {
                            console.log('status OK ', resp.data.response)
                            // commit('SET_DATA', resp.data)
                            resolve(resp.data)
                        } else if (resp.data.header.status == 'GLOBAL') {
                            dispatch('CLEAN_BREAD_CUMP_MENU_LIST')
                            dispatch('SIGN_OUT')
                            commit('SET_ERROR', resp.data.header.message)
                            router.push("/login");
                        } else {
                            commit('SET_PROCESSING', false)
                            commit('SET_ERROR', resp.data.header.message)
                            // resolve(resp.data.header.message)
                        }
                    }).catch(err => {
                    reject(err)
                })
            });
        },
        SEND_REQUEST_GET({commit, getters}, payload) {
            // console.log('main payload',payload)
            var url=getters.getGateUrl+payload.url
            return new Promise((resolve, reject) => {
                Vue.axios.get(url, {
                    // headers: {Authorization: getters.getToken}
                })
                    .then(resp => {
                        commit('CLEAN_ERROR')
                        console.log('get Response ', resp.data)
                        // commit('SET_DATA', resp.data)
                        resolve(resp.data)

                    }).catch(err => {
                    commit('SET_ERROR', 'Ошибка подключения')
                    console.log('error connect')
                    reject(err)
                })
            });
        },






    },
    getters: {
        getGateUrl:(state)=>state.gateUrl,
        getError: (state) => state.error,

    }

}