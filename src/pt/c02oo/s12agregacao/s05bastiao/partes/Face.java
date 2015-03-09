package pt.c02oo.s12agregacao.s05bastiao.partes;

import pt.c02oo.s12agregacao.s05bastiao.Bastiao;

public class Face implements Parte
{
    public static final int OLHO_ESQUERDO = 0,
                            NARIZ = 1,
                            OLHO_DIREITO = 2,
                            NUMERO_PARTES = 3;
    
    private Parte partesFace[];
    
    public Face(Bastiao pai)
    {
        partesFace = new Parte[NUMERO_PARTES];
        
        partesFace[OLHO_ESQUERDO] = new Olho(pai);
        partesFace[NARIZ] = new Nariz();
        partesFace[OLHO_DIREITO] = new Olho(pai);
    }
    
    public void aparece()
    {
        System.out.print(" ");
        for (int p = 0; p < NUMERO_PARTES; p++)
            partesFace[p].aparece();
        System.out.println();
    }
}
