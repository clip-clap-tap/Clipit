<template>
    <div class="max-w-xl">
        <canvas ref="MyChart">hello</canvas>
    </div>
</template>

<script>
import axios from 'axios';
import { Chart, registerables } from 'chart.js';
import { useCookies } from 'vue3-cookies';
Chart.register(...registerables);

export default {
    data: () => ({
        type: 'pie',
        data: {
            labels: ['목', '등', '팔', '다리', '가슴', '배', '허리'],
            datasets: [
                {
                    label: '',
                    data: [12, 19, 3, 5, 2, 3],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }
            ]
        },
        options: {
            layout: {
                padding: 20
            },
            plugins: {
                legend: {
                    position: 'right'
                }
            }
        }
    }),

    mounted() {
        this.createChart();
    },
    methods: {
        async createChart() {
            const { cookies } = useCookies();
            const REST_URL = import.meta.env.VITE_REST_API_URL;
            const stRawData = (
                await axios.get(`${REST_URL}/users/${cookies.get('user')}/post-statistics`)
            ).data;
            if (Object.values(stRawData).length == 0) {
                const ctx = this.$refs.MyChart.getContext('2d');
                ctx.font = '16px sans-serif';
                ctx.textAlign = 'center';
                ctx.fillText(
                    '데이터가 존재하지 않습니다.',
                    this.$refs.MyChart.width / 2,
                    this.$refs.MyChart.height / 2
                );
                return;
            }
            new Chart(this.$refs.MyChart, {
                type: 'pie',
                data: {
                    labels: ['목', '등', '팔', '다리', '가슴', '복근', '허리'],
                    datasets: [
                        {
                            label: '',
                            data: [
                                stRawData.neck,
                                stRawData.back,
                                stRawData.arm,
                                stRawData.leg,
                                stRawData.chest,
                                stRawData.abs,
                                stRawData.waist
                            ],
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(120, 159, 64, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(120, 159, 64, 0.2)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1
                        }
                    ]
                },
                options: this.options
            });
        }
    }
};
</script>

<style></style>
