
public class UserInfo {
String login,userPassword;
public UserInfo()
{       
	login="";userPassword="";
}
public UserInfo(String login, String userPassword)
{
    this.login =login;
	this.userPassword = userPassword;
	
}
public String getLogin() {
	return login;
}

public void setLogin(String l) {
	login = l;
}

public String getUserPassword() {
	return userPassword;
}

public void setUserPassword(String userPass) {
	userPassword = userPass;
}
}
