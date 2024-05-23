<script setup>
import { usePostStore } from '@/stores/PostStore';
import IconField from 'primevue/iconfield';
import InputIcon from 'primevue/inputicon';
import InputText from 'primevue/inputtext';
import Slider from 'primevue/slider';
import { ref, onMounted, onBeforeUnmount } from 'vue';
import { useRouter } from 'vue-router';

const postStore = usePostStore();
const showCategory = ref(false);

const slotProps = [
    { name: '', label: '전체' },
    { name: 'title', label: '제목' },
    { name: 'description', label: '내용' },
    { name: 'writer', label: '작성자' },
    { name: 'video_title', label: '영상제목' }
];
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

const categoryModal = ref(null);

const toggleEvent = (e) => {
    if (e.target !== categoryModal.value && e.composedPath().includes(categoryModal.value)) return;
    showCategory.value = false;
};

onMounted(() => {
    document.addEventListener('click', toggleEvent);
});
onBeforeUnmount(() => {
    document.removeEventListener('click', toggleEvent);
});
const router = useRouter();
const search = () => {
    router.push({ name: 'search', query: postStore.searchInfo }).then(() => router.go(0));
};
</script>
<template>
    <form
        ref="categoryModal"
        @submit.prevent="search"
        class="relative w-full flex justify-center px-2"
    >
        <div ref="categoryModal" class="flex mt-8 w-full gap-1">
            <Dropdown
                v-model="postStore.searchInfo.category"
                placeholder="전체"
                :options="slotProps"
                optionLabel="label"
                optionValue="name"
                class="w-40 items-center"
            />
            <IconField iconPosition="left" class="grow">
                <InputIcon class="pi pi-search"> </InputIcon>
                <InputText
                    v-model="postStore.searchInfo.keyword"
                    id="category"
                    @focus="() => (showCategory = true)"
                    class="w-full py-3"
                    placeholder="Search"
                    autocomplete="off"
                />
            </IconField>
            <Button
                class="break-keep justify-center"
                type="submit"
                severity="primary"
                label="검색"
            />
        </div>
        <div
            v-if="showCategory"
            class="absolute top-[5.4rem] bg-white w-full min-h-16 px-4 md:px-8 shadow-lg border-2 rounded transition-all py-6 ease-in-out"
        >
            <div class="py-4">
                <div class="mb-3 text-lg">연령대</div>
                <div class="flex gap-2">
                    <div v-for="ageRange in ageRangeProps" :key="`age_${ageRange.age}`">
                        <input
                            v-model="postStore.searchInfo.ageRange"
                            :value="ageRange.age"
                            :id="ageRange.age"
                            type="checkbox"
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
            <div class="py-4">
                <div class="mb-3 text-lg">운동 부위</div>
                <div class="flex gap-2">
                    <div v-for="bodyPart in bodyPartsProps" :key="`bodypart_${bodyPart.part}`">
                        <input
                            v-model="postStore.searchInfo.bodyParts"
                            :value="bodyPart.part"
                            :id="bodyPart.part"
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
                        class="w-full"
                        tap
                        :step="20"
                        :end="100"
                        v-model="postStore.searchInfo.strength"
                    />
                    <span>{{ postStore.searchInfo.strength }}</span>
                </div>
            </div>
        </div>
    </form>
</template>
