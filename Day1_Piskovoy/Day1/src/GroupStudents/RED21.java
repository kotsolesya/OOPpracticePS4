package GroupStudents;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
 
 
public class RED21 {
    public static void main(String[] args) {
        Fr f = new Fr();
        f.setVisible(true);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("image.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(800, 508, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        setContentPane(new JLabel(imageIcon));

    }

	private static void setContentPane(JLabel jLabel) {
		// TODO Auto-generated method stub
		
	}
    
}
 
class Fr extends JFrame{
    JLabel lbl;
    JButton b;
    JButton c;
    JButton d;
    JTextArea ta;
    public Fr(){
        setTitle("Window");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 450);
        setResizable(false); 

        
        
        setContentPane(new BgPanel());
        Container cont = getContentPane();
  
        lbl = new JLabel("Phone");
        lbl.setFont(new Font("Arial", Font.BOLD, 24));
        b = new JButton("Зателефонувати");
        c = new JButton ("Зайнято");
        ta = new JTextArea(5,32);
         
        cont.setLayout(new FlowLayout());
        cont.add(lbl);
        cont.add(b);
        cont.add(ta);
        cont.add(c);
    }  
}

 
class BgPanel extends JPanel{
    public void paintComponent(Graphics g){
        Image im = null;
        try {
            im = ImageIO.read(new File("D:\\Tests\\fon.jpg"));
        } catch (IOException e) {}
        g.drawImage(im, 0, 0, null); 
    }
}
