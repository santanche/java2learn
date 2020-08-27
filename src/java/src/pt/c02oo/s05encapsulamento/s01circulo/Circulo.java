package pt.c02oo.s05encapsulamento.s01circulo;

public class Circulo {
   int centroX, centroY;
   int raio;
   double area;
   
   Circulo(int centroX, int centroY, int raio) {
      this.centroX = centroX;
      this.centroY = centroY;
      this.raio = raio;
      this.area = Math.PI * raio * raio;
   }
}
