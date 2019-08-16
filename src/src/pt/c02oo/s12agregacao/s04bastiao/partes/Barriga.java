package pt.c02oo.s12agregacao.s04bastiao.partes;

import pt.c02oo.s12agregacao.s04bastiao.Bastiao;

public class Barriga extends Parte
{
	private Bastiao pai;
	
    public Barriga(Bastiao pai)
    {
    	this.pai = pai;
    }
    
    public void aparece()
    {
        if (pai.getIdade() >= 3)
            System.out.println("*****");
    }
}
