import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

public class AddressBookDemo implements ActionListener
{
	Connection con;
	ArrayList<PersonInfo> personsList;
	ArrayList<UserInfo> userList;
   	PersonDAO pDAO;
   	JFrame appFrame,frame;JPanel p;
   	JLabel jlbName,jlbSurname, jlbAddress, jlbMonth, jlbFrom,jlbTo;
   	JTextField jtfName,jtfSurname, jtfAddress, jtfMonth, jtfFrom,jtfTo;
   	JButton jbbSave, jbnDelete, jbnClear, jbnUpdate, jbnSearch,
   					jbnForward, jbnBack, jbnExit;
    JButton ok; 
    JLabel lUserLogin,lPass,lPass1;
    JTextField dUserLogin,dPass,dPass1;
	//User parameters
    String login,pass;
   	//Person Parameters
    String name,surname, address;
	int month,FromTime,ToTime;
   //	String phone;
   	int recordNumber;	 // used to naviagate using >> and << buttons 
   	Container cPane;
   	JLabel llogin,lpassword;
   	JTextField dlogin,dpassword;
   public static void main(String args[]){
      new AddressBookDemo(); 
   }

   public AddressBookDemo()
   { 	
	    name = "";
	    surname ="";
	    address = "";
	    month =0;
	    FromTime = 0;
	    ToTime = 0;
	    recordNumber = -1;
	    login="";
	    pass="";
	
	    StartMenu();	
	    personsList = new ArrayList<PersonInfo>();
	    userList = new ArrayList<UserInfo>();
	
	    // creating PersonDAO object
	    pDAO = new PersonDAO();	

   }

   	public void createGUI(){

   		/*Create a frame, get its contentpane and set layout*/
   		appFrame = new JFrame("Summit Meeting");

   		cPane = appFrame.getContentPane();
   		cPane.setLayout(new GridBagLayout());
   		
   		//Arrange components on contentPane and set Action Listeners to each JButton
   		arrangeComponents();
   		
   		appFrame.setSize(340,500);
   		appFrame.setResizable(false);
   		appFrame.setVisible(true);
   		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   	}
   	public void StartMenu(){
   		frame = new JFrame("Start Menu");
   		
   		frame.setSize(400,200); 
   		p = new JPanel();
   		frame.setContentPane(p);
   		frame.setLocation(600, 300);
   		frame.setVisible(true);
   	   frame.setResizable(false);  
   	   JButton signUp = new JButton("Sign Up");
   		signUp.addActionListener(new ActionListener() {
   			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SignUp();
			}
		});
   		JButton logIn = new JButton("Log in");
   		logIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LogIn();
			}
		});
   		frame.add(signUp);
   		frame.add(logIn);
   	}
	public void SignUp(){
   		/*Create a frame, get its contentpane and set layout*/
   	frame = new JFrame("Sign Up");
	
	frame.setSize(230,300); 
	p = new JPanel();
	p.setLayout(null);
	frame.setContentPane(p);
	frame.setLocation(600, 300);
	frame.setVisible(true);
	frame.setResizable(false);
	formSignUp();
   	}
	
	public void formSignUp(){
   		lUserLogin = new JLabel("Input Login"); 
   		lUserLogin.setBounds(10,20,180,18); 
   		frame.add(lUserLogin); 

   		dUserLogin = new JTextField();
   		dUserLogin.setBounds(10, 40, 180, 20); 
   		frame.add(dUserLogin); 

   		lPass = new JLabel("Input password");  
   		lPass.setBounds(10,60,180,20); 
   		frame.add(lPass);

   		dPass = new JTextField();
   		dPass.setBounds(10, 80, 180, 20); 
   		frame.add(dPass); 
   		
   		lPass1 = new JLabel("Input Password one more time:");  
   		lPass1.setBounds(10,100,180,20); 
   		frame.add(lPass1); 

   		dPass1 = new JTextField();
   		dPass1.setBounds(10, 120, 180, 20); 
   		frame.add(dPass1); 

   		ok = new JButton("Ok"); 
   		ok.setSize(20,20);
   		ok.setBounds(10, 160, 180, 20);
   		p.add(ok);
   		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(dPass.getText().equals(dPass1.getText()))
				{saveUser();
				createGUI();
				frame.setVisible(false);}
				else JOptionPane.showMessageDialog(null,"Паролі не співпадають. Спробуте ще.");
			}
		});
   		

   	}
   	public void LogIn(){
   		/*Create a frame, get its contentpane and set layout*/
   	frame = new JFrame("Log IN");
	
	frame.setSize(230,300); 
	p = new JPanel();
	p.setLayout(null);
	frame.setContentPane(p);
	frame.setLocation(600, 300);
	frame.setVisible(true);
	frame.setResizable(false);
	formLogIn();
   	}
   	public void formLogIn(){
   		llogin = new JLabel("Input Login"); 
   		llogin.setBounds(10,20,180,18); 
   		frame.add(llogin); 

   		dlogin = new JTextField();
   		dlogin.setBounds(10, 40, 180, 20); 
   		frame.add(dlogin); //додавання до панелі

   		lpassword = new JLabel("Input password");  
   		lpassword.setBounds(10,60,180,20); 
   		frame.add(lpassword);

   		dpassword = new JTextField();
   		dpassword.setBounds(10, 80, 180, 20); 
   		frame.add(dpassword); 
   			

   		JButton ok = new JButton("Ok");
   		ok.setSize(100,20); 
   		ok.setBounds(10, 120, 180, 20);;
   		p.add(ok);
   		ok.addActionListener(
                new ActionListener() {
                
                public void actionPerformed(ActionEvent e) {
                	if(dlogin.getText().equals("")&&dpassword.getText().equals(""))
                	{JOptionPane.showMessageDialog(null, "Please, enter your login and pass!!!");}
                	else
                	{LoginCheck();
                	createGUI();
                	frame.setVisible(false);}
                }} );

   	}

   	public void arrangeComponents(){
   		jlbName = new JLabel("Name");
   		jlbSurname = new JLabel("Surname");
   		jlbAddress = new JLabel("Address(country)");
   		jlbMonth = new JLabel("Month");
   		jlbFrom = new JLabel("From Date");
   		jlbTo = new JLabel("To Date");

   		jtfName= new JTextField(20);
   		jtfAddress = new JTextField(20);
   		jtfSurname = new JTextField(20);
   		jtfAddress = new JTextField(20);
   		jtfMonth = new JTextField(20);
   		jtfFrom = new JTextField(20);
   		jtfTo = new JTextField(20);

   		jbbSave   = new JButton("Save");
   		jbnDelete = new JButton("Delete");
   		jbnClear  = new JButton("Clear");
   		jbnUpdate = new JButton("Update");
   		jbnSearch = new JButton("Search");

   		jbnForward = new JButton(">>");
   		jbnBack    = new JButton("<<");
   		jbnExit    = new JButton("Exit");

   		/*add all initialized components to the container*/
   		GridBagConstraints gridBagConstraintsx01 = new GridBagConstraints();
        gridBagConstraintsx01.gridx = 0;
        gridBagConstraintsx01.gridy = 0;
        gridBagConstraintsx01.insets = new Insets(5,5,5,5); 
        cPane.add(jlbName, gridBagConstraintsx01);
        
        GridBagConstraints gridBagConstraintsx02 = new GridBagConstraints();
        gridBagConstraintsx02.gridx = 1;
        gridBagConstraintsx02.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx02.gridy = 0;
        gridBagConstraintsx02.gridwidth = 2;
        gridBagConstraintsx02.fill = GridBagConstraints.BOTH;
        cPane.add(jtfName, gridBagConstraintsx02);
        
        GridBagConstraints gridBagConstraintsx03 = new GridBagConstraints();
        gridBagConstraintsx03.gridx = 0;
        gridBagConstraintsx03.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx03.gridy = 1;
        cPane.add(jlbSurname, gridBagConstraintsx03);
        
        GridBagConstraints gridBagConstraintsx04 = new GridBagConstraints();
        gridBagConstraintsx04.gridx = 1;
        gridBagConstraintsx04.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx04.gridy = 1;
        gridBagConstraintsx04.gridwidth = 2;
        gridBagConstraintsx04.fill = GridBagConstraints.BOTH;
        cPane.add(jtfSurname, gridBagConstraintsx04);
        
        GridBagConstraints gridBagConstraintsx05 = new GridBagConstraints();
        gridBagConstraintsx05.gridx = 0;
        gridBagConstraintsx05.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx05.gridy = 2;
        cPane.add(jlbAddress, gridBagConstraintsx05);
        
        GridBagConstraints gridBagConstraintsx06 = new GridBagConstraints();
        gridBagConstraintsx06.gridx = 1;
        gridBagConstraintsx06.gridy = 2;
        gridBagConstraintsx06.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx06.gridwidth = 2;
        gridBagConstraintsx06.fill = GridBagConstraints.BOTH;
        cPane.add(jtfAddress, gridBagConstraintsx06);
        
        GridBagConstraints gridBagConstraintsx07 = new GridBagConstraints();
        gridBagConstraintsx07.gridx = 0;
        gridBagConstraintsx07.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx07.gridy = 3;
        cPane.add(jlbMonth, gridBagConstraintsx07);
        
        GridBagConstraints gridBagConstraintsx08 = new GridBagConstraints();
        gridBagConstraintsx08.gridx = 1;
        gridBagConstraintsx08.gridy = 3;
        gridBagConstraintsx08.gridwidth = 2;
        gridBagConstraintsx08.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx08.fill = GridBagConstraints.BOTH;
        cPane.add(jtfMonth, gridBagConstraintsx08);
        
        GridBagConstraints gridBagConstraintsx09 = new GridBagConstraints();
        gridBagConstraintsx09.gridx = 0;
        gridBagConstraintsx09.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx09.gridy = 4;
        cPane.add(jlbFrom, gridBagConstraintsx09);
        
        GridBagConstraints gridBagConstraintsx10 = new GridBagConstraints();
        gridBagConstraintsx10.gridx = 1;
        gridBagConstraintsx10.gridy = 4;
        gridBagConstraintsx10.gridwidth = 2;
        gridBagConstraintsx10.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx10.fill = GridBagConstraints.BOTH;
        cPane.add(jtfFrom, gridBagConstraintsx10);
        
        GridBagConstraints gridBagConstraintsx11 = new GridBagConstraints();
        gridBagConstraintsx11.gridx = 0;
        gridBagConstraintsx11.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx11.gridy = 5;
        cPane.add(jlbTo, gridBagConstraintsx11);
        
        GridBagConstraints gridBagConstraintsx12 = new GridBagConstraints();
        gridBagConstraintsx12.gridx = 1;
        gridBagConstraintsx12.gridy = 5;
        gridBagConstraintsx12.gridwidth = 2;
        gridBagConstraintsx12.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx12.fill = GridBagConstraints.BOTH;
        cPane.add(jtfTo, gridBagConstraintsx12);
        
        GridBagConstraints gridBagConstraintsx13 = new GridBagConstraints();
        gridBagConstraintsx13.gridx = 0;
        gridBagConstraintsx13.gridy = 6;
        gridBagConstraintsx13.insets = new Insets(5,5,5,5); 
        cPane.add(jbbSave, gridBagConstraintsx13);
        
        GridBagConstraints gridBagConstraintsx14 = new GridBagConstraints();
        gridBagConstraintsx14.gridx = 1;
        gridBagConstraintsx14.gridy = 6;
        gridBagConstraintsx14.insets = new Insets(5,5,5,5); 
        cPane.add(jbnDelete, gridBagConstraintsx14);
        
        GridBagConstraints gridBagConstraintsx15 = new GridBagConstraints();
        gridBagConstraintsx15.gridx = 2;
        gridBagConstraintsx15.gridy = 6;
        gridBagConstraintsx15.insets = new Insets(5,5,5,5); 
        cPane.add(jbnUpdate, gridBagConstraintsx15);
        
        GridBagConstraints gridBagConstraintsx16 = new GridBagConstraints();
        gridBagConstraintsx16.gridx = 0;
        gridBagConstraintsx16.gridy = 7;
        gridBagConstraintsx16.insets = new Insets(5,5,5,5);
        cPane.add(jbnBack, gridBagConstraintsx16);
        
        GridBagConstraints gridBagConstraintsx17 = new GridBagConstraints();
        gridBagConstraintsx17.gridx = 1;
        gridBagConstraintsx17.gridy = 7;
        gridBagConstraintsx17.insets = new Insets(5,5,5,5); 
        cPane.add(jbnSearch, gridBagConstraintsx17);
        
        GridBagConstraints gridBagConstraintsx18 = new GridBagConstraints();
        gridBagConstraintsx18.gridx = 2;
        gridBagConstraintsx18.gridy = 7;
        gridBagConstraintsx18.insets = new Insets(5,5,5,5); 
        cPane.add(jbnForward, gridBagConstraintsx18);
        
        GridBagConstraints gridBagConstraintsx19 = new GridBagConstraints();
        gridBagConstraintsx19.gridx = 1;
        gridBagConstraintsx19.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx19.gridy = 8;
        cPane.add(jbnClear, gridBagConstraintsx19);
        
        GridBagConstraints gridBagConstraintsx20 = new GridBagConstraints();
        gridBagConstraintsx20.gridx = 2;
        gridBagConstraintsx20.gridy = 8;
        gridBagConstraintsx20.insets = new Insets(5,5,5,5); 
        cPane.add(jbnExit, gridBagConstraintsx20);
   		
   		jbbSave.addActionListener(this);
   		jbnDelete.addActionListener(this);
   		jbnClear.addActionListener(this);
   		jbnUpdate.addActionListener(this);
   		jbnSearch.addActionListener(this);
   		jbnForward.addActionListener(this);
   		jbnBack.addActionListener(this);
   		jbnExit.addActionListener(this);
   		//ok.addActionListener(this);
   	}

   	public void actionPerformed (ActionEvent e){
   		
   		if (e.getSource () == jbbSave){
             savePerson();
             clear(); 
        }
   		/*if (e.getSource () == ok){
            saveUser();
            clear(); 
       }*/

   		else if (e.getSource() == jbnDelete){
             deletePerson();
             clear();
        }

   		else if (e.getSource() == jbnUpdate){
             updatePerson();
             clear(); 
        }

   		else if (e.getSource() == jbnSearch){
             searchPerson();
        } 

   		else if (e.getSource() == jbnForward){
             displayNextRecord(); 
        }

  		else if (e.getSource() == jbnBack){
            displayPreviousRecord();
        }

   		else if (e.getSource() == jbnClear){
            clear();
        }

   		else if (e.getSource() == jbnExit){			
   			System.exit(0);
   		}

   	}
 
   	
    // Save the Person into the Address Book 
    public void saveUser(){  
	   	login = dUserLogin.getText();
	   	pass = dPass.getText();
	   	  	if(login.equals("")){
	   		JOptionPane.showMessageDialog(null, "Please enter person name.");
	   	}else{
		   	  //create a UserInfo object and pass it to PersonDAO to save it
		   	  UserInfo user = new UserInfo(login,pass);
		   	  pDAO.saveUser(user);
		   	  //JOptionPane.showMessageDialog(null, "Person Saved");
	      }
    }
     // Save the Person into the Address Book 
     public void savePerson(){  
	   	name    = jtfName.getText();
	   //	name = name.toUpperCase();	//Save all names in Uppercase
	   	surname = jtfSurname.getText();
	   	address = jtfAddress.getText();
	   	try{
	   	month = Integer.parseInt(""+jtfMonth.getText());
	   	FromTime = Integer.parseInt(""+jtfFrom.getText());
	   	ToTime = Integer.parseInt(""+jtfTo.getText());}
	   	catch (Exception e) {
			// TODO: handle exception
		}
	
	   	if(name.equals("")){
	   		JOptionPane.showMessageDialog(null, "Please enter person name.");
	   	}else{
		   	  //create a PersonInfo object and pass it to PersonDAO to save it
		   	  PersonInfo person = new PersonInfo(name,surname,address,month,FromTime,ToTime);
		   	  pDAO.savePerson(person);
		   	  JOptionPane.showMessageDialog(null, "Person Saved");
	      }
     }

     public void deletePerson(){

	   	name = jtfName.getText();
	   	name = name.toUpperCase();
	   	if(name.equals("")){
	   		JOptionPane.showMessageDialog(null,"Please enter person name to delete.");
	   	}
	   	else{
	   		//remove Person of the given name from the Address Book database
	   		int numberOfDeleted = pDAO.removePerson(name);
	   		JOptionPane.showMessageDialog(null, numberOfDeleted + " Record(s) deleted.");
	   	}
     }

    public void updatePerson(){
         if (recordNumber >= 0 && recordNumber < personsList.size())
         {
            PersonInfo person = (PersonInfo)personsList.get(recordNumber);

            int id = person.getId();

   	   /*get values from text fields*/            
   	   name    = jtfName.getText();
   	   address = jtfAddress.getText();
   	   surname=jtfSurname.getText();
       month   = Integer.parseInt(jtfMonth.getText());
       FromTime   = Integer.parseInt(jtfFrom.getText());
       ToTime   = Integer.parseInt(jtfTo.getText());
   	   /*update data of the given person name*/
   	   person = new PersonInfo(id,name,surname,address,month,FromTime,ToTime);
            pDAO.updatePerson(person);

   	   JOptionPane.showMessageDialog(null, "Person info record updated successfully.");         
         }
         else
         {   
              JOptionPane.showMessageDialog(null, "No record to Update");  
         }
    } 
    
    //Perform a Case-Insensitive Search to find the Person
    public void LoginCheck() {
        
	   	login = dlogin.getText();
	   	pass = dpassword.getText();
	   
	   	recordNumber = 0;
	
	   	
	   		/*get an array list of searched persons using PersonDAO*/
	   		userList = pDAO.Login(login,pass);
	
	   		if(userList.size() == 0){
	   			JOptionPane.showMessageDialog(null, "Invalid login or pass.");
	   			//Perform a clear if no records are found.
	   			clear();
	   		}
	   		
	   	}

    

      public void searchPerson() {
    
	   	name = jtfName.getText();
	   	name = name.toUpperCase();
	   	/*clear contents of arraylist if there are any from previous search*/
	   	personsList.clear();

	   	recordNumber = 0;
	
	   	if(name.equals("")){
	   		JOptionPane.showMessageDialog(null,"Please enter person name to search.");
	   	}
	   	else{
	   		/*get an array list of searched persons using PersonDAO*/
	   		personsList = pDAO.searchPerson(name);
	
	   		if(personsList.size() == 0){
	   			JOptionPane.showMessageDialog(null, "No records found.");
	   			//Perform a clear if no records are found.
	   			clear();
	   		}
	   		else
	   		{
	   			/*downcast the object from array list to PersonInfo*/
	   			PersonInfo person = (PersonInfo) personsList.get(recordNumber);
	
	             // displaying search record in text fields 
	   			jtfName.setText(person.getName());
	   			jtfAddress.setText(person.getAddress());
	   			jtfSurname.setText(person.getSurname());
	   			jtfMonth.setText(""+person.getMonth());
	   			jtfFrom.setText(""+person.getFromTime());
	   			jtfTo.setText(""+person.getToTime());
	   		}
	   	}

     }

   public void displayNextRecord(){

    // inc in recordNumber to display next person info, already stored in 
	//  personsList during search                  
   	recordNumber++;

   	if(recordNumber >= personsList.size()){
        JOptionPane.showMessageDialog(null, "You have reached end of " +
        		"search results"); 

   		/*if user has reached the end of results, disable forward button*/
   		jbnForward.setEnabled(false);
   		jbnBack.setEnabled(true);

       // dec by one to counter last inc
       recordNumber -- ; 
   	}
   	else{
   		jbnBack.setEnabled(true);
   		PersonInfo person = (PersonInfo) personsList.get(recordNumber);

       // displaying search record in text fields 
   		jtfName.setText(person.getName());
			jtfAddress.setText(person.getAddress());
			jtfSurname.setText(""+person.getSurname());
			jtfMonth.setText(""+person.getMonth());
			jtfFrom.setText(""+person.getFromTime());
			jtfTo.setText(""+person.getToTime());
   	}
   }


     public void displayPreviousRecord(){

         // dec in recordNumber to display previous person info, already 
    	 //stored in personsList during search                  
	   	recordNumber--;
	
	   	if(recordNumber < 0 ){
	        JOptionPane.showMessageDialog(null, "You have reached begining " +
	        		"of search results"); 
	
	   		/*if user has reached the begining of results, disable back button*/
	   		jbnForward.setEnabled(true);
	   		jbnBack.setEnabled(false);
	
             // inc by one to counter last dec
               recordNumber++;
	   	}else{
	   		jbnForward.setEnabled(true);
	   		PersonInfo person = (PersonInfo) personsList.get(recordNumber);
	
	        // displaying search record in text fields 
	   		jtfName.setText(person.getName());
   			jtfAddress.setText(person.getAddress());
   			jtfSurname.setText(""+person.getSurname());
   			jtfMonth.setText(""+person.getMonth());
   			jtfFrom.setText(""+person.getFromTime());
   			jtfTo.setText(""+person.getToTime());
	   	}

     }

     public void clear(){
    
    	 jtfName.setText("");
		jtfAddress.setText("");
		jtfSurname.setText("");
		jtfMonth.setText("");
		jtfFrom.setText("");
		jtfTo.setText("");
	   	
	   	/*clear contents of arraylist*/
	    recordNumber = -1;
	   	personsList.clear();
	   	jbnForward.setEnabled(true);
	   	jbnBack.setEnabled(true);
     }


   }