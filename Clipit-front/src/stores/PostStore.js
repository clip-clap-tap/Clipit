import axios from 'axios';
import { defineStore } from 'pinia';
import { ref } from 'vue';

export const usePostStore = defineStore('post', () => {
    const posts = ref([]);
    const getPosts = async () => {
        const REST_URL = import.meta.env.VITE_REST_API_URL;
        posts.value = (await axios.get(`${REST_URL}/posts`)).data;
    };

    return { getPosts, posts };
});
