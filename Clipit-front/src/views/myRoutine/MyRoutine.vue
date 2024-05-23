<script setup>
import { usePostStore } from '@/stores/PostStore';
import Button from 'primevue/button';
import { ref } from 'vue';
import { onMounted } from 'vue';

const store = usePostStore();

onMounted(() => {
    store.getUserPosts();
});

const getAll = () => {
    store.getUserPosts();
    current.value = 'all';
};

const getMine = () => {
    store.getMine();
    current.value = 'mine';
};

const getFav = () => {
    store.getFav();
    current.value = 'fav';
};

const current = ref('all');
</script>
<template>
    <div class="w-full flex flex-col items-center max-w-4xl gap-3">
        <div class="flex justify-between w-full px-4 items-center">
            <span class="text-xl font-bold">My Routines</span>
            <div class="grow"></div>
            <div class="flex mr-1 lg:mr-5">
                <Button
                    :class="`${current == 'all' ? 'underline' : ''} underline-offset-4`"
                    @click="getAll"
                    text
                    >All</Button
                >
                <Button
                    :class="`${current == 'mine' ? 'underline' : ''} underline-offset-4`"
                    @click="getMine"
                    text
                    >My</Button
                >
                <Button
                    :class="`${current == 'fav' ? 'underline' : ''} underline-offset-4`"
                    @click="getFav"
                    text
                    >Favorite</Button
                >
            </div>
            <RouterLink :to="{ name: `newPost` }">
                <Button class="break-keep" severity="info" outlined>추가</Button>
            </RouterLink>
        </div>

        <PostSummaryComponent
            v-for="post in store.userPosts"
            :key="post.id"
            :post="post"
        ></PostSummaryComponent>
    </div>
</template>
