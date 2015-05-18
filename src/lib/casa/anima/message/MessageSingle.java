package lib.casa.anima.message;

public class MessageSingle extends Message
{
  protected Object value = null;

  public MessageSingle()
  {
    super();
  }

  public MessageSingle(String label, Object value, Object source)
  {
    super(label, source);
    this.value = value;
  }

  public void setValue(Object value)
  {
    this.value = value;
  }

  public Object getValue()
  {
    return value;
  }

  public boolean getValueBoolean()
  {
    return valueBoolean(value);
  }

  public static boolean valueBoolean(Object value)
  {
    if (value instanceof Boolean)
      return ((Boolean)value).booleanValue();
    else {
      if (((String)value).equalsIgnoreCase("true") ||
          ((String)value).equalsIgnoreCase("1"))
        return true;
      else
        return false;
    }
  }

  public int getValueInt()
  {
    return valueInt(value);
  }

  public static int valueInt(Object value)
  {
    return (value instanceof Integer) ?
             ((Integer)value).intValue() :
             Integer.parseInt((String)value);
  }

  public long getValueLong()
  {
    return valueLong(value);
  }

  public static long valueLong(Object value)
  {
    return (value instanceof Long) ?
             ((Long)value).longValue() :
             Long.parseLong((String)value);
  }

  public float getValueFloat()
  {
    return valueFloat(value);
  }

  public static float valueFloat(Object value)
  {
    return (value instanceof Float) ?
             ((Float)value).floatValue() :
             Float.parseFloat((String)value);
  }

  public double getValueDouble()
  {
    return valueDouble(value);
  }

  public static double valueDouble(Object value)
  {
    return (value instanceof Double) ?
             ((Double)value).doubleValue() :
             Double.parseDouble((String)value);
  }

  public String getValueString()
  {
    return valueString(value);
  }

  public static String valueString(Object value)
  {
    return value.toString();
  }

  public char getCategory()
  {
    return AnimaMessage.MESSAGE_SINGLE;
  }

  public String getTaggedMessage()
  {
    return AnimaMessage.tagMessage(getCategory(), label, value.toString());
  }
}