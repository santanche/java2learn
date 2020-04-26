package pt.c02oo.s13subtipo;

public class PilhaAritmetica extends Pilha
{
    public PilhaAritmetica(int tamanho)
    {
        super(tamanho);
    }
    
    public void calcula(char operacao)
    {
        int resultado = 0;
        if (numeroElementos() >= 2) {
            int op2 = desempilha(),
                op1 = desempilha();
            switch (operacao)
            {
                case '+' : resultado = op1 + op2; break;
                case '-' : resultado = op1 - op2; break;
                case '*' : resultado = op1 * op2; break;
                case '/' : resultado = op1 / op2; break;
            }
        }
        empilha(resultado);
    }
}
