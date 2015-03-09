package pt.c02oo.s12agregacao.s01bastiao.partes;

public class Topete
{
	public enum TipoTopete { PENTEADO, ESPALHADO, FINO }
	
	private TipoTopete tipo;
	
    public Topete(TipoTopete tipo)
    {
    	this.tipo = tipo;
    }
    
    public void aparece()
    {
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
