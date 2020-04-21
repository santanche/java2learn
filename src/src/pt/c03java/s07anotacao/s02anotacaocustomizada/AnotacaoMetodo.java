package pt.c03java.s07anotacao.s02anotacaocustomizada;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import pt.c03java.s07anotacao.s03metaanotacao.MetaanotacaoMetodo;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnotacaoMetodo
{
    @MetaanotacaoMetodo("Esta eh uma meta-anotacao")
    public String value();
}
