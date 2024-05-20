<script setup>
import Button from 'primevue/button';
import { ref } from 'vue';
import { useYoutubeStore } from '@/stores/YoutubeStore';
import InfiniteLoading from 'v3-infinite-loading';

const isOpen = ref(false);
const setIsOpen = () => {
    isOpen.value = !isOpen.value;
};

const store = useYoutubeStore();
const searchValue = ref('');

const removeVideo = (index) => {
    store.selectedVideos.splice(index, 1);
};

const handleClose = () => {
    setIsOpen();
    searchValue.value = '';
    store.resetVideos();
};

const handleSearch = () => {
    store.resetVideos();
    store.youtubeSearch(searchValue.value);
};

const handleSave = () => {
    handleClose();
};
</script>
<template>
    <div>
        <Button severity="success" text @click="setIsOpen">편집</Button>

        <ModalComponent :visible="isOpen">
            <template #content>
                <div class="w-[85vw] h-[70vh] grid grid-cols-[20rem_1fr]">
                    <div class="flex flex-col items-center">
                        <div
                            @click="removeVideo(index)"
                            v-for="(selected, index) in store.selectedVideos"
                            :key="selected.id.video_id"
                        >
                            {{ selected.snippet.title }}
                        </div>
                    </div>
                    <div class="flex flex-col items-center h-3/4">
                        <form class="w-3/4 flex gap-2" @submit.prevent="handleSearch">
                            <InputText class="grow" v-model="searchValue"></InputText
                            ><Button type="submit">검색</Button>
                        </form>

                        <div class="flex flex-col gap-2 overflow-y-auto h-96">
                            <VideoInfoComponent
                                v-for="video in store.videos"
                                :video="video"
                                :key="`youtube_${video.id.video_id}`"
                                :clickHandler="() => store.selectedVideos.push(video)"
                            />
                            <InfiniteLoading
                                v-if="store.videos.length > 0"
                                @infinite="store.youtubeSearch(searchValue)"
                            ></InfiniteLoading>
                        </div>
                        <Button @click="handleClose">취소</Button>
                        <Button @click="handleSave">저장</Button>
                    </div>
                </div>
            </template>
        </ModalComponent>
    </div>
</template>
