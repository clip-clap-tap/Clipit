import { defineStore } from 'pinia';
import { ref } from 'vue';

export const useLayoutStore = defineStore('layout', () => {
    const isOpen = ref(false);
    const setIsOpen = (status = !isOpen.value) => {
        isOpen.value = !isOpen.value && !!status;
    };

    return { isOpen, setIsOpen };
});
