<script setup>
import NewRoutineComponent from '@/components/myRoutine/NewRoutineComponent.vue';
import TagModalComponent from '@/components/util/tag/TagModalComponent.vue';
import { usePostStore } from '@/stores/PostStore';
import { useTagStore } from '@/stores/TagStore';
import { useYoutubeStore } from '@/stores/YoutubeStore';
import { onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const youtubeStore = useYoutubeStore();
const router = useRouter();
const handleSave = async () => {
    if (youtubeStore.selectedVideos.length == 0 && postStore.post.videos.length == 0) {
        return;
    }
    if (route.name == 'postModify') {
        await postStore.modifyPost();
    } else {
        await postStore.savePost();
    }
    youtubeStore.resetVideos();
    router.push({ name: 'myRoutine' }).then(() => router.go(0));
};

const ageRangeProps = [
    { age: 10, label: '10대' },
    { age: 20, label: '20대' },
    { age: 30, label: '30대' },
    { age: 40, label: '40대' },
    { age: 50, label: '50대' },
    { age: 60, label: '60대 이상' }
];
const bodyPartsProps = [
    { part: 'neck', label: '목' },
    { part: 'back', label: '등' },
    { part: 'arm', label: '팔' },
    { part: 'leg', label: '다리' },
    { part: 'chest', label: '가슴' },
    { part: 'abs', label: '배' },
    { part: 'waist', label: '허리' }
];
const postStore = usePostStore();
const tagStore = useTagStore();
const route = useRoute();

onMounted(async () => {
    if (route.name == 'postModify') {
        await postStore.getPostDetail(route.params.id);
        tagStore.tags = postStore.post.tags;
    } else {
        postStore.post = {
            title: '',
            description: '',
            tags: [],
            videos: [],
            ageRange: [],
            bodyPart: [],
            strength: 0
        };
    }
});
</script>
<template>
    <div class="w-full max-w-4xl px-2">
        <InputText v-model="postStore.post.title" class="w-full" placeholder="title"></InputText>

        <div
            class="flex flex-col w-full items-center border border-slate-300 rounded-md p-4 my-4 shadow-sm"
        >
            <div class="flex w-full items-center mb-4">
                <h2 class="text-xl font-bold">플레이리스트</h2>
                <div class="grow"></div>
                <NewRoutineComponent></NewRoutineComponent>
            </div>
            <div class="mb-2" v-if="youtubeStore.selectedVideos.length == 0">
                영상을 추가해주세요
            </div>
            <div class="flex flex-col gap-2">
                <VideoInfoComponent
                    v-for="video in youtubeStore.selectedVideos"
                    :key="`selected_${video.id.video_id}`"
                    :video="video"
                />
            </div>

            <!-- <div v-for="video in selectedVideos" :key="`selected_${video.id.video_id}`">
                    {{ video.snippet.title }}
                </div> -->
        </div>

        <Textarea class="w-full" v-model="postStore.post.description"></Textarea>
        <div class="bg-white w-full min-h-16 px-4 md:px-8 py-6">
            <div class="py-4 lg:flex gap-5">
                <div class="mb-3 text-lg">연령대</div>
                <div class="flex gap-2">
                    <div v-for="ageRange in ageRangeProps" :key="`age_${ageRange.age}`">
                        <input
                            :value="ageRange.age"
                            v-model="postStore.post.ageRange"
                            type="checkbox"
                            :id="ageRange.age"
                            class="hidden peer"
                        />
                        <label
                            :for="ageRange.age"
                            class="peer-checked:bg-slate-200 py-2 px-3 rounded border-2 border-slate-200 cursor-pointer"
                            >{{ ageRange.label }}</label
                        >
                    </div>
                </div>
            </div>
            <div class="py-4 lg:flex gap-5">
                <div class="mb-3 text-lg">운동 부위</div>
                <div class="flex gap-2">
                    <div v-for="bodyPart in bodyPartsProps" :key="`bodypart_${bodyPart.part}`">
                        <input
                            :value="bodyPart.part"
                            :id="bodyPart.part"
                            v-model="postStore.post.bodyPart"
                            type="checkbox"
                            class="hidden peer"
                        />
                        <label
                            :for="bodyPart.part"
                            class="peer-checked:bg-slate-200 py-2 px-3 rounded border-2 border-slate-200 cursor-pointer"
                            >{{ bodyPart.label }}</label
                        >
                    </div>
                </div>
            </div>
            <div class="py-4">
                <div class="mb-3 text-lg">강도</div>
                <div class="flex gap-6 items-center px-6">
                    <Slider
                        v-model="postStore.post.strength"
                        class="w-full"
                        tap
                        :step="20"
                        :end="100"
                    />
                    <span>{{ postStore.post.strength }}</span>
                </div>
            </div>
        </div>

        <div
            class="flex flex-col w-full items-center border border-slate-300 rounded-md p-4 my-4 shadow-sm relative"
        >
            <div class="h-fit min-h-48 grow flex items-center">
                <div class="flex flex-wrap p-6" v-if="tagStore.tags.length > 0">
                    <TagComponent
                        @click="handleTagClick(tag)"
                        v-for="(tag, index) in tagStore.tags"
                        :key="`${index}-tag`"
                        :name="tag"
                    />
                </div>
                <div>
                    <TagModalComponent />
                </div>
            </div>
        </div>
        <div class="flex w-full justify-center">
            <Button severity="success" @click="handleSave">저장</Button>
        </div>
    </div>
</template>
