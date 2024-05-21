import { createRouter, createWebHistory } from 'vue-router';
import TemplatePage from '@/views/TemplatePage.vue';
import SearchPage from '@/views/SearchPage.vue';
import MainPage from '@/views/MainPage.vue';
import MyPage from '@/views/MyPage.vue';
import MyRoutine from '@/views/myRoutine/MyRoutine.vue';
import NewPost from '@/views/myRoutine/NewPost.vue';
import PostDetailPage from '@/views/PostDetailPage.vue';
import LoginView from '@/views/LoginView.vue';
import SignUpView from '@/views/SignUpView.vue';
import ProfileView from '@/views/ProfileView.vue';
// import axios from 'axios';
// import { useUserStore } from '@/stores/UserStore';

const routes = [
    {
        path: '/',
        name: 'main',
        component: MainPage
        // beforeEnter: async () => {
        //     const userStore = useUserStore();
        //     try {
        //         const token = (await axios.get('http://localhost:8080/users/validate')).data;
        //         userStore.setUserData(token);
        //     } catch (error) {
        //         console.log('login needed');
        //     }
        // }
    },
    { path: '/template', name: 'template', component: TemplatePage },
    { path: '/search', name: 'search', component: SearchPage },
    { path: '/post/:id', name: 'postDetail', component: PostDetailPage },
    { path: '/myPage', name: 'myPage', component: MyPage },
    { path: '/login', name: 'login', component: LoginView },
    { path: '/signup', name: 'signup', component: SignUpView },
    { path: '/profile', name: 'profile', component: ProfileView },
    {
        path: '/myRoutine',
        name: 'myRoutine',
        component: MyRoutine
    },
    { path: '/new', name: 'newPost', component: NewPost },
    { path: '/post/modify/:id', name: 'postModify', component: NewPost }
];

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes,

    scrollBehavior(to) {
        if (to.hash) {
            return {
                el: to.hash,
                behavior: 'smooth'
            };
        }
    }
});

export default router;
