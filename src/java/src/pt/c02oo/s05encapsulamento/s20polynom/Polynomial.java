package pt.c02oo.s05encapsulamento.s20polynom;

public class Polynomial {
   private TermoB termos[];
   private int n = 0;
   private int x;
   
   public int getN() {
      return n;
   }

   public void setN(int n) {
      this.n = n;
   }

   public int getX() {
      return x;
   }

   public void setX(int x) {
      this.x = x;
   }
   
   public void addTermo(TermoB t) {
      if (n+1 < termos.length) {
         termos[n] = t;
         n++;
      }
   }

   public Polynomial() {
      termos = new TermoB[20];
   }
   
   public Polynomial clone() {
      Polynomial cln = new Polynomial();
      
      int kAnt = 0;
      int aTemp = 0;
      for (int t = 0; t < termos.length && termos[t] != null; t++) {
         if (termos[t].getK() == kAnt || kAnt == 0)
            aTemp += termos[t].getA();
         else {
            cln.addTermo(new TermoB(aTemp, kAnt));
            aTemp = termos[t].getA(); 
         }
         kAnt = termos[t].getK();
      }
      cln.addTermo(new TermoB(aTemp, kAnt));
      
      return cln;
   }
}
