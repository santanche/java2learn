package pt.c03java.s03excecao.s03family.chart;

import pt.c03java.s03excecao.s03family.chart.exception.UnsupportedNegativeNumber;

public interface IChart {
   public void plot() throws UnsupportedNegativeNumber;
}
