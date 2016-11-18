package veadtable;

import java.util.List;

import java.util.ListIterator;

import javax.swing.table.AbstractTableModel;

import org.hibernate.Session;



public class MyTableModel extends AbstractTableModel{

   static List<Caseta> data;

   static Session session;

  

   public MyTableModel(Session session) {

  this.session=session; }

  

   public void executeQuery(String query) {

       data=session.createQuery(query).list(); }

  

   public Object getValueAt(int aRow,int aColumn) {

       Caseta row=data.get(aRow);

   

    switch(aColumn) {

        case 0: return row.getId();

        case 1: return row.getName();

        case 2: return row.getNayava();

        case 3: return row.getCost();

        case 4: return row.getZastava();

        default:return "";

       }

  }

   public int getColumnCount() {   

       return 5; }



   public int getRowCount() {

       return data.size();}   

}

