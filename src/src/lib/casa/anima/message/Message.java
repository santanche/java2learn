package lib.casa.anima.message;

public class Message
{
  protected String label = null;
  protected Object source = null;

  protected String feedbackMessage = null;

  public Message()
  {
  }

  public Message(String label)
  {
    this.label = label;
  }

  public Message(String label, Object source)
  {
    this.label = label;
    this.source = source;
  }

  public void setLabel(String label)
  {
    this.label = label;
  }

  public String getLabel()
  {
    return label;
  }

  public void setSource(Object source)
  {
    this.source = source;
  }

  public Object getSource()
  {
    return source;
  }

  public void setFeedbackMessage(String feedbackMessage)
  {
    this.feedbackMessage = feedbackMessage;
  }

  public String getFeedbackMessage()
  {
    return feedbackMessage;
  }

  public char getCategory()
  {
    return AnimaMessage.MESSAGE_SIMPLE;
  }

  public String getTaggedMessage()
  {
    return AnimaMessage.tagMessage(getCategory(), label);
  }

  public String toString()
  {
    return getTaggedMessage();
  }
}