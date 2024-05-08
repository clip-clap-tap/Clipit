<script setup>
import Chip from 'primevue/chip';
defineProps({
    img: String,
    tag: String,
    title: String,
    description: String,
    writer: String,
    date: String
});
</script>
<template>
    <button class="flex items-center gap-6 h-44 py-3 px-4 rounded hover:bg-slate-100">
        <img class="object-cover object-center w-36 h-full rounded-lg" :src="img" alt="" />
        <div class="flex flex-col h-full">
            <div class="flex items-center justify-between mb-2">
                <div>
                    <RouterLink
                        :to="`#`"
                        class="font-medium text-gray-700 dark:text-gray-300 hover:underline hover:text-gray-500"
                    >
                        {{ writer }}
                    </RouterLink>
                    <span class="text-sm text-gray-500 dark:text-gray-400 ml-2">| {{ date }}</span>
                </div>

                <!-- <span class="text-sky-500 uppercase tracking-wider">{{ tag }}</span> -->
            </div>
            <h1 class="text-xl font-semibold text-gray-800 dark:text-white truncate text-left">
                {{ title }}
            </h1>
            <p class="mt-2 text-gray-500 dark:text-gray-400 text-left grow">
                {{ description }}
            </p>
            <Chip class="text-sm bg-slate-100 w-fit" :label="tag" />
        </div>
    </button>
</template>
