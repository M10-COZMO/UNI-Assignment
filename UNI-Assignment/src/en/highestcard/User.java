package en.highestcard;

public class User {

	private String name;
	private int credit;
	
	public User(String _name, int _credit) {
		this.name = _name;
		this.credit = _credit;
	}
	
	public User() {
		
	}
	
	public void setName(String nameToSet) {
		this.name = nameToSet;
	}
	
	public int getCredit() {
		return credit;
	}
	
	public void setCredit(int initialCredit) {
		this.credit = initialCredit;
	}
	
	public void addCredit(int creditToAdd) {
		credit +=creditToAdd;
	}
	
	public void removesCredit(int creditToRemove) {
		credit -= creditToRemove;
	}
	
	@Override
	public String toString() {
		return "User Data\n -Name: " + name + "\n -Credit: " + credit;
		
	}
	
}
