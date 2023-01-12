<template>
    <Navbar />
    <Background />
    <div class="conteiner">
      <form class="form">
        <div>
            <div class="col-md-6">
                <h2>CREA TU CUENTA</h2>
            </div>
          <div class="col-md-6">
            <label for="first-name" class="form-label" id="first-name"
              >First name</label
            >
            <input
              v-model="firstName"
              type="text"
              class="form-control"
              placeholder="First name"
            />
          </div>
          <div class="col-md-6">
            <label for="last-name" class="form-label" id="last-name"
              >Last name</label
            >
            <input
              v-model="lastName"
              type="text"
              class="form-control"
              placeholder="Last name"
            />
          </div>
  
          <div class="col-md-6">
            <label for="input-email" class="form-label">Email</label>
            <input
              v-model="userName"
              type="email"
              class="form-control"
              placeholder="Email"
              id="input-email"
            />
          </div>
          <div class="col-md-6">
            <label for="input-password" class="form-label">Password</label>
            <input
              v-model="password"
              type="password"
              class="form-control"
              id="input-password"
              placeholder="Password"
            />
          </div>
          <br />
          <button
            @click.prevent="getUser()"
            type="button"
            class="btn btn-dark btn-lg"
          >
            Sing Up
          </button>
        </div>
      </form>
    </div>
    <FooterComponent class="footer" />
  </template>
  
  <script>
  import { mapState, mapActions } from "pinia";
  import { useUserStore } from "../stores/user";
  import Navbar from "../components/Navbar.vue";
  import FooterComponent from "../components/FooterComponent.vue";
  import Background from "../components/Background.vue";
  
  export default {
    components: { Navbar, FooterComponent, Background },
    data() {
      return {
        firstName: "",
        lastName: "",
        userName: "",
        password: "",
        user: {},
      };
    },
    methods: {
      ...mapActions(useUserStore, [ "singUp"]),
  
      resetValues() {
        this.firstName = "";
        this.lastName = "";
        this.userName = "";
        this.password = "";
      },
      async getUser() {
        this.user = {
          userName: this.userName,
          password: this.password,
          name: this.firstName + " " + this.lastName,
          dateOfBirth: "22/12/1993",
        };
        await this.singUp(this.user);
        this.resetValues();
      },
    },
    computed: {
      ...mapState(useUserStore, ["catalogUser"]),
    },
    
  };
  </script>
  
  <style>
  h2{
    font-style: normal;
    font-weight: bold;
    text-decoration:underline;
  }
  label {
    color: rgb(33, 32, 32);
    font-weight: bold;
  }
  .conteiner {
   
    padding-left: 35%;
    padding-top: 10%;
    
  }
  
  .footer {
    position: absolute;
    margin-top: 650px;
  }
  </style>
  