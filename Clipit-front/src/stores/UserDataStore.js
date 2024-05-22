import axios from 'axios';
import { defineStore } from 'pinia';
import { ref } from 'vue';
import { useCookies } from 'vue3-cookies';

export const useUserDataStore = defineStore('userData', () => {
    const { cookies } = useCookies();
    const inRowCount = ref(0);

    const getUserExerciseHistory = async () => {
        const REST_URL = import.meta.env.VITE_REST_API_URL;
        const history = (
            await axios.get(`${REST_URL}/users/${cookies.get('user')}/exercise-history`)
        ).data;
        inRowCount.value = history.findIndex((v) => v == 0);
        return history;
    };

    const getUserExerciseStatistics = async () => {
        const REST_URL = import.meta.env.VITE_REST_API_URL;
        const stData = (
            await axios.get(`${REST_URL}/users/${cookies.get('user')}/exercise-statistics`)
        ).data;

        return stData;
    };

    const getUserPostStatistics = async () => {
        const REST_URL = import.meta.env.VITE_REST_API_URL;
        const stData = (await axios.get(`${REST_URL}/users/${cookies.get('user')}/post-statistics`))
            .data;

        return stData;
    };

    return { getUserExerciseHistory, inRowCount, getUserExerciseStatistics, getUserPostStatistics };
});
