package pt.c03java.s03excecao.s03family.chart;

import pt.c03java.s03excecao.s03family.chart.exception.InvalidBlankChar;

public interface IBarChartProperties {
   public boolean isFilled();
   public void setFilled(boolean filled);

   public char getCharacter();
   public void setCharacter(char character) throws InvalidBlankChar;

   public int getN();
   public void setN(int n);
}
