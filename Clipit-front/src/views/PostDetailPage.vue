<script setup>
import CommentSection from '@/components/section/CommentSection.vue';
import { usePostStore } from '@/stores/PostStore';
import { onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const store = usePostStore();
const route = useRoute();
const router = useRouter();

onMounted(() => {
    store.getPostDetail(route.params.id);
});

const removePost = async () => {
    await store.disablePost(route.params.id);
    router.push({ name: 'myRoutine' }).then(() => router.go(0));
};
</script>

<template>
    <div class="w-full max-w-4xl">
        <div class="w-full">
            <h1 class="text-3xl font-bold py-4">{{ store.post.title }}</h1>
            <div class="flex mb-4 items-center">
                <TagComponent
                    :name="tag.name"
                    class="text-black"
                    v-for="tag in store.post.tags"
                    :key="`tag_${tag.id}`"
                >
                </TagComponent>
                <div class="grow"></div>
                <div>
                    <Button text severity="info" label="수정" />
                    <Button text severity="danger" label="삭제" @click="removePost" />
                </div>
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
        <div class="flex flex-col gap-1 fixed right-10 top-48 py-2">
            <RouterLink
                class="truncate w-48 text-slate-400 hover:text-black rounded p-3"
                v-for="video in store.post.videos"
                :key="video.id"
                :to="{ name: 'postDetail', hash: `#${video.index}` }"
                >{{ video.title }}</RouterLink
            >
        </div>
    </div>
</template>
