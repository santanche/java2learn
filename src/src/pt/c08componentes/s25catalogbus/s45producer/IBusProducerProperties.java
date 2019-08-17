package pt.c08componentes.s25catalogbus.s45producer;

import pt.c08componentes.s25catalogbus.s00shared.IBusProperties;

public interface IBusProducerProperties extends IBusProperties {
  public int getVerbose();
  public void setVerbose(int verbose);
}
