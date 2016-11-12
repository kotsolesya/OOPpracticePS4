import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MAPScommunication extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	Color color = Color.black;
	Color color1 = Color.red;
	Color color2 = Color.blue;          
	
	int dia = -1;
    long delay = 10;
    private int x = 10;
    private int y = 10;
    private int dx = -1;
    private int dy = 1;
    private boolean isRunning;
    
    int dia1 = -5; 
    long delay1 = 10; 
    private int x1 = 20; 
    private int y1 = 200; 
    private int dx1 = 1; 
    private int dy1 = 8; 
    private boolean isRunning1; 
    
    int dia2 = -5; 
    long delay2 = 10; 
    private int x2 = 200; 
    private int y2 = 20; 
    private int dx2 = 8; 
    private int dy2 = 1; 
    private boolean isRunning2; 

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        Graphics2D g3 = (Graphics2D)g;
        Graphics2D g4 = (Graphics2D)g;
        Graphics2D g1 = (Graphics2D)g;
        Graphics2D g5 = (Graphics2D)g;
       
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color); 
        g.fillOval(x,y,10,10); 
        g.setColor(Color.yellow); 
        g2.drawOval(x,y,10,10); 

        g.setColor(color1); 
        g1.fillOval(x1,y1,10,10); 
        g.setColor(Color.yellow); 
        g1.drawOval(x1,y1,10,10);
        
        g.setColor(color2); 
        g5.fillOval(x2,y2,10,10); 
        g.setColor(Color.yellow); 
        g5.drawOval(x2,y2,10,10);
        
        Color newColor1 = new Color(0, 0, 0);
        g3.setColor(newColor1);
        g3.drawString("Mini-APS", 10, 60);
        g3.drawString("Phone 1", 10, 170);
        g3.drawString("Phone 2", 160, 60);
        g3.drawString("Phone 3", 160, 170);
        
        final Rectangle box1 = new Rectangle(10, 10, 200, 200);
        g.setColor(Color.white);
        g2.draw(box1);
        
        Color newColor = new Color(0, 215, 215);
        g2.setColor(newColor);
        g2.fillRect(10, 10, 30, 30);
        
        Color newColor2 = new Color(95, 158, 160);
        g4.setColor(newColor2);
        g2.fillRect(180, 10, 30, 30);
        g2.fillRect(180, 180, 30, 30);
        g2.fillRect(10, 180, 30, 30);
        
    }

    public void run(int a) {
        while(isVisible()) {
            try {
            	Thread.sleep(delay); 
            	Thread.sleep(delay1); 
            	Thread.sleep(delay2); 
            } catch(InterruptedException e) {
            System.out.println("interrupted");
            } 
            	switch(a){
            	case 1:move2();
            	break;
            	case 2:move1();
            	break;
            	case 3:move();
            	break;
            	}
            	repaint(); 
            } 
        }

    public void move() {
        if (isRunning) {
        if(x + dx < 10 || x + dia + dx > 200) {
            dx *= -1;  
        }
        if(y + dy < 10 || y + dia + dy > 200) {
            dy *= -1;
        }
        x += dx;
        y += dy;
    }
    }
    public void move1() { 
    	if (isRunning1) { 
    	if(x1 + dx1 < 10 || x1 + dia1 + dx1 <200) { 
    	dx1 *= -1; 
    	if (x1 == 50) color1 = getColor();
    	} 
    	if(y1 + dy1 < 10 || y1 + dia1 + dy1 >200) { 
    	dy1 *= -1; 
    	
    	} 
    	x1 += dx1; 
    	y1 += dy1; 
    	} 
    	}   
    public void move2() { 
    	if (isRunning2) { 
    	if(x2 + dx2 < 10 || x2 + dia2 + dx2 >200) { 
    	dx2 *= -1; 
    	if (x2 == 200) color2 = getColor(); 
    	} 
    	if(y2 + dy2 > 10 || y2 + dia2 + dy2 <200) { 
    	dy2 *= -1; 
    	color2 = getColor();
    	} 
    	x2 += dx2; 
    	y2 += dy2; 
    	} 
    	} 
    	private Color getColor() { 
    	int rval = (int)Math.floor(0); 
    	int gval = (int)Math.floor(215); 
    	int bval = (int)Math.floor(0); 
    	return new Color(rval, gval, bval);
    	} 

    private void start() {
        while(!isVisible()) {
            try {
                Thread.sleep(25);
            } catch(InterruptedException e) {
                System.exit(1);
            }
        }
        Thread thread = new Thread(this);
        thread.setPriority(Thread.NORM_PRIORITY);
        thread.start();
    }

    public static void main(String[] args) {

    EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            final MAPScommunication test = new MAPScommunication();
            JFrame f = new JFrame();

            
            JButton start = new JButton("Show communication");
            start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                test.isRunning = true;
                test.isRunning1 = true; 
                test.isRunning2 = true; 
            }    
        });
            JButton stop = new JButton("Pause");
            stop.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    test.isRunning = false;
                    test.isRunning1 = false; 
                    test.isRunning2 = false;        
                } 
            });

            JPanel panel = new JPanel();
            panel.add(start);
            panel.add(stop);
            

            f.add(panel, java.awt.BorderLayout.SOUTH);
            f.getContentPane().add(test);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(new Dimension(300, 300));
            f.setResizable(false);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            test.start();
        }
    });
}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}