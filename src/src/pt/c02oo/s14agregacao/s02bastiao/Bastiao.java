package pt.c02oo.s12agregacao.s02bastiao;

import pt.c02oo.s12agregacao.s02bastiao.partes.Barriga;
import pt.c02oo.s12agregacao.s02bastiao.partes.Face;
import pt.c02oo.s12agregacao.s02bastiao.partes.Topete;
import pt.c02oo.s12agregacao.s02bastiao.partes.Topete.TipoTopete;

public class Bastiao
{
    public enum TipoEstado {ACORDADO, DORMINDO}
	
	private int idade;
    
    /* objetos agregados */
    private Topete meuTopete;
    private Face minhaFace;
    private Barriga minhaBarriga;
    
    public Bastiao()
    {
        this(1, TipoEstado.ACORDADO);
    }
    
    public Bastiao(int idade, TipoEstado estado)
    {
        this.idade = idade;
        
        meuTopete = new Topete(TipoTopete.ESPALHADO, this);
        minhaFace = new Face(estado);
        minhaBarriga = new Barriga(idade);
    }

    public void aparece()
    {
        meuTopete.aparece();
        minhaFace.aparece();
        minhaBarriga.aparece();
    }

    public void cresce()
    {
        if (idade < 3)
            idade++;
        aparece();
    }

    public void dorme()
    {
        minhaFace.dorme();
        aparece();
    }

    public void acorda()
    {
        minhaFace.acorda();
        aparece();
    }

    public void penteia()
    {
        meuTopete.mudaTopete(TipoTopete.PENTEADO);
        aparece();
    }

    public int getIdade()
    {
        return idade;
    }
}
