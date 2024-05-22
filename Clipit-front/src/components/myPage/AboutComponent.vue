<script setup>
import { useTagStore } from '@/stores/TagStore';

const tagStore = useTagStore();

const router = useRouter();
const handleTagClick = (tag) => {
    router.push({ name: 'tagSearch', params: { name: tag } });
};
const username = localStorage.getItem('username');
</script>
<script>
import TagModalComponent from '@/components/util/tag/TagModalComponent.vue';
import TagComponent from '../util/TagComponent.vue';
import { useRouter } from 'vue-router';

export default { components: { TagComponent } };
</script>

<template>
    <div class="text-xl font-bold">{{ username }}님의 운동 기록</div>
    <div class="w-full border p-5 flex items-center flex-col h-fit rounded relative">
        <div class="text-lg font-bold">관심 태그</div>
        <!-- 태그 수정 버튼 -->

        <!-- 태그 목록 -->
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
</template>
