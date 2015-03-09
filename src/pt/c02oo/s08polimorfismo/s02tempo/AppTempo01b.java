package pt.c02oo.s08polimorfismo.s02tempo;

public class AppTempo01b
{
    public static void main(String argumentos[])
    {
        Tempo oTempo = null;

        if (argumentos.length < 4)
            System.out.println ("Argumentos: tempo/data/horario e os respectivos valores");
        else {
            int p1 = Integer.parseInt(argumentos[1]),
                p2 = Integer.parseInt(argumentos[2]),
                p3 = Integer.parseInt(argumentos[3]);

            if (argumentos[0].equalsIgnoreCase("tempo"))
                oTempo = new Tempo();
            else if (argumentos[0].equalsIgnoreCase("data"))
                oTempo = new Data(p1, p2, p3);
            else if (argumentos[0].equalsIgnoreCase("horario"))
                oTempo = new Horario(p1, p2, p3);

            dadosTempo(oTempo);
        }
    }

    public static void dadosTempo(Tempo oTempo)
    {
        if (oTempo == null)
            System.out.println("Tipo inexistente");
        else {
            System.out.println("Tempo formatado: " +
                               oTempo.toString());
            
            System.out.println("Tempo em segundos: " +
                               oTempo.quantidade());
        }
    }
}
