package lib.casa.anima.message.java;

import lib.casa.anima.message.Message;

public interface AnimaEventSource
{
  public void addAnimaListener(AnimaListener listener);
  public void addAnimaListener(AnimaListener listener, String event,
                               Message message);
  public void removeAnimaListener(AnimaListener listener);
}