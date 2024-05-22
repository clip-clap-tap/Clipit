import axios from 'axios';
import { defineStore } from 'pinia';
import { ref } from 'vue';

export const useCommentStore = defineStore('comment', () => {
    const comments = ref([]);
    const comment = ref('');

    const getComments = async (id) => {
        const REST_URL = import.meta.env.VITE_REST_API_URL;
        comments.value = (await axios.get(`${REST_URL}/posts/${id}/comments`)).data;
    };

    const saveComment = async (id) => {
        const REST_URL = import.meta.env.VITE_REST_API_URL;
        await axios.post(`${REST_URL}/posts/${id}/comment`, { content: comment.value });
        await getComments(id);
        comment.value = '';
    };

    const deleteComment = async (postId, commentId) => {
        const REST_URL = import.meta.env.VITE_REST_API_URL;
        await axios.delete(`${REST_URL}/posts/comment/${commentId}`);
        await getComments(postId);
    };
    return { comments, getComments, comment, saveComment, deleteComment };
});
