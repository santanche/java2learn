package pt.c02oo.s12agregacao.s01bastiao;

import pt.c02oo.s12agregacao.s01bastiao.partes.Olho;
import pt.c02oo.s12agregacao.s01bastiao.partes.Topete;
import pt.c02oo.s12agregacao.s01bastiao.partes.Topete.TipoTopete;

public class Bastiao
{
    public enum TipoEstado {ACORDADO, DORMINDO}
	
	private int idade;
	private String nome;
    
    /* objetos agregados */
    private Topete meuTopete;
    private Olho meuOlhoEsquerdo, meuOlhoDireito;

    public Bastiao()
    {
        this(1, TipoEstado.ACORDADO, "bastiao");
    }
    
    public Bastiao(int idade, TipoEstado estado, String nome)
    {
        this.idade = idade;
        this.nome = nome;
        
        meuTopete = new Topete(TipoTopete.ESPALHADO);
        meuOlhoEsquerdo = new Olho(estado);
        meuOlhoDireito = new Olho(estado);
    }

    public void aparece(boolean imprimeNome)
    {
        if (idade >= 2)
            meuTopete.aparece();

        System.out.print(" ");
        meuOlhoEsquerdo.aparece();
        System.out.print("*");
        meuOlhoDireito.aparece();
        System.out.println();

        if (idade >= 3)
            System.out.println("*****");

        if (imprimeNome)
            System.out.println(nome);
    }

    public void aparece()
    {
        aparece(true);
    }

    public void cresce()
    {
        if (idade < 3)
            idade++;
        aparece();
    }

    public void dorme()
    {
        meuOlhoEsquerdo.dorme();
        meuOlhoDireito.dorme();
        aparece();
    }

    public void acorda()
    {
        meuOlhoEsquerdo.acorda();
        meuOlhoDireito.acorda();
        aparece();
    }

    public void penteia()
    {
        meuTopete.mudaTopete(TipoTopete.PENTEADO);
        aparece();
    }
}
