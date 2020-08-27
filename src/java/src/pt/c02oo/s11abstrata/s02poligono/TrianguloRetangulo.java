package pt.c02oo.s11abstrata.s02poligono;

public class TrianguloRetangulo extends Poligono {
   public TrianguloRetangulo(int altura, int largura) {
       super(altura, largura);
   }
   
   public float getArea() {
       return getAltura() * getLargura() / 2;
   }
}