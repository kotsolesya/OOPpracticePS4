import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class AddressBookDemo implements ActionListener
{
	//Connection con;
	ArrayList<PersonInfo> personsList;
	ArrayList<UserInfo> userList;
   	PersonDAO pDAO;
   	JFrame appFrame,frame;JPanel p;
   	JLabel jlbName, jlbAddress, jlbPhone, jlbEmail;
   	JTextField jtfName, jtfAddress, jtfPhone, jtfEmail;
   	JButton jbbSave, jbnDelete, jbnClear, jbnUpdate, jbnSearch,
   					jbnForward, jbnBack, jbnExit;
    JButton ok; 
    JLabel lUserLogin,lPass,lPass1;
    JTextField dUserLogin,dPass,dPass1;
	String login,pass;
   	String name, address, email;
   	JLabel llogin,lpassword;
   	JTextField dlogin,dpassword;
   	String phone;
   	int recordNumber;	 // used to naviagate using >> and << buttons 
   	Container cPane,cPane1;
   public static void main(String args[]){
      new AddressBookDemo(); 
   }

   public AddressBookDemo()
   { 	
	    name    = "";
	    address = "";
	    email  = "";
	    phone   = "" ;		//Stores 0 to indicate no Phone Number
	    recordNumber = -1;
	    login="";
	    pass="";
	
	    StartMenu();	
	    personsList = new ArrayList<PersonInfo>();
	
	    // creating PersonDAO object
	    pDAO = new PersonDAO();	

   }

   	public void createGUI(){

   		/*Create a frame, get its contentpane and set layout*/
   		appFrame = new JFrame("Address Book");

   		cPane = appFrame.getContentPane();
   		cPane.setLayout(new GridBagLayout());
   		
   		//Arrange components on contentPane and set Action Listeners to each JButton
   		arrangeComponents();
   		
   		appFrame.setSize(240,300);
   		appFrame.setResizable(false);
   		appFrame.setVisible(true);
   		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   	}
   	public void StartMenu(){
   		frame = new JFrame("Зареєструватись");//встановлення назви вікна
   		
   		frame.setSize(200,200);//встановлення розміру вікна 
   		p = new JPanel();//створення панелі 
   		frame.setContentPane(p);//додавання до вікна панелі
   		frame.setLocation(600, 300);//встановлення розміщення вікана
   		frame.setVisible(true);//показ вікна
   	   
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
   	frame = new JFrame("Зареєструватись");//встановлення назви вікна
	
	frame.setSize(500,300);//встановлення розміру вікна 
	p = new JPanel();//створення панелі 
	p.setLayout(null);//заборона стандартного розміщення об’єктів
	frame.setContentPane(p);//додавання до вікна панелі
	frame.setLocation(600, 300);//встановлення розміщення вікана
	frame.setVisible(true);//показ вікна
   	formSignUp();
   	}
	
	public void formSignUp(){
   		lUserLogin = new JLabel("Введіть логін:"); //створення надпису над текстовим полем
   		lUserLogin.setBounds(10,20,180,18); //встановлення розміру
   		frame.add(lUserLogin); //додавання до панелі

   		dUserLogin = new JTextField();//створення надпису над текстовим полем
   		dUserLogin.setBounds(10, 40, 180, 20); //встановлення розміру
   		frame.add(dUserLogin); //додавання до панелі

   		lPass = new JLabel("Введіть пароль:");  //створення надпису над текстовим полем
   		lPass.setBounds(10,60,180,20); //встановлення розміру
   		frame.add(lPass); //додавання до панелі

   		dPass = new JTextField();//створення надпису над текстовим полем
   		dPass.setBounds(10, 80, 180, 20); //встановлення розміру
   		frame.add(dPass); //додавання до панелі
   		
   		lPass1 = new JLabel("Підтвердіть пароль:");  //створення надпису над текстовим полем
   		lPass1.setBounds(10,100,180,20); //встановлення розміру
   		frame.add(lPass1); //додавання до панелі

   		dPass1 = new JTextField();//створення надпису над текстовим полем
   		dPass1.setBounds(10, 120, 180, 20); //встановлення розміру
   		frame.add(dPass1); //додавання до панелі	

   		ok = new JButton("Ok"); //створення кнопки
   		ok.setSize(100,20);//встановлення розміру кнопки 
   		ok.setBounds(10, 140, 180, 20);;//встановлення положення кнопки
   		p.add(ok);//додавання до панелі
   		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(dPass.getText().equals(dPass1.getText()))
				{saveUser();
				createGUI();}
				else JOptionPane.showMessageDialog(null,"Паролі не співпадають. Спробуте ще.");
			}
		});

   	}
   	public void LogIn(){
   		/*Create a frame, get its contentpane and set layout*/
   	frame = new JFrame("Увійти");//встановлення назви вікна
	
	frame.setSize(500,300);//встановлення розміру вікна 
	p = new JPanel();//створення панелі 
	p.setLayout(null);//заборона стандартного розміщення об’єктів
	frame.setContentPane(p);//додавання до вікна панелі
	frame.setLocation(600, 300);//встановлення розміщення вікана
	frame.setVisible(true);//показ вікна
	formLogIn();
   	}
   	public void formLogIn(){
   		llogin = new JLabel("Введіть логін:"); //створення надпису над текстовим полем
   		llogin.setBounds(10,20,180,18); //встановлення розміру
   		frame.add(llogin); //додавання до панелі

   		dlogin = new JTextField();//створення надпису над текстовим полем
   		dlogin.setBounds(10, 40, 180, 20); //встановлення розміру
   		frame.add(dlogin); //додавання до панелі

   		lpassword = new JLabel("Введіть пароль:");  //створення надпису над текстовим полем
   		lpassword.setBounds(10,60,180,20); //встановлення розміру
   		frame.add(lpassword); //додавання до панелі

   		dpassword = new JTextField();//створення надпису над текстовим полем
   		dpassword.setBounds(10, 80, 180, 20); //встановлення розміру
   		frame.add(dpassword); //додавання до панелі
   			

   		JButton ok = new JButton("Ok"); //створення кнопки
   		ok.setSize(100,20);//встановлення розміру кнопки 
   		ok.setBounds(10, 120, 180, 20);;//встановлення положення кнопки
   		p.add(ok);//додавання до панелі
   		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				searchUser();
				createGUI();
				
			}
		});

   	}

   	public void arrangeComponents(){
   		jlbName = new JLabel("Name");
   		jlbAddress = new JLabel("Address");
   		jlbPhone = new JLabel("Phone");
   		jlbEmail = new JLabel("Email");
   		

   		jtfName    = new JTextField(20);
   		jtfAddress = new JTextField(20);
   		jtfPhone   = new JTextField(20);
   		jtfEmail   = new JTextField(20);

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
        cPane.add(jlbAddress, gridBagConstraintsx03);
        
        GridBagConstraints gridBagConstraintsx04 = new GridBagConstraints();
        gridBagConstraintsx04.gridx = 1;
        gridBagConstraintsx04.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx04.gridy = 1;
        gridBagConstraintsx04.gridwidth = 2;
        gridBagConstraintsx04.fill = GridBagConstraints.BOTH;
        cPane.add(jtfAddress, gridBagConstraintsx04);
        
        GridBagConstraints gridBagConstraintsx05 = new GridBagConstraints();
        gridBagConstraintsx05.gridx = 0;
        gridBagConstraintsx05.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx05.gridy = 2;
        cPane.add(jlbPhone, gridBagConstraintsx05);
        
        GridBagConstraints gridBagConstraintsx06 = new GridBagConstraints();
        gridBagConstraintsx06.gridx = 1;
        gridBagConstraintsx06.gridy = 2;
        gridBagConstraintsx06.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx06.gridwidth = 2;
        gridBagConstraintsx06.fill = GridBagConstraints.BOTH;
        cPane.add(jtfPhone, gridBagConstraintsx06);
        
        GridBagConstraints gridBagConstraintsx07 = new GridBagConstraints();
        gridBagConstraintsx07.gridx = 0;
        gridBagConstraintsx07.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx07.gridy = 3;
        cPane.add(jlbEmail, gridBagConstraintsx07);
        
        GridBagConstraints gridBagConstraintsx08 = new GridBagConstraints();
        gridBagConstraintsx08.gridx = 1;
        gridBagConstraintsx08.gridy = 3;
        gridBagConstraintsx08.gridwidth = 2;
        gridBagConstraintsx08.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx08.fill = GridBagConstraints.BOTH;
        cPane.add(jtfEmail, gridBagConstraintsx08);
        
        GridBagConstraints gridBagConstraintsx09 = new GridBagConstraints();
        gridBagConstraintsx09.gridx = 0;
        gridBagConstraintsx09.gridy = 4;
        gridBagConstraintsx09.insets = new Insets(5,5,5,5); 
        cPane.add(jbbSave, gridBagConstraintsx09);
        
        GridBagConstraints gridBagConstraintsx10 = new GridBagConstraints();
        gridBagConstraintsx10.gridx = 1;
        gridBagConstraintsx10.gridy = 4;
        gridBagConstraintsx10.insets = new Insets(5,5,5,5); 
        cPane.add(jbnDelete, gridBagConstraintsx10);
        
        GridBagConstraints gridBagConstraintsx11 = new GridBagConstraints();
        gridBagConstraintsx11.gridx = 2;
        gridBagConstraintsx11.gridy = 4;
        gridBagConstraintsx11.insets = new Insets(5,5,5,5); 
        cPane.add(jbnUpdate, gridBagConstraintsx11);
        
        GridBagConstraints gridBagConstraintsx12 = new GridBagConstraints();
        gridBagConstraintsx12.gridx = 0;
        gridBagConstraintsx12.gridy = 5;
        gridBagConstraintsx12.insets = new Insets(5,5,5,5);
        cPane.add(jbnBack, gridBagConstraintsx12);
        
        GridBagConstraints gridBagConstraintsx13 = new GridBagConstraints();
        gridBagConstraintsx13.gridx = 1;
        gridBagConstraintsx13.gridy = 5;
        gridBagConstraintsx13.insets = new Insets(5,5,5,5); 
        cPane.add(jbnSearch, gridBagConstraintsx13);
        
        GridBagConstraints gridBagConstraintsx14 = new GridBagConstraints();
        gridBagConstraintsx14.gridx = 2;
        gridBagConstraintsx14.gridy = 5;
        gridBagConstraintsx14.insets = new Insets(5,5,5,5); 
        cPane.add(jbnForward, gridBagConstraintsx14);
        
        GridBagConstraints gridBagConstraintsx15 = new GridBagConstraints();
        gridBagConstraintsx15.gridx = 1;
        gridBagConstraintsx15.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx15.gridy = 6;
        cPane.add(jbnClear, gridBagConstraintsx15);
        
        GridBagConstraints gridBagConstraintsx16 = new GridBagConstraints();
        gridBagConstraintsx16.gridx = 2;
        gridBagConstraintsx16.gridy = 6;
        gridBagConstraintsx16.insets = new Insets(5,5,5,5); 
        cPane.add(jbnExit, gridBagConstraintsx16);
   		
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
	   	name = name.toUpperCase();	//Save all names in Uppercase
	   	address = jtfAddress.getText();
	   	try{
	   		phone = jtfPhone.getText();
	   	}catch(Exception e){
	   		/*System.out.print("Input is a string");
	   		JOptionPane.showMessageDialog(null, "Please enter Phone Number");*/
	   	}
	   	
	   	email   = jtfEmail.getText();
	
	   	if(name.equals("")){
	   		JOptionPane.showMessageDialog(null, "Please enter person name.");
	   	}else{
		   	  //create a PersonInfo object and pass it to PersonDAO to save it
		   	  PersonInfo person = new PersonInfo(name, address, phone, email);
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
   	   phone   = jtfPhone.getText();
       email   = jtfEmail.getText();

   	   /*update data of the given person name*/
   	   person = new PersonInfo(id, name, address, phone, email);
            pDAO.updatePerson(person);

   	   JOptionPane.showMessageDialog(null, "Person info record updated successfully.");         
         }
         else
         {   
              JOptionPane.showMessageDialog(null, "No record to Update");  
         }
    } 
    
    //Perform a Case-Insensitive Search to find the Person

    public void searchUser() {
        
	   	login = dlogin.getText();
	   	pass = dpassword.getText();
	   	/*clear contents of arraylist if there are any from previous search*/
	   //userList.clear();

	   	recordNumber = 0;
	
	   	if(login.equals("")){
	   		JOptionPane.showMessageDialog(null,"Please enter person login.");
	   	}
	   	else{
	   		/*get an array list of searched persons using PersonDAO*/
	   		userList = pDAO.searchUser(login);
	
	   		if(userList.size() == 0){
	   			JOptionPane.showMessageDialog(null, "No records found.");
	   			//Perform a clear if no records are found.
	   			clear();
	   		}
	   		else
	   		{
	   			/*downcast the object from array list to PersonInfo*/
	   			UserInfo user = (UserInfo) userList.get(recordNumber);
	
	            
	   		}
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
	   			jtfPhone.setText(""+person.getPhone());
	   			jtfEmail.setText(person.getEmail());
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
   		jtfPhone.setText(""+person.getPhone());
   		jtfEmail.setText(person.getEmail());
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
	   		jtfPhone.setText(""+person.getPhone());
	   		jtfEmail.setText(person.getEmail());
	   	}

     }

     public void clear(){
    
	   	jtfName.setText("");
	   	jtfAddress.setText("");
	   	jtfPhone.setText("");
	   	jtfEmail.setText("");
	   	
	   	/*clear contents of arraylist*/
	    recordNumber = -1;
	   	personsList.clear();
	   	jbnForward.setEnabled(true);
	   	jbnBack.setEnabled(true);
     }


   }