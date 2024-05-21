<script setup>
import PostCardSectionComponent from '@/components/util/post/PostCardSectionComponent.vue';
import { usePostStore } from '@/stores/PostStore';
import { onMounted } from 'vue';

const postStore = usePostStore();
onMounted(() => {
    postStore.getRecentPosts();
    postStore.getPopularPosts();
    console.log(postStore.recentPosts);
    console.log(postStore.popularPosts);
});
</script>
<template>
    <HeaderComponent></HeaderComponent>

    <div class="container">
        <PostCardSectionComponent
            :title="`최근 루틴`"
            :type="`recent`"
            :posts="postStore.recentPosts"
        />
        <PostCardSectionComponent
            :title="`인기 루틴`"
            :type="`popular`"
            :posts="postStore.popularPosts"
        />
        <!-- <PostCardSectionComponent :title="`Podcasts`" :items="[1, 2, 3]"></PostCardSectionComponent> -->
    </div>
</template>
