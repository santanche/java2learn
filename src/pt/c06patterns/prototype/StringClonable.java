package pt.c06patterns.prototype;

class StringClonable implements Cloneable
{
    private StringBuffer conteudo;
    
    public StringClonable(String conteudo)
    {
        this.conteudo = new StringBuffer(conteudo);
    }
    
    public void append(String toAppend)
    {
        conteudo.append(toAppend);
    }
    
    public StringClonable clone()
    {
        return new StringClonable(conteudo.toString());
    }
    
    public String toString()
    {
        return conteudo.toString();
    }
}
