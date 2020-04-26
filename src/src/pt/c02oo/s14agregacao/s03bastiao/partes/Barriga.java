package pt.c02oo.s12agregacao.s03bastiao.partes;

import pt.c02oo.s12agregacao.s03bastiao.Bastiao;

public class Barriga implements Parte
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
    
    public void mudaCaracteristica(String caracteristica,
                                   String valor)
    {
        /* nada */
    }
}
