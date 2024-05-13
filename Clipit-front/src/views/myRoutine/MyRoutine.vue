<script setup>
import Button from 'primevue/button';
</script>
<template>
    <div class="w-full flex flex-col items-center max-w-4xl gap-3">
        <RouterLink :to="{ name: `newPost` }"><Button>추가</Button></RouterLink
        >my routines
    </div>
</template>
