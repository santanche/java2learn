package pt.c02oo.s04sobrecarga;

public class Bastiao
{
    private int idade;
    private String estado;
    private String nome;
    
    public Bastiao()
    {
        this.idade = 1;
        this.estado = "acordado";
        this.nome = "<sem nome>";
    }
    
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
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public void setIdade(String idade) {
       if (idade.equalsIgnoreCase("pequeno"))
         this.idade = 1;
       else if (idade.equalsIgnoreCase("medio"))
          this.idade = 2;
       else if (idade.equalsIgnoreCase("grande"))
          this.idade = 3;
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
