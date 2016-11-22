import java.util.*;
import java.sql.*;
/*Two tables need to be created in MySQL DB
First:
create table Person (
	 id Integer,
	 name Varchar(30),
	 surname Varchar(30),
	 address Varchar(30),
	 month Integer,
	 FromTime Integer,
	 ToTime Integer
	 );
	 
Second:
create table Users (
Login Varchar(10),
UserPassword Varchar(30)
);*/
public class PersonDAO{      

    
	private ArrayList<PersonInfo> personsList;
	private ArrayList<UserInfo> userList;
	
	private String userid = "root";
	private String password = "VladViva_98";
	static String url = "jdbc:mysql://localhost:3306/adressbook";	
	private Connection con;

     // constructor 
	public PersonDAO(){
		personsList = new ArrayList<PersonInfo>();
		userList = new ArrayList<UserInfo>();
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
public ArrayList<UserInfo> Login(String Login,String Pass)
	{
		try	{
			String sql = "SELECT * FROM Users WHERE Login like '%"+Login+"%'";

			// Create a prepared statement
 			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery(sql);

            Login = "";
            Pass="";
            while(rs.next())
			{
            	Login=rs.getString("Login");
            	Pass=rs.getString("UserPassword");

				//Create a PersonInfo object
				UserInfo user = new UserInfo(Login,Pass);

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
            String surname = "";
            String address = "";
            int id,month,from,to;

			while(rs.next())
			{
                id = rs.getInt("id");
				pname = rs.getString("name");
				surname = rs.getString("surname");
				address = rs.getString("address");
				month = rs.getInt("month");
				from = rs.getInt("FromTime");
				to = rs.getInt("ToTime");

				//Create a PersonInfo object
				PersonInfo person = new PersonInfo(id, pname,surname,address, month,from,to);

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
			String sql = "INSERT INTO users(Login, UserPassword)"
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
			String sql = "INSERT INTO person(name, surname, address, "
					+ "month, FromTime, ToTime) VALUES (?,?,?,?,?,?) ";

			// Create a Prepared statement
 			java.sql.PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setString(1, person.getName());
			ps.setString(2, person.getSurname());
			ps.setString(3, person.getAddress());
			ps.setInt(4, person.getMonth());
			ps.setInt(5, person.getFromTime());
			ps.setInt(6, person.getToTime());

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
			String sql = "UPDATE Person SET name = ?,surname = ?, "
					+ "address=? , month=? , FromTime=?,to=? where id=?";

			// Create a Prepared statement
 			java.sql.PreparedStatement ps = con.prepareStatement(sql);
	
 			ps.setString(1, person.getName());
			ps.setString(2, person.getSurname());
			ps.setString(3, person.getAddress());
			ps.setInt(4, person.getMonth());
			ps.setInt(5, person.getFromTime());
			ps.setInt(6, person.getToTime());
			ps.setInt(7 , person.getId());

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