package pt.c02oo.s12agregacao.s02bastiao.partes;

import pt.c02oo.s12agregacao.s02bastiao.Bastiao;

public class Topete
{
	public enum TipoTopete { PENTEADO, ESPALHADO, FINO }
	
	private TipoTopete tipo;

	private Bastiao pai;
	
    public Topete(TipoTopete tipo, Bastiao pai)
    {
    	this.tipo = tipo;
    	this.pai = pai;
    }
    
    public void aparece()
    {
    	if (pai.getIdade() >= 2)
            switch (tipo) {
        	    case PENTEADO  : System.out.println("  ="); break;
        	    case ESPALHADO : System.out.println("  *"); break;
        	    case FINO      : System.out.println("  |"); break;
        	}
    }
    
    public void mudaTopete(TipoTopete tipo)
    {
        this.tipo = tipo;
    }
}
