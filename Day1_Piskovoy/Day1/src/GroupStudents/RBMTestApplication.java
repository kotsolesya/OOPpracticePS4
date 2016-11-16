package GroupStudents;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class RBMTestApplication implements Runnable {

    private static final Insets SPACE_INSETS    = new Insets(10, 10, 4, 10);

    private JFrame              frame;

    private JPanel              mainPanel;
    private JPanel              communicationPanel;
    private JPanel              cPanel1;
    private JPanel              cPanel2;
    private JPanel              llpPanel;

    private JTabbedPane         tabbedPane;

    @Override
    public void run() {
        createFrame();
    }

    private void createFrame() {
        frame = new JFrame();
        frame.setTitle("RBM Test Application");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });
        createMainPanel();
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public void exitProcedure() {
        frame.dispose();
        System.exit(0);
    }

    private void createMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        createCommunicationPanel();
        mainPanel.add(communicationPanel);
        createTabbedPane();
        mainPanel.add(tabbedPane);
    }

    private void createCommunicationPanel() {
        communicationPanel = new JPanel();
        Border border = BorderFactory.createTitledBorder("Communication");
        communicationPanel.setBorder(border);
        communicationPanel.setLayout(new BoxLayout(communicationPanel,
                BoxLayout.Y_AXIS));

        cPanel1 = new JPanel();

        JButton initializeButton = new JButton("Initialize");
        cPanel1.add(initializeButton);

        JButton connectButton = new JButton("Connect");
        cPanel1.add(connectButton);

        JButton disconnectButton = new JButton("Disconnect");
        cPanel1.add(disconnectButton);

        JButton shutdownButton = new JButton("Shutdown");
        cPanel1.add(shutdownButton);

        communicationPanel.add(cPanel1);

        cPanel2 = new JPanel();

        JButton portSettingsButton = new JButton("Port Settings");
        portSettingsButton.setHorizontalAlignment(JButton.CENTER);
        cPanel2.add(portSettingsButton);

        communicationPanel.add(cPanel2);
    }

    private void createTabbedPane() {
        tabbedPane = new JTabbedPane();
        createLLPPanel();
        tabbedPane.addTab("LLP", llpPanel);
        // tabbedPane.addTab("POS", posPanel);
        // tabbedPane.addTab("Tere", terePanel);
    }

    private void createLLPPanel() {
        llpPanel = new JPanel();
        llpPanel.setLayout(new GridBagLayout());

        int gridy = 0;

        JButton goOnlineButton = new JButton("Go online");
        addComponent(llpPanel, goOnlineButton, 0, gridy, 1, 1, SPACE_INSETS,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JButton statusButton = new JButton("Status");
        addComponent(llpPanel, statusButton, 1, gridy, 1, 1, SPACE_INSETS,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JButton pccountButton = new JButton("PC count");
        addComponent(llpPanel, pccountButton, 2, gridy, 1, 1, SPACE_INSETS,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JButton resetButton = new JButton("Reset");
        addComponent(llpPanel, resetButton, 3, gridy++, 1, 1, SPACE_INSETS,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JButton goOfflineButton = new JButton("Go offline");
        addComponent(llpPanel, goOfflineButton, 0, gridy, 1, 1, SPACE_INSETS,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JButton rebootButton = new JButton("Reboot");
        addComponent(llpPanel, rebootButton, 1, gridy, 1, 1, SPACE_INSETS,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JButton amountButton = new JButton("Amount");
        addComponent(llpPanel, amountButton, 2, gridy, 1, 1, SPACE_INSETS,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JButton approveButton = new JButton("Approve / Decline");
        addComponent(llpPanel, approveButton, 3, gridy++, 1, 1, SPACE_INSETS,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JPanel logPanel = new JPanel();
        Border border = BorderFactory.createTitledBorder("Input / output log");
        logPanel.setBorder(border);

        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.getViewport().setPreferredSize(new Dimension(400, 150));

        logPanel.add(scrollPane);

        addComponent(llpPanel, logPanel, 0, gridy++, 4, 1, SPACE_INSETS,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);
    }

    private void addComponent(Container container, Component component,
            int gridx, int gridy, int gridwidth, int gridheight, Insets insets,
            int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 1.0D, 1.0D, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new RBMTestApplication());
    }

}