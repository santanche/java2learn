package pt.c02oo.s12interface.s04poligono;

public class AppPoligonoInterface3 {

   public static void main(String[] args) {
      Retangular rt = new Retangulo(6, 10);
      Retangular tr = new TrianguloRetangulo(60, 100);

      System.out.println("Medidas do retângulo - altura: " +
         rt.getAltura() + "; largura: " + rt.getLargura());
      System.out.println("Medidas do triangulo retângulo - altura: " +
         tr.getAltura() + "; largura: " + tr.getLargura());
         
      System.out.println("Perímetro do retângulo: " + rt.getPerimetro());
      System.out.println("Área do retângulo: " + rt.getArea());

      System.out.println("Perímetro do triângulo retângulo: " + tr.getPerimetro());
      System.out.println("Área do triângulo retângulo: " + tr.getArea());

      if (tr.sameProportions(rt))
         System.out.println("Ambos têm as mesmas proporções");
      else
         System.out.println("Ambos têm proporções diferentes");
   }

}
