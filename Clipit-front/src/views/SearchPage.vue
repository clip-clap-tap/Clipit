<script setup>
import PostSummaryComponent from '@/components/util/post/PostSummaryComponent.vue';
import { usePostStore } from '@/stores/PostStore';
import { onBeforeUnmount, onMounted } from 'vue';
import { useRoute } from 'vue-router';

const store = usePostStore();
onMounted(() => {
    const route = useRoute();
    store.search(route.query);
});
onBeforeUnmount(() => {
    store.searchInfo = {};
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
