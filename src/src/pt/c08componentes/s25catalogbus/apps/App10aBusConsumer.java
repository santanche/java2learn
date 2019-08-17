package pt.c08componentes.s25catalogbus.apps;

import pt.c08componentes.s25catalogbus.s15consumer.BusConsumerComponent;
import pt.c08componentes.s25catalogbus.s15consumer.IBusConsumer;

public class App10aBusConsumer {
  public static void main(String args[])
  {
      try {
        IBusConsumer bc = new BusConsumerComponent();
        bc.setBusURI("tcp://localhost:1883");
        bc.setTopic("sensor/+/+");
        bc.setVerbose(2);  // mostra todas as mensagens
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
