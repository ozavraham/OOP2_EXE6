import javax.swing.JOptionPane;

/**
 * @author ozavraham
 *
 */
public class Controller {
	
	protected GUI gui;
	protected static int number;
	protected int threadsNum;
	protected PrimeThreard[] threads;
	public static boolean isPrimeNumber;
	
	public Controller(int num, int numOfthreads) {
		GUI.textArea.append("Strting Calculation...\n");
		Controller.isPrimeNumber = true;
		Controller.number = num;
		this.threadsNum = numOfthreads;
		num = (int) Math.sqrt(num);
		int gap = num/numOfthreads;
		threads = new PrimeThreard[numOfthreads];
		int start = 2;
		for (int i=0 ; i<numOfthreads ; i++) {
			int end = start+gap;
			threads[i] = new PrimeThreard(i, start, end);
			System.out.println("Thread #" + (i+1) + " Created, from " + start + " to " + end);
			GUI.textArea.append("Thread #" + (i+1) + " Created, from " + start + " to " + end + ".\n");
			start = start+gap;
		}
		long startTime = System.currentTimeMillis();
		for (int i=0 ; i<numOfthreads ; i++) {
			threads[i].start();
			System.out.println("Thread #" + (i+1) + " Started.");
			GUI.textArea.append("Thread #" + (i+1) + " Started.\n");
		}
		for (int i=0 ; i<numOfthreads ; i++) {
			try {
				threads[i].join();
			}
			catch (InterruptedException e) {				
			}
		}
		long elapsedTime = System.currentTimeMillis() - startTime;
		if (Controller.isPrimeNumber) {
			GUI.result.setText("YES!");
		}
		else GUI.result.setText("NO!");
		GUI.timeStamp.setText(elapsedTime + "ms");
		GUI.textArea.append("Finished calculation in " + elapsedTime + " ms.");
		GUI.textArea.append("Enter new number to calculate.");
		Controller.isPrimeNumber = true;
	}
}


