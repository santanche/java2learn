package pt.c02oo.s12agregacao.s04bastiao.partes;

import pt.c02oo.s12agregacao.s04bastiao.Bastiao;

public class Olho extends Parte
{
    private Bastiao pai;
    
    public Olho(Bastiao pai)
    {
        this.pai = pai;
    }

    public void aparece()
    {
        switch (pai.getEstado()) {
            case ACORDADO : System.out.print("O"); break;
            case DORMINDO : System.out.print("-"); break;
        }
    }
}
