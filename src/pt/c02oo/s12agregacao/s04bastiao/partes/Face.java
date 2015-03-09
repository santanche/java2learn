package pt.c02oo.s12agregacao.s04bastiao.partes;

import pt.c02oo.s12agregacao.s04bastiao.Bastiao;

public class Face extends Parte
{
    private Olho olhoEsquerdo, olhoDireito;
    
    public Face(Bastiao pai)
    {
        olhoEsquerdo = new Olho(pai);
        olhoDireito = new Olho(pai);
    }
    
    public void aparece()
    {
        System.out.print(" ");
        olhoEsquerdo.aparece();
        System.out.print("*");
        olhoDireito.aparece();
        System.out.println();
    }
}
