package pt.c02oo.s02classe.s01circulo02;

public class AppCirculo02 {
  public static void main(String args[]) {
     Circulo circ = new Circulo();
     circ.centroX = 5;
     circ.centroY = 3;
     circ.raio = 10;
     
     System.out.println("Circulo: centro(" + circ.centroX + ", " + circ.centroY + "), raio " + circ.raio);
     System.out.println("Area do circulo: " + circ.area());
  }
}
