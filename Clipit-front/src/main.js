import './assets/input.css';
import './assets/themes/mytheme/theme.scss';
import 'primeicons/primeicons.css';
import 'v3-infinite-loading/lib/style.css';

import { createApp } from 'vue';
import { createPinia } from 'pinia';
import PrimeVue from 'primevue/config';
import InfiniteLoading from 'v3-infinite-loading';

import NavbarComponent from '@/components/Layout/NavbarComponent.vue';
import FooterComponent from '@/components/Layout/FooterComponent.vue';

import App from './App.vue';
import router from './router';
import { useLayoutStore } from './stores/LayoutStore';

const app = createApp(App);

app.use(createPinia());
app.use(router);
app.use(PrimeVue);

app.component('NavbarComponent', NavbarComponent);
app.component('FooterComponent', FooterComponent);
app.component('infinite-loading', InfiniteLoading);

app.mount('#app');

const layoutStore = useLayoutStore();
router.beforeEach(() => {
    layoutStore.setIsOpen(false);
});
