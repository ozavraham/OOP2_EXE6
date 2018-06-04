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
			if (Controller.number%i == 0) {
				Controller.isPrimeNumber = false;
				System.out.println("Thread #" + (this.id+1) + " found " + Controller.number + " is divided with " + i + " without rest!");
				GUI.textArea.append("Thread #" + (this.id+1) + " found " + Controller.number + " is divided with " + i + " without rest!\n");
			}
		} 
		System.out.println("Thread #" + (this.id+1) + " finished.");
		GUI.textArea.append("Thread #" + (this.id +1) + " finished.\n");
	}
	
	public String toString() {
		return "Thread #" + this.id + "Started at " +  this.start + " to " + this.end + "\n";
	}
}
