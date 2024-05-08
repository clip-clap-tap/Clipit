import { ref } from 'vue';
import { defineStore } from 'pinia';

export const useLayoutStore = defineStore('layout', () => {
    const isOpen = ref(false);
    const setIsOpen = () => {
        isOpen.value = !isOpen.value;
    };

    return { isOpen, setIsOpen };
});
