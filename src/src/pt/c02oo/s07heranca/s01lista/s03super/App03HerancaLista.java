package pt.c02oo.s07heranca.s01lista.s03super;

public class App03HerancaLista {

   public static void main(String[] args) {
      ListaEstatistica le = new ListaEstatistica();
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
