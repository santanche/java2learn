package pt.c08componentes.s15industry.s01local.termometer;

import pt.c08componentes.s15industry.s01local.lifecycle.IRun;

public interface ITermometer extends IRun {
    public int getInterval();
    public void setInterval(int interval);
}
