package lib.casa.anima.message;

public class MessageNamed extends MessageOrdered
{
  public MessageNamed()
  {
    super();
  }

  public MessageNamed(String label, Object source)
  {
    super(label, source);
  }

  public MessageNamed(String label, Object parameters[], Object source)
  {
    super(label, source);
    setParameters(parameters);
  }

  public void setParameters(Object parameters[])
  {
    if (parameters instanceof ParameterMessage[])
      this.parameters = parameters;
    else
    {
      this.parameters = new ParameterMessage[parameters.length];
      for (int p = 0; p < parameters.length; p++)
        setParameters(p, parameters[p]);
    }
  }

  public void setParameters(int index, Object parameter)
  {
    if (parameter instanceof ParameterMessage)
      this.parameters[index] = parameter;
    else if (parameter instanceof Object[])
      this.parameters[index] =
        new ParameterMessage(((Object[])parameter)[0].toString(),
                             ((Object[])parameter)[1]);
    else
      this.parameters[index] =
        new ParameterMessage("v" + (index + 1), parameter);
  }

  public Object getParameterValue(int index)
  {
    return ((ParameterMessage)parameters[index]).getValue();
  }

  public Object getParameterValue(String name)
  {
    int p;
    for (p = 0; p < parameters.length &&
         !name.equalsIgnoreCase(((ParameterMessage)parameters[p]).getName());
         p++)
      /* nothing */ ;
    return (p < parameters.length) ?
             ((ParameterMessage)parameters[p]).getValue() : null;
  }

  public boolean getParameterBoolean(String name)
  {
    return MessageSingle.valueBoolean(getParameterValue(name));
  }

  public int getParameterInt(String name)
  {
    return MessageSingle.valueInt(getParameterValue(name));
  }

  public long getParameterLong(String name)
  {
    return MessageSingle.valueLong(getParameterValue(name));
  }

  public float getParameterFloat(String name)
  {
    return MessageSingle.valueFloat(getParameterValue(name));
  }

  public double getParameterDouble(String name)
  {
    return MessageSingle.valueDouble(getParameterValue(name));
  }

  public String getParameterString(String name)
  {
    return MessageSingle.valueString(getParameterValue(name));
  }

  public Object getParameterValue(String name, int index)
  {
    return getParameterValue(name);
  }

  public boolean getParameterBoolean(String name, int index)
  {
    return getParameterBoolean(name);
  }

  public int getParameterInt(String name, int index)
  {
    return getParameterInt(name);
  }

  public long getParameterLong(String name, int index)
  {
    return getParameterLong(name);
  }

  public float getParameterFloat(String name, int index)
  {
    return getParameterFloat(name);
  }

  public double getParameterDouble(String name, int index)
  {
    return getParameterDouble(name);
  }

  public String getParameterString(String name, int index)
  {
    return getParameterString(name);
  }

  public char getCategory()
  {
    return AnimaMessage.MESSAGE_NAMED;
  }
}