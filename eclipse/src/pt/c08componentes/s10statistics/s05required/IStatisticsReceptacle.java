package pt.c08componentes.s10statistics.s05required;

import anima.annotation.ComponentReceptacle;
import anima.component.IReceptacle;
import pt.c08componentes.s10statistics.s04dcc.IStatistics;

@ComponentReceptacle("<http://purl.org/dcc/pt.c08componentes.s10statistics.s04dcc.IStatistics>")
public interface IStatisticsReceptacle extends IReceptacle
{
    public void connect(IStatistics provider);
}
