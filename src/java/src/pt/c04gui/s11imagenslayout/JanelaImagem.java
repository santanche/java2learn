package pt.c04gui.s11imagenslayout;

import java.awt.Container;
import java.awt.FlowLayout;

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
      setSize(500, 250);

      painel = getContentPane();
      painel.setLayout(new FlowLayout());
      
      setVisible(true);
   }
   
   public void adicionaImagem(Imagem img) {
      painel.add(img);
      SwingUtilities.updateComponentTreeUI(this);
   }
}
