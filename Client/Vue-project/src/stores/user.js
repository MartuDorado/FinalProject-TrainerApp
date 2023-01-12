import { defineStore } from "pinia";
export const useUserStore = defineStore("user", {
  state: () => ({
    catalogUser: {},
    userName:"",
    
  }),
  actions: {
    async login(user) {
      this.userName = user.userName;
        const response = await fetch(
        `http://127.0.0.1:8082/catalog/${this.userName}`
      );
      const userFetch = await response.json();
      this.catalogUser = userFetch;
    },

    async singUp(user){
    this.catalogUser = user;
    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(this.catalogUser),
    };
    fetch("http://127.0.0.1:8082/catalog", requestOptions)
      
    },
    // async login(user) {
    //   this.catalogUser = user;
    //   const requestOptions = {
    //     method: "POST",
    //     headers: { "Content-Type": "application/json" },
    //     body: JSON.stringify(this.catalogUser),
    //   };
    //   fetch("http://127.0.0.1:8082/catalog", requestOptions)
    //    // .then((response) => response.json())
    //   // .then((data) => (this.catalogUser = data));
    // },
    
  },
});
