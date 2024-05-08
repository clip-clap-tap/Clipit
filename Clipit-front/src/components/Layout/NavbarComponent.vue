<script setup>
import { useLayoutStore } from '@/stores/counter.js';
const { isOpen } = useLayoutStore();
</script>

<template>
    <nav x-data="{ isOpen: false }" class="relative bg-white dark:bg-gray-800">
        <div class="container px-4 py-6 mx-auto">
            <div class="lg:flex lg:items-center lg:justify-between">
                <div class="flex items-center justify-between">
                    <!-- <div class="text-xl font-semibold text-gray-700"> -->
                    <RouterLink :to="`/`">
                        <img src="@/assets/Clipit_logo.png" class="w-36 h-8 object-cover" />
                    </RouterLink>
                    <!-- </div> -->

                    <!-- Mobile menu button -->
                    <div class="flex lg:hidden">
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
                    </div>
                </div>

                <!-- Mobile Menu open: "block", Menu closed: "hidden" -->
                <div
                    x-cloak
                    :class="[isOpen ? 'translate-x-0 opacity-100 ' : 'opacity-0 -translate-x-full']"
                    class="absolute inset-x-0 z-20 w-full px-6 py-4 transition-all duration-300 ease-in-out bg-white dark:bg-gray-800 lg:mt-0 lg:p-0 lg:top-0 lg:relative lg:bg-transparent lg:w-auto lg:opacity-100 lg:translate-x-0 lg:flex lg:items-center"
                >
                    <div class="flex flex-col -mx-6 lg:flex-row lg:items-center">
                        <RouterLink
                            :to="`/`"
                            class="px-4 py-1.5 mx-3 mt-2 text-gray-700 transition-colors duration-300 transform rounded-lg lg:mt-0 dark:text-gray-200 bg-gray-100 dark:bg-gray-700"
                        >
                            Blog
                        </RouterLink>
                        <RouterLink
                            :to="`/`"
                            class="px-4 py-1.5 mx-3 mt-2 text-gray-700 transition-colors duration-300 transform rounded-lg lg:mt-0 dark:text-gray-200 hover:bg-gray-100 dark:hover:bg-gray-700"
                        >
                            Join Slack
                        </RouterLink>
                        <RouterLink
                            :to="`/template`"
                            class="px-4 py-1.5 mx-3 mt-2 text-gray-700 transition-colors duration-300 transform rounded-lg lg:mt-0 dark:text-gray-200 hover:bg-gray-100 dark:hover:bg-gray-700"
                        >
                            Browse Topics
                        </RouterLink>
                        <RouterLink
                            :to="`/test`"
                            class="px-4 py-1.5 mx-3 mt-2 text-gray-700 transition-colors duration-300 transform rounded-lg lg:mt-0 dark:text-gray-200 hover:bg-gray-100 dark:hover:bg-gray-700"
                        >
                            Random Item
                        </RouterLink>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</template>
