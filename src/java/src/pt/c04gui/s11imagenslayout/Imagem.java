package pt.c04gui.s11imagenslayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Imagem extends JLabel {
   private static final long serialVersionUID = 4310667556938403035L;

   public Imagem(String arquivoImagem) {
      super(new ImageIcon(arquivoImagem));
   }
}
