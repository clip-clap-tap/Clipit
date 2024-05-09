<script setup>
import IconField from 'primevue/iconfield';
import InputIcon from 'primevue/inputicon';
import InputText from 'primevue/inputtext';
</script>
<template>
    <header class="h-[28rem] bg-gray-50">
        <div class="container px-4 flex h-full py-6 items-center max-w-7xl">
            <div class="flex items-center flex-col w-full">
                <h2 class="text-7xl font-bold text-gray-800 uppercase">
                    <span class="title-word title-word-1">Clip </span>
                    <span class="title-word title-word-2">Your </span>
                    <span class="title-word title-word-3">Fit</span>
                    <!-- <span class="title-word title-word-4">text</span> -->
                </h2>
                <!-- <p class="text-gray-500 mt-4 text-lg">
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Soluta error odit vel
                    minima optio consequuntur atque omnis, repellendus eos, rerum totam quas vitae
                    voluptatibus, facere distinctio fugit? Nam, iure expedita!
                </p> -->
                <IconField iconPosition="left" class="mt-8 w-full max-w-2xl">
                    <InputIcon class="pi pi-search"> </InputIcon>
                    <InputText class="w-full py-3" placeholder="Search" />
                </IconField>
            </div>
        </div>
    </header>
</template>
