<script setup>
import InputText from 'primevue/inputtext';
import { useUserStore } from '@/stores/UserCounter';
import { ref } from 'vue';

const store = useUserStore();

const user = ref({
    id: '',
    password: '',
    username: ''
});

const register = function () {
    store.register(user.value);
};
</script>
<template>
    <div>
        <label for="">아이디</label>
        <InputText type="text" v-model="user.id" />
        <Button label="중복확인" severity="info"></Button>
    </div>
    <div>
        <label for="">비밀번호</label>
        <InputText type="text" v-model="user.password" />
    </div>
    <div>
        <label for="">닉네임</label>
        <InputText type="text" v-model="user.username" />
    </div>
    <div>
        <Button label="가입하기" severity="info" @click="register"></Button>
    </div>
</template>

<style lang="scss" scoped></style>
