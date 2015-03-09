package pt.c02oo.s12agregacao.s02bastiao.partes;

import pt.c02oo.s12agregacao.s02bastiao.Bastiao.TipoEstado;

public class Face
{
    private Olho olhoEsquerdo, olhoDireito;
    
    public Face(TipoEstado estado)
    {
        olhoEsquerdo = new Olho(estado);
        olhoDireito = new Olho(estado);
    }
    
    public void aparece()
    {
        System.out.print(" ");
        olhoEsquerdo.aparece();
        System.out.print("*");
        olhoDireito.aparece();
        System.out.println();
    }
    
    public void dorme()
    {
        olhoEsquerdo.dorme();
        olhoDireito.dorme();
    }
    
    public void acorda()
    {
        olhoEsquerdo.acorda();
        olhoDireito.acorda();
    }
}
