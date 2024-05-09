import { createRouter, createWebHistory } from 'vue-router';
import TemplatePage from '@/views/TemplatePage.vue';
import TestPage from '@/views/TestPage.vue';
import MainPage from '@/views/MainPage.vue';
import MyPage from '@/views/MyPage.vue';

const routes = [
    { path: '/', name: 'main', component: MainPage },
    { path: '/template', name: 'template', component: TemplatePage },
    { path: '/test', name: 'test', component: TestPage },
    { path: '/myPage', name: 'myPage', component: MyPage }
];

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes
});

export default router;
