<template>
  
  <div v-if="routine.title">
        <h1>{{ routine.title }}</h1>
            <ul class="list-style-none">
              <li v-for="(block, index) in routine.blocks" :key="index">
                <h2>{{ block.title }}</h2>
                <h3>{{ block.laps }}</h3>
                <ul class="list-style-none">
                  <li v-for="(exercise, index) in block.exercises" :key="index">
                    <div>
                      <p>{{ exercise.name }}</p>
                      <p>{{ exercise.reps }}</p>
                      <span>{{ exercise.description }}</span>
                      <a  class="btn btn-secondary" :href=" exercise.video " target="_blank" >See the video</a>
                    </div>
                  </li>
                </ul>
                
              </li>
            </ul>

  </div>
</template>
<script>
  import { mapState, mapStores, mapActions } from "pinia";
  import { useRoutinesStore } from "../stores/routines.js";

  export default {
    computed: {
      ...mapStores(useRoutinesStore),
      ...mapState(useRoutinesStore, ["routine"]),
    },
    methods: {
      ...mapActions(useRoutinesStore, ["fetchOne"]),
    },
    watch: {
      "$route.params.routineId": {
        async handler() {
          
          if (this.$route.params.routineId) {
            this.fetchOne(this.$route.params.routineId);
            
          }
        },
        immediate: true,
      },
    },
  };
</script>
<style></style>
