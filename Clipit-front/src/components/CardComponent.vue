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
    <div>
        <img class="object-cover object-center w-full h-64 rounded-lg lg:h-80" :src="img" alt="" />

        <div class="mt-8">
            <span class="text-sky-500 uppercase tracking-wider">{{ tag }}</span>

            <h1 class="mt-4 text-xl font-semibold text-gray-800 dark:text-white truncate">
                {{ title }}
            </h1>

            <p class="mt-2 text-gray-500 dark:text-gray-400">
                {{ description }}
            </p>

            <div class="flex items-center justify-between mt-4">
                <div>
                    <a
                        href="#"
                        class="text-lg font-medium text-gray-700 dark:text-gray-300 hover:underline hover:text-gray-500"
                    >
                        {{ writer }}
                    </a>

                    <p class="text-sm text-gray-500 dark:text-gray-400">{{ date }}</p>
                </div>

                <a href="#" class="inline-block text-sky-500 underline hover:text-sky-400"
                    >Read more</a
                >
            </div>
        </div>
    </div>
</template>
