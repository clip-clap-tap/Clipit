import { defineStore } from 'pinia';
import { ref } from 'vue';

export const useLayoutStore = defineStore('layout', () => {
    const isOpen = ref(false);
    const setIsOpen = () => {
        isOpen.value = !isOpen.value;
    };

    return { isOpen, setIsOpen };
});
