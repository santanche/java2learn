package pt.c03java.s07anotacao.s02anotacaocustomizada;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnotacaoClasse
{
    public String value();
}
