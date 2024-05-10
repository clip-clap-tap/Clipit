<script setup>
import Button from 'primevue/button';
import FloatLabel from 'primevue/floatlabel';
import InputText from 'primevue/inputtext';
import { ref } from 'vue';
import { useUserStore } from '@/stores/UserCounter';
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
    <div>
        <div>
            <FloatLabel>
                <InputText id="username" v-model="user.id" />
                <label for="username">아이디</label>
            </FloatLabel>
        </div>
        <div>
            <FloatLabel>
                <InputText id="username" v-model="user.password" />
                <label for="username">비밀번호</label>
            </FloatLabel>
        </div>
        <div>
            <Button label="로그인" severity="info" icon="pi pi-check" @click="login"></Button>
        </div>
        <RouterLink :to="{ name: 'signup' }">회원가입</RouterLink>
    </div>
</template>

<style scoped></style>
