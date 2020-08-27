package pt.c03java.s06wrapping.s01circulo;

public class AppCirculoWrapping {
  public static void main(String args[]) {
     int raio = 10;
     
     Circulo circ = new Circulo(5, 3, raio);
     
     System.out.println("Circulo: centro(" +
        circ.getCentroX() + ", " + circ.getCentroY() + ")");
     System.out.println("Area do circulo: " + circ.area());
  }
}
