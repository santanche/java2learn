package pt.c04gui.s12animacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImagemAnimada extends JLabel implements ActionListener {
   private static final long serialVersionUID = 4310667556938403035L;

   private int x, y,
               shiftX, shiftY;
   
   public ImagemAnimada(int x, int y,
                        int width, int height,
                        int shiftX, int shiftY) {
      super(new ImageIcon(ImagemAnimada.class.getResource("dino.png")));
      setSize(width, height);
      this.x = x;
      this.y = y;
      setLocation(x, y);
      this.shiftX = shiftX;
      this.shiftY = shiftY;
   }
   
   public void move() {
      x += shiftX;
      y += shiftY;
      setLocation(x, y);
   }
   
   public void actionPerformed(ActionEvent evento) {
      move();
   }
}
