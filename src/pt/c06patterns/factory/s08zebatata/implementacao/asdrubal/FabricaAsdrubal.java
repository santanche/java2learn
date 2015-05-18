package pt.c06patterns.factory.s08zebatata.implementacao.asdrubal;

import pt.c06patterns.factory.s08zebatata.produto.Boca;
import pt.c06patterns.factory.s08zebatata.produto.FabricaBatata;
import pt.c06patterns.factory.s08zebatata.produto.Nariz;
import pt.c06patterns.factory.s08zebatata.produto.Olho;


public class FabricaAsdrubal extends FabricaBatata
{
    public FabricaAsdrubal()
    {
    }
	
	public Olho criaOlhoEsquerdo()
	{
		return new OlhosAsdrubal("esquerdo");
	}

    public Olho criaOlhoDireito()
    {
        return new OlhosAsdrubal("direito");
    }

    public Nariz criaNariz()
    {
        return new NarizAsdrubal();
    }
    
    
    public Boca criaBoca()
    {
        return new BocaAsdrubal();
    }
}
