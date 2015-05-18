package pt.c06patterns.factory.s07zebatata.teste;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pt.c06patterns.factory.s07zebatata.implementacao.doriana.FabricaDoriana;
import pt.c06patterns.factory.s07zebatata.produto.Boca;
import pt.c06patterns.factory.s07zebatata.produto.FabricaBatata;
import pt.c06patterns.factory.s07zebatata.produto.Nariz;
import pt.c06patterns.factory.s07zebatata.produto.Olho;

public class MontaDoriana
{
	private JFrame janela;
	
	public MontaDoriana()
    {
	    janela = new JFrame("Ze Batata");
	    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    janela.setSize(400, 500);

	    montaVisual(new FabricaDoriana());
	    
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
		new MontaDoriana();
    }
}
