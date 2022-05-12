package pt.c02oo.s05encapsulamento.s20polynom;

public class TermoA {
   private static int x;
   private int a, k;
   
   public static int getX() {
      return x;
   }
   public static void setX(int x) {
      TermoA.x = x;
   }
   
   public TermoA(int a, int k) {
      this.a = a;
      this.k = k;
   }
   
   public int getA() {
      return a;
   }
   public void setA(int a) {
      this.a = a;
   }
   
   public int getK() {
      return k;
   }
   public void setK(int k) {
      this.k = k;
   }
}
