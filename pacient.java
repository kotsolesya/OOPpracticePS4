package pacient;





	import javax.swing.*;
	import java.awt.*;
	 
	public class pacient {
	    private JTextField displayField;
	 
	    public void setDisplayValue(String val) {
	        displayField.setText(val);
	    }
	 
	    public String getDisplayValue() {
	        return displayField.getText();
	    }
	 
	    public static void main(String[] args) {
	        JPanel p1;
	 
	        JButton button0;
	        JPanel windowContent = new JPanel();
	        JTextField displayField;
	 
	        button0 = new JButton("Внести данні");
	        p1 = new JPanel();
	      
	        JLabel label1 = new JLabel("ПІБ");
	        JTextField field = new JTextField(10);
	        JLabel label = new JLabel("Вік");
	        JTextField field1 = new JTextField(10);
	        JLabel label2 = new JLabel("Стать");
	        JTextField field2 = new JTextField(10);
	        JLabel label3 = new JLabel("Флюорографія");
	        JTextField field3 = new JTextField(10);
	        JLabel label4 = new JLabel("Медичний огляд");
	        JTextField field4 = new JTextField(10);
	        JLabel label5 = new JLabel("Результат флюорографії");
	        JTextField field5 = new JTextField(10);
	        JLabel label6 = new JLabel("Дата останньої флюорографії");
	        JTextField field6 = new JTextField(10);
	 
	        windowContent.add(label1);
	        windowContent.add(field1);
	        windowContent.add(label2);
	        windowContent.add(field2);
	        windowContent.add(label3);
	        windowContent.add(field3);
	        windowContent.add(label4);
	        windowContent.add(field4);
	        windowContent.add(label5);
	        windowContent.add(field5);
	        windowContent.add(label6);
	        windowContent.add(field6);
	 
	 
	        p1 = new JPanel();
	 
	        GridLayout gl = new GridLayout(15, 30);
	        p1.setLayout(gl);
	 
	        windowContent.add(button0);
	       
	    
	 
	 
	 
	        JFrame frame = new JFrame("PAY");
	 
	        frame.setContentPane(windowContent);
	 
	        frame.setSize(1500, 400);
	        frame.setVisible(true);
	    }
	}



