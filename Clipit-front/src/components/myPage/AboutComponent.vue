<template>
    <div class="w-full bg-gray-100 p-5 flex items-center flex-col h-fit rounded relative">
        <div class="text-xl font-bold">뭉크님은 주n회 운동 도전 중!</div>
        <Button
            @click="setVisible"
            class="absolute right-2 top-2 text-clip-primary px-2 py-1 text-sm"
            label="수정"
            text
        />
        <ModalComponent :visible="visible">
            <template #test><Button @click="setVisible">닫기</Button></template>
        </ModalComponent>
        <div class="h-fit min-h-48 grow flex items-center">
            <TagComponent name="헬린이" />
            <TagComponent name="체중감량" />
            <TagComponent name="스트레칭" />
        </div>
    </div>
</template>
<script setup>
import { ref } from 'vue';

const visible = ref(false);
const setVisible = () => {
    visible.value = !visible.value;
    console.log(visible.value);
};
</script>
<script>
import TagComponent from '../util/TagComponent.vue';

export default { components: { TagComponent } };
</script>
