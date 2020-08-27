package lib.casa.anima.message;

public class MessageWrite extends MessageSingle
{
  public MessageWrite()
  {
    super();
  }

  public MessageWrite(String label, Object value, Object source)
  {
    super(label, value, source);
  }

  public char getCategory()
  {
    return AnimaMessage.MESSAGE_WRITE;
  }
}