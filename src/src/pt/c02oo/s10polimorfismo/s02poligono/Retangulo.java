package pt.c02oo.s10polimorfismo.s02poligono;

public class Retangulo extends Poligono {
   public Retangulo(int altura, int largura) {
       super(altura, largura);
   }
   
   public float getArea() {
       return getAltura() * getLargura();
   }
}