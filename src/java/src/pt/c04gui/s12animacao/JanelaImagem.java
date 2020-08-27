package pt.c04gui.s12animacao;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JanelaImagem extends JFrame {
   private static final long serialVersionUID = 1278136335268310294L;
   private Container painel;

   public JanelaImagem() {
      super();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      visual();
   }
    
   public void visual() {
      setSize(600, 250);

      painel = getContentPane();
      painel.setLayout(null);
      
      setVisible(true);
   }
   
   public void adicionaImagem(ImagemAnimada img) {
      painel.add(img);
      SwingUtilities.updateComponentTreeUI(this);
   }
}
