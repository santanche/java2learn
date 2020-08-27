package pt.c02oo.s05encapsulamento.s02circulo;

public class Circulo {
   private int centroX, centroY;
   private int raio;
   
   public Circulo(int centroX, int centroY, int raio) {
      this.centroX = centroX;
      this.centroY = centroY;
      this.raio = raio;
   }
   
   public double area() {
      return Math.PI * raio * raio;
   }
}
