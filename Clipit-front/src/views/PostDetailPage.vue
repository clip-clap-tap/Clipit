<script setup>
import CommentSection from '@/components/section/CommentSection.vue';
import { usePostStore } from '@/stores/PostStore';
import axios from 'axios';
import { ref } from 'vue';
import { onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { useCookies } from 'vue3-cookies';

const store = usePostStore();
const route = useRoute();
const router = useRouter();
const { cookies } = useCookies();
const user = ref(cookies.get('user'));

onMounted(async () => {
    const REST_URL = import.meta.env.VITE_REST_API_URL;
    await store.getPostDetail(route.params.id);
    clipped.value = (await axios.get(`${REST_URL}/posts/${route.params.id}/favorite`)).data;
});

const clipped = ref(false);

const handleClip = async () => {
    const REST_URL = import.meta.env.VITE_REST_API_URL;
    clipped.value
        ? await axios.delete(`${REST_URL}/posts/${route.params.id}/favorite`)
        : await axios.put(`${REST_URL}/posts/${route.params.id}/favorite`);

    clipped.value = !clipped.value;
};

const modifyPost = function () {
    router.push({ name: 'postModify', params: { id: route.params.id } });
};

const removePost = async () => {
    await store.disablePost(route.params.id);
    router.push({ name: 'myRoutine' }).then(() => router.go(0));
};
</script>

<template>
    <div class="w-full max-w-4xl px-4">
        <div class="w-full p-3 relative">
            <button
                @click="handleClip"
                style="transform: rotateY(180deg)"
                class="py-1 px-2 absolute -left-3 top-4"
                v-if="store.post.writerId != user"
            >
                <i
                    :class="`pi pi-paperclip ${clipped ? 'rotate-[-45deg] text-slate-600 translate-y-2' : 'rotate-[-55deg] text-slate-300'} text-3xl ease-in-out hover:translate-y-2 hover:rotate-[-45deg] hover:text-slate-600`"
                ></i>
            </button>
            <h1 class="text-3xl font-bold py-2 lg:py-4 pl-4">{{ store.post.title }}</h1>
            <div class="flex mb-4 items-center">
                <TagComponent
                    :name="tag"
                    class="text-black"
                    v-for="tag in store.post.tags"
                    :key="`tag_${tag.id}`"
                >
                </TagComponent>
                <div class="grow"></div>
                <div>
                    <Button
                        v-if="store.post.writerId == user"
                        text
                        severity="info"
                        label="수정"
                        @click="modifyPost"
                    />
                    <Button
                        v-if="store.post.writerId == user"
                        text
                        severity="danger"
                        label="삭제"
                        @click="removePost"
                    />
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
        <div class="md:flex flex-col gap-1 hidden fixed right-10 top-48 py-2">
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
