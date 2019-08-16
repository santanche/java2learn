package lib.casa.anima.message;

public class MessageRead extends Message
{
  public MessageRead()
  {
    super();
  }

  public MessageRead(String label, Object source)
  {
    super(label, source);
  }

  public char getCategory()
  {
    return AnimaMessage.MESSAGE_READ;
  }
}