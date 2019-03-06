//import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Club extends Info {
	private String address;
	private String trainer;
	private Set<Archer> archers;
	
	public Club(String name, String address, String trainer, Set<Archer> archers) {
		super(name);
		setAddress(address);
		setTrainer(trainer);
		setArchers(archers);	
	}

	public void startTournament() {
		Race race = new Race("IT Talents", archers);
		race.startRace();
	}
	
	public String getAddress() {
		return this.address;
	}

	private void setAddress(String address) {
		if(address != null && address.trim().length() > 0) {
			this.address = address;
		} else {
			System.err.println("Invalid address for club");
		}
	}

//	public Set<Archer> getArchers() {
//		return Collections.unmodifiableSet(this.archers);
//	}

	public String getTrainer() {
		return this.trainer;
	}

	private void setTrainer(String trainer) {
		if(trainer != null && trainer.trim().length() > 0) {
			this.trainer = trainer;
		} else {
			System.err.println("Invalid trainer for club");
		}
	}

	private void setArchers(Set<Archer> archers) {
		if(archers != null && archers.size() > 0) {
			this.archers = new TreeSet<Archer>(new ArchersComparator());
			this.archers.addAll(archers);
		} 
	}
}
