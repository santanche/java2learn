package pt.c03java.s06wrapping.s01circulo;

public class Circulo {
   private int centroX, centroY;
   private int raio;
   
   Circulo(int centroX, int centroY, int raio) {
      this.centroX = centroX;
      this.centroY = centroY;
      this.raio = raio;
   }
   
   public int getCentroX() {
      return centroX;
   }
   
   public int getCentroY() {
      return centroY;
   }
   
   public double area() {
      return Math.PI * raio * raio;
   }
}
