/**
 * 
 */

/**
 * @author ozavraham
 *
 */
public class PrimeThreard extends Thread{

	int id;
	int start;
	int end;
	String answer;
	
	public PrimeThreard(int id, int start, int end) {
		this.id = id;
		this.start = start;
		this.end = end;
	}
	
	/* Code here */
	public void run() {	
		for (int i=start ; i<end ; i++) {
			if (Controller.number%i == 0) Controller.isPrimeNumber = false;
		} 
	}
	
	public String toString() {
		return "Thread #" + this.id + "Started at " +  this.start + " to " + this.end + "\n";
	}
}
