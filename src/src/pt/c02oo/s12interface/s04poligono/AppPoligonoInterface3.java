package pt.c02oo.s12interface.s04poligono;

public class AppPoligonoInterface3 {

   public static void main(String[] args) {
      Geometria g = new Retangulo(6, 10);

      System.out.println("Perímetro do retângulo: " + g.getPerimetro());
      System.out.println("Área do retângulo: " + g.getArea());

      g = new Circulo(8);

      System.out.println("Perímetro do círculo: " + g.getPerimetro());
      System.out.println("Área do círculo: " + g.getArea());
   }

}
