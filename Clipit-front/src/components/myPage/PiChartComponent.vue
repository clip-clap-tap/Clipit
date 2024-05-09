<template>
    <div class="w-1/3 h-1/2">
        <Pie id="my-chart-id" :options="chartOptions" :data="chartData" />
    </div>
</template>

<script>
import { Pie } from 'vue-chartjs';
import { Chart as ChartJS, Title, Tooltip, Legend, ArcElement, Colors } from 'chart.js';

ChartJS.register(Title, Tooltip, Legend, ArcElement, Colors);

export default {
    name: 'PieChart',
    components: { Pie },
    data() {
        return {
            chartData: {
                labels: ['January', 'February', 'March'],
                backgroundColor: ['rgb(255, 99, 132)', 'rgb(54, 162, 235)', 'rgb(255, 205, 86)'],
                datasets: [{ data: [40, 20, 12] }]
            },
            chartOptions: {
                responsive: true
            }
        };
    }
};
</script>
