
public class WoodenBow extends Bow {

	private static final int MAX_TENSILE_STRENGTH = 30;
	private static final int MIN_TENSILE_STENGTH = 20;

	public WoodenBow(String producer, int weight, int tensileStrength) {
		super(producer, weight, tensileStrength);
	}
	
	@Override
	public void setTensileStrength(int tensileStrength) {
		if(tensileStrength >= MIN_TENSILE_STENGTH && tensileStrength <= MAX_TENSILE_STRENGTH) {
			super.setTensileStrength(tensileStrength);
			
		} else {
			System.err.println("Invalid strength for wooden bow!");
		}
	}

	@Override
	public String toString() {
		return "Wooden " + super.toString();
	}
}
