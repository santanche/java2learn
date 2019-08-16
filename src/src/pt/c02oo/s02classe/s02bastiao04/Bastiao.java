package pt.c02oo.s02classe.s02bastiao04;

public class Bastiao
{
    int idade;
    static String estado;
    String nome;
    
    public Bastiao(int idade, String estado, String nome)
    {
        this.idade = idade;
        Bastiao.estado = estado;
        this.nome = nome;
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
        
        System.out.println(nome);
        
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
