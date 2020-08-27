package pt.c05concorrente.s08exercicios01.q02.s04;

public class AppChat04
{
    public static void main(String[] args)
    {
        Servidor oServidor = new Servidor();
        
        Chat doriana = new Chat("Doriana", oServidor, "personagem1.txt"),
             alcebiades = new Chat("Alcebiades", oServidor, "personagem2.txt");

        doriana.setOutro(alcebiades);
        alcebiades.setOutro(doriana);
        
        doriana.start();
        alcebiades.start();
    }
}
