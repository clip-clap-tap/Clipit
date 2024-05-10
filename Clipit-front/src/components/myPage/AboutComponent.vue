<script setup>
import { ref } from 'vue';

const visible = ref(false);
const setVisible = () => {
    visible.value = !visible.value;
};

const tags = ref([]);

const newTags = ref(['tag1', 'tag2']);
const removeTag = (index) => {
    newTags.value.splice(index, 1);
};

const newTag = ref('');
const addTag = () => {
    newTags.value.push(newTag.value);
    newTag.value = '';
};

const handleSubmit = () => {
    console.log(newTags.value);
    newTag.value = '';
    tags.value = newTags.value;
    setVisible();
};

const router = useRouter();
const handleTagClick = (tag) => {
    router.push({ name: 'tagSearch', params: { name: tag } });
};
</script>
<script>
import TagComponent from '../util/TagComponent.vue';
import { useRouter } from 'vue-router';

export default { components: { TagComponent } };
</script>

<template>
    <div class="w-full border p-5 flex items-center flex-col h-fit rounded relative">
        <div class="text-xl font-bold">뭉크님은 주n회 운동 도전 중!</div>
        <!-- 태그 수정 버튼 -->
        <Button
            v-if="tags.length > 0"
            @click="setVisible"
            class="absolute right-2 top-2 text-clip-primary px-2 py-1 text-sm"
            label="수정"
            text
        />

        <!-- 태그 추가/수정창 -->
        <ModalComponent :visible="visible">
            <template #closeBtn>
                <Button @click="setVisible" icon="pi pi-times" text rounded aria-label="Cancel" />
            </template>
            <template #content>
                <div class="w-96 flex items-center flex-col gap-3">
                    <InputText
                        @input="newTag = $event.target.value"
                        @keyup.enter="addTag"
                        :value="newTag"
                        class="grow-0 h-fit"
                        autocomplete="off"
                    />
                    <div
                        style="scrollbar-width: thin"
                        class="flex w-80 gap-2 flex-wrap overflow-y-auto grow max-h-[25vh]"
                    >
                        <Chip v-for="(tag, index) in newTags" :key="`tag-${index}`" :label="tag">
                            <span class="text-sm font-medium">{{ tag }}</span>
                            <button @click="removeTag(index)">
                                <i class="pi pi-times text-xs ml-2 text-gray-500"></i></button
                        ></Chip>
                    </div>
                    <Button
                        class="shrink-0 px-2 py-1 text-sm bg-clip-primary"
                        severity="info"
                        @click="handleSubmit"
                        >수정</Button
                    >
                </div>
            </template>
        </ModalComponent>

        <!-- 태그 목록 -->
        <div class="h-fit min-h-48 grow flex items-center">
            <div class="flex flex-wrap p-6" v-if="tags.length > 0">
                <TagComponent
                    @click="handleTagClick(tag)"
                    v-for="(tag, index) in tags"
                    :key="`${index}-tag`"
                    :name="tag"
                />
            </div>
            <div v-else>
                <Button
                    @click="setVisible"
                    class="text-clip-primary px-3 py-2"
                    label="관심 태그를 추가해주세요"
                    outlined=""
                    severity="info"
                />
            </div>
        </div>
    </div>
</template>
