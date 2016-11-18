package veadtable;

import java.util.ArrayList;
import java.util.List;

import java.util.ListIterator;

import javax.swing.table.AbstractTableModel;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;


@SuppressWarnings("serial")
public class MyTableAboutModel extends AbstractTableModel{

   private static List<klient> data = null;

   private static Session session;  

   

   public MyTableAboutModel(Session ses) {
	  //data = new ArrayList<AboutBook>();
      session=ses;   }

  

   @SuppressWarnings("unchecked")
public void executeQuery(String query) {
	   data = session.createQuery(query).list();
      }

 

   public Object getValueAt(int aRow,int aColumn) {

       klient row=data.get(aRow);

       switch(aColumn) {

        case 0: return row.getId();

        case 1: return row.getName_k();

        case 2: return row.getTermin();

        case 3: return row.getPovernen();

        default:return "";}

   }

   public int getColumnCount() {   

       return 4;}



   public int getRowCount() {

       return data.size();}   

}
