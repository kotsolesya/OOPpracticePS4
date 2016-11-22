
public class PersonInfo
{
	String name,surname, address;
	int month;
    int FromTime,ToTime;
	private int id;

      // default constructor
      public PersonInfo()
      {       
        name = "";
        address = "";
        surname = "";
        id = 0;  
        month=0;
        FromTime=0;
        ToTime=0;
      }

	public PersonInfo(int id, String name, String surname, String address, int month,int FromTime,int ToTime)
	{
        this.id = id;
		this.name = name;
		this.surname=surname;
		this.address = address;
		this.month = month;
		this.FromTime = FromTime;
		this.ToTime=ToTime;
	}
 

	public PersonInfo(String name, String surname, String address, int month,int FromTime,int ToTime)
	{
		this.name = name;
		this.surname=surname;
		this.address = address;
		this.month = month;
		this.FromTime = FromTime;
		this.ToTime=ToTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surn) {
		surname = surn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String addr) {
		address = addr;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int mon) {
		this.month = mon;
	}

	public int getFromTime() {
		return FromTime;
	}

	public void setFromTime(int fr) {
		this.FromTime = fr;
	}

	public int getId() {
		return id;
	}

	public void setId(int Id) {
		id = Id;
	}

	public int getToTime() {
		return ToTime;
	}

	public void setToTime(int t) {
		ToTime = t;
	}

     

}