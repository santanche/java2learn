package pt.c06patterns.factory.s08zebatata.implementacao.doriana;

import java.net.URL;

import javax.swing.JComponent;

import lib.casa.casa.component.image.ResourceImageCollection;
import pt.c06patterns.factory.s08zebatata.produto.Olho;

public class OlhosDoriana implements Olho
{
    public static URL IMAGEM_OLHO_ESQUERDO = OlhosDoriana.class.getResource("olho-esquerdo-doriana.gif"),
                      IMAGEM_OLHO_DIREITO = OlhosDoriana.class.getResource("olho-direito-doriana.gif");
    
    private ResourceImageCollection imagemOlho = null;
	
	public OlhosDoriana(String esquerdoDireito)
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
