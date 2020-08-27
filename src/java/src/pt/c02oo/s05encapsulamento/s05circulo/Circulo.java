package pt.c02oo.s05encapsulamento.s05circulo;

public class Circulo {
   private int centroX = 0,
               centroY = 0;
   private int raio = 1;
   
   public int getCentroX() {
      return centroX;
   }

   public void setCentroX(int centroX) {
      this.centroX = centroX;
   }

   public int getCentroY() {
      return centroY;
   }

   public void setCentroY(int centroY) {
      this.centroY = centroY;
   }

   public int getRaio() {
      return raio;
   }

   public void setRaio(int raio) {
      if (raio > 0)
         this.raio = raio;
   }

   public double getArea() {
      return Math.PI * raio * raio;
   }
}
