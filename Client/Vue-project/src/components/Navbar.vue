<template>
  <nav class="navbar-dark">
   <router-link to="/"><img class="logo" src="../assets/Logo.png" alt="Logo img" /></router-link> 

    <router-link class="navbar-brand" to="/"
      >My Personal Trainer App</router-link
    >

    <router-link class="routines" to="/routines">Routines</router-link>
    <router-link class="login" to="/login">Login</router-link>
    <router-link class="sing-up" to="/singUp">Sing Up</router-link>
  </nav>
</template>

<style>
.navbar-dark {
  position: relative;
  /* position: absolute; */
  width: 1520px;
  height: 60px;
  background: linear-gradient(180deg, #575151 0%, #150e0e 100%);
}
.logo {
  position: absolute;
  width: 70px;
  height: 60px;
  left: 0px;
  top: 0px;
}

.navbar-brand {
  position: absolute;
  width: 268px;
  height: 42px;
  left: 6%;
  top: 14px;
}
.routines {
  position: absolute;
  width: 80px;
  height: 42px;
  left: 1270px;
  top: 12px;

  font-family: "Mukta";
  font-size: 16px;
  line-height: 42px;
  color: #eae3e3;
  text-decoration: none;
}
.routines:hover{
    color:#868c8d; 
    text-decoration:none; 
    cursor:pointer;  
}

.login {
  position: absolute;
  width: 141px;
  height: 42px;
  left: 1370px;
  top: 12px;

  font-family: "Mukta";
  font-size: 16px;
  line-height: 42px;
  color: #eae3e3;
  text-decoration: none;
}
.login:hover{
    color:#868c8d; 
    text-decoration:none; 
    cursor:pointer;  
}
.sing-up {
  position: absolute;
  width: 141px;
  height: 42px;
  left: 1445px;
  top: 12px;

  font-family: "Mukta";
  font-size: 16px;
  line-height: 42px;
  color: #eae3e3;
  text-decoration: none;
}
.sing-up:hover{
    color:#868c8d; 
    text-decoration:none; 
    cursor:pointer;  
}

</style>
