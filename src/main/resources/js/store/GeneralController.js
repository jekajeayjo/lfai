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
        serverList: [
            {
                //Сергей
                name: 'Сервер для разработчиков'
                , resource_url: 'http://127.0.0.1:8888/ods/query'
                , resource_file_url: 'http://127.0.0.1:8888/ods/upload'
                , resource_inbox_url: 'http://127.0.0.1:8888/ods/inbox'
                , resource_file_download: 'http://127.0.0.1:8888/ods/download'
                , resource_file_delete: 'http://127.0.0.1:8888/ods/delete'
                , resource_print: 'http://127.0.0.1:8888/ods/print'
            },
            {
                name: 'Тестовый сервер'
                , resource_url: 'http://25.133.210.152:8888/ods/query'
                , resource_file_url: 'http://25.133.210.152:8888/ods/upload'
                , resource_inbox_url: 'http://25.133.210.152:8888/ods/inbox'
                , resource_file_download: 'http://25.133.210.152:8888/ods/download'
                , resource_file_delete: 'http://25.133.210.152:8888/ods/delete'
                , resource_print: 'http://25.133.210.152:8888/ods/print'

            },
            {
                name: ' Боевой сервер'
                , resource_url: 'http://192.168.254.14:8080/ods/query'
                , resource_file_url: 'http://192.168.254.14:8080/ods/upload'
                , resource_inbox_url: 'http://192.168.254.14:8080/ods/inbox'
                , resource_file_download: 'http://192.168.254.14:8080/ods/download'
                , resource_file_delete: 'http://192.168.254.14:8080/ods/delete'
                , resource_print: 'http://192.168.254.14:8080/ods/print'

            }

        ],
        currentServer: {},
        resourcePrint: resource_print,
        checkContractInfo: false,
        data: null,
        processing: false,
        error: null,
        menu: null,
        news: null,
        countryList: null,
        fileUpload: null,
        pageModule: null,
        overLay: false,
        breadCumpMenuList: [],
        options: {
            perPaginationTable: -1
        },
        choosedItemMenu: {}

    },
    mutations: {
        SET_CURRENT_SERVER(state, payload) {
            state.currentServer = payload
        },
        SET_CHOOSED_ITEM_MENU(state, payload) {
            state.choosedItemMenu = payload
        },
        SET_CHECK_CONTRACT_INFO(state, payload) {
            state.checkContractInfo = payload
        },
        DELETE_LAST_ITEM_BREAD_CUMP_MENU_LIST(state) {
            state.breadCumpMenuList.pop()
        },
        ADD_BREAD_CUMP_MENU_LIST(state, payload) {
            console.log('ADD_BREAD_CUMP_MENU_LIST', payload)
            state.breadCumpMenuList.push(payload)
        },
        SET_BREAD_CUMP_MENU_LIST(state, payload) {
            state.breadCumpMenuList = payload;
        },
        SET_OVERLAY(state, payload) {
            state.overLay = payload
        },
        SET_PROCESSING(state, payload) {
            state.processing = payload
        },
        SET_ERROR(state, payload) {
            state.error = payload
        },
        CLEAN_ERROR(state) {
            state.error = null
        },
        SET_DATA(state, payload) {
            state.data = payload
        },
        SET_MENU(state, payload) {
            state.menu = payload
        },
        SET_NEWS(state, payload) {
            state.news = payload
        },
        SET_COUNTRY_LIST(state, payload) {
            state.countryList = payload
        },
        CLEAN_COUNTRY_LIST(state) {
            state.countryList = null
        },
        SET_FILE_UPLOAD(state, payload) {
            state.fileUpload = payload
        },
        CLEAN_FILE_UPLOAD(state) {
            state.fileUpload = null
        },
        SET_PAGE_MODULE(state, payload) {
            state.pageModule = payload
        },
        CLEAN_PAGE_MODULE(state) {
            state.pageModule = null
        }
        // SET_USERS(state,payload)
        // {
        //     state.users=payload
        // }
    }
    , actions: {
        SET_CHOOSED_ITEM_MENU({commit}, payload) {
            commit('SET_CHOOSED_ITEM_MENU', payload.data)
        },
        SET_CURRENT_SERVER({commit}, payload) {
            commit('SET_CURRENT_SERVER', payload.data)
        },
        SET_CHECK_CONTRACT_INFO({commit}, payload) {
            commit('SET_CHECK_CONTRACT_INFO', payload.data)
        },
        DELETE_LAST_ITEM_BREAD_CUMP_MENU_LIST({commit}) {
            commit('DELETE_LAST_ITEM_BREAD_CUMP_MENU_LIST')
        },
        ADD_BREAD_CUMP_MENU_LIST({commit}, payload) {
            commit('ADD_BREAD_CUMP_MENU_LIST', payload.data)
        },
        CLEAN_BREAD_CUMP_MENU_LIST({commit}) {
            commit('SET_BREAD_CUMP_MENU_LIST', [])
        },
        SET_BREAD_CUMP_MENU_LIST({commit, getters}, payload) {
            if (payload.data.url != null && payload.data.url != '') {
                var breadCumpList = getters.getBreadCumpMenuList
                breadCumpList = []
                if (payload.data.level == 1) {
                    var ojectLevelOne = getters.getMenu.filter(p => p.url == payload.data.url)
                    breadCumpList.push(ojectLevelOne)
                } else if (payload.data.level == 2) {
                    for (var i = 0; i < getters.getMenu.length; i++) {
                        var parent = null, child = null
                        var subList = getters.getMenu[i].children
                        if (getters.getMenu[i].children.length > 0) {
                            for (var j = 0; j < getters.getMenu[i].children.length; j++) {
                                console.log(subList)
                                if (getters.getMenu[i].children[j].url == payload.data.url) {
                                    console.log(getters.getMenu[i].children[j])
                                    child = {
                                        text: getters.getMenu[i].children[j].name
                                    }
                                    parent = {
                                        text: getters.getMenu[i].name
                                    }
                                    breadCumpList.push(parent)
                                    breadCumpList.push(child)
                                    console.log(child)
                                }
                            }


                        }
                    }
                } else if (payload.data.level == 3) {
                    for (var k = 0; k < getters.getMenu.length; k++) {
                        var parentThree = null, childThree = null, subchild = null

                        if (getters.getMenu[k].children.length > 0) {
                            for (var l = 0; l < getters.getMenu[k].children.length; l++) {
                                if (getters.getMenu[k].children[l].children.length > 0) {
                                    for (var g = 0; g < getters.getMenu[k].children[l].children.length; g++) {
                                        if (getters.getMenu[k].children[l].children[g].url == payload.data.url) {
                                            console.log(getters.getMenu[k].children[l].children[g])
                                            parentThree = {
                                                text: getters.getMenu[k].name
                                            }
                                            childThree = {
                                                text: getters.getMenu[k].children[l].name
                                            }
                                            subchild = {
                                                text: getters.getMenu[k].children[l].children[g].name
                                            }
                                            breadCumpList.push(parentThree)
                                            breadCumpList.push(childThree)
                                            breadCumpList.push(subchild)
                                        }
                                    }
                                }

                            }


                        }
                    }
                }

                commit('SET_BREAD_CUMP_MENU_LIST', breadCumpList)
            }
        },
        SET_OVERLAY({commit}, payload) {
            commit('SET_OVERLAY', payload.data)
        },
        SET_PAGE_MODULE({commit}, payload) {
            commit('SET_PAGE_MODULE', payload.pageModule)
        },
        CLEAN_PAGE_MODULE({commit}) {
            commit('CLEAN_MODULE_PAGE')
        },
        SEND_REQUEST({commit,dispatch, state}, payload) {
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
        //ЗАГРУЗКА ФАЙЛА НА СЕРВЕР
        UPLOAD_FILE({commit, state}, payload) {
            // console.log('main payload',payload)
            return new Promise((resolve, reject) => {
                Vue.axios.post(state.currentServer.resource_file_url, payload, {
                    headers: {
                        'Content-Type': 'multipart/form-data;charset=UTF-8'

                    }
                })
                    .then(resp => {
                        commit('CLEAN_ERROR')
                        console.log('get Response ', resp.data)
                        if (resp.data.header.status == 'OK') {
                            console.log('status OK ', resp.data.response)
                            // commit('SET_DATA', resp.data)
                            resolve(resp.data)
                        } else {

                            commit('SET_ERROR', resp.data.header.message)
                            resolve(resp.data.header.message)
                        }
                    }).catch(err => {
                    reject(err)
                })
            });
        },
        //ЗАГРУЗКА ИМПОРТА ДАННЫХ НА СЕРВЕР
        UPLOAD_INBOX_FILE({commit, state}, payload) {
            console.log('main payload', payload)
            return new Promise((resolve, reject) => {
                Vue.axios.post(state.currentServer.resource_inbox_url, payload, {
                    headers: {
                        'Content-Type': 'multipart/form-data;charset=UTF-8'

                    }
                })
                    .then(resp => {
                        commit('CLEAN_ERROR')
                        console.log('get Response ', resp.data)
                        if (resp.data.header.status == 'OK') {
                            console.log('status OK ', resp.data.response)
                            // commit('SET_DATA', resp.data)
                            resolve(resp.data)
                        } else {

                            commit('SET_ERROR', resp.data.header.message)
                            resolve(resp.data.header.message)
                        }
                    }).catch(err => {
                    reject(err)
                })
            });
        },
        // Получение списка
        GET_ROWS({commit, dispatch}, payload) {
            // console.log('GET_ROWS',payload.data)
            dispatch('SEND_REQUEST', payload.data)
                .then(resolve => {
                        // console.log('GET_ROWS', resolve.response.rows)
                        commit('CLEAN_ERROR')
                        payload.showRows(resolve.response.rows)

                    }
                )
        },
        GET_ITEM({commit, dispatch}, payload) {
            console.log('GET_ITEM', payload.data)
            dispatch('SEND_REQUEST', payload.data)
                .then(resolve => {


                        commit('CLEAN_ERROR')
                        payload.showRows(resolve.response)


                    }
                )
        },
        //Сохранение ноного элемента
        ADD_ITEM({dispatch, getters}, payload) {
            console.log('ADD_ITEM', payload.data)
            dispatch('SEND_REQUEST', payload.data)
                .then(resolve => {
                        console.log('ADD_ITEM', resolve.response)
                        if (getters.getError == null) {
                            payload.saveSucces()
                        } else {
                            payload.saveError()
                        }


                    }
                )
        },
        //Сохранение ноного элемента
        ADD_ITEM_P({dispatch, getters}, payload) {
            console.log('ADD_ITEM', payload.data)
            dispatch('SEND_REQUEST', payload.data)
                .then(resolve => {
                        console.log('ADD_ITEM', resolve.response)
                        if (getters.getError == null) {
                            payload.saveSucces(resolve.response)
                        } else {
                            payload.saveError()
                        }


                    }
                )
        },
        //ЗАГРУЗКА ФАЙЛА С СЕРВЕРА
        DOWNLOAD_FILE({commit}, payload) {
            commit('CLEAN_ERROR')
            console.log('main payload', payload.data)
            var urlDownload = resource_file_download + '?id=' + payload.data
            console.log('urlDownload', urlDownload)
            window.location.replace(urlDownload);
        },
        DELETE_FILE({commit}, payload) {
            console.log('delete file', payload)
            return new Promise((resolve, reject) => {
                Vue.axios.get(resource_file_delete + '?id=' + payload)
                    .then(resp => {
                        commit('CLEAN_ERROR')
                        console.log('get Response ', resp.data)
                        if (resp.data.header.status == 'OK') {
                            console.log('status OK ', resp.data.response)
                            // commit('SET_DATA', resp.data)
                            resolve(resp.data)
                        } else {
                            commit('SET_ERROR', resp.data.header.message)
                            resolve(resp.data.header.message)
                        }
                    }).catch(err => {
                    reject(err)
                })
            });

        },
        //получение меню
        GET_MENU({commit, dispatch}, payload) {
            dispatch('SEND_REQUEST', payload.data)
                .then(resolve => {
                        commit('SET_MENU', resolve.response.children)
                    }
                )
        },
        GET_NEWS({commit, dispatch}, payload) {
            dispatch('SEND_REQUEST', payload.data)
                .then(resolve => {
                        commit('SET_NEWS', resolve.response.data)
                    }
                )
        },
        GET_NEWS_DETAIL({dispatch}, payload) {
            dispatch('SEND_REQUEST', payload.data)
                .then(resolve => {
                        payload.getNewsDetail(resolve.response.body)
                    }
                )
        },
        DELETE_NEWS_DETAIL({dispatch, getters}, payload) {
            console.log('DELETE_NEWS_DETAIL', payload.data)
            dispatch('SEND_REQUEST', payload.data)
                .then(resolve => {
                        console.log('DELETE_NEWS_DETAIL', resolve.response)
                        if (getters.getError != null) {
                            payload.statusError()

                        } else {

                            payload.statusSucces()  // commit('SET_POSTSALL', resolve)
                        }


                    }
                )
        },
        GET_COUNTRY_LIST({commit, dispatch}, payload) {
            dispatch('SEND_REQUEST', payload.data)
                .then(resolve => {

                        commit('SET_COUNTRY_LIST', resolve.response.rows)
                    }
                )
        }
        // GET_USERS({commit,dispatch},payload)
        // {
        //     dispatch('SEND_REQUEST', payload.data)
        //         .then(resolve => {
        //
        //                 commit('SET_USERS', resolve.response.rows)
        //             }
        //         )
        // }
        // SEND_REQUEST({commit, state}, payload) {
        //     return new Promise((resolve) => {
        //     Vue.axios.post(resource_url,
        //     payload.data)
        //         .then(resp=>  {
        //            resolve( state.data=resp.data)
        //             if (resp.data) {
        //                 commit('SET_DATA', resp.data)
        //             }
        //         }).catch(err=>{
        //             console.log(err)
        //     })
        //     });
        // }
    },
    getters: {
        getProcessing: (state) => state.processing,
        getError: (state) => state.error,
        getData: (state) => state.data,
        getMenu: (state) => state.menu,
        getNews: (state) => state.news,
        getCountryList: (state) => state.countryList,
        getPageModule: (state) => state.pageModule,
        getOverLay: (state) => state.overLay,
        getBreadCumpMenuList: (state) => state.breadCumpMenuList,
        getOptions: (state) => state.options,
        getResourcePrint: (state) => state.resourcePrint,
        getCurrentServer: (state) => state.currentServer,
        getServerList: (state) => state.serverList,
        getChoosedItemMenu: (state) => state.choosedItemMenu
        // getUsers:(state) => state.users

    }

}