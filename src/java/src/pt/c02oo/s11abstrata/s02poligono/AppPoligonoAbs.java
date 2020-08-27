package pt.c02oo.s11abstrata.s02poligono;

public class AppPoligonoAbs {

   public static void main(String[] args) {
      Poligono tr = new TrianguloRetangulo(6, 10);
      Poligono rt = new Retangulo(6, 10);

      System.out.println("Área do triangulo retângulo: " + tr.getArea());
      System.out.println("Área do retângulo: " + rt.getArea());
   }

}
