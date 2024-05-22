<script setup>
import { usePostStore } from '@/stores/PostStore';
import Button from 'primevue/button';
import { onMounted } from 'vue';

const store = usePostStore();

onMounted(() => {
    store.getUserPosts();
});

const getAll = () => {
    store.getUserPosts();
};

const getMine = () => {
    store.getMine();
};

const getFav = () => {
    store.getFav();
};
</script>
<template>
    <div class="w-full flex flex-col items-center max-w-4xl gap-3">
        <div class="flex justify-between w-full px-4 items-center">
            <span class="text-xl font-bold">My Routines</span>
            <Button severity="info" outlined @click="getAll">전체</Button>
            <Button severity="info" outlined @click="getMine">내가 작성</Button>
            <Button severity="info" outlined @click="getFav">찜</Button>
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
