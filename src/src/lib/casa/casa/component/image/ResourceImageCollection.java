package lib.casa.casa.component.image;

import java.awt.Image;
import java.net.URL;

import lib.casa.anima.message.Message;
import lib.casa.anima.message.MessageWrite;
import lib.casa.anima.util.IOUtil;
import lib.casa.casa.util.ImageCollectionProducer;
import lib.casa.casa.util.ImageCollectionUtil;
import lib.casa.casa.util.ImageLoader;

public class ResourceImageCollection extends ImageCollectionComponent
             // implements Companion <GAMES> temporary
{
  protected URL resource = null;
  protected Image stripImage = null;
  protected int numberLines = 0,
                numberColumns = 0;
  protected boolean waitCompleteLoad = true;

  private boolean companionMode = false;
  
  public static final String
    BASIC_STRIP = ResourceImageCollection.class.getResource("strip.gif").toString();
  public static final int
    NUMBER_LINES = 1,
    NUMBER_COLUMNS = 4;

  protected boolean completedLoad = true;

  public ResourceImageCollection()
  {
    super(IOUtil.findURLWithoutException(BASIC_STRIP), NUMBER_LINES, NUMBER_COLUMNS);
  }

  public ResourceImageCollection(URL resource, int numberLines, int numberColumns)
  {
    this.resource = resource;
    this.numberLines = numberLines;
    this.numberColumns = numberColumns;
    stripImage = ImageLoader.loadImage(resource);
    mountStrip();
  }

  public ResourceImageCollection(URL resource, boolean waitCompleteLoad)
  {
    super(resource, waitCompleteLoad);
    completedLoad = false;
    this.resource = resource;
    this.waitCompleteLoad = waitCompleteLoad;
  }
  
  protected void mountStrip()
  {
    imageCollection =
      ImageCollectionUtil.mountStripFrames(stripImage, numberLines, numberColumns);
  }
  
  public void setResource(URL resource)
  {
      if (!companionMode) {
          this.resource = resource;
          stripImage = ImageLoader.loadImage(resource);
          mountStrip();
      }
  }

  /*
   * Provisoriamente desativado
   *
  public void setResource(URL resource)
  {
    if (completedLoad) {
      completedLoad = false;
      ImageCollectionLoader icl =
        new ImageCollectionLoader(resource, this, !waitCompleteLoad);
      this.resource = resource;
    }
  }
  */

  public URL getResource()
  {
    return resource;
  }
  
  public void setNumberLines(int numberLines)
  {
    this.numberLines = numberLines;
    if (stripImage != null)
      mountStrip();
  }

  public int getNumberLines()
  {
    return numberLines;
  }

  public void setNumberColumns(int numberColumns)
  {
    this.numberColumns = numberColumns;
    if (stripImage != null)
      mountStrip();
  }

  public int getNumberColumns()
  {
    return numberColumns;
  }
  
  public void setWaitCompleteLoad(boolean waitCompleteLoad)
  {
    this.waitCompleteLoad = waitCompleteLoad;
  }

  public boolean getWaitCompleteLoad()
  {
    return waitCompleteLoad;
  }

  public void imageCollectionReady(ImageCollectionProducer producer,
                                   Image imageCollection[])
  {
    super.imageCollectionReady(producer, imageCollection);
    completedLoad = true;
  }

  /*
   * Anima Messages
   */

  public boolean localMessage(Message theMessage)
  {
    boolean found = super.localMessage(theMessage);

    if (theMessage instanceof MessageWrite)
    {
      MessageWrite mw = (MessageWrite)theMessage;
      String mess = theMessage.getLabel();
      switch (Character.toLowerCase(mess.charAt(0)))
      {
        case 'n' : if (mess.equalsIgnoreCase("numberLines")) {
                     setNumberLines(mw.getValueInt());
                     found = true;
                   } else if (mess.equalsIgnoreCase("numberColumns")) {
                     setNumberColumns(mw.getValueInt());
                     found = true;
                   }
                   break;
        case 'r' : if (mess.equalsIgnoreCase("resource")) {
        	         /* <GAMES> temporary
                     try {
                       setResource(
                         GerenteArquivos.urlArquivo(GerenteArquivos.dPadraoLeitura,
                                                    mw.getValueString()));
                     } catch (NomeArquivoInvalido e) {
                       // nao faz nada
                     }
                     found = true;
                     */
                   }
                   break;
      }
    }

    return found;
  }
  
  /*
   * DCC Companion methods
   */
  
  /* <GAMES> temporary
  
  public void setMainModule(String mainModule)
  {
      try {
          setResource(new URL(mainModule));
      } catch (MalformedURLException e) {
          e.printStackTrace();
      }
      companionMode = true;
  }
  */
}
