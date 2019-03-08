package lib.casa.anima.message;

public class MessageOrdered extends Message
{
  protected Object parameters[] = null;

  public MessageOrdered()
  {
    super();
  }

  public MessageOrdered(String label, Object source)
  {
    super(label, source);
  }

  public MessageOrdered(String label, Object parameters[], Object source)
  {
    super(label, source);
    this.parameters = parameters;
  }

  public void setParameters(Object parameters[])
  {
    this.parameters = parameters;
  }

  public void setParameters(int index, Object parameter)
  {
    this.parameters[index] = parameter;
  }

  public Object[] getParameters()
  {
    return parameters;
  }

  public Object getParameters(int index)
  {
    return parameters[index];
  }

  public Object getParameterValue(int index)
  {
    return parameters[index];
  }

  public boolean getParameterBoolean(int index)
  {
    return MessageSingle.valueBoolean(parameters[index]);
  }

  public int getParameterInt(int index)
  {
    return MessageSingle.valueInt(parameters[index]);
  }

  public long getParameterLong(int index)
  {
    return MessageSingle.valueLong(parameters[index]);
  }

  public float getParameterFloat(int index)
  {
    return MessageSingle.valueFloat(parameters[index]);
  }

  public double getParameterDouble(int index)
  {
    return MessageSingle.valueDouble(parameters[index]);
  }

  public String getParameterString(int index)
  {
    return MessageSingle.valueString(parameters[index]);
  }

  public Object getParameterValue(String name, int index)
  {
    return getParameterValue(index);
  }

  public boolean getParameterBoolean(String name, int index)
  {
    return getParameterBoolean(index);
  }

  public int getParameterInt(String name, int index)
  {
    return getParameterInt(index);
  }

  public long getParameterLong(String name, int index)
  {
    return getParameterLong(index);
  }

  public float getParameterFloat(String name, int index)
  {
    return getParameterFloat(index);
  }

  public double getParameterDouble(String name, int index)
  {
    return getParameterDouble(index);
  }

  public String getParameterString(String name, int index)
  {
    return getParameterString(index);
  }

  public char getCategory()
  {
    return AnimaMessage.MESSAGE_ORDERED;
  }

  public String getTaggedMessage()
  {
    return AnimaMessage.tagMessage(getCategory(), label, parameters);
  }
}