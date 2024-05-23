<script setup>
import SearchComponent from '@/components/SearchComponent.vue';
import PostSummaryComponent from '@/components/util/post/PostSummaryComponent.vue';
import { usePostStore } from '@/stores/PostStore';
import { onBeforeUnmount, onMounted } from 'vue';
import { useRoute } from 'vue-router';

const store = usePostStore();
onMounted(async () => {
    const route = useRoute();
    await store.search(route.query);
});
onBeforeUnmount(() => {
    store.searchInfo = {};
});
</script>

<template>
    <div class="max-w-4xl w-full flex flex-col items-center gap-6">
        <SearchComponent />
        <div v-if="store.posts" class="flex flex-col gap-2 w-full max-w-4xl">
            <PostSummaryComponent
                v-for="post in store.posts"
                :key="`post_${post.id}`"
                :post="post"
            ></PostSummaryComponent>
        </div>
    </div>
</template>
