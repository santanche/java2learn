package pt.c02oo.s10polimorfismo.s02poligono;

public class AppPoligonoPoli {

   public static void main(String[] args) {
      Poligono tr = new TrianguloRetangulo(6, 10);
      Poligono rt = new Retangulo(6, 10);

      System.out.println("Área do triangulo retângulo: " + tr.getArea());
      System.out.println("Área do retângulo: " + rt.getArea());
   }

}
