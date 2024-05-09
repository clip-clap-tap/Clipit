import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';
import router from '@/router';

const URL = `http://localhost:8080`;

export const useUserStore = defineStore('user', () => {
    const isOpen = ref(false);
    const setIsOpen = () => {
        isOpen.value = !isOpen.value;
    };

    const login = function (user) {
        axios({
            url: `${URL}/users/login`,
            method: 'POST',
            data: user
        }).then(() => {
            router.push({ name: 'main' });
        });
    };

    const register = function (user) {
        axios({
            url: `${URL}/users/signup`,
            method: 'POST',
            data: user
        }).then(() => {
            router.push({ name: 'profile' });
        });
    };

    return {
        isOpen,
        setIsOpen,
        login,
        register
    };
});
