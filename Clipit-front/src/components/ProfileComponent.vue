<script setup>
import { onMounted } from 'vue';
import { useUserStore } from '@/stores/UserStore';
import { useCookies } from 'vue3-cookies';
import { ref } from 'vue';

const store = useUserStore();
const { cookies } = useCookies();

const username = ref('');

onMounted(() => {
    store.getProfile(cookies.get('user'));
    username.value = localStorage.getItem('username');
});

const saveProfile = function () {
    store.saveProfile(cookies.get('user'), store.userProfile);
};
</script>

<template>
    <table className="min-w-full text-left text-md font-light mb-5">
        <tr
            className="border-b transition duration-300 ease-in-out hover:bg-neutral-100 dark:border-neutral-500 dark:hover:bg-neutral-600"
        >
            <td className="whitespace-nowrap px-6 py-4 font-medium">닉네임</td>
            <td className="whitespace-nowrap px-6 py-4">
                {{ username }}
            </td>
        </tr>
        <tr
            className="border-b transition duration-300 ease-in-out hover:bg-neutral-100 dark:border-neutral-500 dark:hover:bg-neutral-600"
        >
            <td className="whitespace-nowrap px-6 py-4 font-medium">성별</td>
            <td className="whitespace-nowrap px-6 py-4 flex justify-evenly">
                <div>
                    <input
                        type="radio"
                        id="male"
                        name="gender"
                        value="M"
                        v-model="store.userProfile.gender"
                    />
                    <label for="male">남</label><br />
                </div>
                <div>
                    <input
                        type="radio"
                        id="female"
                        name="gender"
                        value="F"
                        v-model="store.userProfile.gender"
                    />
                    <label for="female">여</label><br />
                </div>
            </td>
        </tr>
        <tr
            className="border-b transition duration-300 ease-in-out hover:bg-neutral-100 dark:border-neutral-500 dark:hover:bg-neutral-600"
        >
            <td className="whitespace-nowrap px-6 py-4 font-medium">나이</td>
            <td className="whitespace-nowrap px-6 py-4 flex justify-center">
                <input type="number" v-model="store.userProfile.age" />
            </td>
        </tr>
        <tr
            className="border-b transition duration-300 ease-in-out hover:bg-neutral-100 dark:border-neutral-500 dark:hover:bg-neutral-600"
        >
            <td className="whitespace-nowrap px-6 py-4 font-medium">키</td>
            <td className="whitespace-nowrap px-6 py-4 flex justify-center">
                <input type="number" step="0.1" v-model="store.userProfile.height" /> cm
            </td>
        </tr>
        <tr
            className="border-b transition duration-300 ease-in-out hover:bg-neutral-100 dark:border-neutral-500 dark:hover:bg-neutral-600"
        >
            <td className="whitespace-nowrap px-6 py-4 font-medium ">몸무게</td>
            <td className="whitespace-nowrap px-6 py-4 flex justify-center">
                <input type="number" step="0.1" v-model="store.userProfile.weight" /> kg
            </td>
        </tr>
        <tr
            className="border-b transition duration-300 ease-in-out hover:bg-neutral-100 dark:border-neutral-500 dark:hover:bg-neutral-600"
        >
            <td className="whitespace-nowrap px-6 py-4 font-medium">목표</td>
            <td className="whitespace-nowrap px-6 py-4 flex justify-center">
                <input
                    class="w-full"
                    type="text"
                    v-model="store.userProfile.goal"
                    placeholder="목표를 설정하고 나만의 루틴을 모아보세요!"
                />
            </td>
        </tr>
    </table>
    <div class="flex justify-center">
        <Button label="저장" severity="info" @click="saveProfile"></Button>
    </div>
</template>

<style scoped></style>
