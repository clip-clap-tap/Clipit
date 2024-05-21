<script setup>
import PostCardSectionComponent from '@/components/util/post/PostCardSectionComponent.vue';
import { usePostStore } from '@/stores/PostStore';

import { onMounted } from 'vue';

const postStore = usePostStore();

onMounted(async () => {
    await postStore.getRecentPosts();
    await postStore.getPopularPosts();
});
</script>
<template>
    <HeaderComponent></HeaderComponent>

    <div class="container">
        <PostCardSectionComponent :title="`최근 루틴`" :posts="postStore.recentPosts" />
        <PostCardSectionComponent :title="`인기 루틴`" :posts="postStore.popularPosts" />
        <!-- <PostCardSectionComponent :title="`Podcasts`" :items="[1, 2, 3]"></PostCardSectionComponent> -->
    </div>
</template>
