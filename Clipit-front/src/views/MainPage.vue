<script setup>
import CardSectionComponent from '@/components/util/CardSectionComponent.vue';
</script>
<template>
    <HeaderComponent></HeaderComponent>
    <div class="container">
        <CardSectionComponent
            :title="`Latest Articles`"
            :items="[1, 2, 3, 4]"
        ></CardSectionComponent>
        <CardSectionComponent :title="`Podcasts`" :items="[1, 2, 3]"></CardSectionComponent>

        <section class="bg-white dark:bg-gray-900">
            <div class="container px-4 py-10 lg:py-16 lg:flex lg:items-center lg:justify-between">
                <h2
                    class="text-2xl font-semibold tracking-tight text-gray-800 xl:text-3xl dark:text-white"
                >
                    Join us and get the update from anywhere
                </h2>

                <div class="mt-8 lg:mt-0">
                    <div class="flex flex-col space-y-3 sm:space-y-0 sm:flex-row sm:-mx-2">
                        <input
                            id="email"
                            type="text"
                            class="px-4 py-2 text-gray-700 bg-white border border-gray-200 rounded-md sm:mx-2 dark:bg-gray-900 dark:text-gray-300 dark:border-gray-600 focus:border-sky-400 dark:focus:border-sky-400 focus:ring-sky-300 focus:outline-none focus:ring focus:ring-opacity-40"
                            placeholder="Email Address"
                        />

                        <button
                            class="px-4 py-2 text-sm font-medium tracking-wide text-white capitalize transition-colors duration-300 transform bg-sky-500 rounded-md focus:ring focus:ring-sky-300 focus:ring-opacity-80 fo sm:mx-2 hover:bg-sky-400 focus:outline-none focus:bg-sky-400"
                        >
                            Get Started
                        </button>
                    </div>

                    <p class="mt-3 text-sm text-gray-500 dark:text-gray-300">
                        Attention! Offer expires in 30 days. Make sure not to miss this opportunity
                    </p>
                </div>
            </div>
        </section>

        <CardSectionComponent :title="`Most Popular`" :items="[1, 2]"></CardSectionComponent>
    </div>
</template>
