<script setup>
import { useUserDataStore } from '@/stores/UserDataStore';
import { ref } from 'vue';
import { onMounted } from 'vue';

const today = new Date();
const day = today.getDay();

const history = ref([]);
const userDataStore = useUserDataStore();

onMounted(async () => {
    history.value = await userDataStore.getUserExerciseHistory();
});
</script>
<template>
    <div class="w-full flex flex-col items-center p-3 gap-1 border rounded max-w-6xl">
        <div class="font-bold w-full max-w-2xl">현재 n일</div>
        <div
            class="py-1 overflow-x-auto w-full md:w-fit grid grid-flow-col grid-rows-7 grid-cols-[repeat(42,_1fr)] h-fit gap-1"
        >
            <div
                v-for="(_, index) in 294 - (6 - day)"
                :key="`static_${index}`"
                :style="`background-color: rgba(0, 0, ${history[293 - (6 - day) - index] ? 200 : 0},  ${0.1 + history[293 - (6 - day) - index] / 25})`"
                :class="` w-3 h-3 rounded-sm`"
            ></div>
        </div>
    </div>
</template>
