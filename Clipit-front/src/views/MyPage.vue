<script setup>
import AboutComponent from '@/components/myPage/AboutComponent.vue';
import StaticComponent from '@/components/myPage/StaticComponent.vue';
import VisitedPostComponent from '@/components/myPage/VisitedPostComponent.vue';
import PiChartComponent from '@/components/myPage/PiChartComponent.vue';
import RadarChartComponent from '@/components/myPage/RadarChartComponent.vue';
</script>
<template>
    <div class="w-full flex flex-col items-center max-w-4xl gap-3 px-4">
        <AboutComponent></AboutComponent>
        <StaticComponent></StaticComponent>
        <div class="w-full border p-5 flex justify-center gap-8 flex-wrap">
            <div>
                <div class="text-lg font-bold">부위별 운동 통계</div>
                <RadarChartComponent />
            </div>
            <div>
                <div class="text-lg font-bold">관심 부위 통계</div>
                <PiChartComponent />
            </div>
        </div>
        <VisitedPostComponent />
    </div>
</template>
