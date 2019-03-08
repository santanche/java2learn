package pt.c04gui.s07eventopeixe.s03eventografico;

public class PeixeVisualTexto implements PeixeListener
{
    public void apresentaPeixe(int tamanho)
    {
    	switch (tamanho)
    	{
    	    case 1 : System.out.println(">"); break;
    	    case 2 : System.out.println(">>"); break;
    	    case 3 : System.out.println(">->"); break;
    	    case 4 : System.out.println(">0->");
    	}
    }
    
	
	public void novoTamanho(int tamanho)
	{
		apresentaPeixe(tamanho);
	}

}
