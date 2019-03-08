package pt.c08componentes.s10statistics.s03component.v02;

public interface IStatisticsProperties {

	int getSize();

	void setSize(int size);

	int getLast();

	double[] getValueSet();

	void setValueSet(double[] valueSet);

	double getValueSet(int index);

	void setValueSet(int index, double value);

}