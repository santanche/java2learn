package lib.casa.anima.message.java;

import java.util.EventObject;

import lib.casa.anima.message.AnimaMessageParser;
import lib.casa.anima.message.Message;

public class AnimaTaggedEvent extends EventObject
{
  protected Message theMessage = null;

  public AnimaTaggedEvent(Object source)
  {
    super(source);
  }

  public AnimaTaggedEvent(Object source, Message theMessage)
  {
    super(source);
    this.theMessage = theMessage;
  }

  public AnimaTaggedEvent(Object source, String theMessage)
  {
    super(source);
    setTaggedMessage(theMessage);
  }

  public void setMessage(Message theMessage)
  {
    this.theMessage = theMessage;
  }

  public Message getMessage()
  {
    return (Message)theMessage;
  }

  public void setTaggedMessage(String theMessage)
  {
    this.theMessage = AnimaMessageParser.parseMessage(theMessage);
  }

  public String getTaggedMessage()
  {
    return theMessage.getTaggedMessage();
  }
}