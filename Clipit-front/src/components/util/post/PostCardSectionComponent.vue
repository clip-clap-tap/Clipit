<script setup>
import { onMounted } from 'vue';

import { usePostStore } from '@/stores/PostStore';

const postStore = usePostStore();
onMounted(async () => {
    await postStore.getRecentPosts();
});

defineProps({
    title: String
});
</script>
<template>
    <section class="container px-4 py-16">
        <div class="flex items-center justify-between">
            <h2 class="text-gray-800 font-bold text-3xl">{{ title }}</h2>
        </div>

        <div class="grid grid-cols-1 gap-8 md:grid-cols-2 mt-12 xl:grid-cols-3">
            <PostCardComponent
                v-for="item in postStore.posts"
                :post="item"
                :key="item.id"
            ></PostCardComponent>
        </div>
    </section>
</template>
