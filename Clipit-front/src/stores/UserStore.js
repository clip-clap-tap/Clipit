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
            setUserData(res.data).then(() =>
                router.push({ name: 'main' }).then(() => router.go(0))
            );
        });
    };

    const setUserData = async (token) => {
        const id = JSON.parse(atob(token.split('.')[1]))['id'];
        const user = (await axios.get(`${URL}/${id}/info`)).data;
        cookies.set('user', id);
        localStorage.setItem('username', user.username);
    };

    const logout = async () => {
        const REST_URL = import.meta.env.VITE_REST_API_URL;
        await axios.post(`${REST_URL}/users/logout`);
        cookies.remove('user');
        localStorage.removeItem('username');
        router.push({ name: 'main' }).then(() => router.go(0));
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
        }).then((res) => {
            setUserData(res.data).then(() =>
                router.push({ name: 'profile' }).then(() => router.go(0))
            );
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

    const saveProfile = function (id, profile) {
        if (initialRegist.value === true) {
            axios({
                url: `${URL}/profile/${id}`,
                method: 'POST',
                data: profile
            }).then(() => {
                router.push({ name: 'main' });
                userProfile.value = {};
            });
        } else {
            axios({
                url: `${URL}/profile/${id}`,
                method: 'PUT',
                data: profile
            }).then(() => {
                router.push({ name: 'main' });
                userProfile.value = {};
            });
        }
    };

    const validate = async () => {
        const REST_URL = import.meta.env.VITE_REST_API_URL;
        try {
            const token = (await axios.get(`${REST_URL}/users/validate`)).data;
            await setUserData(token);
        } catch {
            return false;
        }
        return true;
    };

    return {
        login,
        duplicateCheck,
        register,
        logout,
        userProfile,
        getProfile,
        saveProfile,
        validate,
        setUserData
    };
});
