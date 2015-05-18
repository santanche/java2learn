package pt.c06patterns.factory.s08zebatata.implementacao.doriana;

import pt.c06patterns.factory.s08zebatata.produto.Boca;
import pt.c06patterns.factory.s08zebatata.produto.FabricaBatata;
import pt.c06patterns.factory.s08zebatata.produto.Nariz;
import pt.c06patterns.factory.s08zebatata.produto.Olho;


public class FabricaDoriana extends FabricaBatata
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
