package pt.c02oo.s03relacionamento.s03agregacao;

public class App3ConjuntoEmprestimos {
   public static void main(String[] args) {
      ConjuntoEmprestimos ce = new ConjuntoEmprestimos(5); 
      
      ce.adicionaEmprestimo(new Emprestimo(200, 3, 1));
      ce.adicionaEmprestimo(new Emprestimo(500, 4, 2));
      ce.adicionaEmprestimo(new Emprestimo(300, 2, 1));
      ce.adicionaEmprestimo(new Emprestimo(450, 3, 2));
      ce.adicionaEmprestimo(new Emprestimo(700, 2, 3));

      boolean status;
      do {
         status = ce.proximasParcelas();
      } while (status);
   }
}
