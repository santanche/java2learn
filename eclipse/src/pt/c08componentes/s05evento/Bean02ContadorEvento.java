package pt.c08componentes.s05evento;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Bean02ContadorEvento extends JComponent implements ActionListener {

    private static final long serialVersionUID = 7300761624112291628L;

    protected int contagem = 0;

    private JLabel rotulo;

    public Bean02ContadorEvento()
    {
        super();

        setLayout(new BorderLayout());

        rotulo = new JLabel(String.valueOf(contagem));
        rotulo.setHorizontalAlignment(SwingConstants.CENTER);

        add(rotulo, BorderLayout.CENTER);
    }

    public void setContagem(int contagem)
    {
        this.contagem = contagem;
        rotulo.setText(String.valueOf(contagem));
    }

    public int getContagem()
    {
        return contagem;
    }

    public void incrementa()
    {
        setContagem(contagem + 1);
    }

    /*
     * Implementa manipulacao de evento
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    
    public void actionPerformed(ActionEvent evento)
    {
        incrementa();
    }
}
