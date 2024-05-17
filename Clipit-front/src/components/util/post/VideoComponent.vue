<script setup>
const embedURL = import.meta.env.VITE_EMBED_URL;
defineProps({
    video: Object
});
</script>

<template>
    <div class="bg-slate-100 p-6 rounded">
        <iframe class="w-full aspect-video" :src="`${embedURL}/${video.id}`"></iframe>
    </div>
</template>
