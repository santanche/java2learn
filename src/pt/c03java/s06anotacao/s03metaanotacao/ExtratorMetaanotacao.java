package pt.c03java.s06anotacao.s03metaanotacao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import pt.c03java.s06anotacao.s02anotacaocustomizada.AnotacaoMetodo;

public class ExtratorMetaanotacao
{
    public static void main(String args[])
    {
        Method metodos[] = AnotacaoMetodo.class.getDeclaredMethods();
        for (Method m : metodos)
        {
            System.out.println("Metodo: " + m.getName());
            
            Annotation anotacoesMetodo[] = m.getAnnotations();
            for (Annotation am : anotacoesMetodo)
            {
                if (am instanceof MetaanotacaoMetodo)
                    System.out.println("    * Anotacao do metodo: " + ((MetaanotacaoMetodo)am).value());
                else
                    System.out.println("    * Anotacao do metodo (tipo desconhecido)");
            }
        }
    }
}
