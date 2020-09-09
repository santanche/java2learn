package pt.c06patterns.factory.s03aquatic.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import pt.c06patterns.factory.s03aquatic.interfaces.IFishTank;
import pt.c06patterns.factory.s03aquatic.interfaces.ISeaAnimal;

public class FishTankGUI extends JFrame implements IFishTank {
   private static final long serialVersionUID = 8757083673686143226L;

   ArrayList<ISeaAnimal> aquaticList = new ArrayList<ISeaAnimal>(); 

   public void addSeaAnimal(ISeaAnimal aquatic) {
      aquaticList.add(aquatic);
   }
   
   public FishTankGUI() {
      super();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
    
   public void showFishTank() {
      setSize(600, 300);
       
      Container contentPane = getContentPane();
      contentPane.setLayout(new FlowLayout());
      contentPane.setBackground(new Color(192, 192, 255));

      for (ISeaAnimal aq: aquaticList) {
         ImageIcon imagem = new ImageIcon(aq.image());
         JLabel campoImagem = new JLabel(imagem);
         contentPane.add(campoImagem);
      }

      setVisible(true);
   }
}
