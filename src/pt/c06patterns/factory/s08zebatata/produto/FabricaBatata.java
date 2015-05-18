package pt.c06patterns.factory.s08zebatata.produto;

import pt.c06patterns.factory.s08zebatata.implementacao.asdrubal.FabricaAsdrubal;
import pt.c06patterns.factory.s08zebatata.implementacao.doriana.FabricaDoriana;
import pt.c06patterns.factory.s08zebatata.implementacao.quincas.FabricaQuincas;

public abstract class FabricaBatata
{
    public static FabricaBatata criaFabrica(String tipoFabrica)
    {
        if (tipoFabrica.equalsIgnoreCase("doriana"))
            return new FabricaDoriana();
        else if (tipoFabrica.equalsIgnoreCase("asdrubal"))
            return new FabricaAsdrubal();
        else
            return new FabricaQuincas();
    }
    
    public abstract Olho criaOlhoEsquerdo();
    public abstract Olho criaOlhoDireito();
    public abstract Nariz criaNariz();
    public abstract Boca criaBoca();
}
