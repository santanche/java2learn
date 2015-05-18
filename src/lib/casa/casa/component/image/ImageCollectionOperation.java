package lib.casa.casa.component.image;

import java.net.URL;

import lib.casa.casa.component.CasaOperation;

public class ImageCollectionOperation extends CasaOperation
{
    public ImageCollectionOperation()
    {
        super();
    }

    public ImageCollectionOperation(boolean isVisual)
    {
        super(isVisual);
    }

    public ImageCollectionOperation(URL source, int numberLines, int numberColumns)
    {
        super(false);
        setVisual(new ImageCollectionComponent(
                  source, numberLines, numberColumns));
    }
}