package pt.c02oo.s10polimorfismo.s01emprestimo;

public class App2DoisEmprestimosPoli {
   public static void main(String[] args) {
      Emprestimo empST = new Emprestimo(200, 5, 1);
      Emprestimo empCT = new EmprestimoTA(200, 5, 1, 15);
      
      int i = 1;
      float pst = empST.proximaParcela();
      float pct = empCT.proximaParcela();
      while (pst > 0 || pct > 0) {
         if (pst > 0)
            System.out.println("Emprestimo sem taxa: parcela " + i + " eh " + pst);
         if (pct > 0)
            System.out.println("Emprestimo com taxa: parcela " + i + " eh " + pct);
         pst = empST.proximaParcela();
         pct = empCT.proximaParcela();
         i++;
      }
   }
}
