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
	
	static boolean isPrimeNumber = true;
	
	public Controller(int num, int numOfthreads) {
		Controller.number = num;
		this.threadsNum = numOfthreads;
		System.out.println("num:" + Controller.number + "    Threads" + this.threadsNum);
		num = (int) Math.sqrt(num);
		int gap = num/numOfthreads;
		System.out.println(gap);
		threads = new PrimeThreard[numOfthreads];
		int start = 2;
		for (int i=0 ; i<numOfthreads ; i++) {
			int end = start+gap;
			threads[i] = new PrimeThreard(i, start, end);
			System.out.println("Thread #" + (i+1) + " Created, from " + start + " to " + end);
			start = start+gap;
		}
		long startTime = System.currentTimeMillis();
		for (int i=0 ; i<numOfthreads ; i++) {
			threads[i].start();
			System.out.println("Thread #" + (i+1) + " Started.");
		}
		long elapsedTime = System.currentTimeMillis() - startTime;
		if (Controller.isPrimeNumber) {
			GUI.result.setText("YES!");
		}
		else GUI.result.setText("NO!");
		GUI.timeStamp.setText(elapsedTime + "ms");
		GUI.usedThreads.setText(this.threadsNum + "");	
	}
	

}


