<script setup>
defineProps({
    post: Object
});
</script>
<template>
    <RouterLink :to="{ name: 'postDetail', params: { id: post.id } }">
        <img
            class="object-cover object-center w-full h-64 rounded-lg lg:h-80"
            :src="post.videos ? `https://i.ytimg.com/vi/${post.videos[0].id}/hqdefault.jpg` : ''"
            alt=""
        />

        <div class="mt-8">
            <!-- <span class="text-sky-500 uppercase tracking-wider">{{ tag }}</span> -->

            <h1 class="mt-4 text-xl font-semibold text-gray-800 dark:text-white truncate">
                {{ post.title }}
            </h1>

            <p class="mt-2 text-gray-500 dark:text-gray-400 line-clamp-3 text-ellipsis">
                {{ post.description }}
            </p>

            <div class="flex items-center justify-between mt-4">
                <div class="text-lg font-medium text-gray-700">
                    <span>{{ post.writerName }}</span>

                    <p class="text-sm text-gray-500 dark:text-gray-400">{{ post.createDate }}</p>
                </div>
            </div>
        </div>
    </RouterLink>
</template>
