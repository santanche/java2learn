package pt.c08componentes.s01javabeans;

public class Bean01Nome {
    private String primeiroNome = "",
                   sobrenome = "";
    
    /**
     * Construtor sem argumentos
     */
    public Bean01Nome() {
        /* nada */
    }
    
    public String getPrimeiroNome() {
        return primeiroNome;
    }
    
    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNomeCompleto() {
        return primeiroNome + " " + sobrenome;
    }
}
