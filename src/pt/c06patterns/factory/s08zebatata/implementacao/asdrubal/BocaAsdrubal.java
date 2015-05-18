package pt.c06patterns.factory.s08zebatata.implementacao.asdrubal;


import java.net.URL;

import javax.swing.JComponent;

import lib.casa.casa.component.image.ResourceImageCollection;
import pt.c06patterns.factory.s08zebatata.produto.Boca;

public class BocaAsdrubal implements Boca
{
    public static URL IMAGEM_BOCA = BocaAsdrubal.class.getResource("boca-asdrubal.gif");
    
    private ResourceImageCollection imagemBoca = null;
    
    public BocaAsdrubal()
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
