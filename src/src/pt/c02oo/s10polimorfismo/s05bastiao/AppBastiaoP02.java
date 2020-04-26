package pt.c02oo.s08polimorfismo.s05bastiao;

public class AppBastiaoP02
{
    public static void main(String argumentos[])
    {
        Bastiao theGeneric = null;

        if (argumentos.length < 1)
        {
            System.out.println("Bastiao on-line:");
            System.out.println("Sintaxe: java Principal <escolhido>");
        } else {
            if (argumentos[0].equalsIgnoreCase("Bastiao"))
                theGeneric = new Bastiao(1, "acordado", "Bastiao");
            else if (argumentos[0].equalsIgnoreCase("Perfeito"))
                theGeneric = new Perfeito(1, "acordado", "Perfeito", "normal");
            else if (argumentos[0].equalsIgnoreCase("Monstro"))
                theGeneric = new Monstro(1, "acordado", "Monstro");
            
            imprimeBastiao(theGeneric);
        }
    }
    
    public static void imprimeBastiao(Bastiao theGeneric)
    {
        System.out.println();

        if (theGeneric == null)
            System.out.println("Este bastiao nao existe");
        else
        {
            theGeneric.aparece();
            System.out.println();
            for (int i = 1; i <= 4; i++) {
                theGeneric.cresce();
                System.out.println();
            }
        }
    }

}
