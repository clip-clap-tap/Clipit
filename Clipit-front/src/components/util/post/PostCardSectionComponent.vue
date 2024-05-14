<script setup>
import PostCardComponent from './PostCardComponent.vue';
defineProps({
    title: String,
    items: Array
});
</script>
<template>
    <section class="container px-4 py-16">
        <div class="flex items-center justify-between">
            <h2 class="text-gray-800 font-bold text-3xl">{{ title }}</h2>

            <button
                class="flex items-center px-4 py-2.5 font-medium tracking-wide text-sky-500 capitalize transition-colors duration-300 transform border border-sky-500 rounded-lg hover:bg-sky-50 focus:outline-none focus:ring focus:ring-sky-300 focus:ring-opacity-80"
            >
                <span class="mx-1">Explore All</span>

                <svg
                    xmlns="http://www.w3.org/2000/svg"
                    fill="none"
                    viewBox="0 0 24 24"
                    stroke-width="1.5"
                    stroke="currentColor"
                    class="w-6 mx-1 h-6"
                >
                    <path
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        d="M17.25 8.25L21 12m0 0l-3.75 3.75M21 12H3"
                    />
                </svg>
            </button>
        </div>

        <div class="grid grid-cols-1 gap-8 md:grid-cols-2 mt-12 xl:grid-cols-3">
            <PostCardComponent
                v-for="(item, index) in items"
                :key="index"
                :img="`https://images.unsplash.com/photo-1624996379697-f01d168b1a52?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80`"
                :tag="`Article`"
                :title="`What do you want to know about UI`"
                :description="`Lorem ipsum dolor sit amet consectetur adipisicing elit. Nam est asperiores vel, ab animi recusandae nulla veritatis id tempore sapiente`"
                :writer="`John snow`"
                :date="`February 1, 2022`"
            ></PostCardComponent>
        </div>
    </section>
</template>
