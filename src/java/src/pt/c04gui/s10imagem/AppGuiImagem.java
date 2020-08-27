package pt.c04gui.s10imagem;

/* Agradecimento: imagem Rawr Dinosaur 
 * https://openclipart.org/detail/234369/rawr-dinosaur
 * by Tavin (https://openclipart.org/artist/Tavin) 
 */

public class AppGuiImagem {
   // tecnica para identificar o diretorio em que a classe esta
   public static String DIRETORIO =
         AppGuiImagem.class.getResource(".").getPath();
   
   public static void main(String[] args) {
       new JanelaImagem(DIRETORIO + "dino.png");
   }
}
