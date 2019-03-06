import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Race extends Info{
	private static final int MAX_VALUE = 10;
	private String name;
	private Set<Archer> raceArchers;
	//category -> archer -> list of archer points
	private Map<String, Map<Archer, List<Integer>>> dictionary;
	

	public Race(String name, Set<Archer> archers) {
		super(name);
		setArchers(archers);
		this.dictionary = new HashMap<String, Map<Archer, List<Integer>>>();
	}
	
	public void printArchers() {
		System.out.println("All archer participants:");
		for(Iterator<Archer> it = this.raceArchers.iterator(); it.hasNext();) {
			it.next().increaseNumberOfRaces();
		}
		for(Archer archer : this.raceArchers) {
			System.out.println(archer);
		}
		System.out.println();
		
	}
	
	public void startRace() {
		for(Archer a: this.raceArchers) {
			if(this.dictionary.containsKey(a.getType())) {
				this.dictionary.get(a.getType()).put(a, new ArrayList<Integer>(a.makeShots()));
			} else {
				this.dictionary.put(a.getType(), new HashMap<Archer, List<Integer>>());
				this.dictionary.get(a.getType()).put(a, new ArrayList<Integer>(a.makeShots()));
			}
		}
	
		printAllPoints();
		printArchers();
		printAllWinners();
		avarageResult();
		mostAccurantInaccurantArcher();
		listAllWomen();
		listAllWithCarbonBows();
	}
	
	private int sumPoints(Archer archer) {
		
		int sumPoints = 0;
		for(Iterator<Integer> it = this.dictionary.get(archer.getType()).get(archer).iterator(); it.hasNext();) {
			sumPoints += it.next();
		}
		return sumPoints;
	}
	
	public void printAllPoints() {
		System.out.println("All archer points:");
		for(Entry<String, Map<Archer, List<Integer>>> e1 : this.dictionary.entrySet()) {
			System.out.println("Category: " + e1.getKey());
			for(Entry<Archer, List<Integer>> e2 : e1.getValue().entrySet()) {
				System.out.println(e2.getKey() + " ");
				int sum = sumPoints(e2.getKey());
				e2.getKey().setPercentAccurancy(sum);
				System.out.println(sum);
			}
		}
		System.out.println();
	}
	
	public void printAllWinners() {
		
		if(this.dictionary != null) {
			System.out.println("All winners by category:");
			for(Entry<String, Map<Archer, List<Integer>>> e1 : this.dictionary.entrySet()) {
				System.out.println(e1.getKey());
				int maxPoints = 0;
				String maxNamePoints = "";
				int sumPoints = 0;
				for(Entry<Archer, List<Integer>> e2 : e1.getValue().entrySet()) {
					for(Iterator<Integer> it = e2.getValue().iterator(); it.hasNext();) {
						sumPoints += it.next();
					}
					if(sumPoints > maxPoints) {
						maxPoints = sumPoints;
						maxNamePoints = e2.getKey().getName();
					}
					sumPoints = 0;
				}
				System.out.println("Best archer in category: " + maxNamePoints);
			}
			System.out.println();
		}
	}
	
	public void listAllWomen() {
		System.out.println("All women percent accurancy:");
		Set<Archer> womenArchers = new TreeSet<Archer>(new AccurancyComparator());
		for(Archer archer : this.raceArchers) {
			if(archer.isMale() == false) {
				womenArchers.add(archer);
			}	
		}
		for(Archer archer : womenArchers) {
			System.out.println(archer);
		}
		System.out.println();
	}
	
	public void avarageResult() {
		System.out.println("Avarage result by category:");
		if(this.dictionary != null) {
			for(Entry<String, Map<Archer, List<Integer>>> e1 : this.dictionary.entrySet()) {
				System.out.println(e1.getKey());
				int sum = 0;
				for(Entry<Archer, List<Integer>> e2 : e1.getValue().entrySet()) {
					for(Iterator<Integer> it = e2.getValue().iterator(); it.hasNext();) {
						sum += it.next();
					}
				}
				System.out.println("Avarage: " + sum / e1.getValue().size());
			}
			System.out.println();
		}
	}
	
	public void mostAccurantInaccurantArcher() {
		if(this.dictionary != null) {
			int maxCountTens = 0;
			String bestArcherName = "";
			int countTens = 0;
			int maxCountZeroes = 0;
			String worstArcherName = "";
			int countZeroes = 0;
			for(Entry<String, Map<Archer, List<Integer>>> e1 : this.dictionary.entrySet()) {
				for(Entry<Archer, List<Integer>> e2 : e1.getValue().entrySet()) {
					for(Integer point : e2.getValue()) {
						if(point == MAX_VALUE) {
							countTens++;
						}
						if(point == 0) { 
							countZeroes++;
						}
					}
					if(countTens > maxCountTens) {
						maxCountTens = countTens;
						bestArcherName = e2.getKey().getName();
					}
					if(countZeroes > maxCountZeroes) {
						maxCountZeroes = countZeroes;
						worstArcherName = e2.getKey().getName();
					}
					countTens = 0;
					countZeroes = 0;
				}
			}
			System.out.println("Most accurant archer: " + bestArcherName);
			System.out.println();
			System.out.println("Most inaccurant archer: " + worstArcherName);
			System.out.println();
		}
	}
	
	public void listAllWithCarbonBows() {
		System.out.println("All archers with carbon bows:");
		Set<Archer> carbonBowArchers = new TreeSet<Archer>(new ArcherYearsComparator());
		for(Archer archer : this.raceArchers) {
			if(archer.getBow() instanceof CarbonBow) {
				carbonBowArchers.add(archer);
			}
		}
		for(Archer archer : carbonBowArchers) {
			System.out.println(archer);
		}
		System.out.println();
	}
	    
		
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if(name != null && name.trim().length() > 0) {
			this.name = name;
		}
	}
	
	public Set<Archer> getArchers(){
		return this.raceArchers;
	}
	
	public void setArchers(Set<Archer> archers) {
		if(archers != null && archers.size() > 0) {
			this.raceArchers = new TreeSet<Archer>(new ArchersComparator());
			this.raceArchers.addAll(archers);
		}
	}
}
