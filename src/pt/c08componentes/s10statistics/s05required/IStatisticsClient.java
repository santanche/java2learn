package pt.c08componentes.s10statistics.s05required;

import anima.annotation.ComponentInterface;
import anima.component.ISupports;

@ComponentInterface("<http://purl.org/dcc/pt.c08componentes.s10statistics.s05required.IStatisticsClient>")
public interface IStatisticsClient extends ISupports {
    public void start();
}
