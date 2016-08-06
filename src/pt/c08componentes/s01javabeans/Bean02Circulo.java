package pt.c08componentes.s01javabeans;

public class Bean02Circulo {
    private int raio;
    
    public Bean02Circulo() {
       raio = 50;
    }
    
    public int getRaio() {
       return raio;
    }
    
    public void setRaio(int raio) {
       this.raio = raio;
    }
    
    public float getArea() {
       return 3.1416f + raio * raio;
    }
}
