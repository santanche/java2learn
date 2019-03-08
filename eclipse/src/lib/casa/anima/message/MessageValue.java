package lib.casa.anima.message;

public class MessageValue extends MessageSingle
{
  public MessageValue()
  {
    super();
  }

  public MessageValue(String label, String value, Object source)
  {
    super(label, value, source);
  }

  public char getCategory()
  {
    return AnimaMessage.MESSAGE_VALUE;
  }
}