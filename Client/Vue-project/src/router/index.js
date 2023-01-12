import { createRouter, createWebHistory } from "vue-router";

const routes = [
  {
    path: "/",
    name: "home",
    component: () => import("../views/Home.vue"),
  },
  {
    path: "/routines",
    name: "routines",
    component: () => import("../components/Routines.vue"),
    children: [{
      path: "/:routineId",
      name: "routinesDetails",
      component: () => import("../components/RoutineDetails.vue"),
    },],
  },
  {
    path: "/singUp",
    name: "singUp",
    component: () => import("../views/SingUp.vue"),
    children: [],
  },
  {
    path: "/login",
    name: "login",
    component: () => import("../views/Login.vue"),
    children: [{
      path: "/profile",
      name: "profile",
      component: () => import("../views/UserProfile.vue"),
    },],
  },
    
];

const router = createRouter({
  history: createWebHistory("/"),
  routes,
  scrollBehavior() {
    document.getElementById("app").scrollIntoView();
  },
});

export default router;
