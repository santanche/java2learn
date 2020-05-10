package pt.c02oo.s12interface.s03poligono;

public class Circulo implements Geometria {
   public static float PI = 3.1416f;
   
   private int raio;
   
   public Circulo(int raio) {
       this.raio = raio;
   }
   
   public int getRaio() {
       return raio;
   }
   
   public float getPerimetro() {
       return 2 * Circulo.PI * raio;
   }
   
   public float getArea() {
       return Circulo.PI * raio * raio;
   }
}