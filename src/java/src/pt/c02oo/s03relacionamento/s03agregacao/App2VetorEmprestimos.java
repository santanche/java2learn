package pt.c02oo.s03relacionamento.s03agregacao;

public class App2VetorEmprestimos {
   public static void main(String[] args) {
      Emprestimo vEmprestimos[];
      vEmprestimos = new Emprestimo[5];
      
      vEmprestimos[0] = new Emprestimo(200, 3, 1);
      vEmprestimos[1] = new Emprestimo(500, 4, 2);
      vEmprestimos[2] = new Emprestimo(300, 2, 1);
      vEmprestimos[3] = new Emprestimo(450, 3, 2);
      vEmprestimos[4] = new Emprestimo(700, 2, 3);

      int i = 1;
      boolean temParcela = true;
      while (temParcela) {
         temParcela = false;
         for (int e = 0; e < 5; e++) {
            float p = vEmprestimos[e].proximaParcela();
            if (p > 0) {
               temParcela = true;
               System.out.println("Emprestimo " + e + ": parcela " + i + " eh " + p);
            }
         }
         i++;
      }
   }
}
