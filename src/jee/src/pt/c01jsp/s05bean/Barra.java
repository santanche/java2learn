package pt.c01jsp.s05bean;

public class Barra {
    private int tamanho;
    
    public int getTamanho() {
        return tamanho;
    }
    
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    public String monta() {
    	String d = "";
    	for (int t = 1; t <= tamanho; t++)
    		d += "=";
        return d;
    }
}
