
public class AluminiumBow extends Bow {

	private static final int MAX_TENSILE_STRENGTH = 40;
	private static final int MIN_TENSILE_STRENGTH = 25;

	public AluminiumBow(String producer, int weight, int tensileStrength) {
		super(producer, weight, tensileStrength);
		
	}
	
	@Override
	public void setTensileStrength(int tensileStrength) {
		if(tensileStrength >= MIN_TENSILE_STRENGTH && tensileStrength <= MAX_TENSILE_STRENGTH) {
			super.setTensileStrength(tensileStrength);
		} else {
			System.err.println("Invalid tensile strength for aluminium bow");
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Aluminium " + super.toString();
	}

}
