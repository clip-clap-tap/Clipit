<script setup>
import { onMounted } from 'vue';
import PostSummaryComponent from '../util/post/PostSummaryComponent.vue';
import { usePostStore } from '@/stores/PostStore';

const postStore = usePostStore();
onMounted(() => {
    postStore.getRecentVisitedPosts();
});
</script>
<template>
    <div class="w-full mt-4">
        <h2 class="text-xl font-bold">최근 방문한 루틴</h2>
        <PostSummaryComponent :post="post" v-for="post in postStore.posts" :key="post.id" />
    </div>
</template>
