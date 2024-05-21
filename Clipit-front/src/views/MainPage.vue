<script setup>
import PostCardSectionComponent from '@/components/util/post/PostCardSectionComponent.vue';
import { usePostStore } from '@/stores/PostStore';
import { onMounted } from 'vue';

const postStore = usePostStore();
onMounted(() => {
    postStore.getRecentPosts();
});
</script>
<template>
    <HeaderComponent></HeaderComponent>

    <div class="container">
        <PostCardSectionComponent :title="`최근 포스트`" />
        <!-- <PostCardSectionComponent :title="`Podcasts`" :items="[1, 2, 3]"></PostCardSectionComponent> -->
    </div>
</template>
