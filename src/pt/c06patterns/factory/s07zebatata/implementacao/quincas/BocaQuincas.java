package pt.c06patterns.factory.s07zebatata.implementacao.quincas;

import java.net.URL;

import javax.swing.JComponent;

import lib.casa.casa.component.image.ResourceImageCollection;
import pt.c06patterns.factory.s07zebatata.produto.Boca;

public class BocaQuincas implements Boca
{
    public static URL IMAGEM_BOCA = BocaQuincas.class.getResource("boca-quincas.gif");
    
    private ResourceImageCollection imagemBoca = null;
    
    public BocaQuincas()
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
