package pt.c08componentes.s10statistics.s04required;

import pt.c08componentes.s10statistics.s04dcc.IStatistics;
import pt.c08componentes.s10statistics.s04dcc.StatisticsComponent;

public class AppStatistics04
{
    public static void main(String args[])
    {
       IStatistics componentStat = new StatisticsComponent();
       IStatisticsClient componentClient = new StatisticsClientComponent();
       
       IStatisticsReceptacle componentClientReceptacle = (IStatisticsReceptacle)componentClient;
       componentClientReceptacle.connect(componentStat);
       
       componentClient.start();
    }
}
