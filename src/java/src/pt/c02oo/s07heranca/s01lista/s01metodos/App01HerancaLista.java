package pt.c02oo.s07heranca.s01lista.s01metodos;

public class App01HerancaLista {

   public static void main(String[] args) {
      ListaEstatistica le = new ListaEstatistica();
      le.adicionar(10);
      le.adicionar(20);
      le.adicionar(5);
      le.adicionar(35);
      le.adicionar(15);
      System.out.println("Soma: " + le.soma());
      System.out.println("Media: " + le.media());

      ListaUtil lu = new ListaUtil();
      lu.adicionar(10);
      lu.adicionar(20);
      lu.adicionar(5);
      lu.adicionar(35);
      lu.adicionar(15);
      lu.ordena();
      System.out.println("Ordenado: " + lu);
      
   }

}
