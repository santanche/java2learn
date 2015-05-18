package pt.c06patterns.factory.s07zebatata.implementacao.doriana;

import pt.c06patterns.factory.s07zebatata.produto.Boca;
import pt.c06patterns.factory.s07zebatata.produto.FabricaBatata;
import pt.c06patterns.factory.s07zebatata.produto.Nariz;
import pt.c06patterns.factory.s07zebatata.produto.Olho;

public class FabricaDoriana implements FabricaBatata
{
    public FabricaDoriana()
    {
    }
	
	public Olho criaOlhoEsquerdo()
	{
		return new OlhosDoriana("esquerdo");
	}

    public Olho criaOlhoDireito()
    {
        return new OlhosDoriana("direito");
    }

    public Nariz criaNariz()
    {
        return new NarizDoriana();
    }
    
    
    public Boca criaBoca()
    {
        return new BocaDoriana();
    }
}
