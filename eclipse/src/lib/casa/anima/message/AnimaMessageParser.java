/*
Message without parameters (single)
-----------------------------------
<MS>

Message with ordered parameters
-------------------------------
<MO>

Message with named parameters
-----------------------------
<MN>

Message for property write
--------------------------
<MW id="{property}">{value}</MW>
*/

package lib.casa.anima.message;

import java.util.Vector;

public class AnimaMessageParser
{
  static final int FAST_INITIAL_QUOTE = 7;

  static String xMessage = null;
  static char xmess[] = null;

  public static Message parseMessage(String theMessage)
  {
    Message m = null;

    xMessage = theMessage;
    xmess = xMessage.toCharArray();

    // fast message parse
    if (xmess[2] != ' ')
    {
      char delimiter = xmess[FAST_INITIAL_QUOTE];
      int p = FAST_INITIAL_QUOTE + 1;
      while (p < xmess.length && xmess[p] != delimiter)
        p++;
      String mText = xMessage.substring(FAST_INITIAL_QUOTE + 1, p);

      switch (xmess[2]) {
        case 'S' : m = new Message(mText);
                   break;
        case '1' : m = new MessageSingle(mText, parseValue(p + 2), null);
                   break;
        case 'W' : m = new MessageWrite(mText, parseValue(p + 2), null);
                   break;
        case 'R' : m = new MessageRead(mText, null);
                   break;
        case 'V' : m = new MessageValue(mText, parseValue(p + 2), null);
                   break;
        case 'O' : m = new MessageOrdered(mText, parseOrderedParameters(p + 2),
                                          null);
                   break;
        case 'N' : m = new MessageNamed(mText, parseNamedParameters(p + 2),
                                        null);
                   break;
      }
    }

    return m;
  }

  static String parseValue(int initial)
  {
    int p = initial;
    while (p < xmess.length && xmess[p] != '<')
      p++;
    return xMessage.substring(initial, p);
  }

  static Object[] parseOrderedParameters(int initial)
  {
    Vector list = new Vector();
    int pi = initial;
    while (pi < xmess.length && xmess[pi + 1] != '/')
    {
      while (pi < xmess.length && xmess[pi] != '>')
        pi++;
      pi++;
      int pf = pi;
      while (pf < xmess.length && xmess[pf] != '<')
        pf++;
      list.addElement(xMessage.substring(pi, pf));
      pi = pf + 1;
      while (pi < xmess.length && xmess[pi] != '>')
        pi++;
      pi++;
    }
    if (list.size() > 0)
      return list.toArray();
    else
      return null;
  }

  static ParameterMessage[] parseNamedParameters(int initial)
  {
    Vector list = new Vector();
    int pin = initial + 1;
    while (pin < xmess.length && xmess[pin] != '/')
    {
      int pfn = pin;
      while (pfn < xmess.length && xmess[pfn] != '>')
        pfn++;
      int pfv = pfn + 1;
      while (pfv < xmess.length && xmess[pfv] != '<')
        pfv++;
      list.addElement(new ParameterMessage(xMessage.substring(pin, pfn),
                                           xMessage.substring(pfn + 1, pfv)));
      pin = pfv + 1;
      while (pin < xmess.length && xmess[pin] != '>')
        pin++;
      pin++;
    }
    if (list.size() > 0)
      return (ParameterMessage[])list.toArray(new ParameterMessage[0]);
    else
      return null;
  }

  public static int findMessageText(String list[], String messageText)
  {
    int p = 0;
    if (list == null)
      return -1;
    else {
      for (p = 0; p < list.length && !list[p].equalsIgnoreCase(messageText);
           p++)
        /* nothing */;
      if (p >= list.length)
        return -1;
      else
        return p;
    }
  }
}