package pt.c02oo.s12interface.s02poligono;

public class Retangulo implements Geometria {
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
}
