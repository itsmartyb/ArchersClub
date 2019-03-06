
public abstract class Bow {
	private String producer;
	private int weight;
	private int tensileStrength;
	
	public Bow(String producer, int weight, int tensileStrength) {
		setProducer(producer);
		setWeight(weight);
		setTensileStrength(tensileStrength);
	}

	public String getProducer() {
		return this.producer;
	}

	public void setProducer(String producer) {
		if(producer != null && producer.trim().length() > 0) {
			this.producer = producer;
		} else {
			System.err.println("Invalid producer for bow");
		}
	}

	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int weight) {
		if(weight > 0) {
			this.weight = weight;
		} else {
			System.err.println("Invalid weight for bow");
		}
	}

	public int getTensileStrength() {
		return this.tensileStrength;
	}

	public void setTensileStrength(int tensileStrength) {
		if(tensileStrength > 0) {
			this.tensileStrength = tensileStrength;
		} else {
			System.err.println("Invalid tensile strength for bow");
		}
	}

	@Override
	public String toString() {
		return "bow: producer=" + producer + ", weight=" + weight + ", tensileStrength=" + tensileStrength;
	}
}
