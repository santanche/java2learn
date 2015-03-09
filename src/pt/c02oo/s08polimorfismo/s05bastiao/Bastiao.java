package pt.c02oo.s08polimorfismo.s05bastiao;

public class Bastiao
{
    protected int idade = 1;
    protected String estado = "acordado",
                     nome = "bastiao";

    public Bastiao()
    {
        /* nada */
    }
    
    public Bastiao(int idade, String estado, String nome)
    {
        this.idade = idade;
        this.estado = estado;
        this.nome = nome;
    }

    public void aparece(boolean imprimeNome)
    {
        if (idade >= 2)
            System.out.println("  *");

        if (estado.equals("dormindo"))
            System.out.println(" -*-");
        else
            System.out.println(" O*O");

        if (idade >= 3)
            System.out.println("*****");

        if (imprimeNome)
            System.out.println(nome);
    }

    public void aparece()
    {
        aparece(true);
    }

    public void cresce()
    {
        if (idade < 3)
            idade++;
        aparece();
    }

    public void dorme()
    {
        estado = "dormindo";
        aparece();
    }

    public void acorda()
    {
        estado = "acordado";
        aparece();
    }

}
