package lib.casa.anima.visual;

import java.awt.Component;
import java.awt.Rectangle;

import javax.swing.event.EventListenerList;

import lib.casa.anima.message.AnimaInterfaceExtended;
import lib.casa.anima.message.AnimaMessageParser;
import lib.casa.anima.message.Message;
import lib.casa.anima.message.java.AnimaEventSource;
import lib.casa.anima.message.java.AnimaEventSourceUtil;
import lib.casa.anima.message.java.AnimaListener;
import lib.casa.anima.message.java.AnimaTaggedEvent;

public class OperationComponent implements AnimaInterfaceExtended,
                                           AnimaListener, AnimaEventSource,
                                           VisualLimit,
                                           OperationComponentInterface
{
  protected String identifier = null;
  protected VisualComponent visual = null;

  protected EventListenerList animaListenerList;

  public OperationComponent()
  {
    this(true);
  }

  public OperationComponent(boolean isVisual)
  {
    super();
    if (isVisual) {
      animaListenerList = new EventListenerList();
      visual = new VisualComponent(animaListenerList);
    }
  }

  /*
   * Property Methods
   */

  public void setVisual(VisualComponent visual)
  {
    if (animaListenerList == null)
      animaListenerList = new EventListenerList();
    this.visual = visual;
    visual.setAnimaListenerList(animaListenerList);
  }

  public Component getVisual()
  {
    return visual;
  }

  /*
   * Redirected property Methods
   */

  public void setVisible(boolean visible)
  {
    if (visual != null)
      visual.setVisible(visible);
  }

  public boolean isVisible()
  {
    return (visual != null) ? visual.isVisible() : false;
  }

  public void setX(int x)
  {
    if (visual != null)
      visual.setX(x);
  }

  public int getX()
  {
    return (visual != null) ? visual.getX() : 0;
  }

  public void setY(int y)
  {
    if (visual != null)
      visual.setY(y);
  }

  public int getY()
  {
    return (visual != null) ? visual.getY() : 0;
  }

  public void setWidth(int width)
  {
    if (visual != null)
      visual.setWidth(width);
  }

  public int getWidth()
  {
    return (visual != null) ? visual.getWidth() : 0;
  }

  public void setHeight(int height)
  {
    if (visual != null)
      visual.setHeight(height);
  }

  public int getHeight()
  {
    return (visual != null) ? visual.getHeight() : 0;
  }


  /*
   * Anima Interface Methods
   */

  public void setIdentifier(String identifier)
  {
    this.identifier = identifier;
    if (visual != null)
      visual.setIdentifier(identifier);
  }

  public String getIdentifier()
  {
    return identifier;
  }

  public boolean taggedMessage(String theMessage)
  {
    return localMessage(AnimaMessageParser.parseMessage(theMessage));
  }

  public boolean localMessage(Message theMessage)
  {
    if (visual != null)
      return visual.localMessage(theMessage);
    else
      return false;
  }

  /*
   * Event Listener Methods
   */

  public void addAnimaListener(AnimaListener listener)
  {
    if (animaListenerList == null)
      animaListenerList = new EventListenerList();
    addAnimaListener(listener, "action", null);
  }

  public void addAnimaListener(AnimaListener listener, String event,
                               Message message)
  {
    AnimaEventSourceUtil.addAnimaListener(
      animaListenerList, listener, event, message);
  }

  public void removeAnimaListener(AnimaListener listener)
  {
    AnimaEventSourceUtil.removeAnimaListener(animaListenerList, listener);
  }

  protected synchronized void fireAnimaEvent(String event, Message msg)
  {
    AnimaEventSourceUtil.fireAnimaEvent(animaListenerList, event, msg, this);
  }

  public void eventMessage(AnimaTaggedEvent messageEvent)
  {
    localMessage(messageEvent.getMessage());
  }

  /*
   * Visual Limit Methods
   */

  public Rectangle getBounds()
  {
    return (visual != null) ? visual.getBounds() : null;
  }

  public void setBounds(int x, int y, int width, int height)
  {
    if (visual != null)
      visual.setBounds(x, y, width, height);
  }

  public boolean absoluteContains(int x, int y)
  {
    return (visual != null) ? visual.absoluteContains(x, y) : false;
  }
}