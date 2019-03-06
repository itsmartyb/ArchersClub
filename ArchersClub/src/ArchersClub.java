import java.util.Set;
import java.util.TreeSet;
public class ArchersClub {
	
	public static void main(String[] args) {
		
		Archer a1 = new YoungArcher("Nevi", false, 19, new WoodenBow("Husqvarna", 100, 24), 2, 14);
		Archer a2 = new OldArcher("Geri", false, 32, new AluminiumBow("Stihl", 120, 33), 5, 21);
		Archer a3 = new VeteranArcher("Silviya", false, 28, new CarbonBow("Ferrari", 70, 41), 13, 44);
		
		Archer a4 = new YoungArcher("Annie", false, 20, new WoodenBow("Samsung", 69, 21), 1, 8);
		Archer a5 = new OldArcher("Petya", false, 34, new CarbonBow("Asus", 110, 43), 6, 29);
		Archer a6 = new VeteranArcher("Mimi", false, 17, new CarbonBow("LG", 90, 45), 17, 40);
		
		Archer a7 = new YoungArcher("Gosho", true, 39, new WoodenBow("Mitsubishi", 120, 21), 2, 23);
		Archer a8 = new OldArcher("Misho", true, 26, new AluminiumBow("Fujitsu", 45, 33), 6, 41);
		Archer a9 = new VeteranArcher("Ivanka", false, 22, new CarbonBow("Yamaha", 37, 47), 12, 53);
		
		Archer a10 = new YoungArcher("Pesho", true, 24, new WoodenBow("BMW", 55, 24), 1, 11);
		Archer a11 = new OldArcher("Viktoriya", false, 30, new AluminiumBow("Ikarus", 76, 34), 5, 24);
		Archer a12 = new VeteranArcher("Tisho", true, 44, new CarbonBow("Honda", 28, 45), 12, 58);
		
		
		
		
		Set<Archer> archers = new TreeSet<Archer>(new ArchersComparator());
		archers.add(a1);
		archers.add(a2);
		archers.add(a3);
		archers.add(a4);
		archers.add(a5);
		archers.add(a6);
		archers.add(a7);
		archers.add(a8);
		archers.add(a9);
		archers.add(a10);
		archers.add(a11);
		archers.add(a12);
		

		Club club = new Club("IT Talents", "Bul. Bulgaria", "Niki", archers);
		club.startTournament();
	}
}
