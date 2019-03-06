import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VeteranArcher extends Archer {

	private static final int MAX_POINTS = 10;
	private static final int BONUS_POINTS = 3;
	private static final int NUMBER_OF_SHOTS = 60;
	private static final int MIN_YEARS_EXPERIENCE = 10;

	public VeteranArcher(String name, boolean isMale, int age, Bow bow, int experience, int numberOfRaces) {
		super(name, isMale, age, bow, experience, numberOfRaces);
		this.type = "Veteran";
		
	}
	
	@Override
	public void setExperience(int experience) {
		if(experience >= MIN_YEARS_EXPERIENCE) {
			super.setExperience(experience);
		} else {
			System.err.println("Invalid experience for veteran archer");
		}
	}
	
	@Override
	public void setBow(Bow bow) {
		if(bow != null && bow instanceof CarbonBow) {
			super.setBow(bow);
		} else {
			System.err.println("Invalid bow for veteran archers");
		}
	}
	
//	@Override
//	public String getType() {
//		return this.type;
//	}
	
	@Override
	public Bow getBow() {
		return super.getBow();
	}
	
	@Override
	public void setPercentAccurancy(double percentAccurancy) {
		super.setPercentAccurancy((percentAccurancy/NUMBER_OF_SHOTS)*10);
	}
	
	@Override
	public List<Integer> makeShots() {
	
		List<Integer> points = new ArrayList<Integer>(NUMBER_OF_SHOTS);
		for(int i=1; i <= NUMBER_OF_SHOTS; i++) {
				int arrowScore = new Random().nextInt(5) + 6;
				arrowScore += BONUS_POINTS;
				
				if(arrowScore > MAX_POINTS) {
					arrowScore = MAX_POINTS;
				}
				points.add(arrowScore);
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
	    return  (sumPoints/(NUMBER_OF_SHOTS*10))*100;
	}
}
