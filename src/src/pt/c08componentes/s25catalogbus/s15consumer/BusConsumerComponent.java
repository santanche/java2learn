package pt.c08componentes.s25catalogbus.s15consumer;

import java.text.SimpleDateFormat;
import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

import pt.c08componentes.s25catalogbus.s00shared.Message;

public class BusConsumerComponent implements IBusConsumer, MqttCallback {
  private String busURI = null;
  private String topic = null;
  private int blockSize = 10;
  private String[] attributes = null;
  private String[][] instances = null;
  
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
    if (busURI == null) {
      attributes = null;
      instances = null;
    }
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
  
  public String[] requestAttributes() {
    return attributes;
  }
  
  public String[][] requestInstances() {
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
     
    /*
    ArrayList<String[]> instArray = new ArrayList<String[]>();
    try {
      BufferedReader file = new BufferedReader(new FileReader(busURI));
        
      String line = file.readLine();
      if (line != null) {
        attributes = line.split(",");
        line = file.readLine();
        while (line != null) {
          String[] instLine = line.split(",");
          instArray.add(instLine);
          line = file.readLine();
        }
        instances = instArray.toArray(new String[0][]);
      }
        
      file.close();
    } catch (IOException erro) {
      erro.printStackTrace();
    }
    */
  }
  
  @Override
  public void connectionLost(Throwable cause) {
    System.out.println("[BusConsumerComponent] Connection lost.  Reason: " + cause);
    System.exit(1);
  }

  @Override
  public void messageArrived(String topic, MqttMessage message) throws MqttException {
    Message mess = genson.deserialize(new String(message.getPayload()), Message.class);
    
    String json = genson.serialize(mess);

    System.out.println(json);
  }


  @Override
  public void deliveryComplete(IMqttDeliveryToken token) {
  }
}
