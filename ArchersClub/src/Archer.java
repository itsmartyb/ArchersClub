import java.util.List;

public abstract class Archer extends Info{
	private boolean isMale;
	private int age;
	private Bow bow;
	private int experience;
	private int numberOfRaces;
	private double percentAccurancy;
	protected String type;
	
	public Archer(String name, boolean isMale, int age, Bow bow, int experience, int numberOfRaces) {
		super(name);
		setMale(isMale);
		setAge(age);
		setBow(bow);
		setExperience(experience);
		setNumberOfRaces(numberOfRaces);
	}
	
	public abstract List<Integer> makeShots();
	public abstract double calculatePercentAccurancy(List<Integer> archerShots);
	
	public void increaseNumberOfRaces() {
		this.numberOfRaces++;
	}

	public boolean isMale() {
		return this.isMale;
	}

	private void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		if(age > 0 && age < 120) {
			this.age = age;
		} else {
			System.err.println("Invalid age for archer");
		}
	}

	public Bow getBow() {
		return this.bow;
	}

	public void setBow(Bow bow) {
		this.bow = bow;
	}

	public int getExperience() {
		return this.experience;
	}

	public void setExperience(int experience) {
		if(experience > 0) {
			this.experience = experience;
		} else {
			System.err.println("Invalid experience for archer");
		}
	}

	public int getNumberOfRaces() {
		return numberOfRaces;
	}

	public void setNumberOfRaces(int numberOfRaces) {
		if(numberOfRaces > 0) {
			this.numberOfRaces = numberOfRaces;
		} else {
			System.err.println("Invalid number of races for archer");
		}
	}

	public String getType() {
		return this.type;
	}
	
	public double getPercentAccurancy() {
		return percentAccurancy;
	}
	
	public void setPercentAccurancy(double percentAccurancy) {
		if(percentAccurancy > 0) {
			this.percentAccurancy = percentAccurancy;
		} else {
			System.err.println("Invalid percent accurancy");
		}
	}
	
	@Override
	public String toString() {
	
		return super.toString() + " isMale=" + isMale + ", age=" + age + " , " + bow + ", experience=" + experience
				+ ", numberOfRaces=" + numberOfRaces + " category: " + type + ", percentAccurancy: " + percentAccurancy;
	}
	
	@Override
	public int hashCode() {
	
		return (this.isMale == true ? 2 : 3) * (this.age * this.experience + this.numberOfRaces);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Archer) {
			Archer otherArcher = ((Archer)obj);
			return this.age == otherArcher.age && this.isMale == otherArcher.isMale &&
					this.experience == otherArcher.experience && this.numberOfRaces == otherArcher.experience;
		}
		return false;
	}
}
