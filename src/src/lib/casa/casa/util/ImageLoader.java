package lib.casa.casa.util;

import java.awt.Component;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;

public class ImageLoader
{
  protected static final Component component = new Component() {};
  protected static final MediaTracker tracker = new MediaTracker(component);

  public static Image loadImage(URL source)
  {
    Image theImage = Toolkit.getDefaultToolkit().createImage(source);
    prepareImage(theImage);
    return theImage;
  }

  public static void prepareImage(Image theImage)
  {
    synchronized(tracker)
    {
      tracker.addImage(theImage, 0);
      try {
        tracker.waitForID(0, 0);
      } catch (InterruptedException e) {
        System.out.println("INTERRUPTED while loading Image");
      }
      tracker.removeImage(theImage, 0);
    }
  }
}