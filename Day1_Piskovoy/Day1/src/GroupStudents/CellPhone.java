package GroupStudents;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class CellPhone extends JFrame {

	private final String WINDOW_TITLE = "Phone";
	private final int WINDOW_WIDTH = 300; 
	private final int WINDOW_HEIGHT = 422; 
        String input;
	

	// The following named controls will appear in our GUI

    private JPanel textPanel = new JPanel();
    private JPanel digitPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();

    
    private JLabel displayLabel = new JLabel ("                        NOKIA ");

    private JTextField displayTextField = new JTextField(20);
    
    private JButton sendButton = new JButton("Зателефонувати");
    private JButton clearButton = new JButton("    Очистити    ");
    private JButton endButton = new JButton("Завершити виклик");
    private JButton redialButton = new JButton("Повторний виклик");
    private JButton Button1 = new JButton("1");
    private JButton Button2 = new JButton("2");
    private JButton Button3 = new JButton("3");
    private JButton Button4 = new JButton("4");
    private JButton Button5 = new JButton("5");
    private JButton Button6 = new JButton("6");
    private JButton Button7 = new JButton("7");
    private JButton Button8 = new JButton("8");
    private JButton Button9 = new JButton("9");
    private JButton Button0 = new JButton("0");
    private JButton astrButton = new JButton("*");
    private JButton boundButton = new JButton("#");

    private DecimalFormat df2 = new DecimalFormat("#,###.00");

    public static void main(String[] args) {
        new CellPhone();
    }

    public CellPhone()
    {

        setTitle(WINDOW_TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildTextPanel();
        buildButtonPanel();
        buildDigitPanel();
        setLayout(new BorderLayout());
        add(textPanel,BorderLayout.NORTH);
        add(buttonPanel,BorderLayout.CENTER);
        add(digitPanel,BorderLayout.SOUTH);
        clearDisplay();
        setVisible(true);

    }


	public void buildTextPanel () {
		textPanel.setLayout(new BorderLayout());
		textPanel.add(displayLabel,BorderLayout.NORTH);
		textPanel.add(displayTextField,BorderLayout.CENTER);
                textPanel.setBackground(Color.GREEN);
	}

	public void buildButtonPanel () {
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(sendButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(endButton);
                buttonPanel.add(redialButton);
		sendButton.addActionListener(new SendButtonListener());
		clearButton.addActionListener(new ClearButtonListener());
		endButton.addActionListener(new EndButtonListener());
                redialButton.addActionListener(new RedialButtonListener());
                buttonPanel.setBackground(Color.RED);
	}

	public void buildDigitPanel () {
		digitPanel.setLayout(new GridLayout(3,4));
		digitPanel.add(Button1);
		digitPanel.add(Button2);
                digitPanel.add(Button3);
                digitPanel.add(Button4);
                digitPanel.add(Button5);
                digitPanel.add(Button6);
                digitPanel.add(Button7);
                digitPanel.add(Button8);
                digitPanel.add(Button9);
                digitPanel.add(astrButton);
                digitPanel.add(Button0);
                digitPanel.add(boundButton);
 
           InnerListener listener= new InnerListener();
                Button1.addActionListener(listener);
                Button2.addActionListener(listener);
                Button3.addActionListener(listener);
                Button4.addActionListener(listener);
                Button5.addActionListener(listener);
                Button6.addActionListener(listener);
                Button7.addActionListener(listener);
                Button8.addActionListener(listener);
                Button9.addActionListener(listener);
                Button0.addActionListener(listener);
                astrButton.addActionListener(listener);
                boundButton.addActionListener(listener);
	}


	private class SendButtonListener implements ActionListener {

      	public void actionPerformed(ActionEvent e) {

              input= displayTextField.getText();
	       	sendCalling();
                
		}
	}

	private class ClearButtonListener implements ActionListener {

      	public void actionPerformed(ActionEvent e) {

	       	clearDisplay();
		}
	}

	private class EndButtonListener implements ActionListener {

      	public void actionPerformed(ActionEvent e) {

	       	endCalling();
		}
	}

        private class RedialButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
                  input= displayTextField.getText();
                    redialCalling();
                 }
        }

   	public void clearDisplay() {
		displayTextField.setText(" ");
		
	}
   	
   public void sendCalling() {
		displayTextField.setText("Телефонуємо " + input+ input+ input+ "-" + input+ input+input+ "-" +input+ input+ input+ input);
		
	}

        public void endCalling() {
		displayTextField.setText("Виклик завершено");
		
	}

        public void redialCalling() {
		displayTextField.setText("Повторно викликаємо " + input+ input+ input+ "-" + input+ input+input+ "-" + input+ input+ input+ input );
		
	}

      
        
        private class InnerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
                  if(e.getSource()==Button1) {
                    displayTextField.setText("1"); 
                  }
                   else if (e.getSource()==Button2) {
                     displayTextField.setText("2"); 
                   }
                   else if (e.getSource()==Button3) {
                     displayTextField.setText("3"); 
                   }
                   else if (e.getSource()==Button4) {
                     displayTextField.setText("4"); 
                   }
                   else if (e.getSource()==Button5) {
                     displayTextField.setText("5"); 
                   }
                   else if (e.getSource()==Button6) {
                     displayTextField.setText("6"); 
                   }
                   else if (e.getSource()==Button7) {
                     displayTextField.setText("7"); 
                   }
                   else if (e.getSource()==Button8) {
                     displayTextField.setText("8"); 
                   }
                   else if (e.getSource()==Button9) {
                     displayTextField.setText("9"); 
                   }
                   else if (e.getSource()==Button0) {
                     displayTextField.setText("0"); 
                   }
                   else if (e.getSource()==astrButton) {
                     displayTextField.setText("*"); 
                   }
                   else if (e.getSource()==boundButton) {
                     displayTextField.setText("#"); 
                   }
                   
         }       
     }     
 }    