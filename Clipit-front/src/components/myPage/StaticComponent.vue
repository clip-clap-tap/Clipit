<template>
    <div class="w-full flex flex-col items-center p-3 gap-1 border rounded max-w-6xl">
        <div class="font-bold w-full max-w-2xl">현재 n일</div>
        <div
            class="py-1 overflow-x-auto w-full md:w-fit grid grid-flow-col grid-rows-7 grid-cols-[repeat(42,_1fr)] h-fit gap-1"
        >
            <div
                v-for="(_, index) in 294 - (6 - day)"
                :key="`static_${index}`"
                :class="`${day == index % 7 ? 'bg-green-300' : 'bg-gray-300'} w-3 h-3 rounded-sm`"
            ></div>
        </div>
    </div>
</template>
<script setup>
const today = new Date();
// const date = today.getDate();
const day = today.getDay();
</script>
