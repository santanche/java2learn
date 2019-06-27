package pt.c05concorrente.s08exercicios01.q02.s03;

public class AppChat03
{
    public static void main(String[] args)
    {
        Servidor oServidor = new Servidor();
        
        Chat doriana = new Chat("Doriana", oServidor),
             alcebiades = new Chat("Alcebiades", oServidor);

        doriana.setOutro(alcebiades);
        alcebiades.setOutro(doriana);
        
        doriana.start();
        alcebiades.start();
    }
}
