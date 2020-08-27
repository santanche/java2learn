package pt.c02oo.s11abstrata.s02poligono;

public abstract class Poligono {
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
   
   public abstract float getArea();
}