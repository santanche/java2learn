package pt.c04gui.s11imagenslayout;

/* Agradecimentos:
 * 
 * Imagem: Rawr Dinosaur 
 * https://openclipart.org/detail/234369/rawr-dinosaur
 * by Tavin (https://openclipart.org/artist/Tavin) 
 * 
 * Imagem: Sleeping baby dinosaur
 * https://openclipart.org/detail/295093/sleeping-baby-dinosaur
 * by anarres (https://openclipart.org/artist/anarres)
 * 
 */

public class AppGuiImagensLayout {
   // tecnica para identificar o diretorio em que a classe esta
   public static String DIRETORIO =
         AppGuiImagensLayout.class.getResource(".").getPath();
   
   public static void main(String[] args) {
       JanelaImagem janela = new JanelaImagem();
       
       janela.adicionaImagem(new Imagem(DIRETORIO + "dino1.png"));
       janela.adicionaImagem(new Imagem(DIRETORIO + "dino2.png"));
   }
}
