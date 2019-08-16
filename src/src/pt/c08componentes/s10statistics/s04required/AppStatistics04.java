package pt.c08componentes.s10statistics.s04required;

import pt.c08componentes.s10statistics.s03component.v02.IStatistics;
import pt.c08componentes.s10statistics.s03component.v02.StatisticsComponent;

public class AppStatistics04
{
    public static void main(String args[])
    {
       IStatistics componentStat = new StatisticsComponent();
       IClient componentClient = new ClientComponent();
       
       componentClient.connect(componentStat);
       
       componentClient.start();
    }
}
