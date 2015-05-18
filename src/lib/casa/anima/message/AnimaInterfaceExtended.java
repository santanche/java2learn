package lib.casa.anima.message;

public interface AnimaInterfaceExtended extends DCCInterface
{
  public void setIdentifier(String identifier);
  public boolean localMessage(Message theMessage);
}