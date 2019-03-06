
public abstract class Info {
	private String name;

	public Info(String name) {
		setName(name);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if(name != null && name.trim().length() > 0) {
			this.name = name;
		} else {
			System.err.println("Invalid name!");
		}
  }

	@Override
	public String toString() {
		return "name=" + name;
	}

}
