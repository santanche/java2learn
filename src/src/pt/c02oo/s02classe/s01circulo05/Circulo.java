package pt.c02oo.s02classe.s01circulo05;

public class Circulo {
   int centroX, centroY;
   int raio;
   
   Circulo(int centroX, int centroY, int raio) {
      this.centroX = centroX;
      this.centroY = centroY;
      this.raio = raio;
   }
   
   double area() {
      return Math.PI * raio * raio;
   }
}
