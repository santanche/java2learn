package pt.c03java.s06anotacao.s03dao;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MapCampo
{
    public String value();
}
