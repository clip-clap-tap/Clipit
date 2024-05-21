import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

export const useYoutubeStore = defineStore('youtube', () => {
    const URL = 'https://www.googleapis.com/youtube/v3/search';
    const API_KEY = import.meta.env.VITE_YOUTUBE_API_KEY;
    const videos = ref([]);
    const selectedVideos = ref([]);
    const nextToken = ref('');
    const post = ref({ title: '', desc: '' });
    const ages = ref([40]);
    const bodyParts = ref(['leg']);
    const strength = ref(0);
    const selectedTags = ref([{ name: 'new' }, { name: 'good' }]);

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

    const savePost = async () => {
        const YOUTUBE_URL = 'https://www.youtube.com/';
        const REST_URL = import.meta.env.VITE_REST_API_URL;
        console.log(strength.value);
        await axios.post(`${REST_URL}/posts`, {
            ...post.value,
            tags: selectedTags.value,
            videos: selectedVideos.value.map((video, i) => {
                return {
                    id: video.id.videoId,
                    title: video.snippet.title,
                    url: `${YOUTUBE_URL}/watch?v=${video.id.videoId}`,
                    index: i
                };
            }),
            ageRange: ages.value,
            bodyPart: bodyParts.value,
            strength: strength.value
        });
    };
    return { youtubeSearch, videos, selectedVideos, resetVideos, savePost, post };
});
