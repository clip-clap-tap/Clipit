<template>
    <div @click="clickHandler" class="grid grid-cols-[auto_1fr] gap-3 w-full">
        <img :src="video.snippet.thumbnails.default.url" />
        <div class="truncate">
            {{ video.snippet.title }}
        </div>
    </div>
</template>
<script setup>
defineProps({
    video: Object,
    clickHandler: Function
});
</script>
