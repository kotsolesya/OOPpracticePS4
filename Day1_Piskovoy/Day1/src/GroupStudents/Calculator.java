package GroupStudents;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener {

	private JButton add;
	private JButton subtract;
	private JButton multiply;
	private JButton divide;
	JLabel jlbln1, jlbln2, jblresult;
	JTextField jtxtn1, jtxtn2, jtextr;
	private JPanel textPanel;
	private JPanel controlsPanel;
	public Calculator() {
		setTitle("GUI Calculator");
		setSize(300, 400);
		initComponents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void initComponents() {

		add = new JButton("+");
		subtract = new JButton("-");
		multiply = new JButton("*");
		divide = new JButton("/");
		jlbln1 = new JLabel("1st num");
		jtxtn1 = new JTextField(10);
		jlbln2 = new JLabel("2st num");
		jtxtn2 = new JTextField(10);
		jblresult = new JLabel("Result");
		jtextr = new JTextField(10);

		textPanel = new JPanel(new GridLayout(3, 2));
		textPanel.add(jlbln1);
		textPanel.add(jtxtn1);
		textPanel.add(jlbln2);
		textPanel.add(jtxtn2);
		textPanel.add(jblresult);
		textPanel.add(jtextr);
		
		controlsPanel = new JPanel(new GridLayout(1, 4));
		controlsPanel.add(add);
		controlsPanel.add(subtract);
		controlsPanel.add(multiply);
		controlsPanel.add(divide);
		
		JPanel p1 = new JPanel(new BorderLayout());
		p1.add(controlsPanel, BorderLayout.NORTH);
		p1.add(textPanel, BorderLayout.CENTER);
		add(p1);

		add.addActionListener(this);
		subtract.addActionListener(this);
		multiply.addActionListener(this);
		divide.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent eve) {
		int x = Integer.parseInt(jtxtn1.getText());
		int y = Integer.parseInt(jtxtn2.getText()); // was: jtxtn1
		int r = 0;
		if (eve.getSource() == add)
			r = x + y;
		else if (eve.getSource() == subtract)
			r = x - y;
		else if (eve.getSource() == multiply)
			r = x * y;
		else if (eve.getSource() == divide)
			r = x / y;
		jtextr.setText(r + " ");
	}

	public static void main(String[] args) {

		Calculator s = new Calculator();
	}

}