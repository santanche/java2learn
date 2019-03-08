package pt.c02oo.s08polimorfismo.s05bastiao;

public class Perfeito extends Bastiao
{
    private String situacao = "normal";
    
    public Perfeito()
    {
        super();
    }

    public Perfeito(int idade, String estado, String nome, String situacao)
    {
        super(idade, estado, nome);
        this.situacao = situacao;
    }

    public void aparece(boolean imprimeNome)
    {
        System.out.println("+-----+");

        if (idade >= 2)
            System.out.println("|     |");

        if (estado.equals("dormindo")) {
            System.out.println(" - -");
            System.out.println("|  _  |"); }
        else if (situacao.equals("normal")) {
            System.out.println("| o-o |");
            System.out.println("| ___ |"); }
        else if (situacao.equals("milionario")) {
            System.out.println("| $-$ |");
            System.out.println("| ___ |"); }
        else if (situacao.equals("doido")) {
            System.out.println("| @-@ |");
            System.out.println("|  ~  |");
        }

        if (idade < 3)
            System.out.println(" \\___/");
        else {
            System.out.println("|     |");
            System.out.println("\\_____/");
        }

        if (imprimeNome)
            System.out.println(nome);
    }

    public void mudaSituacao()
    {
        String s[] = {"normal",
                      "milionario",
                      "doido" };

        int p;
        for (p = 0; p < s.length && !situacao.equals(s[p]); p++)
            /* nada */ ;

        p = (p + 1) % 3;
        situacao = s[p];

        aparece();
    }
}
