package lib.casa.casa.component;

import lib.casa.anima.message.Message;
import lib.casa.anima.message.MessageWrite;
import lib.casa.anima.visual.OperationComponent;

public class CasaOperation extends OperationComponent
{
  protected String name = null;

  public CasaOperation()
  {
    this(true);
  }

  public CasaOperation(boolean isVisual)
  {
    super(false);
    if (isVisual)
      setVisual(new CasaComponent());
  }

  /*
   * Property Methods
   */

  public void setName(String name)
  {
    this.name = name;
    if (visual instanceof CasaComponent)
      ((CasaComponent)visual).setName(name);
  }

  public String getName()
  {
    return name;
  }

  /*
   * Methods
   */

  public boolean localMessage(Message theMessage)
  {
    boolean found = super.localMessage(theMessage);

    if (theMessage instanceof MessageWrite &&
        theMessage.getLabel().equalsIgnoreCase("name"))
    {
      setName(((MessageWrite)theMessage).getValueString());
      found = true;
    }

    return found;
  }
}