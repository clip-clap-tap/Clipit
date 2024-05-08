<script setup>
import IconField from 'primevue/iconfield';
import InputIcon from 'primevue/inputicon';
import InputText from 'primevue/inputtext';
</script>
<template>
    <header class="h-[28rem] bg-gray-50">
        <div class="container mx-auto px-4 flex h-full py-6 items-center">
            <div class="max-w-xl">
                <h2 class="text-3xl xl:text-4xl font-bold mt-4 text-gray-800 capitalize">
                    All Resurece You Need to grow
                </h2>
                <p class="text-gray-500 mt-4 text-lg">
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Soluta error odit vel
                    minima optio consequuntur atque omnis, repellendus eos, rerum totam quas vitae
                    voluptatibus, facere distinctio fugit? Nam, iure expedita!
                </p>
                <IconField iconPosition="left" class="mt-4">
                    <InputIcon class="pi pi-search"> </InputIcon>
                    <InputText placeholder="Search" />
                </IconField>
            </div>
        </div>
    </header>
</template>
