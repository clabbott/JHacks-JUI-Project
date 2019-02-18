import java.util.ArrayList;

public class IDStuff {
	
	private long timeRight;
	private long timeLeft;
	private long timeUp;
	private long timeDown;
	private long q1Right;
	private long q3Right;
	private long q1Left;
	private long q3Left;
	private long q1Up;
	private long q3Up;
	private long q1Down;
	private long q3Down;
	//private ArrayList<Integer> keyPress;
	//private ArrayList<Long> timePressRight;
	//private ArrayList<Long> timePressLeft;
	//private ArrayList<Long> timePressUp;
	//private ArrayList<Long> timePressDown;
	
	//for existing users
	public IDStuff(long timeRight, long timeLeft, long timeUp, long timeDown) {
		this.timeRight = timeRight;
		this.timeLeft = timeLeft;
		this.timeUp = timeUp;
		this.timeDown = timeDown;
	}
	
	//saving in the server/create new user
	public IDStuff(Biometrics b) {
		
		/*this.keyPress = keyPress;
		this.timePressRight = timeRight; 
		this.timePressLeft = timeLeft;
		this.timePressUp = timeUp;
		this.timePressDown = timeDown;*/
		
		this.q1Right = getQ1(b.getTimePressedRight());
		this.q3Right = getQ3(b.getTimePressedRight());
		this.q1Left = getQ1(b.getTimePressedLeft());
		this.q3Left = getQ3(b.getTimePressedLeft());
		this.q1Up = getQ1(b.getTimePressedUp());
		this.q3Up = getQ3(b.getTimePressedUp());
		this.q1Down = getQ1(b.getTimePressedDown());
		this.q3Down = getQ3(b.getTimePressedDown());
	}
	
	public static long getMedium(ArrayList<Long> a) {
		int totalIndex = a.size();
		long med;
		if(totalIndex %2 == 0) {
			med = (a.get(totalIndex/2) + a.get(totalIndex/2+1))/2;
		}else {
			med = a.get(totalIndex/2);
		}
		return med;
	}
	
	public static long getQ1(ArrayList<Long> a) {
		int totalIndex = a.size();
		long q1;
		if(totalIndex %4 == 0 && totalIndex > 1) {
			q1 = (a.get(totalIndex/4) + a.get(totalIndex/4+1))/2;
		}else {
			q1 = a.get(totalIndex/4);
		}
		return q1;
	}
	
	public static long getQ3(ArrayList<Long> a) {
		int totalIndex = a.size();
		long q3;
		if(totalIndex %4 == 0 && totalIndex > 1) {
			q3 = (a.get(3*(totalIndex/4)) + a.get((3*(totalIndex/4)) + 1));
		}else {
			q3 = a.get(3*(totalIndex/4));
		}
		return q3;
	}
	
	/* This method compares two linked IDStuff objects, by looking at the current object, and seeing if the other object
	 * (which contains the biometrix needed to identify the person) and compares if they are within the alotted degrees
	 * of freedom to be off
	 * 
	 * @param IDStuff object, that contains the information you are trying
	 * @return true if is contained in the interval calculated, false if not contained in the intervals
	 */
	public boolean comparer(IDStuff other) {
		if(timeRight >= other.q1Right && timeRight <= other.q3Right 
				&& timeLeft >= other.q1Left && timeLeft <= other.q3Left
				&& timeUp >= other.q1Up && timeUp <= other.q3Up
				&& timeDown >= other.q1Down && timeDown <= other.q3Down) {
			return true;
		}else {
			return false;
		}
		
	}
	
}