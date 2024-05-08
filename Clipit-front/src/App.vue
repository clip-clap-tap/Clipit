<script setup>
import HeaderComponent from '@/components/Layout/HeaderComponent.vue';
import NavbarComponent from '@/components/Layout/NavbarComponent.vue';
import FooterComponent from '@/components/Layout/FooterComponent.vue';
</script>
<script>
export default {
    name: 'App',
    components: {
        HeaderComponent
    }
};
</script>
<template>
    <NavbarComponent></NavbarComponent>
    <HeaderComponent></HeaderComponent>

    <div class="container mx-auto px-4 py-16 max-w-7xl justify-center flex">
        <RouterView></RouterView>
    </div>

    <FooterComponent></FooterComponent>
</template>
