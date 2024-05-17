import axios from 'axios';
import { defineStore } from 'pinia';
import { ref } from 'vue';
import { useCookies } from 'vue3-cookies';
export const usePostStore = defineStore('post', () => {
    const posts = ref([]);
    const getPosts = async () => {
        const REST_URL = import.meta.env.VITE_REST_API_URL;
        posts.value = (await axios.get(`${REST_URL}/posts`)).data;
    };

    const userPosts = ref([]);
    const getUserPosts = async () => {
        const REST_URL = import.meta.env.VITE_REST_API_URL;
        const { cookies } = useCookies();
        userPosts.value = (
            await axios.get(`${REST_URL}/users/${cookies.get('user')}/all-posts`)
        ).data;
    };

    const post = ref({});
    const getPostDetail = async (id) => {
        const REST_URL = import.meta.env.VITE_REST_API_URL;
        post.value = (await axios.get(`${REST_URL}/posts/${id}`)).data;
    };

    return { getPosts, posts, userPosts, getUserPosts, post, getPostDetail };
});
