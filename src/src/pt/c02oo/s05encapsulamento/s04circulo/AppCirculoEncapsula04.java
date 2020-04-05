package pt.c02oo.s05encapsulamento.s04circulo;

public class AppCirculoEncapsula04 {
  public static void main(String args[]) {
     Circulo circ = new Circulo(5, 3, 10);
     
     System.out.println("Circulo: centro(" + circ.getCentroX() + ", " + circ.getCentroY() + "), raio " + circ.getRaio());
     System.out.println("Area do circulo: " + circ.getArea());
  }
}
