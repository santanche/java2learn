package pt.c02oo.s02classe.s02bastiao05;

public class BastiaoEstatico
{
    static int idade;
    static String estado;
    static String nome;
    
    public static void inicializa(int idade, String estado, String nome)
    {
        BastiaoEstatico.idade = idade;
        BastiaoEstatico.estado = estado;
        BastiaoEstatico.nome = nome;
    }
    
    public static void aparece()
    {
        // cabeleira
        if (idade >= 2)
            System.out.println("  *");
        
        // corpo com olhos
        if (estado.equalsIgnoreCase("acordado"))
            System.out.println(" o*o");
        else
            System.out.println(" -*-");
        
        // barba
        if (idade >= 3)
            System.out.println("*****");
        
        System.out.println(nome);
        
        System.out.println();
    }
    
    public static void cresce()
    {
        if (idade < 3)
            idade++;
        aparece();
    }
    
    public static void acorda()
    {
        estado = "acordado";
        aparece();
    }
    
    public static void dorme()
    {
        estado = "dormindo";
        aparece();
    }
}
