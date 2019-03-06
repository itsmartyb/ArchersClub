import java.util.Comparator;

public class ArcherYearsComparator implements Comparator<Archer> {

	@Override
	public int compare(Archer archer1, Archer archer2) {
		
		if(archer1.getExperience() == archer2.getExperience()) {
			return archer1.getName().compareTo(archer2.getName());
		}
		return archer1.getExperience() - archer2.getExperience();
	}
	

}
