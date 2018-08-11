package pt.c08componentes.s20catalog.s90ml;

import java.util.Random;

import pt.c08componentes.s20catalog.s00shared.IColumnProducer;
import pt.c08componentes.s20catalog.s00shared.IInstancesProducer;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;

public class DiagnosticsComponent implements IDiagnostics {
  private IInstancesProducer iProducer;
  IColumnProducer cProducer;
  
  public void connect(IInstancesProducer producer) {
    iProducer = producer;
  }
  
  public void update(double[] symptoms) {
    try {
      if (iProducer != null) {
        Instances dataTrain = iProducer.requestInstances();
        // setting class attribute
	    dataTrain.setClassIndex(dataTrain.numAttributes() - 1);
	    
	    System.out.println(dataTrain.instance(0));
	      
	    String[] options = {"-U"};  // unpruned tree
	    J48 tree = new J48();       // new instance of tree
	    tree.setOptions(options);   // set the options
	    tree.buildClassifier(dataTrain); // build classifier
	      
	    Evaluation eval = new Evaluation(dataTrain);
	    eval.crossValidateModel(tree, dataTrain, 10, new Random(1)); 
	      
	    System.out.println(eval.toSummaryString("\nResults\n======\n", false));

	    Instance input = dataTrain.instance(0).copy(symptoms);
        double clsLabel = tree.classifyInstance(input);
        input.setClassValue(clsLabel);
	      
        System.out.println("===== Classification:");
	    System.out.println(input);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
