<script setup>
import { useLayoutStore } from '@/stores/LayoutStore';
import { useUserStore } from '@/stores/UserStore';
import { ref } from 'vue';
import { onMounted } from 'vue';
import { useCookies } from 'vue3-cookies';

const layoutStore = useLayoutStore();
const userStore = useUserStore();
const { cookies } = useCookies();

const username = ref('');
onMounted(() => {
    username.value = localStorage.getItem('username');
});
</script>

<template>
    <nav class="bg-white dark:bg-gray-800 flex justify-center fixed top-0 w-full z-[1000]">
        <div class="px-4 py-6 max-w-7xl w-full">
            <div class="flex items-center justify-between">
                <div class="flex items-center justify-between">
                    <!-- <div class="text-xl font-semibold text-gray-700"> -->
                    <a :href="$router.resolve({ name: 'main' }).href">
                        <img src="@/assets/Clipit_logo.png" class="w-36 h-8 object-cover" />
                    </a>
                    <!-- </div> -->

                    <!-- Mobile menu button -->
                    <!-- <div class="flex lg:hidden">
                        <button
                            x-cloak
                            @click="isOpen = !isOpen"
                            type="button"
                            class="text-gray-500 dark:text-gray-200 hover:text-gray-600 dark:hover:text-gray-400 focus:outline-none focus:text-gray-600 dark:focus:text-gray-400"
                            aria-label="toggle menu"
                        >
                            <svg
                                x-show="!isOpen"
                                xmlns="http://www.w3.org/2000/svg"
                                class="w-6 h-6"
                                fill="none"
                                viewBox="0 0 24 24"
                                stroke="currentColor"
                                stroke-width="2"
                            >
                                <path
                                    stroke-linecap="round"
                                    stroke-linejoin="round"
                                    d="M4 8h16M4 16h16"
                                />
                            </svg>

                            <svg
                                x-show="isOpen"
                                xmlns="http://www.w3.org/2000/svg"
                                class="w-6 h-6"
                                fill="none"
                                viewBox="0 0 24 24"
                                stroke="currentColor"
                                stroke-width="2"
                            >
                                <path
                                    stroke-linecap="round"
                                    stroke-linejoin="round"
                                    d="M6 18L18 6M6 6l12 12"
                                />
                            </svg>
                        </button>
                    </div> -->
                </div>

                <!-- Mobile Menu open: "block", Menu closed: "hidden" -->
                <!-- :class="[isOpen ? 'translate-x-0 opacity-100 ' : 'opacity-0 -translate-x-full']" -->
                <div class="relative">
                    <button v-if="username" class="px-6" @click="layoutStore.setIsOpen">
                        {{ username }}님
                    </button>
                    <RouterLink v-if="!cookies.get('user')" class="px-6" :to="{ name: 'login' }">
                        로그인
                    </RouterLink>
                    <div
                        x-cloak
                        v-bind:visible="layoutStore.isOpen"
                        :class="[
                            layoutStore.isOpen
                                ? 'translate-y-0 opacity-100 '
                                : 'opacity-0 -translate-y-0 hidden '
                        ]"
                        class="absolute top-10 right-0 z-20 px-2 py-4 transition-all duration-300 ease-in-out bg-white dark:bg-gray-800 rounded shadow"
                    >
                        <div class="flex flex-col items-centerw">
                            <RouterLink
                                :to="{ name: `myPage` }"
                                class="break-keep px-4 py-3 mt-2 text-gray-700 transition-colors duration-300 transform rounded-lg lg:mt-0 dark:text-gray-200 hover:bg-gray-100 dark:hover:bg-gray-700"
                            >
                                마이페이지
                            </RouterLink>
                            <RouterLink
                                :to="{ name: `myRoutine` }"
                                class="px-4 py-3 mt-2 text-gray-700 transition-colors duration-300 transform rounded-lg lg:mt-0 dark:text-gray-200 hover:bg-gray-100 dark:hover:bg-gray-700"
                            >
                                마이루틴
                            </RouterLink>
                            <RouterLink
                                :to="{ name: `profile` }"
                                class="px-4 py-3 mt-2 text-gray-700 transition-colors duration-300 transform rounded-lg lg:mt-0 dark:text-gray-200 hover:bg-gray-100 dark:hover:bg-gray-700"
                            >
                                마이프로필
                            </RouterLink>

                            <div
                                @click="userStore.logout"
                                class="cursor-pointer px-4 py-3 mt-4 text-gray-700 transition-colors duration-300 transform rounded-lg lg:mt-0 dark:text-gray-200 hover:bg-gray-100 dark:hover:bg-gray-700"
                            >
                                로그아웃
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</template>
