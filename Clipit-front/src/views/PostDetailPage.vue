<script setup>
import { usePostStore } from '@/stores/PostStore';
import { onMounted } from 'vue';
import { useRoute } from 'vue-router';

const store = usePostStore();
const route = useRoute();
const embedURL = import.meta.env.VITE_EMBED_URL;
onMounted(() => {
    store.getPostDetail(route.params.id);
});
</script>

<template>
    <div>
        <h1 class="text-2xl font-bold">{{ store.post.title }}</h1>
        <div>
            <div v-for="video in store.post.videos" :key="video.id">
                <iframe :src="`${embedURL}/${video.id}`"></iframe>
            </div>
        </div>
        <div>{{ store.post.description }}</div>
    </div>
</template>
