package readtable;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import veadtable.tabluca_tablo;
import veadtable.MyTableAboutModel;

public  class Run{
static Configuration config;
   static SessionFactory sf;
   static Session session;
public static void main(String[] args) {
       config=new Configuration();
       config.configure("/hibernate.cfg.xml");
       sf=config.buildSessionFactory();
       session=sf.openSession();
 final JFrame frame= new JFrame("Таблиця з практики день другий Табло");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.getContentPane().setLayout(null);
 JPanel panel2 = new JPanel();
 panel2.setLayout(new GridLayout(1,5));
 final JTextField field6 = new JTextField("Номер id");
 final JTextField field7 = new JTextField("Пункт відправки");
 final JTextField field8 = new JTextField("Пункт призначення");
 final JTextField field9 = new JTextField("Час відправки");
 final JTextField field10 = new JTextField("Час прибуття");

 field6.setEditable(false);
 field7.setEditable(false);
 field8.setEditable(false);
 field9.setEditable(false);
 field10.setEditable(false);
 
 panel2.add(field6);
 panel2.add(field7);
 panel2.add(field8);
 panel2.add(field9);
 panel2.add(field10);  

 final MyTableAboutModel abouttable = new MyTableAboutModel(session);
 abouttable.executeQuery("from veadtable.tabluca_tablo");
 final JTable tabl1 = new JTable(abouttable);
 frame.getContentPane().add(tabl1).setBounds(0, 20, 600, 240);
 frame.getContentPane().add(panel2).setBounds(0, 0, 600, 20);
 frame.setSize(new Dimension(600,300));
 frame.show();}}