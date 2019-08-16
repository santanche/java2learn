package pt.c02oo.s02classe.s01circulo04;

public class Circulo {
   int centroX, centroY;
   int raio;
   
   Circulo(int pCentroX, int pCentroY, int pRaio) {
      centroX = pCentroX;
      centroY = pCentroY;
      raio = pRaio;
   }
   
   double area() {
      return Math.PI * raio * raio;
   }
}
