<script setup>
import NavbarComponent from '@/components/Layout/NavbarComponent.vue';
import FooterComponent from '@/components/Layout/FooterComponent.vue';
</script>
<script>
export default {
    name: 'App'
};
</script>
<template>
    <NavbarComponent></NavbarComponent>
    <div class="w-screen justify-center flex">
        <div class="container min-h-[70vh] justify-center flex">
            <RouterView></RouterView>
        </div>
    </div>

    <FooterComponent></FooterComponent>
</template>
