<template>
 <Navbar/>
 <Background/>
  <div class="container">    
    <h1 v-if="!routines.length">Loading routines</h1>
    <div v-else class="row">        
      <div class="col-5" style="max-height: 90vh; overflow: scroll">
        <div class="list-group">
          <router-link v-for="(routine, index) in routines" :key="index" class="list-group-item list-group-item-action d-flex flex-column justify-content-center align-items-center" :to="`/${routine.id}`">
            <p class="m-0">{{ routine.title }}</p>
          </router-link>
        </div>
      </div>
      <div class="col-7">
        <router-view />
      </div>
    </div>
  </div>  
  <FooterComponent class="footer"/>
</template>
<script>
import Navbar from "./Navbar.vue";
import FooterComponent from "./FooterComponent.vue";
import Background from "./Background.vue";

import { mapState, mapActions } from "pinia";
import { useRoutinesStore } from "../stores/routines.js";

export default {  
  components: { Navbar, FooterComponent, Background },
  computed: {    
    
    ...mapState(useRoutinesStore, ['routines', 'routine'])
  },
  methods: {    
    
    ...mapActions(useRoutinesStore, ['fetchAll']),
  },
  async mounted() {
        
    this.fetchAll();
    
  }
}
</script>

<style>
/* .conteiner{
    width: 100%;
    min-height: 1000px
  
} */


</style>