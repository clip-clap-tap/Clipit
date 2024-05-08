<script setup>
import PostCardComponent from '@/components/PostCardComponent.vue';
</script>
<script>
export default {
    name: 'TestPage',
    components: {
        PostCardComponent
    }
};
</script>
<template>
    <div class="flex flex-col gap-2 max-w-5xl">
        <PostCardComponent
            v-for="(item, index) in [1, 2, 3, 4]"
            :key="index"
            :img="`https://images.unsplash.com/photo-1624996379697-f01d168b1a52?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80`"
            :tag="`Article`"
            :title="`What do you want to know about UI`"
            :description="`Lorem ipsum dolor sit amet consectetur adipisicing elit. Nam est asperiores vel, ab animi recusandae nulla veritatis id tempore sapiente`"
            :writer="`John snow`"
            :date="`February 1, 2022`"
        ></PostCardComponent>
        <!-- <PostCardComponent></PostCardComponent> -->
        <!-- <PostCardComponent></PostCardComponent> -->
    </div>
</template>
