package dataVerify;

public class verifyPerson extends databaseAction {
	String username,password;
	int Roll=0;
	public verifyPerson(String username, String password) {
		
		super();
		loginInfo l=null,li;
		this.username = username;
		this.password = password;
		l=new loginInfo();
		l.setPassword(password);
		l.setUsername(username);
		li=new loginInfo();
		li=databaseAction.verifyLogin(l);
		if(li!=null)
		this.Roll=li.getRoll();
		
	}
	public verifyPerson(int roll,String username,String password)
	{
		loginInfo li=new loginInfo();
		li.setRoll(roll);
		li.setPassword(password);
		li.setUsername(username);
		databaseAction.insert(li);
		
	}
	
	public verifyPerson(int roll) {
		super();
		loginInfo li=new loginInfo();
		
		li.setRoll(roll);
		search(li);
	}
	public verifyPerson(String password, int roll) {
		super();
		this.password = password;
		Roll = roll;
		loginInfo l=new loginInfo();
		l.setPassword(password);
		l.setRoll(roll);
		databaseAction.update(l);
		
	}
	public int getRoll() {
		return Roll;
	}
	public void setRoll(int roll) {
		Roll = roll;
	}
	public void verifyLogin(int id, String username2, String conPass) {
		// TODO Auto-generated method stub
		
	}

	
}
