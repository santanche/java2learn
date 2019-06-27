package pt.c02oo.s12agregacao.s03bastiao;

import pt.c02oo.s12agregacao.s03bastiao.partes.Barriga;
import pt.c02oo.s12agregacao.s03bastiao.partes.Face;
import pt.c02oo.s12agregacao.s03bastiao.partes.Parte;
import pt.c02oo.s12agregacao.s03bastiao.partes.Topete;
import pt.c02oo.s12agregacao.s03bastiao.partes.Topete.TipoTopete;

public class Bastiao
{
    public static final int TOPETE = 0,
                            FACE = 1,
                            BARRIGA = 2,
                            NUMERO_PARTES = 3;
    
    public enum TipoParte {TOPETE, FACE, BARRIGA};
    
    public enum TipoEstado {ACORDADO, DORMINDO}
	
	private int idade;
	private TipoEstado estado;
    
    /* objetos agregados */
	private Parte partesCorpo[];
    
    public Bastiao()
    {
        this(1, TipoEstado.ACORDADO);
    }
    
    public Bastiao(int idade, TipoEstado estado)
    {
        this.idade = idade;
        this.estado = estado;

        partesCorpo = new Parte[NUMERO_PARTES];
        
        partesCorpo[TOPETE] = new Topete(TipoTopete.ESPALHADO, this);
        partesCorpo[FACE] = new Face(this);
        partesCorpo[BARRIGA] = new Barriga(this);
    }

    public void aparece()
    {
        for (int p = 0; p < NUMERO_PARTES; p++)
            partesCorpo[p].aparece();
    }

    public void cresce()
    {
        if (idade < 3)
            idade++;
        aparece();
    }

    public void dorme()
    {
        estado = TipoEstado.DORMINDO;
        aparece();
    }

    public void acorda()
    {
        estado = TipoEstado.ACORDADO;
        aparece();
    }

    public void penteia()
    {
        partesCorpo[TOPETE].mudaCaracteristica("topete", "penteado");
        aparece();
    }

    public int getIdade()
    {
        return idade;
    }
    
    public TipoEstado getEstado()
    {
        return estado;
    }
}
