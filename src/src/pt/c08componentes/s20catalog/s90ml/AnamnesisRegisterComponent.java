package pt.c08componentes.s20catalog.s90ml;

public class AnamnesisRegisterComponent implements IAnamnesisRegister {
  IEHR ehrOutput;
	
  public void connect(IEHR ehr) {
    this.ehrOutput = ehr;
  }

  public boolean start() {
	  double[] symptoms = {0, 0, 1, 1, 1, 1, 1, 0};
	  if (ehrOutput != null) {
        ehrOutput.sendEHR(new EHR("Asdrubal", 45, symptoms, ""));
	  }
	  return true;
  }
  
  public boolean stop() {
    return true;
  }
}
