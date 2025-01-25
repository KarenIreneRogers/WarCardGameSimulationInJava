package FinalCodingProject_War;

public class Card {
	
	String name;
	int value;
	
	public Card () {}
	
	public Card(String name, int value) {
		this.name= name;
		this.value = value;
	}
//	public void describe(String name, int value) {
//		System.out.println(name + " Value: " + value);
//	}
	
	public void describe() {   
		String spaceString = "   ";
		if (value <10) { 
			spaceString = spaceString + " "; 
			}
		System.out.println("Value: " + value + spaceString + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
