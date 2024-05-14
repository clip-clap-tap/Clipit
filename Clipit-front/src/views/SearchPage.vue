<script setup>
import PostSummaryComponent from '@/components/util/post/PostSummaryComponent.vue';
import { usePostStore } from '@/stores/PostStore';
import { onMounted } from 'vue';

const store = usePostStore();
onMounted(() => {
    store.getPosts();
});
</script>

<template>
    <div v-if="store.posts" class="flex flex-col gap-2 max-w-5xl w-full">
        <PostSummaryComponent
            v-for="post in store.posts"
            :key="`post_${post.id}`"
            :post="post"
        ></PostSummaryComponent>
    </div>
</template>
