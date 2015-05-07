package pt.c06patterns.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class BastiaoDAO implements Serializable
{
    // captura o diretorio em que se encontra a classe bastiao
    public static String DIRETORIO = BastiaoDAO.class.getResource(".").getPath() + "/";
   
    private static final long serialVersionUID = 3863010501019562695L;
    
    private int idade;
    private String estado;
    private String nome;
    
    public final static int MAIOR_IDADE = 3;
    
    public BastiaoDAO()
    {
        
    }
    
    public BastiaoDAO(int idade, String estado, String nome)
    {
        this.idade = idade;
        this.estado = estado;
        this.nome = nome;
    }
    
    public void aparece()
    {
        // cabeleira
        if (idade >= 2)
            System.out.println("  *");
        
        // corpo com olhos
        if (estado.equalsIgnoreCase("acordado"))
            System.out.println(" o*o");
        else
            System.out.println(" -*-");
        
        // barba
        if (idade >= 3)
            System.out.println("*****");
        
        System.out.println(nome);
        
        System.out.println();
    }
    
    public void cresce()
    {
        if (idade < MAIOR_IDADE)
            idade++;
        aparece();
    }
    
    public void acorda()
    {
        estado = "acordado";
        aparece();
    }
    
    public void dorme()
    {
        estado = "dormindo";
        aparece();
    }
    
    /* Getters e setters
     */

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void write(PrintWriter saida) {
       saida.println(idade);
       saida.println(estado);
       saida.println(nome);
    }
    
    public void read(BufferedReader entrada) {
       try {
          idade = new Integer(entrada.readLine());
          estado = entrada.readLine();
          nome = entrada.readLine();
       } catch (IOException erro) {
          erro.printStackTrace();
       }
    }
}
