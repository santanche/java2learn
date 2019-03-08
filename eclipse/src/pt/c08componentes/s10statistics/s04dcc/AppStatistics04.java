package pt.c08componentes.s10statistics.s04dcc;

import anima.factory.context.componentContext.ComponentContextFactory;
import anima.factory.IGlobalFactory;

public class AppStatistics04
{
    public static void main(String args[])
    {
        try {
            // creates a local context to operate using Java language
            IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
            
            factory.registerPrototype(StatisticsComponent.class);
            
            // creates a component of a given class, with a given name
            // and a given interface respectively
            IStatistics componentStat = factory.createInstance(
                    "<http://purl.org/dcc/pt.c08componentes.s10statistics.s04dcc.StatisticsComponent>");

            System.out.println("inserido valor: " + 50.0f);
            componentStat.insertValue(50.0f);
            System.out.println("inserido valor: " + 70.0f);
            componentStat.insertValue(70.0f);
            System.out.println("inserido valor: " + 30.0f);
            componentStat.insertValue(30.0f);
        
            System.out.println("-- somatorio: " + componentStat.sum());
            System.out.println("-- media: " + componentStat.average());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
