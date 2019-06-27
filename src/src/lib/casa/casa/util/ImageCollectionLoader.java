package lib.casa.casa.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.net.URL;
import java.util.Vector;

public class ImageCollectionLoader implements ImageObserver,
                                              ImageCollectionProducer
{
  Image image;
  BufferedImage imageFrame;

  int nFrames = 0;
  Graphics2D imageFrameGraphics;

  Color back;
  int w, h;
  int viFirst[], viLast[];

  Vector vImages = new Vector();

  boolean imageCompleted = false;

  ImageCollectionObserver observer;
  boolean notifyPartialLoad;

  int numberId;

  public ImageCollectionLoader(URL source, ImageCollectionObserver observer,
                               boolean notifyPartialLoad)
  {
    this(source, observer, notifyPartialLoad, 0);
  }

  public ImageCollectionLoader(URL source, ImageCollectionObserver observer,
                               boolean notifyPartialLoad, int numberId)
  {
    this(source, observer, notifyPartialLoad, numberId, Color.white);
  }

  public ImageCollectionLoader(URL source, ImageCollectionObserver observer,
                               boolean notifyPartialLoad, int numberId,
                               Color backgroundColor)
  {
    this.observer = observer;
    this.notifyPartialLoad = notifyPartialLoad;
    this.numberId = numberId;
    image = Toolkit.getDefaultToolkit().createImage(source);
    if (image == null)
       return;
    ImageLoader.prepareImage(image);

    w = image.getWidth(null);
    h = image.getHeight(null);
    back = backgroundColor;

    imageFrame = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_INDEXED);
    imageFrameGraphics = imageFrame.createGraphics();
    nextFrame();
  }

  public int getNumberId()
  {
    return numberId;
  }

  void nextFrame()
  {
    nFrames++;
    imageFrameGraphics.setColor(back);
    imageFrameGraphics.fillRect(0, 0, w, h);
    boolean status = imageFrameGraphics.drawImage(image, 0, 0, this);
    // single image file
    if (status) {
      Image img[] = {image};
      observer.imageCollectionReady(this, img);
    }
  }

  void frameCompleted(boolean allLoaded)
  {
    imageFrameGraphics.setColor(back);
    imageFrameGraphics.fillRect(0, 0, w, h);
    imageFrameGraphics.drawImage(image, 0, 0, null);
    BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_INDEXED);
    bi.setData(imageFrame.getData());
    int aux[] = null;
    if (!allLoaded) {
      if (nFrames == 1)
        viFirst = bi.getData().getPixels(0, 0, w, h, aux);
      else
        viLast = bi.getData().getPixels(0, 0, w, h, aux);
    }
    if (allLoaded) {
      vImages.addElement(bi);
      observer.imageCollectionReady(this, (Image[])vImages.toArray(new Image[0]));
    } else if (equals(viFirst, viLast)) {
      imageCompleted = true;
      observer.imageCollectionReady(this, (Image[])vImages.toArray(new Image[0]));
    } else {
      if (notifyPartialLoad)
        observer.imageFrameReady(this, bi, nFrames - 1);
      vImages.addElement(bi);
      nextFrame();
    }
  }

  public boolean imageUpdate(Image theImage, int infoflags, int x, int y,
                                             int width, int height)
  {
    if ((infoflags & ImageObserver.ALLBITS) != 0) {
      imageCompleted = true;
      frameCompleted(true);
    } else if ((infoflags & ImageObserver.FRAMEBITS) != 0) {
      frameCompleted(false);
    }

    return !imageCompleted;
  }

  boolean equals(int first[], int second[])
  {
    if (first == null || second == null)
      return false;
    else if (first.length != second.length)
      return false;
    else {
      int c = 0;
      for (; c < first.length && first[c] == second[c]; c++)
        /* nothing */ ;
      return (c >= first.length);
    }
  }
}
