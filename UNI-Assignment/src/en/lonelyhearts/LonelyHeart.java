package en.lonelyhearts;

import java.util.Objects;

public class LonelyHeart {
	
	private String name;
	private int age;
	private String gender;
	private String zodiacSign;
	
	public LonelyHeart(String _name, int _age, String _gender, String _zodiacSign) {
		this.name = _name;
		this.age = _age;
		this.gender = _gender;
		this.zodiacSign = _zodiacSign;
	}
	
	public String getZodiacSign() {
		return zodiacSign;
	}

	public void setZodiacSign(String zodiacSign) {
		this.zodiacSign = zodiacSign;
	}

	public LonelyHeart() {
		
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
	
	
	private Boolean sameGender(LonelyHeart lonelyHeart) {
		if (gender.equals(lonelyHeart.getGender())) {
			return true;
		} else {
			return false;
		}
	}
	
	private Boolean sameZodiacSign(LonelyHeart lonelyHeart) {
		if (getZodiacSign().equals(lonelyHeart.getZodiacSign())) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "LonelyHeart [name=" + name + ", age=" + age + ", gender=" + gender + ", zodiac sign=" + zodiacSign + "]";
	}

	public Boolean isCompatibleWith(LonelyHeart lonelyHeart) {
		if (age - lonelyHeart.getAge() <= 5 && sameGender(lonelyHeart) == false && sameZodiacSign(lonelyHeart) == false) {
			return true;
		} else {
			return false;
		}
	}
	
	public void gendereError() {
		if(gender != "M" || gender != "F") {
			System.out.println("Insert the character \"M\" or \"M\"");
		}
	}
}
