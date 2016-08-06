package pt.c08componentes.s01javabeans;

import pt.c08componentes.s01javabeans.Bean01Nome;

public class App01BeanNome {

    public static void main(String[] args) {
        Bean01Nome b = new Bean01Nome();
        b.setPrimeiroNome("Asdrubal");
        b.setSobrenome("Silva");
        
        System.out.println("Primeiro nome: " + b.getPrimeiroNome());
        System.out.println("Sobrenome: " + b.getSobrenome());
        System.out.println("Nome completo: " + b.getNomeCompleto());
    }

}
