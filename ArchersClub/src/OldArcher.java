import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OldArcher extends Archer{

	private static final int MAX_POINTS = 10;
	private static final int ADDITIONAL_BONUS = 2;
	private static final int PERCENT_CHANCE_OF_MISS = 5;
	private static final int NUMBER_OF_SHOTS = 60;
	private static final int MAX_YEARS_EXPERIENCE = 10;
	private static final int MIN_YEARS_EXPERIENCE = 3;

	public OldArcher(String name, boolean isMale, int age, Bow bow, int experience, int numberOfRaces) {
		super(name, isMale, age, bow, experience, numberOfRaces);
		this.type = "Old";
	}
	
	@Override
	public void setExperience(int experience) {
		if(experience >= MIN_YEARS_EXPERIENCE && experience <= MAX_YEARS_EXPERIENCE) {
			super.setExperience(experience);
		} else {
			System.err.println("Invalid experience for old archer");
		}
	}

	@Override
	public void setBow(Bow bow) {
		if(bow != null && (bow instanceof AluminiumBow || bow instanceof CarbonBow)) {
			super.setBow(bow);
		} else {
			System.err.println("Invalid bow for old archer");
		}
	}
	
	@Override
	public Bow getBow() {
		return super.getBow();
	}
	
	@Override
	public List<Integer> makeShots() {
		
		List<Integer> points = new ArrayList<Integer>(NUMBER_OF_SHOTS);
		for(int i=1; i <= NUMBER_OF_SHOTS; i++) {
			int chanceOfMiss = new Random().nextInt(100) + 1;
			if(chanceOfMiss > PERCENT_CHANCE_OF_MISS) {
				int arrowScore = new Random().nextInt(5) + 6;
				arrowScore += 1;
				
				if(getBow() instanceof CarbonBow) {
					arrowScore += ADDITIONAL_BONUS;
				}
				
				if(arrowScore > MAX_POINTS) {
					arrowScore = MAX_POINTS;
				}
				points.add(arrowScore);
			}
		}
		calculatePercentAccurancy(points);
		return points;
	}
	
	@Override
	public void setPercentAccurancy(double percentAccurancy) {
		super.setPercentAccurancy((percentAccurancy/NUMBER_OF_SHOTS)*10);
	}
	
	@Override
	public double calculatePercentAccurancy(List<Integer> archerShots) {
		int sumPoints = 0;
		for(Integer p : archerShots) {
			sumPoints += p;
		}
		setPercentAccurancy(sumPoints);
		return (sumPoints/(NUMBER_OF_SHOTS*10))*100;
	}
}
