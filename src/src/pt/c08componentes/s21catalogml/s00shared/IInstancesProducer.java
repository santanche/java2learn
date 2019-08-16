package pt.c08componentes.s21catalogml.s00shared;

import weka.core.Instances;

public interface IInstancesProducer {
  Instances requestInstances();
}
