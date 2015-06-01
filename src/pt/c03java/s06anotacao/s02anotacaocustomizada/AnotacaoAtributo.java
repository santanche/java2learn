package pt.c03java.s06anotacao.s02anotacaocustomizada;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnotacaoAtributo
{
    public String value();
}
