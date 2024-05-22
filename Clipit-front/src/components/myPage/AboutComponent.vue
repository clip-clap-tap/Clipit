<script setup>
import { useTagStore } from '@/stores/TagStore';

const tagStore = useTagStore();

const router = useRouter();
const handleTagClick = (tag) => {
    router.push({ name: 'tagSearch', params: { name: tag } });
};
</script>
<script>
import TagModalComponent from '@/components/util/tag/TagModalComponent.vue';
import TagComponent from '../util/TagComponent.vue';
import { useRouter } from 'vue-router';

export default { components: { TagComponent } };
</script>

<template>
    <div class="w-full border p-5 flex items-center flex-col h-fit rounded relative">
        <div class="text-xl font-bold">뭉크님은 주n회 운동 도전 중!</div>
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
