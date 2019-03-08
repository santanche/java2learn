package pt.c06patterns.factory.s08zebatata.teste;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pt.c06patterns.factory.s08zebatata.produto.Boca;
import pt.c06patterns.factory.s08zebatata.produto.FabricaBatata;
import pt.c06patterns.factory.s08zebatata.produto.Nariz;
import pt.c06patterns.factory.s08zebatata.produto.Olho;

public class MontaBatata
{
	private JFrame janela;
	
	public MontaBatata()
    {
       System.out.println("Escolha o personagem: ");
       Scanner teclado = new Scanner(System.in);
       String personagem = teclado.nextLine();
       teclado.close();
        
	    janela = new JFrame("Ze Batata");
	    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    janela.setSize(400, 500);

        montaVisual(FabricaBatata.criaFabrica(personagem));
	    
	    janela.setVisible(true);
    }
    
    private void montaVisual(FabricaBatata fabrica)
    {
        Olho oOlhoEsquerdo, oOlhoDireito;
        Nariz oNariz;
        Boca aBoca;
        
        oOlhoEsquerdo = fabrica.criaOlhoEsquerdo();
        oOlhoDireito = fabrica.criaOlhoDireito();
        oNariz = fabrica.criaNariz();
        aBoca = fabrica.criaBoca();
        
        Container contentPane = janela.getContentPane();
        contentPane.setLayout(new GridLayout(3, 1));
        
        JPanel painelOlhos = new JPanel();
        painelOlhos.setLayout(new GridLayout(1, 2));
        painelOlhos.add(oOlhoEsquerdo.getVisual());
        painelOlhos.add(oOlhoDireito.getVisual());
        
        contentPane.add(painelOlhos);
        contentPane.add(oNariz.getVisual());
        contentPane.add(aBoca.getVisual());
    }
    
	public static void main(String args[])
    {
		new MontaBatata();
    }
}
