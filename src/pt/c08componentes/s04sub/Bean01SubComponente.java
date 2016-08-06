package pt.c08componentes.s04sub;

import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Bean01SubComponente extends JComponent
{
    private static final long serialVersionUID = -3270827060605665217L;

    private JLabel componenteRotulo;
    private JTextField componenteEntrada;

    public Bean01SubComponente()
    {
        super();
        setLayout(new FlowLayout());

        componenteRotulo = new JLabel("Nome");
        add(componenteRotulo);

        componenteEntrada = new JTextField();
        componenteEntrada.setColumns(15);
        add(componenteEntrada);
    }
    
    public String getRotulo()
    {
        return componenteRotulo.getText();
    }
    
    public void setRotulo(String novoRotulo)
    {
        componenteRotulo.setText(novoRotulo);
    }
}
