<script setup>
defineProps({
    visible: Boolean
});
</script>

<template>
    <div v-if="visible" class="fixed top-0 left-0 w-screen h-screen bg-black/10"></div>
    <div class="card flex justify-center relative">
        <Dialog :visible="visible" header="Edit Profile" class="w-fit py-8 px-5">
            <template #container>
                <div class="absolute right-1 top-1"><slot name="closeBtn"></slot></div>
                <div class="flex align-items-center gap-3">
                    <slot name="content"></slot>
                </div>
            </template>
        </Dialog>
    </div>
</template>
