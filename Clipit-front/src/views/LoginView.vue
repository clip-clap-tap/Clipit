<script setup>
import LoginComponent from '@/components/LoginComponent.vue';
import { useUserStore } from '@/stores/UserStore';
import { onMounted } from 'vue';
import { useRouter } from 'vue-router';

const userStore = useUserStore();
const router = useRouter();
onMounted(async () => {
    console.log(await userStore.validate());
    if (await userStore.validate()) {
        router.push({ name: 'main' }).then(() => router.go(0));
    }
});
</script>
<template>
    <div class="h-full">
        <LoginComponent />
    </div>
</template>

<style scoped></style>
