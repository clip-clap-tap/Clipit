<script setup>
import NewRoutineComponent from '@/components/myRoutine/NewRoutineComponent.vue';
import { useYoutubeStore } from '@/stores/YoutubeStore';
import { useRouter } from 'vue-router';

const store = useYoutubeStore();
const router = useRouter();
const handleSave = () => {
    store.savePost();
    store.resetVideos();
    router.push({ name: 'myRoutine' });
};
</script>
<template>
    <div>
        <InputText v-model="store.post.title" class="w-full" placeholder="title"></InputText>
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
        <Button @click="handleSave">저장</Button>
        <Textarea v-model="store.post.description"></Textarea>
        <!-- <div>{{ store.videos }}</div> -->
    </div>
</template>
