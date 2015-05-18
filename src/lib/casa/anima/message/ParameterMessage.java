package lib.casa.anima.message;

public class ParameterMessage
{
  protected String name;
  protected Object value;

  public ParameterMessage(String name, Object value)
  {
    this.name = name;
    this.value = value;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  public void setValue(Object value)
  {
    this.value = value;
  }

  public Object getValue()
  {
    return value;
  }
}