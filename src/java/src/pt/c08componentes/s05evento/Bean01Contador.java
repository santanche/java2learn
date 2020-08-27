package pt.c08componentes.s05evento;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Bean01Contador extends JComponent {
    private static final long serialVersionUID = 883936361544256797L;

    private int contagem = 0;

    private JLabel rotulo;

    public Bean01Contador() {
        super();

        setLayout(new BorderLayout());

        rotulo = new JLabel(String.valueOf(contagem));
        rotulo.setHorizontalAlignment(SwingConstants.CENTER);
        rotulo.setFont(getFont());

        add(rotulo, BorderLayout.CENTER);
    }

    public int getContagem() {
        return contagem;
    }
    
    public void setContagem(int contagem) {
        this.contagem = contagem;
        rotulo.setText(String.valueOf(contagem));
    }

    public void setFont(Font f) {
        super.setFont(f);
        rotulo.setFont(f);
    }
}
