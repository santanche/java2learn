package pt.c04gui.s07eventopeixe.s03eventografico;

import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class PeixeVisualImagem extends JComponent
                               implements PeixeListener
{
	private JLabel imagemPeixe;

	public PeixeVisualImagem()
	{
		super();
		this.setLayout(new BorderLayout());

		imagemPeixe = new JLabel();
		this.add(imagemPeixe, BorderLayout.CENTER);
	}

    public void apresentaPeixe(int tamanho)
    {
		try {
			URL arquivoImagem =
				PeixeVisualImagem.class.getResource(
				    "imagem/peixe" + tamanho + ".gif");
			
			imagemPeixe.setIcon(new ImageIcon(arquivoImagem));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }

	public void novoTamanho(int tamanho)
	{
		apresentaPeixe(tamanho);
	}
}
