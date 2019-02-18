import java.util.ArrayList;

public class IDStuff {
	
	private long average;
	private long q1;
	private long q3;
	
	public long getQ1() {
		return q1;
	}
	
	public long getAverage() {
		return average;
	}

	public long getQ3() {
		return q3;
	}
	
	public boolean compaerer(IDStuff other) {
		if(average >= other.q1 && average <= other.q3) {
			return true;
		}
		else {
			return false;
		}
	}
}
