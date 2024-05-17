<script setup>
import CommentSection from '@/components/section/CommentSection.vue';
import { usePostStore } from '@/stores/PostStore';
import { onMounted } from 'vue';
import { useRoute } from 'vue-router';

const store = usePostStore();
const route = useRoute();

onMounted(() => {
    store.getPostDetail(route.params.id);
});
</script>

<template>
    <div class="w-full max-w-4xl">
        <div class="w-full">
            <h1 class="text-3xl font-bold py-4">{{ store.post.title }}</h1>
            <div class="flex mb-4">
                <TagComponent
                    :name="tag.name"
                    class="text-black"
                    v-for="tag in store.post.tags"
                    :key="`tag_${tag.id}`"
                >
                </TagComponent>
            </div>
            <div class="flex flex-col gap-4">
                <VideoComponent
                    :id="video.index"
                    :video="video"
                    v-for="video in store.post.videos"
                    :key="video.id"
                />
            </div>
            <div class="p-4 my-6">{{ store.post.description }}</div>
            <hr />
            <CommentSection></CommentSection>
        </div>
        <div class="flex flex-col gap-1 fixed right-10 top-36 py-2">
            <RouterLink
                class="truncate w-48 hover:bg-slate-100 rounded p-3"
                v-for="video in store.post.videos"
                :key="video.id"
                :to="{ name: 'postDetail', hash: `#${video.index}` }"
                >{{ video.title }}</RouterLink
            >
        </div>
    </div>
</template>
