package pt.c08componentes.s21catalogml.s90ml;

public class EHRConsoleComponent implements IEHRConsole {
	public void sendEHR(EHR ehr) {
		System.out.println("Name: " + ehr.getName());
		System.out.println("Age: " + ehr.getAge());
		System.out.println("Symptoms: " + ehr.getSymptoms());
		System.out.println("Diagnostics: " + ehr.getDiagnostics());
	}
}
