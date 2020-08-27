package pt.c08componentes.s40industry.s02listener.termometer;

import pt.c08componentes.s40industry.s02listener.lifecycle.IRun;

public interface ITermometer extends IRun {
    public int getInterval();
    public void setInterval(int interval);
}
