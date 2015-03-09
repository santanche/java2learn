package pt.c02oo.s02classe.s01circulo03;

public class Circulo {
   int centroX, centroY;
   int raio;
   
   Circulo() {
      centroX = 5;
      centroY = 3;
      raio = 10;
   }
   
   double area() {
      return Math.PI * raio * raio;
   }
}
