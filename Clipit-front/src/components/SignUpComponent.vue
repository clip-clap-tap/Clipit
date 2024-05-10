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
</script>
<template>
    <div class="gap-2 w-full max-w-s flex flex-col h-full px-8 pt-6 pb-8">
        <div class="flex items-end">
            <div>
                <label for="id" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                    >아이디</label
                >
                <input
                    type="text"
                    name="id"
                    id="id"
                    class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                    placeholder=""
                    required=""
                    v-model="user.id"
                />
            </div>
            <div>
                <Button label="중복확인" severity="info"></Button>
            </div>
        </div>

        <div>
            <label
                for="password"
                class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                >비밀번호</label
            >
            <input
                type="password"
                name="password"
                id="password"
                class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                placeholder=""
                required=""
                v-model="user.password"
            />
        </div>
        <div>
            <label
                for="username"
                class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                >닉네임</label
            >
            <input
                type="text"
                name="username"
                id="username"
                class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                placeholder=""
                required=""
                v-model="user.username"
            />
        </div>
        <div class="flex justify-center">
            <Button label="가입하기" severity="info" @click="register"></Button>
        </div>
    </div>
</template>

<style lang="scss" scoped></style>
