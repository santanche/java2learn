package lib.casa.casa.component.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.net.URL;

import lib.casa.anima.message.Message;
import lib.casa.casa.component.CasaComponent;
import lib.casa.casa.util.ImageCollectionLoader;
import lib.casa.casa.util.ImageCollectionObserver;
import lib.casa.casa.util.ImageCollectionProducer;
import lib.casa.casa.util.ImageCollectionUtil;
import lib.casa.casa.util.ImageLoader;

public class ImageCollectionComponent extends CasaComponent
                                      implements ImageComponent,
                                                 ImageCollectionObserver
{
  protected Image imageCollection[] = null;

  protected int current = 0;

  public ImageCollectionComponent()
  {
    super();
  }

  public ImageCollectionComponent(Image imageCollection[])
  {
    this();
    this.imageCollection = imageCollection;
    prepare();
  }

  public ImageCollectionComponent(URL source)
  {
    this(source, true);
  }

  public ImageCollectionComponent(URL source, boolean waitCompleteLoad)
  {
    this();
    ImageCollectionLoader icl =
      new ImageCollectionLoader(source, this, !waitCompleteLoad);
  }

  public ImageCollectionComponent(URL source, int numberLines, int numberColumns)
  {
    this();
    Image strip = ImageLoader.loadImage(source);
    imageCollection =
      ImageCollectionUtil.mountStripFrames(strip, numberLines, numberColumns);
  }
  
  public void setImageSet(Image imageCollection[])
  {
    this.imageCollection = imageCollection;
    current = 0;
    prepare();
    repaint();
  }

  public Image[] getImageSet()
  {
    return imageCollection;
  }

  public Image getImage(int frame)
  {
    return (imageCollection != null && frame < imageCollection.length) ?
             imageCollection[frame] : null;
  }

  public int getTotalFrames()
  {
    return (imageCollection == null) ? 0 : imageCollection.length;
  }

  public void setCurrent(int current)
  {
    if (imageCollection != null && current < imageCollection.length) {
      this.current = current;
      repaint();
    }
  }

  public int getCurrent()
  {
    return current;
  }

  public void first()
  {
    current = 0;
    if (imageCollection != null)
      repaint();
  }

  public void next()
  {
    next(true);
  }

  public void next(boolean loop)
  {
    if (imageCollection != null) {
      current = (current + 1 < imageCollection.length) ?
                  current + 1 : ((loop) ? 0 : current);
      repaint();
    }
  }

  public void previous()
  {
    previous(true);
  }

  public void previous(boolean loop)
  {
    if (imageCollection != null) {
      current = (current > 0) ?
                  current - 1 : ((loop) ? imageCollection.length - 1 : current);
      repaint();
    }
  }

  public void last()
  {
    if (imageCollection != null) {
      current = imageCollection.length - 1;
      repaint();
    }
  }

  public boolean ready()
  {
    return (imageCollection != null);
  }

  public void imageFrameReady(ImageCollectionProducer producer,
                              Image frame, int sequenceNumber)
  {
    current = 0;
    imageCollection = new Image[1];
    imageCollection[0] = frame;
    repaint();
  }

  public void imageCollectionReady(ImageCollectionProducer producer,
                                   Image imageCollection[])
  {
    current = 0;
    this.imageCollection = imageCollection;
    if (imageCollection != null)
      System.out.println("Numero de frames: " + imageCollection.length);
    repaint();
  }

  public void paintComponent(Graphics g)
  {
      super.paintComponent(g);
      if (imageCollection != null && imageCollection[current] != null) {
          int x = (getWidth() - imageCollection[current].getWidth(null)) / 2;
          x = (x < 0) ? 0 : x;
          int y = (getHeight() - imageCollection[current].getHeight(null)) / 2;
          y = (y < 0) ? 0 : y;
          g.drawImage(imageCollection[current], x, y, this);
      } else {
          g.setColor(new Color((int)(Math.random() * 256), (int)(Math.random() * 256),
                  (int)(Math.random() * 256)));
          g.fillRect(0, 0, getWidth(), getHeight());
      }
  }

  protected void prepare()
  {
    MediaTracker tracker = new MediaTracker(this);
    synchronized(tracker)
    {
      for (int i = 0; i < imageCollection.length; i++)
        tracker.addImage(imageCollection[i], 0);
      try {
        tracker.waitForID(0, 0);
      } catch (InterruptedException e) {
        System.out.println("INTERRUPTED while loading Image");
      }
      for (int j = 0; j < imageCollection.length; j++)
        tracker.removeImage(imageCollection[j], 0);
    }
  }

  public void actionPerformed(ActionEvent e)
  {
    current = (current + 1 >= imageCollection.length) ? 0 : current + 1;
    repaint();
  }

  public boolean localMessage(Message theMessage)
  {
    boolean found = super.localMessage(theMessage);

    String mess = theMessage.getLabel();
    switch (Character.toLowerCase(mess.charAt(0)))
    {
      case 'f' : if (mess.equalsIgnoreCase("first")) {
                   first();
                   found = true;
                 }  
                 break;
      case 'l' : if (mess.equalsIgnoreCase("last")) {
                   last();
                   found = true;
                 }  
                 break;
      case 'n' : if (mess.equalsIgnoreCase("next")) {
                   next();
                   found = true;
                 }  
                 break;
      case 'p' : if (mess.equalsIgnoreCase("previous")) {
                   previous();
                   found = true;
                 }  
                 break;
    }
    
    return found;    
  }
}