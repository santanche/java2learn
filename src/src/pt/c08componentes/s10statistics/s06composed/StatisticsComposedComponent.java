package pt.c08componentes.s10statistics.s06composed;

import anima.annotation.Component;
import anima.component.InterfaceType;
import anima.component.base.ComponentBase;
import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;
import pt.c08componentes.s10statistics.s04dcc.IStatistics;
import pt.c08componentes.s10statistics.s04dcc.StatisticsComponent;
import pt.c08componentes.s10statistics.s05required.IStatisticsClient;
import pt.c08componentes.s10statistics.s05required.IStatisticsReceptacle;
import pt.c08componentes.s10statistics.s05required.StatisticsClientComponent;

@Component(id = "<http://purl.org/dcc/pt.c08componentes.s10statistics.s06sub.StatisticsComposedComponent>",
           provides = {"<http://purl.org/dcc/pt.c08componentes.s10statistics.s05required.IStatisticsClient>"})
public class StatisticsComposedComponent extends ComponentBase implements IStatisticsClient
{
    private IStatistics componentStat;
    private IStatisticsClient componentClient;
   
    public StatisticsComposedComponent() {
       try {
          IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
          
          factory.registerPrototype(StatisticsComponent.class);
          factory.registerPrototype(StatisticsClientComponent.class);

          // First Component -- Statistics Component
          componentStat = factory.createInstance(
                  "<http://purl.org/dcc/pt.c08componentes.s10statistics.s04dcc.StatisticsComponent>");
          
          // Second Component
          IStatisticsReceptacle componentReceptacle = factory.createInstance(
                  "<http://purl.org/dcc/pt.c08componentes.s10statistics.s05required.StatisticsClientComponent>");

          // Connects both components
          componentReceptacle.connect(componentStat);
          
          componentClient = componentReceptacle.queryInterface(
                "<http://purl.org/dcc/pt.c08componentes.s10statistics.s05required.IStatisticsClient>",
                InterfaceType.PROVIDED);
          
      } catch (Exception e) {
          e.printStackTrace();
      }
    }
   
    public void start()
    {
       componentClient.start();
    }
    
}
