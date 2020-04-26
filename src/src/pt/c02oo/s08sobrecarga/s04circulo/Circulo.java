package pt.c02oo.s08sobrecarga.s04circulo;

public class Circulo {
   int centroX, centroY;
   int raio;
   
   Circulo() {
      this(5, 3, 10);
   }

   Circulo(int centroX, int centroY, int raio) {
      this.centroX = centroX;
      this.centroY = centroY;
      this.raio = raio;
   }
   
   double area() {
      return Math.PI * raio * raio;
   }
}
