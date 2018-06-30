package pt.c08componentes.s20catalog.s20console;

public class ConsoleComponent implements IConsole {
  private Object source;
  
  public void connect(Object source) {
    this.source = source;
  }
  
  public void update() {
    if (source != null)
      System.out.println(source.toString());
  }
}
