<script setup>
import Chip from 'primevue/chip';
import { useRouter } from 'vue-router';
defineProps({
    post: Object
});
const router = useRouter();
</script>
<template>
    <button
        @click="router.push({ name: `postDetail`, params: { id: post.id } })"
        class="flex items-center gap-6 h-44 py-3 px-4 rounded hover:bg-slate-100 w-full"
    >
        <img
            v-if="post.videos.length > 0"
            class="object-cover object-center w-36 h-full rounded-lg"
            :src="`https://i.ytimg.com/vi/${post.videos[0].id}/default.jpg`"
            alt=""
        />
        <div class="flex flex-col h-full w-full">
            <div class="flex items-center justify-between mb-2">
                <div>
                    <span class="font-medium text-gray-700 dark:text-gray-300">
                        {{ post.writerId }}
                    </span>
                    <span class="text-sm text-gray-500 dark:text-gray-400 ml-2"
                        >| {{ post.createDate }}</span
                    >
                </div>

                <!-- <span class="text-sky-500 uppercase tracking-wider">{{ tag }}</span> -->
            </div>
            <h1 class="text-xl font-semibold text-gray-800 dark:text-white truncate text-left">
                {{ post.title }}
            </h1>
            <p class="mt-2 text-gray-500 dark:text-gray-400 text-left grow">
                {{ post.description }}
            </p>
            <Chip
                v-for="(tag, index) in post.tags"
                :key="index"
                class="text-sm bg-slate-100 w-fit"
                :label="tag"
            />
        </div>
    </button>
</template>
