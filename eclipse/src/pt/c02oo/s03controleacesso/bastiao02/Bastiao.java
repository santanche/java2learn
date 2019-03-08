package pt.c02oo.s03controleacesso.bastiao02;

public class Bastiao
{
    private int idade;
    private String estado;
    private String nome;
    
    public Bastiao(int idade, String estado, String nome)
    {
        this.idade = idade;
        this.estado = estado;
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
    
    public int getIdade()
    {
        return idade;
    }
    
    public void setIdade(int idade)
    {
        if (idade <= 3)
    	    this.idade = idade;
    }
    
    public String getEstado()
    {
        return estado;
    }
    
    public void setEstado(String estado)
    {
        this.estado = estado;
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
}
