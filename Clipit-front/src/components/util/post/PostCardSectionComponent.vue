<script setup>
defineProps({
    title: String,
    posts: Array
});
</script>
<template>
    <section class="container px-4 py-16 items-center flex flex-col">
        <div class="flex items-center w-full max-w-5xl">
            <h2 class="text-gray-800 font-bold text-3xl">{{ title }}</h2>
        </div>

        <div class="grid grid-cols-1 gap-8 md:grid-cols-2 mt-12 max-w-5xl w-full">
            <PostCardComponent
                v-for="item in posts"
                :post="item"
                :key="item.id"
            ></PostCardComponent>
        </div>
    </section>
</template>
