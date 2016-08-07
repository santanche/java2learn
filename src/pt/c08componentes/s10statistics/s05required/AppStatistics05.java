package pt.c08componentes.s10statistics.s05required;

import anima.component.InterfaceType;
import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;
import pt.c08componentes.s10statistics.s04dcc.IStatistics;
import pt.c08componentes.s10statistics.s04dcc.StatisticsComponent;

public class AppStatistics05
{
    public static void main(String args[])
    {
        try {
            IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
            
            factory.registerPrototype(StatisticsComponent.class);
            factory.registerPrototype(StatisticsClientComponent.class);
            
            // First Component -- Statistics Component
            IStatistics componentStat = factory.createInstance(
                    "<http://purl.org/dcc/pt.c08componentes.s10statistics.s04dcc.StatisticsComponent>");
            
            // Second Component -- Visual Component
            IStatisticsReceptacle componentClient = factory.createInstance(
                    "<http://purl.org/dcc/pt.c08componentes.s10statistics.s05required.StatisticsClientComponent>");
            
            // Connects both components
            componentClient.connect(componentStat);
            
            IStatisticsClient startInterface = componentClient.queryInterface(
                  "<http://purl.org/dcc/pt.c08componentes.s10statistics.s05required.IStatisticsClient>",
                  InterfaceType.PROVIDED);
            startInterface.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
