package pt.c02oo.s02classe.s01circulo04;

public class AppCirculo04 {
  public static void main(String args[]) {
     Circulo circ = new Circulo(5, 3, 10);
     
     System.out.println("Circulo: centro(" + circ.centroX + ", " + circ.centroY + "), raio " + circ.raio);
     System.out.println("Area do circulo: " + circ.area());
  }
}
