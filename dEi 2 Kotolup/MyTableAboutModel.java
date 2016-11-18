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

   private static List<tabluca_tablo> data = null;
   private static Session session;  

   public MyTableAboutModel(Session ses) {
	  //data = new ArrayList<tabluca_tablo>();
      session=ses;   }

   @SuppressWarnings("unchecked")
public void executeQuery(String query) {
	   data = session.createQuery(query).list();
      }

 

   public Object getValueAt(int aRow,int aColumn) {

	   tabluca_tablo row=data.get(aRow);

       switch(aColumn) {

        case 0: return row.getId();

        case 1: return row.getPunct_vidpravku();

        case 2: return row.getPunct_prubutty();

        case 3: return row.getChas_vidpravku();

        case 4: return row.getChas_prubutty();
        
        default:return "";}

   }

   public int getColumnCount() {   

       return 5;}



   public int getRowCount() {

       return data.size();}   

}
