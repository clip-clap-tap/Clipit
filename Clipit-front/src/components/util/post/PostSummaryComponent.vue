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
            :src="`https://i.ytimg.com/vi/${post.videos[0].id}/hqdefault.jpg`"
            alt=""
        />
        <div class="flex flex-col h-full w-full">
            <h1
                class="my-1 text-xl font-semibold text-gray-800 dark:text-white line-clamp-1 text-ellipsis text-left shrink-0"
            >
                {{ post.title }}
            </h1>
            <div class="flex items-center">
                <span class="font-medium text-sm text-gray-700 dark:text-gray-300">
                    {{ post.writerName }}
                </span>
                <span class="text-sm text-gray-500 dark:text-gray-400 ml-2"
                    >| {{ post.createDate }}</span
                >

                <!-- <span class="text-sky-500 uppercase tracking-wider">{{ tag }}</span> -->
            </div>

            <p class="mt-1 text-gray-500 dark:text-gray-400 text-left line-clamp-2 text-ellipsis">
                {{ post.description }}
            </p>
            <div class="grow"></div>
            <div class="flex gap-2 flex-nowrap max-w-[45vw] overflow-clip md:w-full">
                <Chip
                    v-for="(tag, index) in post.tags"
                    :key="index"
                    class="text-sm bg-slate-100 w-fit break-keep"
                    :label="tag.name"
                />
            </div>
        </div>
    </button>
</template>
