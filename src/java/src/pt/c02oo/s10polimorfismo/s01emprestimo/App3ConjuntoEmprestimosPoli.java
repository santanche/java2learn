package pt.c02oo.s10polimorfismo.s01emprestimo;

public class App3ConjuntoEmprestimosPoli {
   public static void main(String[] args) {
      ConjuntoEmprestimos ce = new ConjuntoEmprestimos(5); 
      
      ce.adicionaEmprestimo(new Emprestimo(200, 3, 1));
      ce.adicionaEmprestimo(new EmprestimoTA(500, 4, 2, 15));
      ce.adicionaEmprestimo(new Emprestimo(300, 2, 1));
      ce.adicionaEmprestimo(new Emprestimo(450, 3, 2));
      ce.adicionaEmprestimo(new EmprestimoTA(700, 2, 3, 10));

      boolean status;
      do {
         status = ce.proximasParcelas();
      } while (status);
   }
}
