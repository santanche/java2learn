package pt.c06patterns.factory.s07zebatata.implementacao.asdrubal;

import java.net.URL;

import javax.swing.JComponent;

import lib.casa.casa.component.image.ResourceImageCollection;
import pt.c06patterns.factory.s07zebatata.produto.Olho;

public class OlhosAsdrubal implements Olho
{
    public static URL IMAGEM_OLHO_ESQUERDO = OlhosAsdrubal.class.getResource("olho-esquerdo-asdrubal.gif"),
                      IMAGEM_OLHO_DIREITO = OlhosAsdrubal.class.getResource("olho-direito-asdrubal.gif");
    
    private ResourceImageCollection imagemOlho = null;
	
	public OlhosAsdrubal(String esquerdoDireito)
    {
        if (esquerdoDireito.equalsIgnoreCase("esquerdo"))
            imagemOlho = new ResourceImageCollection(IMAGEM_OLHO_ESQUERDO, 1, 1);
        else
            imagemOlho = new ResourceImageCollection(IMAGEM_OLHO_DIREITO, 1, 1);
    }
	
	public JComponent getVisual()
    {
        return imagemOlho;   
    }
    
    
	public void abrir()
	{
		// TODO Auto-generated method stub

	}

	public void fechar()
	{
		// TODO Auto-generated method stub

	}

	public void piscar()
	{
		// TODO Auto-generated method stub

	}

	public void paraDireita()
	{
		// TODO Auto-generated method stub

	}

	public void paraEsquerda()
	{
		// TODO Auto-generated method stub

	}

}
