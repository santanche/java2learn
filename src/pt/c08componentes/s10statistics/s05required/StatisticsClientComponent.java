package pt.c08componentes.s10statistics.s05required;

import anima.annotation.Component;
import anima.component.base.ComponentBase;
import pt.c08componentes.s10statistics.s04dcc.IStatistics;

@Component(id = "<http://purl.org/dcc/pt.c08componentes.s10statistics.s05required.StatisticsClientComponent>",
           provides = {"<http://purl.org/dcc/pt.c08componentes.s10statistics.s05required.IStatisticsClient>"},
           requires = {"<http://purl.org/dcc/pt.c08componentes.s10statistics.s04dcc.IStatistics>"})
public class StatisticsClientComponent extends ComponentBase implements IStatisticsClient, IStatisticsReceptacle
{
    private IStatistics provider = null;
    
    /*
     * Constructor
     *************/
    
    public StatisticsClientComponent()
    {
        super();
    }
    
    /*
     * IStatisticsReceptacle Interface
     **********************************/
    
    public void connect(IStatistics provider)
    {
        this.provider = provider;
    }
    
    public void start()
    {
       System.out.println("inserido valor: " + 50.0f);
       provider.insertValue(50.0f);
       System.out.println("inserido valor: " + 70.0f);
       provider.insertValue(70.0f);
       System.out.println("inserido valor: " + 30.0f);
       provider.insertValue(30.0f);
   
       System.out.println("-- somatorio: " + provider.sum());
       System.out.println("-- media: " + provider.average());
    }
    
}
