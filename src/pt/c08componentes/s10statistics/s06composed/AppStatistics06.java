package pt.c08componentes.s10statistics.s06composed;

import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;
import pt.c08componentes.s10statistics.s05required.IStatisticsClient;

public class AppStatistics06
{
    public static void main(String args[])
    {
        try {
            IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
            
            factory.registerPrototype(StatisticsComposedComponent.class);
            
            // First Component -- Statistics Component
            IStatisticsClient componentStat = factory.createInstance(
                    "<http://purl.org/dcc/pt.c08componentes.s10statistics.s06sub.StatisticsComposedComponent>");
            
            componentStat.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
