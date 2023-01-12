<template>
  <Navbar />
  <Background />
  <div class="conteiner">
    <form class="form">
      <div>
        <div class="col-md-6">
         <h2> ACCEDE A TU CUENTA
         </h2>
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
          Log in
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
      userName: "",
      password: "",
      user: {},
    };
  },
  methods: {
    ...mapActions(useUserStore, ["login"]),

    resetValues() {
      this.userName = "";
      this.password = "";
    },
    async getUser() {
      this.user = {
        userName: this.userName,
        password: this.password,
      };
      await this.login(this.user);
      this.resetValues();
      // if()
      this.$router.push({path:"/",replace:true})
    },
  },
  computed: {
    ...mapState(useUserStore, ["catalogUser"]),
  },
 
};
</script>

<style>
h2{
  font-weight: bold;
  font-style: normal;
  text-decoration: underline;
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
