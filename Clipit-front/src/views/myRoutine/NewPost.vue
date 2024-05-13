<script setup>
import NewRoutineComponent from '@/components/myRoutine/NewRoutineComponent.vue';
import { useYoutubeStore } from '@/stores/YoutubeStore';

const store = useYoutubeStore();
</script>
<template>
    <div>
        <InputText class="w-full" placeholder="title"></InputText>
        <div>
            <VideoInfoComponent
                v-for="video in store.selectedVideos"
                :key="`selected_${video.id.video_id}`"
                :video="video"
            />
            <!-- <div v-for="video in selectedVideos" :key="`selected_${video.id.video_id}`">
                    {{ video.snippet.title }}
                </div> -->
        </div>
        <NewRoutineComponent></NewRoutineComponent>
        <!-- <div>{{ store.videos }}</div> -->
    </div>
</template>
