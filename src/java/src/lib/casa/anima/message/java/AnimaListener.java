package lib.casa.anima.message.java;

import java.util.EventListener;

public interface AnimaListener extends EventListener
{
  public void eventMessage(AnimaTaggedEvent messageEvent);
}