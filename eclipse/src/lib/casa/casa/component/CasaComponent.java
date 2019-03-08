package lib.casa.casa.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import lib.casa.anima.message.Message;
import lib.casa.anima.message.MessageWrite;
import lib.casa.anima.visual.VisualComponent;

public class CasaComponent extends VisualComponent
{
  public static final int NAME_LABEL_HEIGHT = 20;
  public static final Font NAME_LABEL_FONT =
    new Font("SansSerif", Font.BOLD, 14);
  public static final Color NAME_LABEL_BACKCOLOR = new Color(255, 255, 206),
                            NAME_LABEL_COLOR = Color.black;


  protected int nameLabelHeight = NAME_LABEL_HEIGHT;
  protected Font nameLabelFont = NAME_LABEL_FONT;
  protected Color nameLabelBackColor = NAME_LABEL_BACKCOLOR,
                  nameLabelColor = NAME_LABEL_COLOR;


  public CasaComponent()
  {
    super();
  }

  /*
   * Property Methods
   */

  public void setName(String name)
  {
    super.setName(name);
    if (nameLabelHeight > 0)
      repaint();
  }

  /*
   * Methods
   */

  public boolean localMessage(Message theMessage)
  {
    boolean found = super.localMessage(theMessage);

    if (theMessage instanceof MessageWrite &&
        theMessage.getLabel().equalsIgnoreCase("name"))
    {
      setName(((MessageWrite)theMessage).getValueString());
      found = true;
    }

    return found;
  }

  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    String name = getName();
    if (name != null && nameLabelHeight > 0 && nameLabelFont != null &&
        nameLabelBackColor != null && nameLabelColor != null)
    {
      g.setFont(nameLabelFont);
      FontMetrics fm = g.getFontMetrics();
      g.setColor(nameLabelBackColor);
      g.fillRect(0, getHeight() - nameLabelHeight, getWidth(), nameLabelHeight);
      g.setColor(nameLabelColor);
      g.drawString(name, (getWidth() - fm.stringWidth(name)) / 2,
                   getHeight() - fm.getDescent());
    }
  }
}