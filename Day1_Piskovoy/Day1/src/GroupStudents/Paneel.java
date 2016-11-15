package GroupStudents;

import java.awt.Dimension;
import java.net.URL;
 
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class Paneel extends JFrame {
 
    public static void createGUI() {
    	
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        JPanel panel = new JPanel();        
 
        JButton button1 = new JButton();
        ImageIcon icon1 = createIcon("phone.png");
        button1.setIcon(icon1);
        panel.add(button1);
         
         
       /* JButton button2 = new JButton();
        ImageIcon icon2 = createIcon("phone2.jpg");
        button2.setIcon(icon2);
        panel.add(button2);*/
         
        
 
        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(390, 135));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
     
    protected static ImageIcon createIcon(String path) {
        URL imgURL = Paneel.class.getResource(path);     
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("File not found " + path);
            return null;
        }
    }
 
 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }
}