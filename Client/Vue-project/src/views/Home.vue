<template>
    <Navbar/>
    <Background/>
    <div class="conteiner">
        <h1>EMPIEZA HOY!</h1> 
        <img  class="rectangle" src="../assets/Rectangle 1.png"/>
        <img class="check-1" src="../assets/check-svgrepo-com.svg"/>
        <h2 class="h-1">RUTINAS PARA TODO TIPO DE OBJETIVOS</h2>
        <img class="check-2" src="../assets/check-svgrepo-com.svg"/>
        <h2 class="h-2">VIDEOS EXPLICATIVOS</h2>
        <img class="check-3" src="../assets/check-svgrepo-com.svg"/>
        <h2 class="h-3">SERVICIO PERSONALIZADO PARA USUARIOS PREMIUM</h2>
      
    </div>
    <FooterComponent/>
</template>
<script>
import Navbar from '../components/Navbar.vue';
import FooterComponent from '../components/FooterComponent.vue';
import Background from '../components/Background.vue';


export default {
  components: { Navbar, FooterComponent, Background}
}  
</script>

<style>

h1{
position: absolute;
width: 563px;
height: 88px;
left: 170px;
top: 180px;

font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
font-style: normal;
font-weight: 900;
font-size: 70px;
line-height: 88px;

display: flex;
align-items: center;
background: linear-gradient(180deg, #d2c7c7 0%, #3a3939 100%);
-webkit-background-clip: text;
-webkit-text-fill-color: transparent;
background-clip: text;
}
.rectangle{
position: absolute;
width: 730px;
height: 350px;
left: 120px;
top: 300px;
background: rgba(87, 81, 81, 0.8);
border-radius: 20px;
border: #2c2b2b solid;
}
.check-1{
position: absolute;
width: 40px;
height: 40px;
left: 160px;
top: 360px;
}
.check-2{
    position: absolute;
width: 40px;
height: 40px;
left: 160px;
top: 460px;
}
.check-3{
    position: absolute;
width: 40px;
height: 40px;
left: 160px;
top: 560px;
}
.h-1{
position: absolute;
width: 491px;
height: 29px;
left: 200px;
top: 365px;
font-weight: 500;
font-size: 24px;
line-height: 29px;


display: flex;
align-items: center;
text-align: center;

color: #000000;
}
.h-2{
    position: absolute;
width: 491px;
height: 29px;
left: 200px;
top: 465px;
font-weight: 500;
font-size: 24px;
line-height: 29px;


display: flex;
align-items: center;
text-align: center;

color: #000000;
}
.h-3{
 position: absolute;
width: 700px;
height: 29px;
left: 200px;
top: 565px;
font-weight: 500;
font-size: 24px;
line-height: 29px;


display: flex;
align-items: center;
text-align: center;

color: #000000;
}
</style>