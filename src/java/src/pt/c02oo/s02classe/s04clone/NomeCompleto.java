package pt.c02oo.s02classe.s04clone;

public class NomeCompleto {
   private String nome, sobrenome;
   
   public NomeCompleto(String nome, String sobrenome) {
      this.nome = nome;
      this.sobrenome = sobrenome;
   }

   public String getNome() {
      return nome;
   }
   
   public void setNome(String nome) {
      this.nome = nome;
   }
   
   public String getSobrenome() {
      return sobrenome;
   }
   
   public void setSobrenome(String sobrenome) {
      this.sobrenome = sobrenome;
   }
   
   public String toString() {
      return nome + " " + sobrenome;
   }
   
   public NomeCompleto clone() {
      return new NomeCompleto(nome, sobrenome);
   }
}
