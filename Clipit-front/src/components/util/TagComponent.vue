<template>
    <div class="cursor-pointer hover:bg-slate-100 rounded-md px-2 py-1">#{{ name }}</div>
</template>
<script setup>
defineProps({
    name: String
});
</script>
