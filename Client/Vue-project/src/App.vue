<template>
  
  <div class="app">
<!--     
    <Navbar />
    <Background></Background> -->
     <router-view />   
    <!-- <FooterComponent/>     -->
  </div>
</template>

<script>
import Navbar from './components/Navbar.vue';

import FooterComponent from './components/FooterComponent.vue';
import Background from './components/Background.vue';


export default {
  components: { Navbar, FooterComponent, Background }
}
</script>
<style>

</style>