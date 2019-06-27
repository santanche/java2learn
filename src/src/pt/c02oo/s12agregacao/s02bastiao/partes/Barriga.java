package pt.c02oo.s12agregacao.s02bastiao.partes;

public class Barriga
{
	private int idade;
	
    public Barriga(int idade)
    {
    	this.idade = idade;
    }
    
    public void aparece()
    {
        if (idade >= 3)
            System.out.println("*****");
    }
    
    public int getIdade()
    {
        return idade;
    }
    
    public void setIdade(int idade)
    {
        this.idade = idade;
    }
}
