package pt.c04gui.s10imagem;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JanelaImagem extends JFrame {
   private static final long serialVersionUID = 1278136335268310294L;

   public JanelaImagem(String arquivoImagem) {
      super();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      visual(arquivoImagem);
   }
    
   public void visual(String arquivoImagem) {
      setSize(250, 250);
       
      Container contentPane = getContentPane();
      contentPane.setLayout(new BorderLayout());

      ImageIcon imagem = new ImageIcon(arquivoImagem);
      JLabel campoImagem = new JLabel(imagem);
      contentPane.add(campoImagem, BorderLayout.CENTER);
      setVisible(true);
   }
}
