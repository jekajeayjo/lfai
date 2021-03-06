import Store from './store'

import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from './views/Home.vue'
import About from './views/About.vue'
import SignIn from "./views/SignIn.vue";
//тест

// import ContractDriver from "../components/contracts/type_atribut_contracts/ContractDriver.vue";
Vue.use(VueRouter)
//гуарды нужны для защиты от входа если пользователь напрмиер не авторизирвоан
// первый способ guardind
// const routes = [
//     {path: '/', component: Home,beforeEnter:AuthGuard},
//     {path: '/about', name: 'about', component: About,beforeEnter:AuthGuard},
//     {path: '/data', name: 'DataTable', component: DataTable,beforeEnter:AuthGuard},
//     {path: '/login', name: 'SignIn', component: SignIn}
// ]

let router = new VueRouter({
    routes: [
        //тест



//Авторизация
        {path: '/login', name: 'SignIn', component: SignIn,meta: {authRequired: false}}


    ]
})
router.beforeEach((to, from, next) => {
    Store.dispatch('INIT_AUTH')
        .then(user => {
            if (to.matched.some(route => route.meta.authRequired)) {
                // if (Store.getnews_redactorters.isUserAuthenticated)
                if(user)
                    next()
                else
                    next('login')
            } else {
                next()
            }
        })

})
router.beforeEach((to, from, next) => {
    Store.dispatch('CHECK_AUTH')
        .then(user => {
            if (to.matched.some(route => !route.meta.authRequired)) {
                // if (Store.getnews_redactorters.isUserAuthenticated)
                if(user)
                {
                    Store.dispatch('SET_PAGE_MODULE', {
                        pageModule:''
                    })
                    Store.dispatch('CLEAN_BREAD_CUMP_MENU_LIST')
                    next('/')
                }
                else
                    next()
            } else {
                next()
            }
        })

})
// // первый способ проерки guard
// function AuthGuard(from,to,next) {
// if (Store.getters.isUserAuthenticated)
//     next()
//     else
//         next('login')
// }
export default router
