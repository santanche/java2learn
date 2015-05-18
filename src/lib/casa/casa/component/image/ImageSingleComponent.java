package lib.casa.casa.component.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.PixelGrabber;
import java.net.URL;

import lib.casa.anima.message.AnimaInterfaceExtended;
import lib.casa.anima.message.Message;
import lib.casa.anima.message.MessageOrdered;
import lib.casa.anima.message.MessageSingle;
import lib.casa.casa.component.CasaComponent;
import lib.casa.casa.util.ImageLoader;

public class ImageSingleComponent extends CasaComponent
                                  implements ImageComponent
{
  protected Image theImage = null;

  public ImageSingleComponent()
  {
    super();
  }

  public ImageSingleComponent(Image theImage)
  {
    this();
    setImage(theImage);
  }

  public ImageSingleComponent(URL resource)
  {
    this();
    setResource(resource);
  }

  public void setImage(Image theImage)
  {
    this.theImage = theImage;
    ImageLoader.prepareImage(theImage);
    if (theImage != null)
      setSize(theImage.getWidth(null), theImage.getHeight(null));
    repaint();
  }

  public Image getImage()
  {
    return theImage;
  }
  
  public int getPixel(int x, int y)
  {
      int gp = 0;
      if (theImage != null)
      {
          int[] pixels = new int[1];
          PixelGrabber pg = new PixelGrabber(theImage, x, y, 1, 1, pixels, 0, 1);
          try {
              pg.grabPixels();
              if ((pg.getStatus() & ImageObserver.ABORT) != 0) {
                  System.err.println("image fetch aborted or errored");
               }
          } catch (InterruptedException e) {
              System.err.println("interrupted waiting for pixels!");
          }
          
          int red   = (pixels[0] >> 16) & 0xff,
              green = (pixels[0] >>  8) & 0xff,
              blue  = (pixels[0]      ) & 0xff;
          gp = (red + green + blue) / 3;
          System.out.println("x:" + x + "; y:" + y + ";gp:" + gp);
      }
      return gp;
  }
  
  public void setResource(URL resource)
  {
    setImage(Toolkit.getDefaultToolkit().createImage(resource));
  }
  
  public boolean ready()
  {
    return (theImage != null);
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    if (theImage != null)
      g.drawImage(theImage, 0, 0, this);
    else {
      g.setColor(new Color((int)(Math.random() * 256), (int)(Math.random() * 256),
                           (int)(Math.random() * 256)));
      g.fillRect(0, 0, getWidth(), getHeight());
    }
  }

  /*
   * Anima Messages
   */

  public boolean localMessage(Message theMessage)
  {
    boolean found = super.localMessage(theMessage);

    if (theMessage instanceof MessageOrdered)
    {
      String mess = theMessage.getLabel();
      switch (Character.toLowerCase(mess.charAt(0)))
      {
        case 'g' : if (mess.equalsIgnoreCase("getPixel")) {
                     if (theMessage.getSource() instanceof AnimaInterfaceExtended)
                     {
                         Object params[] = ((MessageOrdered)theMessage).getParameters();
                         if (params != null && params.length <= 2 &&
                                 params[0] instanceof Integer && params[1] instanceof Integer) {
                             int x = ((Integer)params[0]).intValue(),
                                 y = ((Integer)params[1]).intValue();
                             int pixel = getPixel(x, y);
                             ((AnimaInterfaceExtended)theMessage.getSource()).localMessage(
                                     new MessageSingle("getPixel", new Integer(pixel), this));
                         }
                     }
                     found = true;
                   }
                   break;
      }
    }
    
    return found;
  }

  /*
  protected void prepare()
  {
    MediaTracker tracker = new MediaTracker(this);
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
  */
}
