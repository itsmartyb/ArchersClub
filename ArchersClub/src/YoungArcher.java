import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class YoungArcher extends Archer{

	private static final int CHANCE_OF_MISS = 10;
	private static final int PERCENT_CHANCE_OF_MISS = CHANCE_OF_MISS;
	private static final int NUMBER_SHOTS = 30;
	private static final int MAX_YEARS_EXPERIENCE = 3;
	private static final int MIN_YEARS_EXPERIENCE = 1;

	public YoungArcher(String name, boolean isMale, int age, Bow bow, int experience, int numberOfRaces) {
		super(name, isMale, age, bow, experience, numberOfRaces);
		this.type = "Young";
	}
	
	@Override
	public void setExperience(int experience) {
		if(experience >= MIN_YEARS_EXPERIENCE && experience <= MAX_YEARS_EXPERIENCE) {
			super.setExperience(experience);
		} else {
			System.err.println("Invalid experience for young archer");
		}
	}
	
	@Override
	public void setBow(Bow bow) {
		if(bow != null && bow instanceof WoodenBow) {
			super.setBow(bow);
		} else {
			System.err.println("Invalid bow for young archer");
		}
	}
	
	@Override
	public Bow getBow() {
		return super.getBow();
	}
	
	@Override
	public void setPercentAccurancy(double percentAccurancy) {
		super.setPercentAccurancy((percentAccurancy/NUMBER_SHOTS)*10);
		
	}

	@Override
	public List<Integer> makeShots() {
	
		List<Integer> points = new ArrayList<Integer>(NUMBER_SHOTS);
		for(int i=1; i <= NUMBER_SHOTS; i++) {
			double chanceOfMiss = new Random().nextInt(100) + 1;
			if(chanceOfMiss > PERCENT_CHANCE_OF_MISS) {
				int arrowScore = new Random().nextInt(10) + 1;
				points.add(arrowScore);
			} else {
				points.add(0);
			}
		}
		calculatePercentAccurancy(points);
		return points;
    }
	
	@Override
	public double calculatePercentAccurancy(List<Integer> archerShots) {
		int sumPoints = 0;
		for(Integer p : archerShots) {
			sumPoints += p;
		}
		setPercentAccurancy(sumPoints);
		return (sumPoints/(NUMBER_SHOTS*10))*100;
	}

	@Override
	public String getType() {
	
		return this.type;
	}
}
