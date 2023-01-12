<template>
    <h1 @click="setPrueba()">{{prueba}}</h1>
    <h1>{{ catalogUser }}</h1>
    </template>

<script>
import { mapState, mapActions } from "pinia";
import { useUserStore } from "../stores/user.js";

export default {  
  
  computed: {    
     // gives read access to this.countries and this.anotherVar
    ...mapState(useUserStore, ['catalogUser','prueba'])
  },
  methods: {    
    // gives access to this.fetchAll()
    ...mapActions(useUserStore, ['fetchOne','setPrueba']),
  },
  async mounted() {
    // Use pinia store method    
    this.fetchOne();
    
    
  }
}
</script>