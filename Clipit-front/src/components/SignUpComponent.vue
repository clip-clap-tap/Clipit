<script setup>
import { useUserStore } from '@/stores/UserStore';
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

const duplicateCheck = function () {
    store.duplicateCheck(user.value.id);
};
</script>
<template>
    <div class="gap-2 w-full flex flex-col h-full px-8 pt-6 pb-8">
        <div class="relative">
            <label for="id" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                >아이디</label
            >
            <InputText v-model="user.id" type="text" name="id" id="id" required />
            <Button
                class="absolute -right-28 bottom-0"
                label="중복확인"
                severity="info"
                @click="duplicateCheck"
            ></Button>
        </div>

        <div>
            <label
                for="password"
                class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                >비밀번호</label
            >
            <InputText
                v-model="user.password"
                type="password"
                name="password"
                id="password"
                required
            />
        </div>
        <div>
            <label
                for="username"
                class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                >닉네임</label
            >
            <InputText v-model="user.username" type="text" name="username" id="username" required />
        </div>
        <div class="flex justify-center">
            <Button label="가입하기" severity="info" @click="register"></Button>
        </div>
    </div>
</template>

<style lang="scss" scoped></style>
