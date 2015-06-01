package pt.c03java.s03reflexao.s01basico;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AppReflete01
{

    public static void main(String[] args)
    {
        Class<Bastiao> classeBastiao = Bastiao.class;
        
        String nome = classeBastiao.getCanonicalName();
        
        System.out.println("Nome: " + nome);
        
        Method metodos[] = classeBastiao.getMethods();
        
        for (int m = 0; m < metodos.length; m++)
            System.out.println("Metodo: " + metodos[m].getName());
        
        Field atributos[] = classeBastiao.getFields();
        
        for (int a = 0; a < atributos.length; a++)
            System.out.println("Atributo: " + atributos[a].getName());

        Field atributosDeclarados[] = classeBastiao.getDeclaredFields();
        
        for (int a = 0; a < atributosDeclarados.length; a++)
            System.out.println("Atributo: " + atributosDeclarados[a].getName());
    }

}
