package pt.c03java.s06anotacao.s03dao;

@MapTabela("TABIND")
public class Individuo2 {
  @MapCampoChave(campo="NAME",chavePrimaria=true)
  public String nome;
  
  @MapCampoChave(campo="AGE",chavePrimaria=false)
  public int idade;

  @MapCampoChave(campo="MARRIED",chavePrimaria=false)
  public boolean casado;
}
