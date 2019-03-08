package lib.casa.anima.visual;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.event.EventListenerList;

import lib.casa.anima.message.AnimaInterfaceExtended;
import lib.casa.anima.message.AnimaMessageParser;
import lib.casa.anima.message.Message;
import lib.casa.anima.message.MessageOrdered;
import lib.casa.anima.message.MessageSingle;
import lib.casa.anima.message.MessageWrite;
import lib.casa.anima.message.java.AnimaEventSource;
import lib.casa.anima.message.java.AnimaEventSourceUtil;
import lib.casa.anima.message.java.AnimaListener;
import lib.casa.anima.message.java.AnimaTaggedEvent;

public class VisualComponent extends JComponent
                             implements AnimaInterfaceExtended,
                                        AnimaListener, AnimaEventSource,
                                        MouseListener, VisualLimit
{
  public static final String MESSAGE_ACTION = "http://purl.org/net/dcc/taxonomy/DCCEvent.owl#Action";
  public static final Message MESSAGE_ACTION_OBJECT =
                                          new Message(MESSAGE_ACTION);

  public static final String MESSAGE_ABS_CONTAINS = "abs contains",
                             MESSAGE_ABS_CONTAINS_RETURN = "r(abs contains)";

  public static final String MESSAGE_CLICKED = "http://purl.org/net/dcc/taxonomy/DCCEvent.owl#MouseClicked";

  protected EventListenerList animaListenerList;

  protected String identifier = null;

  public VisualComponent()
  {
    super();
    addMouseListener(this);
  }

  public VisualComponent(EventListenerList animaListenerList)
  {
    this();
    this.animaListenerList = animaListenerList;
  }

  public void setAnimaListenerList(EventListenerList animaListenerList)
  {
    this.animaListenerList = animaListenerList;
  }

  /*
   * Property Methods
   */

  public void setX(int x)
  {
    setLocation(x, getY());
  }

  public void setY(int y)
  {
    setLocation(getX(), y);
  }

  public void setWidth(int width)
  {
    setSize(width, getHeight());
  }

  public void setHeight(int height)
  {
    setSize(getWidth(), height);
  }

  /*
   * Anima Interface Methods
   */

  public void setIdentifier(String identifier)
  {
    this.identifier = identifier;
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
    boolean found = false;
    String mess = theMessage.getLabel();
    if (theMessage instanceof MessageWrite ||
        theMessage instanceof MessageSingle /* provisory */)
    {
      MessageSingle mw = (MessageSingle)theMessage;
      switch (Character.toLowerCase(mess.charAt(0))) {
        case 'v' : if (mess.equalsIgnoreCase("visible")) {
                     setVisible(mw.getValueBoolean());
                     found = true;
                   }
                   break;
        case 'x' : if (mess.length() == 1) {
                     setX(mw.getValueInt());
                     found = true;
                   }
                   break;
        case 'y' : if (mess.length() == 1) {
                     setY(mw.getValueInt());
                     found = true;
                   }
                   break;
        case 'w' : if (mess.equalsIgnoreCase("width")) {
                     setWidth(mw.getValueInt());
                     found = true;
                   }
                   break;
        case 'h' : if (mess.equalsIgnoreCase("height")) {
                     setHeight(mw.getValueInt());
                     found = true;
                   }
                   break;
      }
    }
    else if (theMessage instanceof MessageOrdered)
    {
      MessageOrdered mo = (MessageOrdered)theMessage;
      switch (mess.charAt(0))
      {
        case 'a' : if (mess.equalsIgnoreCase(MESSAGE_ABS_CONTAINS))
                   {
                     int x = mo.getParameterInt("x", 0),
                         y = mo.getParameterInt("y", 1);
                     if (mo.getSource() instanceof AnimaInterfaceExtended &&
                         mo.getFeedbackMessage() != null)
                       ((AnimaInterfaceExtended)mo.getSource()).localMessage(
                         new MessageSingle(mo.getFeedbackMessage(),
                                           new Boolean(absoluteContains(x, y)),
                                           this)
                       );
                   }
      }
    }
    if (mess.equalsIgnoreCase(MESSAGE_ACTION)) {
      found = true;
      action(theMessage);
    }

    return found;
  }

  /*
   * Event Listener Methods
   */

  public void addAnimaListener(AnimaListener listener)
  {
    addAnimaListener(listener, MESSAGE_ACTION, null);
  }

  public void addAnimaListener(AnimaListener listener, String event,
                               Message message)
  {
    if (animaListenerList == null)
      animaListenerList = new EventListenerList();
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
   * Event Methods
   */

  public void action()
  {
    action(MESSAGE_ACTION_OBJECT);
  }

  public void action(Message theMessage)
  {
    fireAnimaEvent(MESSAGE_ACTION, theMessage);
  }

  public void mouseClicked(MouseEvent event)
  {
    fireAnimaEvent(MESSAGE_CLICKED, new Message(MESSAGE_CLICKED));
  }

  public void mouseEntered(MouseEvent theEvent)
  { /* nothing */ }

  public void mouseExited(MouseEvent theEvent)
  { /* nothing */ }

  public void mousePressed(MouseEvent evento)
  { /* nothing */ }

  public void mouseReleased(MouseEvent evento)
  { /* nothing */ }

  /*
   * Methods
   */

  public boolean absoluteContains(int x, int y)
  {
    if (x >= this.getX() && x < this.getX() + this.getWidth() &&
        y >= this.getY() && y < this.getY() + this.getHeight())
      return true;
    else
      return false;
  }
}
