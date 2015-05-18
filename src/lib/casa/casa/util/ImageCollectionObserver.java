package lib.casa.casa.util;

import java.awt.Image;

public interface ImageCollectionObserver
{
  public void imageFrameReady(ImageCollectionProducer producer,
                              Image frame, int sequenceNumber);
  public void imageCollectionReady(ImageCollectionProducer producer,
                                   Image imageCollection[]);
}
