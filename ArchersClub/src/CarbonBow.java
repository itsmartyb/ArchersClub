
public class CarbonBow extends Bow {

	private static final int MAX_TENSILE_STRENGTH = 48;
	private static final int MIN_TENSILE_STRENGTH = 28;

	public CarbonBow(String producer, int weight, int tensileStrength) {
		super(producer, weight, tensileStrength);

	}
	
	@Override
	public void setTensileStrength(int tensileStrength) {
		if(tensileStrength >= MIN_TENSILE_STRENGTH && tensileStrength <= MAX_TENSILE_STRENGTH) {
			super.setTensileStrength(tensileStrength);
		} else {
			System.err.println("Invalid tensile strength for carbon bow");
		}
	}
	
	@Override
	public String toString() {
		
		return "Carbon " + super.toString();
	}

}
