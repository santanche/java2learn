package pt.c02oo.s08polimorfismo.s05bastiao;

public class Monstro extends Bastiao
{
    public Monstro()
    {
        super();
    }
    
    public Monstro(int idade, String estado, String nome)
    {
        super(idade, estado, nome);
    }

    public void aparece(boolean imprimeNome)
    {
        super.aparece(false);

        if (idade >= 4)
            System.out.println("#####");
        if (idade >= 5)
            System.out.println("/   \\");

        if (imprimeNome)
            System.out.println(nome);
    }

    public void cresce()
    {
        if (idade < 5)
            idade++;
        aparece();
    }
}

