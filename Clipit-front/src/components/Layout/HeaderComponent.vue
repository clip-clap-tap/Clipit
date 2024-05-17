<script setup>
import IconField from 'primevue/iconfield';
import InputIcon from 'primevue/inputicon';
import InputText from 'primevue/inputtext';
import Accordion from 'primevue/accordion';
import AccordionTab from 'primevue/accordiontab';
import { ref } from 'vue'

const category = ref(null)

const toggle=(value)=>{
    if (category.value === value) {
            category.value = null; 
        } else {
            category.value = value;
        }
}

</script>
<template>
    <header class="h-[28rem] bg-gray-50 w-screen">
        <div class="px-4 flex h-full py-6 items-center">
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

                    <Accordion class="mt-8 w-full max-w-2xl" expandIcon="none" collapseIcon="none">
                        <AccordionTab>
                            <template #header>
                                <IconField iconPosition="left" class="w-full max-w-2xl" >
                                    <InputIcon class="pi pi-search"> </InputIcon>
                                    <InputText class="w-full py-3" placeholder="Search" />
                                </IconField>
                            </template>
    
                            <div class="flex gap-3 my-8 md:my-12 flex-wrap justify-around px-4 md:px-8">
                                <Button label="Info" severity="secondary" rounded @click="toggle('title')">제목</Button>
                                <Button label="Info" severity="secondary" rounded @click="toggle('content')">내용</Button>
                                <Button label="Info" severity="secondary" rounded @click="toggle('writer')">작성자</Button>
                                <Button label="Info" severity="secondary" rounded @click="toggle('video_title')">영상제목</Button>
                            </div>
                        </AccordionTab>
                    </Accordion>
               
<!-- 
                <IconField iconPosition="left" class="mt-8 w-full max-w-2xl" >
                    <InputIcon class="pi pi-search"> </InputIcon>
                    <InputText class="w-full py-3" placeholder="Search" />
                </IconField> -->
            </div>
        </div>
    </header>
</template>
