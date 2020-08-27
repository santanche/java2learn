package pt.c08componentes.s25catalogbus.apps;

import pt.c08componentes.s25catalogbus.s15consumer.BusConsumerComponent;
import pt.c08componentes.s25catalogbus.s15consumer.IBusConsumer;
import pt.c08componentes.s25catalogbus.s45producer.BusProducerComponent;
import pt.c08componentes.s25catalogbus.s45producer.IBusProducer;

public class App45aBusProducerConsumer {
  public static void main(String args[])
  {
      try {
         IBusConsumer bc1 = new BusConsumerComponent();
         bc1.setBusURI("tcp://localhost:1883");
         bc1.setTopic("sensor/+/temperature");
         bc1.setBlockSize(10);
         bc1.setVerbose(2);  // mostra todas as mensagens
        
         IBusProducer bp = new BusProducerComponent();
         bp.setBusURI("tcp://localhost:1883");
         bp.setTopic("sensor/*/temperature/avg");
         bp.connect(bc1);
         
         bc1.connect(bp);

         IBusConsumer bc2 = new BusConsumerComponent();
         bc2.setBusURI("tcp://localhost:1883");
         bc2.setTopic("sensor/*/temperature/avg");
         bc2.setVerbose(2);  // mostra todas as mensagens
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
