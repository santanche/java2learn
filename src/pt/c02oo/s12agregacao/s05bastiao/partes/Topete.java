package pt.c02oo.s12agregacao.s05bastiao.partes;

import pt.c02oo.s12agregacao.s05bastiao.Bastiao;

public class Topete implements ParteCustomizavel
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
    
    public void mudaCaracteristica(String caracteristica,
                                   String valor)
    {
        if (caracteristica.equalsIgnoreCase("topete"))
        {
            if (valor.equalsIgnoreCase("penteado"))
                mudaTopete(TipoTopete.PENTEADO);
            else if (valor.equalsIgnoreCase("espalhado"))
                mudaTopete(TipoTopete.ESPALHADO);
            else if (valor.equalsIgnoreCase("fino"))
                mudaTopete(TipoTopete.FINO);
        }
    }
}
