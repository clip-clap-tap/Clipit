import { defineStore } from 'pinia';
import axios from 'axios';
import router from '@/router';
import { ref } from 'vue';

const URL = `http://localhost:8080/users`;

export const useUserStore = defineStore('user', () => {
    const initialRegist = ref(true);

    const login = function (user) {
        axios({
            url: `${URL}/login`,
            method: 'POST',
            data: user
        }).then(() => {
            router.push({ name: 'main' });
        });
    };

    const loginUser = ref({});

    const register = function (user) {
        axios({
            url: `${URL}/signup`,
            method: 'POST',
            data: user
        }).then(() => {
            loginUser.value = user;
            router.push({ name: 'profile' });
        });
    };

    const userProfile = ref({});

    const getProfile = function (id) {
        axios({
            url: `${URL}/profile/${id}`,
            method: 'GET'
        }).then((res) => {
            userProfile.value = res.data;
            initialRegist.value = false;
        });
    };

    const saveProfile = function (id) {
        if (initialRegist.value === true)
            axios({
                url: `${URL}/profile/${id}`,
                method: 'POST',
                data: userProfile
            }).then(() => {
                router.push({ name: 'profile' });
            });
    };

    return {
        login,
        register,
        loginUser,
        userProfile,
        getProfile,
        saveProfile
    };
});
