package pt.c06patterns.factory.s07zebatata.implementacao.quincas;

import pt.c06patterns.factory.s07zebatata.produto.Boca;
import pt.c06patterns.factory.s07zebatata.produto.FabricaBatata;
import pt.c06patterns.factory.s07zebatata.produto.Nariz;
import pt.c06patterns.factory.s07zebatata.produto.Olho;

public class FabricaQuincas implements FabricaBatata
{
    public FabricaQuincas()
    {
    }
	
	public Olho criaOlhoEsquerdo()
	{
		return new OlhosQuincas("esquerdo");
	}

    public Olho criaOlhoDireito()
    {
        return new OlhosQuincas("direito");
    }

    public Nariz criaNariz()
    {
        return new NarizQuincas();
    }
    
    
    public Boca criaBoca()
    {
        return new BocaQuincas();
    }
}
