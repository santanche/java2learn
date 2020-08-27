package pt.c02oo.s04estatica.s02chat;

public class Chat {
   /* Parte Estática
    ****************/
   
   static int contador = 0;
   
   static int proximoContador() {
      contador++;
      return contador;
   }
   
   /* Parte Instância
    *****************/
   
   String nome;
   
   Chat(String nome) {
      this.nome = nome;
   }
   
   void mensagem(String msg) {
      System.out.println(nome + "[" + proximoContador() + "]: " + msg);
   }
}
