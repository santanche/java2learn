package pt.c02oo.s12interface.s03poligono;

public class Retangulo implements Geometria, Retangular {
   private int altura;
   private int largura;

   public Retangulo(int altura, int largura) {
       this.altura = altura;
       this.largura = largura;
   }
   
   public int getAltura() {
       return altura;
   }
   
   public int getLargura() {
       return largura;
   }
   
   public float getPerimetro() {
       return 2 * (altura + largura);
   }
   
   public float getArea() {
       return altura * largura;
   }
   
   public boolean sameProportions(Retangular toCompare) {
      return (largura / altura == toCompare.getLargura() / toCompare.getLargura());
   }
}
