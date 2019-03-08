package pt.c02oo.s12agregacao.s03bastiao.partes;

import pt.c02oo.s12agregacao.s03bastiao.Bastiao;

public class Olho implements Parte
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
    
    public void mudaCaracteristica(String caracteristica,
                                   String valor)
    {
        /* nada */
    }
}
