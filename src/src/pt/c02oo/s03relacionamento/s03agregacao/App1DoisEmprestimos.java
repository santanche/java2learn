package pt.c02oo.s03relacionamento.s03agregacao;

public class App1DoisEmprestimos {
   public static void main(String[] args) {
      Emprestimo emprestimoA = new Emprestimo(200, 5, 1),
                 emprestimoB = new Emprestimo(500, 7, 2);
      
      int i = 1;
      float pA = emprestimoA.proximaParcela();
      float pB = emprestimoB.proximaParcela();
      while (pA > 0 || pB > 0) {
         if (pA > 0)
            System.out.println("Emprestimo A: parcela " + i + " eh " + pA);
         if (pB > 0)
            System.out.println("Emprestimo B: parcela " + i + " eh " + pB);
         pA = emprestimoA.proximaParcela();
         pB = emprestimoB.proximaParcela();
         i++;
      }
   }
}
