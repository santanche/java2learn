package pt.c02oo.s02classe.s01circulo03;

public class AppCirculo03 {
  public static void main(String args[]) {
     Circulo circ = new Circulo();
     
     System.out.println("Circulo: centro(" + circ.centroX + ", " + circ.centroY + "), raio " + circ.raio);
     System.out.println("Area do circulo: " + circ.area());
  }
}
