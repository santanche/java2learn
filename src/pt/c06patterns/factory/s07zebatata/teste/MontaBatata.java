package pt.c06patterns.factory.s07zebatata.teste;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pt.c06patterns.factory.s07zebatata.implementacao.asdrubal.FabricaAsdrubal;
import pt.c06patterns.factory.s07zebatata.implementacao.doriana.FabricaDoriana;
import pt.c06patterns.factory.s07zebatata.implementacao.quincas.FabricaQuincas;
import pt.c06patterns.factory.s07zebatata.produto.Boca;
import pt.c06patterns.factory.s07zebatata.produto.FabricaBatata;
import pt.c06patterns.factory.s07zebatata.produto.Nariz;
import pt.c06patterns.factory.s07zebatata.produto.Olho;

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

	    if (personagem.equalsIgnoreCase("doriana"))
            montaVisual(new FabricaDoriana());
        else if (personagem.equalsIgnoreCase("asdrubal"))
            montaVisual(new FabricaAsdrubal());
        else
            montaVisual(new FabricaQuincas());
	    
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
