package pt.c02oo.s07heranca.s01lista.s04construtor;

public class App04HerancaLista {

   public static void main(String[] args) {
      ListaUtil lu = new ListaUtil(10, false);
      lu.adicionar(10);
      lu.adicionar(5);
      lu.adicionar(20);
      lu.adicionar(5);
      lu.adicionar(35);
      lu.adicionar(35);
      lu.adicionar(15);
      lu.adicionar(10);
      lu.adicionar(35);
      lu.ordena();
      System.out.println("Ordenado: " + lu);
      
      ListaEstatistica le = new ListaEstatistica(5);
      le.adicionar(10);
      le.adicionar(20);
      le.adicionar(5);
      le.adicionar(35);
      le.adicionar(15);
      System.out.println("Soma: " + le.soma());
      System.out.println("Media: " + le.media());
      System.out.println("Maior: " + le.maior());
   }

}
