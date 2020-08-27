package pt.c01jsp.s07beanentrada;

public class CalculaDias
{
    private int idade;
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public int calcula() {
        return idade * 365;
    }
}
