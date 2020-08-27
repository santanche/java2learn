package pt.c08componentes.s10statistics.s03component.v02;

public interface IStatisticsProperties {

	int getSize();

	double[] getValueSet();

	void setValueSet(double[] valueSet);

	double getValueSet(int index);

	void setValueSet(int index, double value);

}