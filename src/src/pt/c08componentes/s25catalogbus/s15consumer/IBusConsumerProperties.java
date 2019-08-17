package pt.c08componentes.s25catalogbus.s15consumer;

public interface IBusConsumerProperties {
  public String getBusURI();
  public void setBusURI(String dataSource);
  public String getTopic();
  public void setTopic(String topic);
  public int getBlockSize();
  public void setBlockSize(int blockSize);
}
