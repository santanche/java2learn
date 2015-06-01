package pt.c03java.s06anotacao.s03metaanotacao;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MetaanotacaoMetodo
{
    public String value();
}
