import axios from 'axios';
import { defineStore } from 'pinia';
import { ref } from 'vue';
import { useCookies } from 'vue3-cookies';
import qs from 'qs';

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

    const getRecentPosts = async () => {
        const REST_URL = import.meta.env.VITE_REST_API_URL;
        posts.value = (await axios.get(`${REST_URL}/posts/recent`)).data;
    };

    const searchInfo = ref({
        category: null,
        keyword: '',
        ageRange: [],
        bodyParts: [],
        strength: 0
    });

    const search = async (searchQuery) => {
        const REST_URL = import.meta.env.VITE_REST_API_URL;
        axios.defaults.paramsSerializer = (params) => qs.stringify(params);
        posts.value = (
            await axios.get(`${REST_URL}/posts/search`, {
                params: {
                    ...searchQuery
                }
            })
        ).data;
    };

    return {
        getPosts,
        posts,
        userPosts,
        getUserPosts,
        post,
        getPostDetail,
        search,
        searchInfo,
        getRecentPosts
    };
});
