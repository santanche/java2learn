package lib.casa.casa.component.image;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

// import Nucleo.Excecao.NomeArquivoInvalido; <GAMES> temporary
// import Nucleo.Intermediario.GerenteArquivos; <GAMES> temporary
// import anima.dcc.Companion; <GAMES> temporary

import lib.casa.anima.message.Message;
import lib.casa.anima.message.MessageSingle;
import lib.casa.anima.message.MessageWrite;
import lib.casa.anima.util.IOUtil;

public class ResourceImageSingle extends ImageSingleComponent
             // implements Companion <GAMES> temporary
{
  protected URL resource = null;
  
  private boolean companionMode = false;

  public static final String
    BASIC_IMAGE = ResourceImageSingle.class.getResource("image.gif").toString();

  public ResourceImageSingle()
  {
    this(IOUtil.findURLWithoutException(BASIC_IMAGE));
  }

  public ResourceImageSingle(URL resource)
  {
    super(resource);
    this.resource = resource;
  }

  public void setResource(URL resource)
  {
      if (!companionMode) {
          super.setResource(resource);
          this.resource = resource;
      }
  }
  
  public URL getResource()
  {
    return resource;
  }
  
  public void setImage(Image theImage)
  {
    super.setImage(theImage);
    resource = null;
  }

  /*
   * Anima Messages
   */

  public boolean localMessage(Message theMessage)
  {
    boolean found = super.localMessage(theMessage);

    if (theMessage instanceof MessageWrite)
    {
      String mess = theMessage.getLabel();
      switch (Character.toLowerCase(mess.charAt(0)))
      {
        case 'r' : if (mess.equalsIgnoreCase("resource")) {
        	         /* <GAMES> temporary
                     try {
					    setResource(
						    GerenteArquivos.urlArquivo(GerenteArquivos.dPadraoLeitura,
							((MessageSingle)theMessage).getValueString()));
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
