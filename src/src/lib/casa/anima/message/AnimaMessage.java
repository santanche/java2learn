package lib.casa.anima.message;

public class AnimaMessage
{
  public static final char MESSAGE_SIMPLE  = 'S',
                           MESSAGE_SINGLE  = '1',
                           MESSAGE_WRITE   = 'W',
                           MESSAGE_READ    = 'R',
                           MESSAGE_VALUE   = 'V',
                           MESSAGE_ORDERED = 'O',
                           MESSAGE_NAMED   = 'N';

  public static String tagMessage(String label)
  {
    return tagMessage(MESSAGE_SIMPLE, label);
  }

  public static String tagMessage(char category, String label)
  {
      return "<M"  + category + " id=\"" + label + "\"/>";
  }

  public static String tagMessage(char category, String label, String value)
  {
    return "<M"  + category + " id=\"" + label + "\">" + value +
           "</M" + category + ">";
  }

  public static String tagMessage(char category, String label,
                                  Object parameters[])
  {
    StringBuffer mess =
      new StringBuffer("<M" + category + " id=\"" + label + "\">");
    if (parameters != null)
    {
      int p;
      if (parameters[0] instanceof ParameterMessage)
        for (p = 0; p < parameters.length; p++)
          mess.append("<" + ((ParameterMessage)parameters[p]).getName() + ">" +
                      ((ParameterMessage)parameters[p]).getValue() +
                      "</" + ((ParameterMessage)parameters[p]).getName() + ">");
      else
        for (p = 0; p < parameters.length; p++)
          mess.append("<v" + (p + 1) + ">" + parameters[p] +
                      "</v" + (p + 1) + ">");
    }
    mess.append("</M" + category + ">");
    return mess.toString();
  }
}