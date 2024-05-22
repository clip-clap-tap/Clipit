import { defineStore } from 'pinia';
import { ref } from 'vue';
import axios from 'axios';
import router from '@/router';

const URL = `http://localhost:8080/users`;

export const useTagStore = defineStore('tag', () => {
    const isEmpty = ref(true);

    const tags = ref([]);

    const getFavoriteTags = async function (id) {
        await axios({
            url: `${URL}/${id}/tags`,
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

    const addTag = async function (id) {
        if (isEmpty.value === true) {
            await axios({
                url: `${URL}/${id}/tags`,
                method: 'POST',
                data: tags.value
            }).then(() => {
                router.push({ name: 'myPage' });
            });
        } else {
            await axios({
                url: `${URL}/${id}/tags`,
                method: 'PUT',
                data: tags.value
            }).then(() => {
                router.push({ name: 'myPage' });
            });
        }
    };

    return {
        tags,
        getFavoriteTags,
        addTag,
        isEmpty
    };
});
