<script setup>
import { useCommentStore } from '@/stores/CommentStore';
import { useUserStore } from '@/stores/UserStore';

import { useRoute } from 'vue-router';

const commentStore = useCommentStore();
const userStore = useUserStore();
const route = useRoute();

defineProps({
    comment: Object
});
</script>
<template>
    <div class="border-b py-4 px-2">
        <div class="flex items-center justify-between">
            <div>{{ comment.writerName }}</div>
            <Button
                v-if="userStore.validate(comment.writerId)"
                @click="commentStore.deleteComment(route.params.id, comment.id)"
                class="py-0 px-2"
                text
                severity="danger"
                >삭제</Button
            >
        </div>
        <div>{{ comment.content }}</div>
    </div>
</template>
