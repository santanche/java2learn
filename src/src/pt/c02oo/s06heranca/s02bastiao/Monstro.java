package pt.c02oo.s06heranca.s02bastiao;

public class Monstro extends Bastiao {
  private boolean irritado;
  
  public Monstro(int idade, String estado, String nome, boolean irritado) {
     super(idade, estado, nome);
     this.irritado = irritado;
  }
  
  public void cutuca() {
     if (irritado)
        System.out.println("Graur graurrrrr");
     else
        System.out.println("Hi hi hi");
  }
}
