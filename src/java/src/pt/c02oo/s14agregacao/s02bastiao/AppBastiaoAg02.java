package pt.c02oo.s14agregacao.s02bastiao;

import pt.c02oo.s14agregacao.s02bastiao.Bastiao.TipoEstado;

public class AppBastiaoAg02
{
    public static void main(String args[])
    {
        Bastiao theBastian = new Bastiao(2, TipoEstado.ACORDADO);
        
        theBastian.aparece();
        System.out.println();
        
        theBastian.dorme();
        System.out.println();
        
        theBastian.penteia();
    }
}
