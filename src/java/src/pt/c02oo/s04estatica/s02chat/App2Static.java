package pt.c02oo.s04estatica.s02chat;

public class App2Static {

   public static void main(String[] args) {
      Chat doriana = new Chat("Doriana"),
           quincas = new Chat("Quincas"),
           melissa = new Chat("Melissa");
      
      doriana.mensagem("Quem aqui gosta de dinossauros?");
      quincas.mensagem("Eu gosto!");
      melissa.mensagem("Dinossauros? Por que dinossauros?");
      doriana.mensagem("Deixa de ser chata Melissa, você gosta ou não gosta?");
      melissa.mensagem("Ainda não entendi por que dinossauros.");
   }

}
