/**
 * 
 */
package pt.c30ml.s01classifier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;

public class ZombieHealthTree {

  public static void main(String[] args) {
    BufferedReader readerTrain, readerTest;
    try {
      readerTrain = new BufferedReader(
                     new FileReader("db/datasets/zombie/weka/zombie-health-spreadsheet-ml-training.arff"));
      Instances dataTrain = new Instances(readerTrain);
      readerTrain.close();
      // setting class attribute
      dataTrain.setClassIndex(dataTrain.numAttributes() - 1);
      
      String[] options = {"-U"};  // unpruned tree
      J48 tree = new J48();       // new instance of tree
      tree.setOptions(options);   // set the options
      tree.buildClassifier(dataTrain); // build classifier
      
      Evaluation eval = new Evaluation(dataTrain);
      eval.crossValidateModel(tree, dataTrain, 10, new Random(1)); 
      
      System.out.println(eval.toSummaryString("\nResults\n======\n", false));
      
      readerTest = new BufferedReader(
                    new FileReader("db/datasets/zombie/weka/zombie-health-spreadsheet-ml-test.arff"));
      Instances dataTest = new Instances(readerTest);
      readerTest.close();
      dataTest.setClassIndex(dataTrain.numAttributes() - 1);

      // label instances
      for (int i = 0; i < dataTest.numInstances(); i++) {
        double clsLabel = tree.classifyInstance(dataTest.instance(i));
        dataTest.instance(i).setClassValue(clsLabel);
      }
      
      System.out.println("===== Classification:");
      System.out.println(dataTest);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
