package pt.c02oo.s14exonline.q01generalizada;

public class Produto
{
    private String nome;
    private Produto next = null,
                    firstChild = null;
    
    public int compara(Produto outro)
    {
        int result = 0;
        
        if (firstChild == null) {
            if (outro.firstChild != null)
                result = 2;
            else
                if (!nome.equalsIgnoreCase(outro.nome))
                    if (Compara.eq(nome, outro.nome))
                        result = 1;
                    else
                        result = 2;
        } else {
            if (outro.firstChild == null)
                result = 2;
            else {
                Produto p1 = firstChild,
                        p2 = outro.firstChild;
                while (p1 != null && p2 != null) {
                    int comp = p1.compara(p2);
                    if (comp == 1 && result < 2)
                        result = 1;
                    else if (comp == 2)
                        result = comp;
                    p1 = p1.next;
                    p2 = p2.next;
                }
                if (p1 != p2)
                    result = 2;
            }
        }
        
        return result;
    }
}
