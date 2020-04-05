package pt.c02oo.s05encapsulamento.s03circulo;

public class AppCirculoEncapsula03 {
   public static void main(String args[]) {
      Circulo circ = new Circulo();
      circ.setCentroX(5);
      circ.setCentroY(3);
      circ.setRaio(10);
        
      System.out.println("Circulo: centro(" + circ.getCentroX() + ", " + circ.getCentroY() + "), raio " + circ.getRaio());
      System.out.println("Area do circulo: " + circ.getArea());
   }
}
