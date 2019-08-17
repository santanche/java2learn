package pt.c08componentes.s25catalogbus.s16counter;

public interface IBusCounterProperties {
  public String getBusURI();
  public void setBusURI(String dataSource);
  public String getTopic();
  public void setTopic(String topic);
  public int getTrigger();
  public void setTrigger(int trigger);
}
