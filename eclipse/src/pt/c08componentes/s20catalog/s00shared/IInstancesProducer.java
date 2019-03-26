package pt.c08componentes.s20catalog.s00shared;

import weka.core.Instances;

public interface IInstancesProducer {
  Instances requestInstancesWeka();
}
