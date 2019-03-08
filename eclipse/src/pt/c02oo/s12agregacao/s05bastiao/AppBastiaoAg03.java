package pt.c02oo.s12agregacao.s05bastiao;

import pt.c02oo.s12agregacao.s05bastiao.Bastiao.TipoEstado;

public class AppBastiaoAg03
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
