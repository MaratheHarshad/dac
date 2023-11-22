package pojos;

public enum Course {
	DAC(1,80), DBDA(2,85), DITISS(3,76);
	
	private int id;
	private int minMarks;

	private Course(int id,int minMarks) {
		//super(name(),ordinal());
		this.id = id;
		this.minMarks = minMarks;
	}
	
	public int getId() {
		return id;
	}

	public int getMinMarks() {
		return minMarks;
	}
	
	
}
