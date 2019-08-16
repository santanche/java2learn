package pt.c02oo.s08polimorfismo.s04tempo;

public class AppTempo03
{
    public static void main(String[] args)
    {
        Tempo listaTempo[] = new Tempo[4];
        
        listaTempo[0] = new Data(5, 12, 2008);
        listaTempo[1] = new Horario(15, 05, 00);
        listaTempo[2] = new Horario(17, 12, 20);
        listaTempo[3] = new Data(25, 03, 2005);
        
        System.out.println("*** toString polimorfico");
        for (int l = 0; l < listaTempo.length; l++)
            System.out.println(listaTempo[l].toString());

        System.out.println("\n*** toString polimorfico implicito");
        for (int l = 0; l < listaTempo.length; l++)
            System.out.println(listaTempo[l]);
    }
}
