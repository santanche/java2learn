package pt.c02oo.s08sobrecarga.s06circulo;

public class AppCirculoSobrecarga02 {
   public static void main(String args[]) {
      Circulo circ1 = new Circulo(), 
              circ2 = new Circulo(4, 2, 8);
        
      System.out.println("Circulo: centro(" + circ1.centroX + ", " +
                         circ1.centroY + "), raio " + circ1.raio);
      System.out.println("Area do circulo: " + circ1.area());
      System.out.println("Circulo: centro(" + circ2.centroX + ", " +
                         circ2.centroY + "), raio " + circ2.raio);
      System.out.println("Area do circulo: " + circ2.area());
   }
}
