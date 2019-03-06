import java.util.Comparator;

public class AccurancyComparator implements Comparator<Archer>{

	@Override
	public int compare(Archer archer1, Archer archer2) {
		
		if((archer1.getPercentAccurancy() - archer2.getPercentAccurancy()) == 0) {
			return archer1.getName().compareTo(archer2.getName());
		}
		return (int)(archer1.getPercentAccurancy() - archer2.getPercentAccurancy());
		
	}
}