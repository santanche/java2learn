package pt.c03java.s06anotacao.s02anotacaocustomizada;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AppExtratorAnotacao
{
    public static void main(String args[])
    {
        Annotation anotacoesClasse[] = ExemploAnotado.class.getAnnotations();
        for (Annotation ac : anotacoesClasse) {
            if (ac instanceof AnotacaoClasse)
                System.out.println("* Anotacao da classe: " + ((AnotacaoClasse)ac).value());
            else
                System.out.println("* Anotacao da classe (tipo desconhecido)");
        }
        
        Field atributos[] = ExemploAnotado.class.getDeclaredFields();
        for (Field a : atributos) {
            System.out.println("Atributo: " + a.getName());
            
            Annotation anotacoesAtributo[] = a.getAnnotations();
            for (Annotation aa : anotacoesAtributo) {
                if (aa instanceof AnotacaoAtributo)
                    System.out.println("    * Anotacao do atributo: " + ((AnotacaoAtributo)aa).value());
                else
                    System.out.println("    * Anotacao do atributo (tipo desconhecido)");
            }
        }

        Method metodos[] = ExemploAnotado.class.getDeclaredMethods();
        for (Method m : metodos) {
            System.out.println("Metodo: " + m.getName());
            
            Annotation anotacoesMetodo[] = m.getAnnotations();
            for (Annotation am : anotacoesMetodo) {
                if (am instanceof AnotacaoMetodo)
                    System.out.println("    * Anotacao do metodo: " + ((AnotacaoMetodo)am).value());
                else
                    System.out.println("    * Anotacao do metodo (tipo desconhecido)");
            }
        }
    }
}
