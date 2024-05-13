<script setup>
import Button from 'primevue/button';
import FloatLabel from 'primevue/floatlabel';
import InputText from 'primevue/inputtext';
import { ref } from 'vue';
import { useUserStore } from '@/stores/UserStore';
import { RouterLink } from 'vue-router';

const store = useUserStore();

const user = ref({
    id: '',
    password: ''
});

const login = function () {
    store.login(user.value);
};
</script>

<template>
    <div class="w-full max-w-s flex flex-col justify-center item-center h-full px-8 pt-6 pb-8">
        <div class="mb-6 w-full max-w-96">
            <img src="/src/assets/Clipit_logo.png" alt="" />
        </div>
        <div class="flex flex-col gap-6">
            <div class="flex justify-center">
                <FloatLabel>
                    <InputText class="w-80" id="username" v-model="user.id" />
                    <label c for="username">아이디</label>
                </FloatLabel>
            </div>
            <div class="flex justify-center">
                <FloatLabel>
                    <InputText class="w-80" id="username" v-model="user.password" />
                    <label for="username">비밀번호</label>
                </FloatLabel>
            </div>
        </div>
        <div class="flex justify-center gap-2 mt-6">
            <div class="flex flex-col justify-center">
                <RouterLink :to="{ name: 'signup' }">
                    <Button label="회원가입" severity="success" text=""></Button>
                </RouterLink>
            </div>
            <div>
                <Button label="로그인" severity="info" text="" @click="login"></Button>
            </div>
        </div>
    </div>
</template>

<style scoped></style>
