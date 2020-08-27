package pt.c02oo.s03relacionamento.s03agregacao;

public class ConjuntoEmprestimos {
   Emprestimo vEmprestimos[];
   int corrente = -1;
   
   ConjuntoEmprestimos(int quantidade) {
      vEmprestimos = new Emprestimo[quantidade];
   }
   
   boolean adicionaEmprestimo(Emprestimo emp) {
      boolean resultado = false;
      if (corrente+1 < vEmprestimos.length) {
         corrente++;
         vEmprestimos[corrente] = emp;
         resultado = true;
      }
      return resultado;
   }
   
   boolean proximasParcelas() {
      boolean status = false;
      for (int e = 0; e < vEmprestimos.length; e++) {
         float p = vEmprestimos[e].proximaParcela();
         if (p > 0) {
            status = true;
            System.out.println("Emprestimo " + (e+1) + ": " + p);
         }
      }
      return status;
   }
}
