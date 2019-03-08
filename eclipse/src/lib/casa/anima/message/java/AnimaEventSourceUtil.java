package lib.casa.anima.message.java;

import javax.swing.event.EventListenerList;

import lib.casa.anima.message.AnimaMessage;
import lib.casa.anima.message.Message;

public class AnimaEventSourceUtil
{
  public static void addAnimaListener(EventListenerList animaListenerList,
                                      AnimaListener listener, String event,
                                      Message message)
  {
    AnimaListenerSpecified ale =
      new AnimaListenerSpecified(listener, event, message);
    animaListenerList.add(AnimaListenerSpecified.class, ale);
  }

  public static void removeAnimaListener(EventListenerList animaListenerList,
                                         AnimaListener listener)
  {
    animaListenerList.remove(AnimaListener.class, listener);
  }

  public static synchronized void fireAnimaEvent(
                                      EventListenerList animaListenerList,
                                      String event, Message msg, Object source)
  {
    if (animaListenerList != null)
    {
      Object[] ln = animaListenerList.getListenerList();
      for (int i = ln.length - 2; i >= 0; i -= 2)
      {
        if (ln[i] == AnimaListenerSpecified.class &&
            ((AnimaListenerSpecified)ln[i + 1]).getEvent().
                                                 equalsIgnoreCase(event))
        {
          AnimaListenerSpecified ale = (AnimaListenerSpecified)ln[i + 1];
          if (ale.getMessage() != null) {
            if (ale.getMessage().getCategory() == AnimaMessage.MESSAGE_SIMPLE)
              msg.setLabel(ale.getMessage().getLabel());
          }
          ale.eventMessage(new AnimaTaggedEvent(source, msg));
        }
      }
    }
  }
}