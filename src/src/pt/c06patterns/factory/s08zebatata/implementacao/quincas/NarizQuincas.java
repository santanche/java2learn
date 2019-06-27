package pt.c06patterns.factory.s08zebatata.implementacao.quincas;

import java.net.URL;

import javax.swing.JComponent;

import lib.casa.casa.component.image.ResourceImageCollection;
import pt.c06patterns.factory.s08zebatata.produto.Nariz;

public class NarizQuincas implements Nariz
{
    public static URL IMAGEM_NARIZ = NarizQuincas.class.getResource("nariz-quincas.gif");
    
    private ResourceImageCollection imagemNariz = null;
    
    public NarizQuincas()
    {
        imagemNariz = new ResourceImageCollection(IMAGEM_NARIZ, 1, 1);
    }
    
    public JComponent getVisual()
    {
        return imagemNariz;
    }

}
