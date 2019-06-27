package lib.casa.anima.message.java;

import lib.casa.anima.message.Message;

public class AnimaListenerSpecified implements AnimaListener
{
  protected AnimaListener listener;
  protected String event;
  protected Message message;

  public AnimaListenerSpecified(AnimaListener listener, String event,
                                Message message)
  {
    this.listener = listener;
    this.event = event;
    this.message = message;
  }

  public AnimaListener getListener()
  {
    return listener;
  }

  public String getEvent()
  {
    return event;
  }

  public Message getMessage()
  {
    return message;
  }

  public void eventMessage(AnimaTaggedEvent messageEvent)
  {
    listener.eventMessage(messageEvent);
  }
}