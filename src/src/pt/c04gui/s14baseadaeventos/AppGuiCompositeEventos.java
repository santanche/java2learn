package pt.c04gui.s14baseadaeventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pt.c04gui.s12animacao.Metronomo;

/* Agradecimentos:
 * 
 * Imagem: Rawr Dinosaur 
 * https://openclipart.org/detail/234369/rawr-dinosaur
 * by Tavin (https://openclipart.org/artist/Tavin) 
 * 
 */

public class AppGuiCompositeEventos {
   // tecnica para identificar o diretorio em que a classe esta
   public static String DIRETORIO =
      AppGuiCompositeEventos.class.getResource(".").getPath();
   
   public static void main(String[] args) {
      JanelaImagem janela = new JanelaImagem();
       
      ImagemAnimada animado =
         new ImagemAnimada(DIRETORIO + "dino.png", 0, 0, 200, 200, 40, 0);
      janela.adicionaImagem(animado);

      Metronomo metro = new Metronomo(1000, 10);
      metro.addActionListener(animado);
      
      JButton botaoAnda = new JButton("Anda");
      janela.adicionaControle(botaoAnda);
      botaoAnda.addActionListener(animado);
      
      JButton botaoInicia = new JButton("Inicia");
      janela.adicionaControle(botaoInicia);
      
      botaoInicia.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               metro.start();
            }
         }
      );
      
      JButton botaoPara = new JButton("Para");
      janela.adicionaControle(botaoPara);
      
      botaoPara.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               metro.stop();
            }
         }
      );
   }
}
