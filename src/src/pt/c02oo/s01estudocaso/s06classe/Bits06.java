package pt.c02oo.s01estudocaso.s06classe;

public class Bits06
{
    public static void main(String args[])
    {
        Bits06Classe.inicializa();
        for (int bits = 1; bits <= 8; bits++)
            System.out.println(bits + " = " +
                               Bits06Classe.proximoNumeroCombinacoes());
    }
}
