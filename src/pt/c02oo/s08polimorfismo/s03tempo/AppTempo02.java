package pt.c02oo.s08polimorfismo.s03tempo;

public class AppTempo02
{
  public static void main(String argumentos[])
  {
    Tempo oTempo = null,
          oTempo2 = null;

    if (argumentos.length < 4)
      System.out.println ("Digite opcao: data ou horario e os respectivos valores");
    else {
      int p1 = Integer.parseInt(argumentos[1]),
          p2 = Integer.parseInt(argumentos[2]),
          p3 = Integer.parseInt(argumentos[3]);

      int p5 = Integer.parseInt(argumentos[5]),
          p6 = Integer.parseInt(argumentos[6]),
          p7 = Integer.parseInt(argumentos[7]);

      if (argumentos[0].equalsIgnoreCase("data"))
        oTempo = new Data(p1, p2, p3);
      else if (argumentos[0].equalsIgnoreCase("horario"))
        oTempo = new Horario(p1, p2, p3);

      if (argumentos[4].equalsIgnoreCase("data"))
        oTempo2 = new Data(p5, p6, p7);
      else if (argumentos[4].equalsIgnoreCase("horario"))
        oTempo2 = new Horario(p5, p6, p7);

      if (oTempo == null)
        System.out.println("Digite: data ou horario");
      else {
        System.out.println("Tempo 1: " + oTempo);
        System.out.println("Em segundos: " + oTempo.quantidade());
        System.out.println("Tempo 2: " + oTempo2);
        System.out.println("Em segundos: " + oTempo2.quantidade());
        System.out.println("Diferenca: " + oTempo.diferenca(oTempo2));
      }
    }
  }
}
