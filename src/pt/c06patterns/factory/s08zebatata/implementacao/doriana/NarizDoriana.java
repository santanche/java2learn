package pt.c06patterns.factory.s08zebatata.implementacao.doriana;

import java.net.URL;

import javax.swing.JComponent;

import lib.casa.casa.component.image.ResourceImageCollection;
import pt.c06patterns.factory.s08zebatata.produto.Nariz;

public class NarizDoriana implements Nariz
{
    public static URL IMAGEM_NARIZ = NarizDoriana.class.getResource("nariz-doriana.gif");
    
    private ResourceImageCollection imagemNariz = null;
    
    public NarizDoriana()
    {
        imagemNariz = new ResourceImageCollection(IMAGEM_NARIZ, 1, 1);
    }
    
    public JComponent getVisual()
    {
        return imagemNariz;
    }

}
