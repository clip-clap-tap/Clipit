<script setup>
import SearchComponent from '../SearchComponent.vue';
</script>
<template>
    <header class="h-[28rem] bg-gray-50 w-screen">
        <div class="px-4 flex h-full py-6 items-center justify-center">
            <div class="flex items-center max-w-2xl flex-col w-full">
                <h2 class="text-7xl font-bold text-gray-800 uppercase">
                    <span class="title-word title-word-1 block text-center md:inline">Clip </span>
                    <span class="title-word title-word-2">Your </span>
                    <span class="title-word title-word-3">Fit</span>
                </h2>
                <SearchComponent />
            </div>
        </div>
    </header>
</template>
