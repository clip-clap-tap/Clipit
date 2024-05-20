import { defineStore } from 'pinia';
import { ref } from 'vue';

export const useTagStore = defineStore('tag', () => {
    const tags = ref([]);
    return { tags };
});
