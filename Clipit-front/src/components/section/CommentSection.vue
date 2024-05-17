<script setup>
import { useCommentStore } from '@/stores/CommentStore';
import { onMounted } from 'vue';
import { useRoute } from 'vue-router';

const route = useRoute();
const store = useCommentStore();

onMounted(() => {
    store.getComments(route.params.id);
});

const handleSubmit = () => {
    store.saveComment(route.params.id);
};
</script>
<template>
    <div class="mt-4">
        <div class="py-2 mb-2 font-bold">{{ store.comments.length }}개의 댓글</div>
        <form @submit.prevent="handleSubmit">
            <Textarea placeholder="내용을 입력하세요..." class="w-full" v-model="store.comment">
            </Textarea>
            <div class="flex w-full justify-end mt-1">
                <Button type="submit" severity="info">댓글 작성</Button>
            </div>
        </form>
        <CommentComponent :comment="comment" v-for="comment in store.comments" :key="comment.id" />
    </div>
</template>
