package pt.c02oo.s05encapsulamento.s01circulo;

public class AppCirculoEncapsula01 {
   public static void main(String args[]) {
      Circulo circ = new Circulo(5, 3, 10);
        
      System.out.println("Circulo: centro(" + circ.centroX + ", " + circ.centroY + "), raio " + circ.raio);
      System.out.println("Area do circulo: " + circ.area);
   }
}
