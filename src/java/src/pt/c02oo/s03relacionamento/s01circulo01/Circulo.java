package pt.c02oo.s03relacionamento.s01circulo01;

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
