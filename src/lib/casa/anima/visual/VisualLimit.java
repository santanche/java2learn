package lib.casa.anima.visual;

import java.awt.Rectangle;

public interface VisualLimit
{
  public Rectangle getBounds();

  public void setBounds(int x, int y, int width, int height);

  public boolean absoluteContains(int x, int y);
}