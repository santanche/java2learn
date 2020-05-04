package pt.c02oo.s10polimorfismo.s02poligono;

public class Poligono {
   private int altura;
   private int largura;

   
   public Poligono(int altura, int largura) {
       this.altura = altura;
       this.largura = largura;
   }
   
   public int getAltura() {
       return altura;
   }
   
   public int getLargura() {
       return largura;
   }
   
   public float getArea() {
       return 0;
   }
}