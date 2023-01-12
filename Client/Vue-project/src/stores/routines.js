import { defineStore } from "pinia";

export const useRoutinesStore = defineStore("routines", {
    state: () => ({
      routines: [],
      routine: {},
      
    }),

    actions: {
      async fetchAll() {
        const response = await fetch(`http://127.0.0.1:8082/catalog/routines`)
        const routinesFetch = await response.json()
        this.routines = routinesFetch
      },

       async fetchOne(routineId) {
         const response = await fetch(`http://127.0.0.1:8082/catalog/routines/${routineId}`);
         const routineFetch = await response.json();
         this.routine = routineFetch;        
       },
    },
  });