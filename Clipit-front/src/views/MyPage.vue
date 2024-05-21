<script setup>
import AboutComponent from '@/components/myPage/AboutComponent.vue';
import StaticComponent from '@/components/myPage/StaticComponent.vue';
import VisitedPostComponent from '@/components/myPage/VisitedPostComponent.vue';
</script>
<template>
    <div class="w-full flex flex-col items-center max-w-4xl gap-3">
        <AboutComponent></AboutComponent>
        <StaticComponent></StaticComponent>
        <VisitedPostComponent />
    </div>
</template>
