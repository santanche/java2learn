package pt.c02oo.s12interface.s05poligono;

public class AppPoligonoInterface4 {

   public static void main(String[] args) {
      GeometriaRetangular rt = new Retangulo(6, 10);

      System.out.println("Medidas do retângulo - altura: " +
            rt.getAltura() + "; largura: " + rt.getLargura());
      System.out.println("Perímetro do retângulo: " + rt.getPerimetro());
      System.out.println("Área do retângulo: " + rt.getArea());

      Geometria ci = new Circulo(8);

      System.out.println("Perímetro do círculo: " + ci.getPerimetro());
      System.out.println("Área do círculo: " + ci.getArea());

      Retangular tr = new TrianguloRetangulo(60, 100);

      System.out.println("Medidas do triangulo retângulo - altura: " +
         tr.getAltura() + "; largura: " + tr.getLargura());
      
      if (tr.sameProportions(rt))
         System.out.println("Retângulo e triângulo retângulo têm as mesmas proporções");
      else
         System.out.println("Retângulo e triângulo retângulo têm proporções diferentes");   
   }

}
