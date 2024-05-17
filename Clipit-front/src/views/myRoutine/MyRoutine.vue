<script setup>
import { usePostStore } from '@/stores/PostStore';
import Button from 'primevue/button';
import { onMounted } from 'vue';

const store = usePostStore();

onMounted(() => {
    store.getUserPosts();
});
</script>
<template>
    <div class="w-full flex flex-col items-center max-w-4xl gap-3">
        <div class="flex justify-between w-full px-4 items-center">
            <span class="text-xl font-bold">my routines</span>
            <RouterLink :to="{ name: `newPost` }">
                <Button severity="info" outlined>추가</Button>
            </RouterLink>
        </div>

        <PostSummaryComponent
            v-for="post in store.userPosts"
            :key="post.id"
            :post="post"
        ></PostSummaryComponent>
    </div>
</template>
