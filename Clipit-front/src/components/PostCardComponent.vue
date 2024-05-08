<script setup>
defineProps({
    img: String,
    tag: String,
    title: String,
    description: String,
    writer: String,
    date: String
})
</script>
<template>
    <button class="flex items-center gap-4 h-40 py-2">
        <img class="object-cover object-center w-32 h-full rounded-lg" :src="img" alt="" />
        <div>
            <div class="flex items-center justify-between">
                <div>
                    <RouterLink
                        :to="`#`"
                        class="font-medium text-gray-700 dark:text-gray-300 hover:underline hover:text-gray-500"
                    >
                        {{ writer }}
                    </RouterLink>

                    <span class="text-sm text-gray-500 dark:text-gray-400 ml-2">| {{ date }}</span>
                </div>

                <span class="text-sky-500 uppercase tracking-wider">{{ tag }}</span>
            </div>
            <h1 class="mt-1 text-xl font-semibold text-gray-800 dark:text-white truncate text-left">
                {{ title }}
            </h1>
            <p class="mt-2 text-gray-500 dark:text-gray-400 text-left">
                {{ description }}
            </p>
        </div>
    </button>
</template>
