package pt.c02oo.s05encapsulamento.s04circulo;

public class Circulo {
   private int centroX, centroY;
   private int raio;
   
   public Circulo(int centroX, int centroY, int raio) {
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

   public int getRaio() {
      return raio;
   }

   public double getArea() {
      return Math.PI * raio * raio;
   }
}
