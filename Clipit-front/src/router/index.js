import { createRouter, createWebHistory } from 'vue-router';
import TemplatePage from '@/views/TemplatePage.vue';
import TestPage from '@/views/TestPage.vue';
import MainPage from '@/views/MainPage.vue';
import MyPage from '@/views/MyPage.vue';
import MyRoutine from '@/views/myRoutine/MyRoutine.vue';
import NewPost from '@/views/myRoutine/NewPost.vue';

const routes = [
    { path: '/', name: 'main', component: MainPage },
    { path: '/template', name: 'template', component: TemplatePage },
    { path: '/test', name: 'test', component: TestPage },
    { path: '/myPage', name: 'myPage', component: MyPage },
    {
        path: '/myRoutine',
        name: 'myRoutine',
        component: MyRoutine
    },
    { path: '/new', name: 'newPost', component: NewPost },
    {
        path: '/tag',
        name: 'tagPage',
        component: TestPage,
        children: [
            {
                path: '/:name',
                name: 'tagSearch',
                component: TestPage
            }
        ]
    }
];

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes
});

export default router;
