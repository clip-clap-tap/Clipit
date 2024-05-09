<script setup>
import AboutComponent from '@/components/myPage/AboutComponent.vue';
import PiChartComponent from '@/components/myPage/PiChartComponent.vue';
import StaticComponent from '@/components/myPage/StaticComponent.vue';
</script>
<template>
    <div class="w-full flex flex-col items-center max-w-4xl">
        <AboutComponent></AboutComponent>
        <StaticComponent></StaticComponent>
        <PiChartComponent></PiChartComponent>
    </div>
</template>
