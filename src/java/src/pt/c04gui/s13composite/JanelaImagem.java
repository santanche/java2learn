package pt.c04gui.s13composite;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JanelaImagem extends JFrame {
   private static final long serialVersionUID = 1278136335268310294L;
   private JPanel painelImagem, painelControle;

   public JanelaImagem() {
      super();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      visual();
   }
    
   public void visual() {
      setSize(600, 300);

      Container painelPrincipal = getContentPane();
      painelPrincipal.setLayout(new BorderLayout());
      
      painelImagem = new JPanel();
      painelImagem.setLayout(null);
      painelPrincipal.add(painelImagem, BorderLayout.CENTER);
      
      painelControle = new JPanel();
      painelControle.setLayout(new FlowLayout());
      painelPrincipal.add(painelControle, BorderLayout.SOUTH);
      
      setVisible(true);
   }
   
   public void adicionaImagem(ImagemAnimada img) {
      painelImagem.add(img);
      SwingUtilities.updateComponentTreeUI(this);
   }
   
   public void adicionaControle(JButton controle) {
      painelControle.add(controle);
      SwingUtilities.updateComponentTreeUI(this);
   }
}
