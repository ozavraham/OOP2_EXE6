/**
 * PrimeThreard 
 * The thread that excute the calculation
 *
 */
public class PrimeThreard extends Thread{

	int id;
	int start;
	int end;
	String answer;
	
	/* Constructor */
	public PrimeThreard(int id, int start, int end) {
		this.id = id;
		this.start = start;
		this.end = end;
	}
	
	/* run() Method
	 * Loop from the start to the end
	 * if at any point the number is divided without rest, its not a prime number
	 *  */
	public void run() {	
		for (int i=start ; i<end ; i++) {
			if (Controller.number%i == 0) {
				Controller.isPrimeNumber = false;
				System.out.println("Thread #" + (this.id+1) + " found " + Controller.number + " is divided with " + i + " without rest!");
				Main.textArea.append("Thread #" + (this.id+1) + " found " + Controller.number + " is divided with " + i + " without rest!\n");
			}
		} 
		System.out.println("Thread #" + (this.id+1) + " finished.");
		Main.textArea.append("Thread #" + (this.id +1) + " finished.\n");
	}
	
	/* toString() Method */ 
	public String toString() {
		return "Thread #" + this.id + "Started at " +  this.start + " to " + this.end + "\n";
	}
}
