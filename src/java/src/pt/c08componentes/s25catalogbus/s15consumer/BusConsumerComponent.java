package pt.c08componentes.s25catalogbus.s15consumer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

import pt.c08componentes.s25catalogbus.s00shared.IUpdate;
import pt.c08componentes.s25catalogbus.s00shared.Message;
import pt.c08componentes.s25catalogbus.s00shared.SensorReading;

public class BusConsumerComponent implements IBusConsumer, MqttCallback {
  private String busURI = null;
  private String topic = null;
  private int blockSize = 5;
  private int number = 10;
  private int verbose = 2;
  
  private String[] attributes = {"message", "timestamp", "dimension", "value", "unit"};
  private ArrayList<String[]> instArray = new ArrayList<String[]>();
  private IUpdate notify = null;
  private int count = 0;
  private int total = 0;
  
  private Genson genson;

  private MqttClient client;
  private MqttConnectOptions connectionOptions;
  private String clientID;  
  
  public BusConsumerComponent() {
    /* nothing */
  }

  public String getBusURI() {
    return busURI;
  }

  public void setBusURI(String busURI) {
    this.busURI = busURI;
  }
  
  public String getTopic() {
     return topic;
  }
  
  public void setTopic(String topic) {
     this.topic = topic;
     readDS();
  }
  
  public int getBlockSize() {
     return blockSize;
  }
  
  public void setBlockSize(int blockSize) {
     this.blockSize = blockSize;
  }
  
  public int getNumber() {
     return number;
  }
  
  public void setNumber(int number) {
     this.number = number;
  }
  
  public int getVerbose() {
     return verbose;
  }
  
  public void setVerbose(int verbose) {
     this.verbose = verbose;
  }
  
  public void connect(IUpdate notify) {
     this.notify = notify;
  }
  
  public String[] requestAttributes() {
    return attributes;
  }
  
  public String[][] requestInstances() {
    String instances[][] = instArray.toArray(new String[0][]);
    instArray = new ArrayList<String[]>();
    return instances;
  }
  
  private void readDS() {
    genson = new GensonBuilder()
      .useDateFormat(new SimpleDateFormat("yyyy-MM-dd"))
      .useIndentation(true)
      .useConstructorWithArguments(false)
      .create();
     
    clientID = UUID.randomUUID().toString();      
    connectionOptions = new MqttConnectOptions();
    connectionOptions.setAutomaticReconnect(true);
    connectionOptions.setCleanSession(true);
    connectionOptions.setConnectionTimeout(20);
     
    try {
      client = new MqttClient(busURI, clientID);
      client.connect(connectionOptions);            
      client.setCallback(this);
      client.subscribe(topic);
      System.out.println("[MQTTConsumer] connected");            
    } catch (MqttException e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void connectionLost(Throwable cause) {
    System.out.println("[BusConsumerComponent] Connection lost.  Reason: " + cause);
    System.exit(1);
  }

  @Override
  public void messageArrived(String topic, MqttMessage message) throws MqttException {
    if (total < number) {
       Message mess = genson.deserialize(new String(message.getPayload()), Message.class);
       
       SensorReading body = mess.getBody();
       
       count++;
       total++;
       String reading[] = {Integer.toString(count),
                           Long.toString(body.getTimestamp().getTime()), body.getDimension(),
                           Double.toString(body.getValue()), body.getUnity()}; 
       instArray.add(reading);
       
       switch (verbose) {
          case 1: System.out.println("message: " + count); break;
          case 2: System.out.println("message: " + count);
                  System.out.println("topic: " + topic);
                  String json = genson.serialize(mess);
                  System.out.println(json);
                  break;
       }
   
       if (count == blockSize && notify != null) {
          count = 0;
          notify.update();
       }
    }
    
  }


  @Override
  public void deliveryComplete(IMqttDeliveryToken token) {
  }
}
