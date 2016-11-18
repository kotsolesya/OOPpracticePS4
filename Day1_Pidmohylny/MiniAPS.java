package com.eventdnb.practike.oop.oneday;
import java.awt.*;

import javax.swing.*;

public class MiniAPS extends JPanel {
    
public static void main(String[] args)  {
JFrame frame = new JFrame();
frame.getContentPane().setBackground(Color.BLACK);
frame.setVisible(true);
frame.setSize(700,600);
JPanel panel=new MiniAPS();
frame.add(panel);
String filepath = "mini-aps.jpg";
String filepath1 = "tel.jpg";
ImageIcon icon1 = new ImageIcon(filepath);
ImageIcon icon2 = new ImageIcon(filepath1);
JLabel label = new JLabel(icon1);
panel.add(label).setBounds(50,50,250,300);
JLabel label2 = new JLabel(icon2);
panel.add(label2).setBounds(500,370,500,300);
}

public void paintComponent(Graphics g){
super.paintComponent(g);
g.drawString("Example jobs Mini-APS",250,20);
}
 
}