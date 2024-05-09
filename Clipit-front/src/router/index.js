import { createRouter, createWebHistory } from 'vue-router';
import TemplatePage from '@/views/TemplatePage.vue';
import TestPage from '@/views/TestPage.vue';
import MainPage from '@/views/MainPage.vue';
import LoginView from '@/views/LoginView.vue';
import SignUpView from '@/views/SignUpView.vue';
import ProfileView from '@/views/ProfileView.vue';

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        { path: '/', name: 'main', component: MainPage },
        { path: '/template', name: 'template', component: TemplatePage },
        { path: '/test', name: 'test', component: TestPage },
        { path: '/login', name: 'login', component: LoginView },
        { path: '/signup', name: 'signup', component: SignUpView },
        { path: '/profile', name: 'profile', component: ProfileView }
    ]
});

export default router;
