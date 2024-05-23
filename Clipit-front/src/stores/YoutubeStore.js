import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

export const useYoutubeStore = defineStore('youtube', () => {
    const URL = 'https://www.googleapis.com/youtube/v3/search';
    const API_KEY = import.meta.env.VITE_YOUTUBE_API_KEY;
    const videos = ref([]);
    const selectedVideos = ref([]);
    const nextToken = ref('');

    const youtubeSearch = function (keyword) {
        if (keyword.length == 0) return false;

        axios({
            url: URL,
            method: 'GET',
            params: {
                key: API_KEY,
                part: 'snippet',
                maxResults: 10,
                q: keyword,
                type: 'video',
                pageToken: nextToken.value
            },
            withCredentials: false
        })
            .then((response) => {
                nextToken.value = response.data.nextPageToken;
                response.data.items.forEach((item) => videos.value.push(item));
                return true;
            })
            .catch(() => {});
    };

    const resetVideos = () => {
        videos.value = [];
    };

    return { youtubeSearch, videos, selectedVideos, resetVideos };
});
