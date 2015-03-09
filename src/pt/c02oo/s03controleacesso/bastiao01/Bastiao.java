package pt.c02oo.s03controleacesso.bastiao01;

public class Bastiao
{
    private int idade;
    private String estado;
    private String nome;
    
    public Bastiao(int pIdade, String pEstado, String pNome)
    {
        idade = pIdade;
        estado = pEstado;
        nome = pNome;
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
