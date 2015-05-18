/*
 * Created on 27/08/2005
 *
 */
package lib.casa.casa.component.image;

import java.net.URL;

import lib.casa.casa.component.CasaOperation;

/**
 * @author André Santanchè
 *
 */
public class ImageSingleOperation extends CasaOperation
{
    public ImageSingleOperation()
    {
      super();
    }

    public ImageSingleOperation(boolean isVisual)
    {
      super(isVisual);
    }

    public ImageSingleOperation(URL source)
    {
      super(false);
      setVisual(new ImageSingleComponent(source));
    }

}
