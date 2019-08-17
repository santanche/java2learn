package pt.c08componentes.s25catalogbus.s15consumer;

import pt.c08componentes.s25catalogbus.s00shared.IBusProperties;

public interface IBusConsumerProperties extends IBusProperties {
  public int getBlockSize();
  public void setBlockSize(int blockSize);
  public int getVerbose();
  public void setVerbose(int verbose);
}
