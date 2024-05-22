import axios from 'axios';
import { defineStore } from 'pinia';
import { useCookies } from 'vue3-cookies';

export const useUserDataStore = defineStore('userData', () => {
    const { cookies } = useCookies();

    const getUserExerciseHistory = async () => {
        const REST_URL = import.meta.env.VITE_REST_API_URL;
        const history = (
            await axios.get(`${REST_URL}/users/${cookies.get('user')}/exercise-history`)
        ).data;
        return history;
    };
    return { getUserExerciseHistory };
});
