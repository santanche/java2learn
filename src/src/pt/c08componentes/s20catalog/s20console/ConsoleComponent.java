package pt.c08componentes.s20catalog.s20console;

import pt.c08componentes.s20catalog.s00shared.ITableProducer;

public class ConsoleComponent implements IConsole {
  private ITableProducer iProducer;
  
  public void connect(ITableProducer producer) {
    iProducer = producer;
  }
  
  public void update() {
    if (iProducer != null) {
        System.out.println("=== Attributes ===");
        String attributes[] = iProducer.requestAttributes();
        for (int a = 0; a < attributes.length-1; a++)
          System.out.print(attributes[a] + ", ");
        System.out.println(attributes[attributes.length-1]);

        System.out.println();
        System.out.println("=== Instances ===");
        String instances[][] = iProducer.requestInstances();
        for (int i = 0; i < instances.length; i++) {
          for (int a = 0; a < attributes.length-1; a ++)
            System.out.print(instances[i][a] + ", ");
          System.out.println(instances[i][attributes.length-1]);
        }
    }
  }}
