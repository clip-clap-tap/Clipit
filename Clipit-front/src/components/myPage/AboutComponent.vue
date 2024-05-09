<template>
    <div class="w-full bg-gray-100 p-5 flex items-center flex-col h-fit">
        <div class="text-xl font-bold">뭉크님은 주n회 운동 도전 중!</div>
        <div class="h-fit grow-0">
            <TagComponent name="헬린이" />
            <TagComponent name="체중감량" />
            <TagComponent name="스트레칭" />
        </div>
    </div>
</template>
<script>
import TagComponent from '../util/TagComponent.vue';

export default { components: { TagComponent } };
</script>
<style lang=""></style>
