<script setup>
import Button from 'primevue/button';
import { ref } from 'vue';
import { useYoutubeStore } from '@/stores/YoutubeStore';
import InfiniteLoading from 'v3-infinite-loading';
import VideoInfoComponent from '../util/VideoInfoComponent.vue';

const isOpen = ref(false);
const setIsOpen = () => {
    isOpen.value = !isOpen.value;
};

const youtubeStore = useYoutubeStore();
const searchValue = ref('');

const removeVideo = (index) => {
    youtubeStore.selectedVideos.splice(index, 1);
};

const handleClose = () => {
    setIsOpen();
    searchValue.value = '';
    youtubeStore.resetVideos();
};

const handleSearch = () => {
    youtubeStore.resetVideos();
    youtubeStore.youtubeSearch(searchValue.value);
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
                    <div class="flex flex-col items-center border-r-2">
                        <!-- <VideoInfoComponent
                            v-for="(selected, index) in store.selectedVideos"
                            :key="selected.id.video_id"
                            :video="selected"
                            :clickHandler="removeVideo(index)"
                        /> -->

                        <div
                            class="grid grid-cols-[8rem_1fr] items-center"
                            @click="removeVideo(index)"
                            v-for="(selected, index) in youtubeStore.selectedVideos"
                            :key="selected.id.video_id"
                        >
                            <img
                                class="aspect-video h-auto shrink-0"
                                :src="selected.snippet.thumbnails.default.url"
                            />
                            <div class="line-clamp-2 text-ellipsis px-2">
                                {{ selected.snippet.title }}
                            </div>
                        </div>
                    </div>
                    <div class="flex flex-col items-center py-2 px-4 gap-4">
                        <form class="w-3/4 flex gap-2" @submit.prevent="handleSearch">
                            <InputText class="grow" v-model="searchValue"></InputText
                            ><Button type="submit">검색</Button>
                        </form>
                        <div class="flex flex-col gap-2 overflow-y-auto h-[54vh]">
                            <VideoInfoComponent
                                v-for="video in youtubeStore.videos"
                                :video="video"
                                :key="`youtube_${video.id.video_id}`"
                                :clickHandler="() => youtubeStore.selectedVideos.push(video)"
                            />
                            <InfiniteLoading
                                v-if="youtubeStore.videos.length > 0"
                                @infinite="youtubeStore.youtubeSearch(searchValue)"
                            ></InfiniteLoading>
                        </div>

                        <div class="flex gap-2">
                            <Button @click="handleClose">취소</Button>
                            <Button @click="handleSave">저장</Button>
                        </div>
                    </div>
                </div>
            </template>
        </ModalComponent>
    </div>
</template>
