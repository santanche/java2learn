package pt.c02oo.s02classe.s02bastiao02;

public class Bastiao
{
    int idade;
    String estado;
    
    public Bastiao(int idade, String estado)
    {
        this.idade = idade;
        this.estado = estado;
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
        
        System.out.println();
    }
    
    public void cresce()
    {
        if (idade < 3)
            idade++;
        aparece();
    }
    
    public void acorda()
    {
        estado = "acordado";
        aparece();
    }
    
    public void dorme()
    {
        estado = "dormindo";
        aparece();
    }
}
