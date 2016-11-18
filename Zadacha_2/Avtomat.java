package com.company;

        import javax.swing.BoxLayout;
        import javax.swing.JFrame;
        import javax.swing.JPanel;
        import javax.swing.JButton;
        import javax.swing.JTextField;
        import javax.swing.JLabel;
        import javax.swing.ImageIcon;
        import javax.swing.border.*;
        import java.awt.*;
        import java.awt.event.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.text.DecimalFormat;
        import javax.swing.event.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.KeyEvent;

public class Main extends JFrame {

    public class itemChooser implements KeyListener {
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode())
            {
                case KeyEvent.VK_W:
                    goodyTextButtons[0].doClick();
                    break;
                case KeyEvent.VK_S:
                    goodyTextButtons[1].doClick();
                    break;
                case KeyEvent.VK_P:
                    goodyTextButtons[2].doClick();
                    break;
                case KeyEvent.VK_C:
                    goodyTextButtons[3].doClick();
                    break;
                default:
                    break;
            }
        }

        public void keyReleased(KeyEvent e){}
        public void keyTyped(KeyEvent e){}
    }

    public class focusSet extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            requestFocusInWindow();
            System.out.println("FOCUS");
        }
    }

    // ActionListener class to display Goody prices
    public class DisplayPricesActionListener implements ActionListener{
        final JTextField priceField;	// Where to diplay the price
        final JButton[] goodyImages;	// What button objects can be clicked
        // These are in the same order as the
        // goodyImageNames & goodyPrices

        public DisplayPricesActionListener(JTextField priceField,
                                           JButton[] goodyImages) {
            super();
            this.priceField = priceField;
            this.goodyImages = goodyImages;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i=0; i<goodyNames.length; i++){	// Check which button was clicked
                // and display approprate price
                if (e.getSource().equals(goodyImages[i])){
                    DecimalFormat df = new DecimalFormat("#.00##");
                    String priceToDisplay = df.format(goodyPrices[i]);
                    priceField.setText("$" + priceToDisplay);
                }
            }
        }
    }

    // ActionListener class to display "here is your goody" when
    // the right price amount is entered
    private class PayForGoodyActionListener implements  ActionListener {

        final JButton[] selectButtons;		// Array of buttons to choose goodies
        final JButton whereButton;
        final JTextField inputPriceTF;		// Text Field where money is entered
        final JTextField outputChangeTF;	// Text Field where "here is your goody is displayed"

        public PayForGoodyActionListener(JButton[] selectButtons,
                                         JButton whereButton,
                                         JTextField inputPriceTF, JTextField outputChangeTF) {
            super();
            this.whereButton = whereButton;
            this.selectButtons = selectButtons;
            this.inputPriceTF = inputPriceTF;
            this.outputChangeTF = outputChangeTF;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedButtonPos = -1;
            for (int i=0; i<selectButtons.length; i++){
                if (e.getSource().equals(selectButtons[i])){
                    selectedButtonPos = i;
                    break;
                }
            }
            String priceEntered = inputPriceTF.getText();
            double inputMoney = 0.0;
            try{
                inputMoney = Double.parseDouble(priceEntered);
                double change = inputMoney - goodyPrices[selectedButtonPos];
                if (change >= 0.0) {
                    whereButton.setText("Here is your " + goodyTips[selectedButtonPos]);
                    outputChangeTF.setText("Your Change is: " + change);
                }
                else
                    outputChangeTF.setText("Not enough for " + goodyTips[selectedButtonPos]);
                inputPriceTF.setText("Enter Money Here ..");
            } catch (Exception exception) {}
        }

    }


    final int goodyType = 4;
    final String[] goodyImageNames = {
            "water-bottle.jpg",
            "soda.jpg",
            "pretzel.jpg",
            "chocalate-bar.jpg"
    };
    final String[] goodyNames = { "W", "S", "P", "C" };
    final String[] goodyTips = {
            "Water Bottle",
            "Soda",
            "Pretzel",
            "Chocalate Bar"
    };
    final double[] goodyPrices = {
            1.25,
            1.50,
            1.75,
            2.00
    };
    public static JButton[] goodyTextButtons;

    public Main(String s) {
        super(s);
        itemChooser itemSelect = new itemChooser();
        focusSet focus = new focusSet();
        addMouseListener(focus);
        addKeyListener(itemSelect);
        // Image of a dollar bill
        int dollarImgWidth = 160, dollarImgHeight = 70;
        ImageIcon dollarImage1 = new ImageIcon("one-dollar.jpg");
        ImageIcon dollarImage2 = new ImageIcon(dollarImage1.getImage().getScaledInstance(
                (int)dollarImgWidth, (int)dollarImgHeight, java.awt.Image.SCALE_SMOOTH));
        JButton oneDollarBotton = new JButton(dollarImage2);

        // The panel of price
        JPanel pPrice = new JPanel();
        pPrice.setLayout(new BoxLayout(pPrice, BoxLayout.Y_AXIS));
        JPanel pPriceText = new JPanel();
        pPriceText.setLayout(new FlowLayout());
        JLabel priceTextLabel = new JLabel("Price");
        JTextField amountTextField = new JTextField("$1.25");
        pPriceText.add(priceTextLabel);
        pPriceText.add(amountTextField);
        JTextField enterMoneyTextField = new JTextField("Enter Money Here ..");
        pPrice.add(pPriceText);
        pPrice.add(enterMoneyTextField);

        // The panel of "return amount"
        JTextField returnAmountTextField = new JTextField("Return amount ..");

        // The "choose one" panel
        JPanel pChooseOne = new JPanel();
        pChooseOne.setLayout(new GridLayout(4,1));
        pChooseOne.setCursor(new Cursor(Cursor.HAND_CURSOR));
        goodyTextButtons = new JButton[goodyType];
        pChooseOne.setBorder(new TitledBorder("Choose one"));

        // Add the above four panels together
        JPanel p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        p1.setPreferredSize(new Dimension (200, 400));
        p1.add(oneDollarBotton);
        p1.add(pPrice);
        p1.add(pChooseOne);
        p1.add(returnAmountTextField);

        // The panel of goodies
        JPanel pGoodies = new JPanel();
        pGoodies.setLayout(new GridLayout(4,1,0,0));
        pGoodies.setBorder(new TitledBorder("Goodies"));
        ((TitledBorder) pGoodies.getBorder()).setTitleColor(Color.BLACK);
        int goodyImgWidth = 100, goodyImgHeight = 100;
        JButton[] goodyImageButtons = new JButton[goodyType];
        DisplayPricesActionListener displayPriceListener = new DisplayPricesActionListener(amountTextField, goodyImageButtons);
        for (int i = 0; i < goodyImageButtons.length; i++) {

            ImageIcon image1 = new ImageIcon(goodyImageNames[i]);
            ImageIcon image2 = new ImageIcon(image1.getImage().getScaledInstance(
                    (int)goodyImgWidth, (int)goodyImgHeight, java.awt.Image.SCALE_SMOOTH));
            goodyImageButtons[i] = new JButton(image2);
            goodyImageButtons[i].setContentAreaFilled(false);
            goodyImageButtons[i].setBorderPainted(true);
            pGoodies.add(goodyImageButtons[i]);
            // ActionListener attached to each button
            goodyImageButtons[i].addActionListener(displayPriceListener);
        }

        // The panel of "where you get your item"
        JButton whereButton = new JButton("This is where you get your item!");
        whereButton.setPreferredSize(new Dimension(250, 100));


        // Add everything onto the frame
        this.add(pGoodies, BorderLayout.CENTER);
        this.add(p1, BorderLayout.EAST);
        this.add(whereButton, BorderLayout.SOUTH);

        // the action listener
        PayForGoodyActionListener payGoodyListener =
                new PayForGoodyActionListener(goodyTextButtons, whereButton,
                        enterMoneyTextField, returnAmountTextField);
        for (int i = 0; i < goodyType; i++) {
            goodyTextButtons[i] = new JButton(goodyNames[i]);
            goodyTextButtons[i].setToolTipText(goodyTips[i]);
            // ActionListener attached to each button
            goodyTextButtons[i].addActionListener(payGoodyListener);
            switch(goodyNames[i])
            {
                case("W"):
                    goodyTextButtons[i].setMnemonic(KeyEvent.VK_W);
                    break;
                case("S"):
                    goodyTextButtons[i].setMnemonic(KeyEvent.VK_S);
                    break;
                case("P"):
                    goodyTextButtons[i].setMnemonic(KeyEvent.VK_P);
                    break;
                case("C"):
                    goodyTextButtons[i].setMnemonic(KeyEvent.VK_C);
                    break;
                default:
                    break;
            }
            pChooseOne.add(goodyTextButtons[i]);
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Main v = new Main("THE FRONT VIEW OF A VENDING MACHINE");
        v.setSize(400, 800);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
        v.setFocusable(true);
    }
}
