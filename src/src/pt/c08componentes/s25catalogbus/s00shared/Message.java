package pt.c08componentes.s25catalogbus.s00shared;

public class Message {
   private String source;
   private String name;
   private String type;
   private SensorReading body;
   
   public String getSource() {
      return source;
   }
   
   public void setSource(String source) {
      this.source = source;
   }
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   public String getType() {
      return type;
   }
   
   public void setType(String type) {
      this.type = type;
   }
   
   public SensorReading getBody() {
      return body;
   }
   
   public void setBody(SensorReading body) {
      this.body = body;
   }
}
