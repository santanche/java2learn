package pt.c02oo.s12agregacao.s01bastiao;

import pt.c02oo.s12agregacao.s01bastiao.Bastiao.TipoEstado;

public class AppBastiaoAg01
{
    public static void main(String args[])
    {
        Bastiao theBastian = new Bastiao(2, TipoEstado.ACORDADO, "Alcebiades");
        
        theBastian.aparece();
        System.out.println();
        
        theBastian.dorme();
        System.out.println();
        
        theBastian.penteia();
    }
}
