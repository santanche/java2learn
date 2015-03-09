package pt.c05concorrente.s08exercicios01.q02.s01;

public class AppChat01
{
    public static void main(String[] args)
    {
        Chat doriana = new Chat("Doriana"),
             alcebiades = new Chat("Alcebiades");

        doriana.setOutro(alcebiades);
        alcebiades.setOutro(doriana);
        
        doriana.start();
        alcebiades.start();
    }
}
