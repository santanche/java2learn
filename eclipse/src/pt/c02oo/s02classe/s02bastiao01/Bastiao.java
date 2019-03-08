package pt.c02oo.s02classe.s02bastiao01;

public class Bastiao
{
    int idade;
    String estado;
    
    public Bastiao()
    {
        idade = 1;
        estado = "acordado";
    }
    
    public void aparece()
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
    }
}
