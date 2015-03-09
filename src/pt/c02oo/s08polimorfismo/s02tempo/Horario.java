package pt.c02oo.s08polimorfismo.s02tempo;

public class Horario extends Tempo
{
    private int hora = 0,
                minuto = 0,
                segundo = 0;

    public Horario()
    {
    }

    public Horario(int hora, int minuto, int segundo)
    {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }

    public void setHora(int hora)
    {
        if (hora >= 0 && hora <= 23)
            this.hora = hora;
    }

    public int getHora()
    {
        return hora;
    }

    public void setMinuto(int minuto)
    {
        if (minuto >= 0 && minuto <= 59)
            this.minuto = minuto;
    }

    public int getMinuto()
    {
        return minuto;
    }

    public void setSegundo(int segundo)
    {
        if (segundo >= 0 && segundo <= 59)
            this.segundo = segundo;
    }

    public int getSegundo()
    {
        return segundo;
    }

    public long quantidade()
    {
        return hora * 3600 + minuto * 60 + segundo;
    }

    public String toString()
    {
        return hora + ":" + minuto + ":" + segundo;
    }
}
