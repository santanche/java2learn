package pt.c02oo.s12interface.s03poligono;

public class AppPoligonoInterface2 {

   public static void main(String[] args) {
      Retangular tr = new TrianguloRetangulo(60, 100);
      Retangular rt = new Retangulo(6, 10);

      System.out.println("Medidas do triangulo retângulo - altura: " +
         tr.getAltura() + "; largura: " + tr.getLargura());
      System.out.println("Medidas do retângulo - altura: " +
         rt.getAltura() + "; largura: " + rt.getLargura());
      
      if (tr.sameProportions(rt))
         System.out.println("Ambos têm as mesmas proporções");
      else
         System.out.println("Ambos têm proporções diferentes");
   }

}
