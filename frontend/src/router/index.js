import Vue from 'vue'
import VueRouter from 'vue-router'
import Room from '@/components/Room'
import Home from '@/components/Home'

Vue.use(VueRouter)
export default new VueRouter({
    routes: [
        {
            path: '/',
            name: 'Home',
            component: Home
        },
        {
            path: '/room',
            name: 'Room',
            component: Room
        }
    ]
})