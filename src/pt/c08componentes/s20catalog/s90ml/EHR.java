package pt.c08componentes.s20catalog.s90ml;

public class EHR {
	private String name;
	private int age;
	private double symptoms[];
	private String diagnostics;

	public EHR(String name, int age, double symptoms[], String diagnostics) {
		this.name = name;
		this.age = age;
		this.symptoms = symptoms;
		this.diagnostics = diagnostics;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double[] getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(double[] symptoms) {
		this.symptoms = symptoms;
	}
	public String getDiagnostics() {
		return diagnostics;
	}
	public void setDiagnostics(String diagnostics) {
		this.diagnostics = diagnostics;
	}
}
