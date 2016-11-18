package readtable;

import java.awt.BorderLayout;

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



import veadtable.klient;

import veadtable.MyTableAboutModel;

import veadtable.MyTableModel;



public  class Run{

static Configuration config;

   static SessionFactory sf;
   
   static Session session;



   public static void main(String[] args) {

      config=new Configuration();

       config.configure("/hibernate.cfg.xml");

       sf=config.buildSessionFactory();

       session=sf.openSession();

       

 final JFrame frame= new JFrame("Пункт прокату відеокасет");

 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 frame.getContentPane().setLayout(null);

 JPanel panel1 = new JPanel();

 JPanel panel2 = new JPanel();

 panel1.setLayout(new GridLayout(1,5));

 panel2.setLayout(new GridLayout(1,5));

 

 final JTextField field1 = new JTextField("Номер №");

 final JTextField field2 = new JTextField("Назва касети");

 final JTextField field3 = new JTextField("наявність");

 final JTextField field4 = new JTextField("вартість");

 final JTextField field5 = new JTextField("застава");

 

 final JTextField field6 = new JTextField("Номер id");

 final JTextField field7 = new JTextField("клієнт");

 final JTextField field8 = new JTextField("термін");

 final JTextField field9 = new JTextField("дата повернення");

 

 field1.setEditable(false);

 field2.setEditable(false);

 field3.setEditable(false);

 field4.setEditable(false);

 field5.setEditable(false);

 field6.setEditable(false);

 field7.setEditable(false);

 field8.setEditable(false);

 field9.setEditable(false);

 

 panel1.add(field1);

 panel1.add(field2);

 panel1.add(field3);

 panel1.add(field4);

 panel1.add(field5);

 

 panel2.add(field6);

 panel2.add(field7);

 panel2.add(field8);

 panel2.add(field9);

   

 final MyTableModel table = new MyTableModel(session);

 final MyTableAboutModel abouttable = new MyTableAboutModel(session);

 table.executeQuery("from veadtable.Caseta");

 abouttable.executeQuery("from veadtable.klient");

 final JTable tabl = new JTable(table);

 final JTable tabl1 = new JTable(abouttable);

 frame.getContentPane().add(panel1).setBounds(0, 0, 600,20);

 frame.getContentPane().add(tabl1).setBounds(0, 140, 600, 240);

 frame.getContentPane().add(panel2).setBounds(0, 120, 600, 20);

 frame.getContentPane().add(tabl).setBounds(0, 20, 600, 80);

 frame.setSize(new Dimension(600,300));

 frame.show();

}   

   

}