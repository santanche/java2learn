package pt.c02oo.s12agregacao.s02bastiao.partes;

import pt.c02oo.s12agregacao.s02bastiao.Bastiao.TipoEstado;

public class Olho
{
    private TipoEstado estado;
    
    public Olho(TipoEstado estado)
    {
        this.estado = estado;
    }

    public void aparece()
    {
        switch (estado) {
            case ACORDADO : System.out.print("O"); break;
            case DORMINDO : System.out.print("-"); break;
        }
    }

    public void dorme()
    {
        estado = TipoEstado.DORMINDO;
    }

    public void acorda()
    {
        estado = TipoEstado.ACORDADO;
    }
}
