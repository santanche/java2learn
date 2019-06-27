package pt.c02oo.s08polimorfismo.s03tempo;

public class Tempo
{
  public long quantidade()
  {
    return 0;
  }

  public String toString()
  {
    return "";
  }

  public long diferenca(Tempo externo)
  {
    return quantidade() - externo.quantidade();
  }
}
