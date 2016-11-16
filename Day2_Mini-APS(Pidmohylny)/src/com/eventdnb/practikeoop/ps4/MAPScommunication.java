package com.eventdnb.practikeoop.ps4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MAPScommunication extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	Color color = Color.black;
	
	
	int dia = -1;
    long delay = 10;
    private int x = 10;
    private int y = 10;
    private int dx = -1;
    private int dy = 1;
    private boolean isRunning;

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        Graphics2D g3 = (Graphics2D)g;
        Graphics2D g4 = (Graphics2D)g;
       
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);
        g.fillOval(x,y,5,5);   // adds color to circle
        g.setColor(Color.black);
        g2.drawOval(x,y,5,5);
        
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

    public void run() {
        while(isVisible()) {
            try {
                Thread.sleep(delay);
                
            } catch(InterruptedException e) {
                System.out.println("interrupted");
            }
           
           move();
            repaint();
        }
    }

    public void move() {
        if (isRunning) {
        if(x + dx < 10 || x + dia + dx > 200) {
            dx *= -1;
            color = getColor();
        }
        if(y + dy < 10 || y + dia + dy > 200) {
            dy *= -1;
            color = getColor();
        }
        x += dx;
        y += dy;
    }
    }

    private Color getColor() {
        int rval = (int)Math.floor(0);
        int gval = (int)Math.floor(0);
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
  
            }
           
        });

            JButton stop = new JButton("Pause");
            stop.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    test.isRunning = false;
                   
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
}