package pt.c06patterns.factory.s07zebatata.implementacao.doriana;

import java.net.URL;

import javax.swing.JComponent;

import lib.casa.casa.component.image.ResourceImageCollection;
import pt.c06patterns.factory.s07zebatata.produto.Boca;

public class BocaDoriana implements Boca
{
    public static URL IMAGEM_BOCA = BocaDoriana.class.getResource("boca-doriana.gif");
    
    private ResourceImageCollection imagemBoca = null;
    
    public BocaDoriana()
    {
        imagemBoca = new ResourceImageCollection(IMAGEM_BOCA, 1, 1);
    }
    
    public JComponent getVisual()
    {
        return imagemBoca;
    }

    public void abre()
    {
        // TODO Auto-generated method stub

    }

    public void fecha()
    {
        // TODO Auto-generated method stub

    }

}
