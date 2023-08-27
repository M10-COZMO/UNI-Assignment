package en.lonelyhearts;

public class LonelyHeart {
	
	private String name;
	private int age;
	private String gender;
	
	public LonelyHeart(String _name, int _age, String _gender) {
		this.name = _name;
		this.age = _age;
		this.gender = _gender;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Boolean itIsRelated() {
	return true;	
	}
	
	
}
