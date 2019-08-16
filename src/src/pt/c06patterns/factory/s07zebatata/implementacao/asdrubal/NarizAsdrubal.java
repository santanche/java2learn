package pt.c06patterns.factory.s07zebatata.implementacao.asdrubal;

import java.net.URL;

import javax.swing.JComponent;

import lib.casa.casa.component.image.ResourceImageCollection;
import pt.c06patterns.factory.s07zebatata.produto.Nariz;

public class NarizAsdrubal implements Nariz
{
    public static URL IMAGEM_NARIZ = NarizAsdrubal.class.getResource("nariz-asdrubal.gif");
    
    private ResourceImageCollection imagemNariz = null;
    
    public NarizAsdrubal()
    {
        imagemNariz = new ResourceImageCollection(IMAGEM_NARIZ, 1, 1);
    }
    
    public JComponent getVisual()
    {
        return imagemNariz;
    }

}
