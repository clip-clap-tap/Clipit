import './assets/input.css';
import 'primevue/resources/themes/aura-light-noir/theme.css';
import 'primeicons/primeicons.css';

import { createApp } from 'vue';
import { createPinia } from 'pinia';
import PrimeVue from 'primevue/config';

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

app.mount('#app');

const layoutStore = useLayoutStore();
router.beforeEach(() => {
    layoutStore.setIsOpen(false);
});
