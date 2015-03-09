package pt.c02oo.s01estudocaso.s07objeto;

public class Bits07
{
    public static void main(String args[])
    {
        Bits07Instancia objeto;
        objeto = new Bits07Instancia();
        
        for (int bits = 1; bits <= 8; bits++)
            System.out.println(bits + " = " +
                               objeto.proximoNumeroCombinacoes());
    }
}
