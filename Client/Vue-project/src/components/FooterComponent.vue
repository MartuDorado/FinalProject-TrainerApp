<template>
  <div class="footer">
    <router-link class="about-us" to="/">About Us</router-link>
  
    <p class="contact">contacto@email.com</p>
  </div>
</template>

<style>
.footer {
 
  position: absolute;
  margin-top: 1100px;
  width: 100%;
  height: 50px;
  background: linear-gradient(180deg, #575151 0%, #150e0e 100%);
}
.about-us {
  position: absolute;
  width: 164px;
  height: 42px;
  left: 102px;
  top: auto;;
  font-family: "Mukta";
  line-height: 42px;
  text-decoration: none;
  color: #eae3e3;
}
.about-us:hover{
    color:#868c8d; 
    text-decoration:none; 
    cursor:pointer;  
}

.contact {
  position: absolute;
  width: 228px;
  height: 42px;
  left: 1114px;
  top: auto;
  font-family: "Mukta";
  line-height: 42px;
  color: #eae3e3;
}

</style>
