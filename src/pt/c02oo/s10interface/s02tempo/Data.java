package pt.c02oo.s10interface.s02tempo;

public class Data implements Tempo
{
    private int dia = 1,
                mes = 1,
                ano = 1;

    public Data()
    {
    }

    public Data(int dia, int mes, int ano)
    {
        setDia(dia);
        setMes(mes);
        setAno(ano);
    }

    public void setDia(int dia)
    {
        if (dia >= 1 && dia <= 30)
            this.dia = dia;
    }

    public int getDia()
    {
        return dia;
    }

    public void setMes(int mes)
    {
        if (mes >= 1 && mes <= 12)
            this.mes = mes;
    }

    public int getMes()
    {
        return mes;
    }

    public void setAno(int ano)
    {
        if (ano >= 1)
            this.ano = ano;
    }

    public int getAno()
    {
        return ano;
    }

    public long quantidade()
    {
        return (long)(ano * 31104000 + mes * 2592000 + dia * 86400);
    }

    public String toString()
    {
        return dia + "/" + mes + "/" + ano;
    }
}
