import java.util.ArrayList;

public class Biometrics {
	private ArrayList<Integer> keyPresses;
	private ArrayList<Long> timePressedLeft;
	private ArrayList<Long> timePressedRight;
	private ArrayList<Long> timePressedUp;
	private ArrayList<Long> timePressedDown;
	private long startTime;
	private long endTime;
	private boolean isSuccess;

	public Biometrics() {

	}

	public Biometrics(ArrayList<Integer> keyPresses, ArrayList<Long> left, ArrayList<Long> right, ArrayList<Long> up, ArrayList<Long> down, long startTime, long endTime, boolean isSuccess) {
		this.keyPresses = keyPresses;
		timePressedLeft = left;
		timePressedRight = right;
		timePressedUp = up;
		timePressedDown = down;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isSuccess = isSuccess;
	}

	public ArrayList<Integer> getKeyPresses() {
		return keyPresses;
	}
	public ArrayList<Long> getTimePressedRight() {
		return timePressedRight;
	}
	public ArrayList<Long> getTimePressedLeft() {
		return timePressedLeft;
	}
	public ArrayList<Long> getTimePressedUp() {
		return timePressedUp;
	}
	public ArrayList<Long> getTimePressedDown() {
		return timePressedDown;
	}
	public long getTotalTime() {
		return endTime - startTime;
	}
	public String toString() {
		String result = "";
		String left = new String("Left: ");
		for(Long l: timePressedLeft) {
			left += l + ", ";
		}
		String right = new String("Right: ");
		for(Long l: timePressedRight) {
			right += l + ", ";
		}
		String up = new String("Up: ");
		for(Long l: timePressedUp) {
			up += l + ", ";
		}
		String down = new String("Down: ");
		for(Long l: timePressedDown) {
			down += l + ", ";
		}
		if(isSuccess == true) {
			String time = new String("Time taken to get the apple: " + this.getTotalTime() + " nanoseconds, or " + (this.getTotalTime()/1000000000) + " seconds");
			result = left + "\n" + right + "\n" + up + "\n" + down + "\n" + time;
		}
		else if(isSuccess == false) {
			String time = new String("Time played: " + this.getTotalTime() + " nanoseconds, or " + (this.getTotalTime()/1000000000) + " seconds");
			result = left + "\n" + right + "\n" + up + "\n" + down + "\n" + time;
		}
		return result;
	}
}
