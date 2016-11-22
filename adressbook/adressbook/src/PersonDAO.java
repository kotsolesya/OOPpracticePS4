
import java.util.*;

import com.mysql.jdbc.PreparedStatement;

import java.sql.*;

public class PersonDAO{      
	
	/* Person Table needs to be created in the Oracle Database.
	 * create table Person (
	id Integer,
	name Varchar(30),
	address Varchar(30),
	phone Varchar(13),
	email Varchar(50)
);*/

    
	private ArrayList<PersonInfo> personsList;
	private ArrayList<UserInfo> userList;
	private String userid = "root";
	private String password = "VladViva_98";
	static String url = "jdbc:mysql://localhost:3306/adressbook";	
	private String login = "root";
	private String Userpassword = "VladViva_98";
	private Connection con;

     // constructor 
	public PersonDAO(){
		personsList = new ArrayList<PersonInfo>();
		getConnection();		//Create Connection to the Oracle Database
	}

	public Connection getConnection(){
		
		try {
			con = DriverManager.getConnection(url, userid, password);
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		
		return con;
	}
	public boolean checkUser(UserInfo user) throws SQLException{
		boolean isUserExists = false;
	   try (PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from Users where `Login` = ? and `Password` = ?")) {
	        ps.setString(1, user.getLogin());
	        ps.setString(2, user.getUserPassword());
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                isUserExists = true;
	            }
	        }
	    }
	    return isUserExists;
	}
	public ArrayList<UserInfo> searchUser(String login){
		try	{
			String sql = "SELECT * FROM Users WHERE Login like '%"+login+"%'";

			// Create a prepared statement
 			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery(sql);

            String log = "";
            String pass = "";
            

			while(rs.next())
			{
                log = rs.getString("Login");
				pass = rs.getString("UserPassword");
				

				//Create a PersonInfo object
				UserInfo user = new UserInfo(log,pass);

				//Add the person object to array list
				userList.add(user);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
           
		return userList;
		
	}
	public ArrayList<PersonInfo> searchPerson(String name)
	{
		try	{
			String sql = "SELECT * FROM Person WHERE name like '%"+name+"%'";

			// Create a prepared statement
 			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery(sql);

            String pname = "";
            String address = "";
            String email = "";
            int id;
			String phone = "";

			while(rs.next())
			{
                id = rs.getInt("id");
				pname = rs.getString("name");
				address = rs.getString("address");
				phone = rs.getString("phone");
				email = rs.getString("email");

				//Create a PersonInfo object
				PersonInfo person = new PersonInfo(id, pname, address, phone, email);

				//Add the person object to array list
				personsList.add(person);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
           
		return personsList;

	} 
	public void saveUser(UserInfo user){
		try
		{
			String sql = "INSERT INTO Users(Login, UserPassword)"
					+ " VALUES (?,?) ";

			// Create a Prepared statement
 			java.sql.PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getUserPassword());
			

			ps.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public void savePerson(PersonInfo person){
		try
		{
			String sql = "INSERT INTO Person(name, address, " +
							"phone, email) VALUES (?,?,?,?) ";

			// Create a Prepared statement
 			java.sql.PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setString(1, person.getName());
			ps.setString(2, person.getAddress());
			ps.setString(3, person.getPhone());
			ps.setString(4, person.getEmail());

			ps.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void updatePerson(PersonInfo person)
	{
		try
		{
			String sql = "UPDATE Person SET name = ?, address=? , " +
					"phone=? , email=? where id=?";

			// Create a Prepared statement
 			java.sql.PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setString(1 , person.getName());		
			ps.setString(2 , person.getAddress());
			ps.setString(3 , person.getPhone());
			ps.setString(4 , person.getEmail());
			ps.setInt(5 , person.getId());

			ps.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public int removePerson(String name){
        int no = 0;
		try{
			String sql = "DELETE FROM Person WHERE name = ?";
			// Create a Prepared statement
 			java.sql.PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			no = ps.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return no;
	}

}// end class PersonDAO