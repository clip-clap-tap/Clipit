<script setup>
// import { RouterLink } from 'vue-router';
defineProps({
    name: Object
});
</script>
<template>
    <RouterLink :to="{ name: 'search', query: { tag: name } }">
        <div class="cursor-pointer hover:bg-slate-100 rounded-md px-2 py-1">#{{ name.name }}</div>
    </RouterLink>
</template>
