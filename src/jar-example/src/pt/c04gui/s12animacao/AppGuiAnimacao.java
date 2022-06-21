package pt.c04gui.s12animacao;

/* Agradecimentos:
 * 
 * Imagem: Rawr Dinosaur 
 * https://openclipart.org/detail/234369/rawr-dinosaur
 * by Tavin (https://openclipart.org/artist/Tavin) 
 * 
 */

public class AppGuiAnimacao {
   public static void main(String[] args) {
       JanelaImagem janela = new JanelaImagem();
       
       ImagemAnimada animado = new ImagemAnimada(0, 0, 200, 200, 40, 0);
       janela.adicionaImagem(animado);
       
       Metronomo metro = new Metronomo(1000, 10);
       metro.addActionListener(animado);
       metro.start();
   }
}
