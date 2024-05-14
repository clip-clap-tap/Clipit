import { defineStore } from 'pinia';
import axios from 'axios';
import router from '@/router';
import { ref } from 'vue';
import { useCookies } from 'vue3-cookies';

const URL = `http://localhost:8080/users`;
axios.defaults.withCredentials = true;

export const useUserStore = defineStore('user', () => {
    const { cookies } = useCookies();

    const login = function (user) {
        axios({
            url: `${URL}/login`,
            method: 'POST',
            data: user
        }).then((res) => {
            cookies.set('token', res.data);
            cookies.set('user', JSON.parse(atob(res.data.split('.')[1]))['id']);
            router.push({ name: 'main' }).then(() => router.go(0));
        });
    };

    const duplicateCheck = function (id) {
        axios({
            url: `${URL}/${id}/info`,
            method: 'GET'
        }).then((res) => {
            if (res.status != 204) {
                alert('이미 가입된 아이디입니다.');
            }
        });
    };

    const register = function (user) {
        axios({
            url: `${URL}/signup`,
            method: 'POST',
            data: user
        }).then(() => {
            // loginUser.value = user;
            router.push({ name: 'profile' });
        });
    };

    const initialRegist = ref(true);
    const userProfile = ref({});

    const getProfile = function (id) {
        axios({
            url: `${URL}/profile/${id}`,
            method: 'GET'
        }).then((res) => {
            if (res.status != 204) {
                userProfile.value = res.data;
                initialRegist.value = false;
            }
        });
    };

    const saveProfile = function (id) {
        if (initialRegist.value === true) {
            axios({
                url: `${URL}/profile/${id}`,
                method: 'POST',
                data: userProfile
            }).then(() => {
                router.push({ name: 'main' });
                userProfile.value = {};
            });
        } else {
            axios({
                url: `${URL}/profile/${id}`,
                method: 'PUT',
                data: userProfile
            }).then(() => {
                router.push({ name: 'main' });
                userProfile.value = {};
            });
        }
    };

    return {
        login,
        duplicateCheck,
        register,

        userProfile,
        getProfile,
        saveProfile
    };
});
