import java.util.Comparator;

public class ArchersComparator implements Comparator<Archer> {
	@Override
	public int compare(Archer archer1, Archer archer2) {
		
		if(!archer1.getName().equals(archer2.getName())) {
			
			return archer1.getName().compareTo(archer2.getName());
		} else {
			return archer1.getAge() - archer2.getAge();
		}
	}
}
