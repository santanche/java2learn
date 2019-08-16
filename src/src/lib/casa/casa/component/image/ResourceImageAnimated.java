/*
 * Created on 07/04/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package lib.casa.casa.component.image;

import java.awt.Image;
import java.net.URL;

import lib.casa.anima.util.IOUtil;
import lib.casa.casa.util.ImageCollectionLoader;
import lib.casa.casa.util.ImageCollectionProducer;

public class ResourceImageAnimated extends ResourceImageCollection
{
    public static final String
        BASIC_ANIMATION = ResourceImageAnimated.class.getResource("dinosaur.gif").toString();
    
    private URL scheduledLoad = null;
    
    public ResourceImageAnimated()
    {
      super(IOUtil.findURLWithoutException(BASIC_ANIMATION), true);
    }

    public void setResource(URL resource)
    {
      if (completedLoad) {
        completedLoad = false;
        ImageCollectionLoader icl =
          new ImageCollectionLoader(resource, this, !waitCompleteLoad);
        this.resource = resource;
      } else
          scheduledLoad = resource;
    }

    public void imageCollectionReady(ImageCollectionProducer producer,
                                     Image imageCollection[])
    {
        super.imageCollectionReady(producer, imageCollection);
        if (scheduledLoad != null) {
            setResource(scheduledLoad);
            scheduledLoad = null;
        }
    }
}
