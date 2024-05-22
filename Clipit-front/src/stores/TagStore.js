import { defineStore } from 'pinia';
import { ref } from 'vue';
import axios from 'axios';
import router from '@/router';
import { useCookies } from 'vue3-cookies';

const URL = `http://localhost:8080/users`;

export const useTagStore = defineStore('tag', () => {
    const isEmpty = ref(true);

    const tags = ref([]);
    const { cookies } = useCookies();

    const getFavoriteTags = async function () {
        await axios({
            url: `${URL}/${cookies.get('user')}/tags`,
            method: 'GET'
        }).then((res) => {
            if (res.status != 204) {
                isEmpty.value = false;
                tags.value = res.data.map((d) => {
                    return { name: d.tagName };
                });
            }
        });
    };

    const addTag = async function () {
        await axios({
            url: `${URL}/${cookies.get('user')}/tags`,
            method: isEmpty.value === true ? 'POST' : 'PUT',
            data: tags.value
        });
    };

    return {
        tags,
        getFavoriteTags,
        addTag,
        isEmpty
    };
});
