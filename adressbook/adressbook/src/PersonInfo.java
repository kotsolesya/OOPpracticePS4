
public class PersonInfo
{
	private String name,address,email,phone;
	private int id;

      // default constructor
      public PersonInfo()
      {       
         name = "";
         address = "";
         email = "";
         id = 0;  
         phone = "";
      }

	public PersonInfo(int id, String name, String address, String phone, String email)
	{
        this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
 
      // param construcrtor with 4 values 
	public PersonInfo(String name, String address, String phone, String email)
	{
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

      // setters
	public void setId(int i)
	{
		id = i;
	}

	public void setName(String n)
	{
		name=n;		
	}
	public void setAddress(String a)
	{
		address=a;
	}
	public void setPhone(String ph)
	{
		phone=ph;
	}
	public void setEmail(String e)
	{
		email=e;
	}

      // getters
	public int getId( )
	{
		return id;
      }

	public String getName()
	{
		return name;
	}

	public String getAddress()
	{
		return address;
	}

	public String getPhone()
	{
		return phone;
	}

	public String getEmail()
	{
		return email;
	}

}