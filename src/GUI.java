import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */

/**
 * @author ozavraham
 *
 */
public class GUI extends JFrame {

	protected JPanel contentPane;
	
	protected static JTextField numInput;
	protected static JTextField threadInput;
	
	protected JButton btnCalc;
	protected JButton btnClear;
	
	public static JLabel result;
	public static JLabel timeStamp;
	public static JLabel usedThreads;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.addClearListener(new ClearListener());
					frame.addSubmitListener(new SubmitListener());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAllRightsRecived = new JLabel("All rights reserved to Oz & Aviram Ⓒ");
		lblAllRightsRecived.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblAllRightsRecived.setBounds(143, 257, 151, 16);
		contentPane.add(lblAllRightsRecived);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(6, 148, 438, 98);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel answerLabel = new JLabel("Is it a Prime Number?");
		answerLabel.setBounds(17, 6, 165, 16);
		panel.add(answerLabel);

		JLabel timeLabel = new JLabel("Time Elapsed:");
		timeLabel.setBounds(17, 33, 87, 16);
		panel.add(timeLabel);

		JLabel threadsLabel = new JLabel("Threads used:");
		threadsLabel.setBounds(17, 61, 88, 16);
		panel.add(threadsLabel);

		result = new JLabel("");
		result.setBounds(201, 6, 202, 16);
		panel.add(result);

		timeStamp = new JLabel("New label");
		timeStamp.setBounds(201, 33, 61, 16);
		panel.add(timeStamp);

		usedThreads = new JLabel("New label");
		usedThreads.setBounds(201, 61, 61, 16);
		panel.add(usedThreads);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(6, 29, 438, 107);
		contentPane.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{208, 95, 115, 0};
		gbl_panel_1.rowHeights = new int[]{26, 32, 29, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		JLabel instruct1 = new JLabel("Enter a natural number to find the prime factors:");
		GridBagConstraints gbc_instruct1 = new GridBagConstraints();
		gbc_instruct1.fill = GridBagConstraints.HORIZONTAL;
		gbc_instruct1.insets = new Insets(0, 0, 5, 5);
		gbc_instruct1.gridwidth = 2;
		gbc_instruct1.gridx = 0;
		gbc_instruct1.gridy = 0;
		panel_1.add(instruct1, gbc_instruct1);

		numInput = new JTextField();
		GridBagConstraints gbc_numInput = new GridBagConstraints();
		gbc_numInput.anchor = GridBagConstraints.NORTH;
		gbc_numInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_numInput.insets = new Insets(0, 0, 5, 0);
		gbc_numInput.gridx = 2;
		gbc_numInput.gridy = 0;
		panel_1.add(numInput, gbc_numInput);
		numInput.setColumns(10);

		JLabel instruct2 = new JLabel("Enter number of threads to use:");
		GridBagConstraints gbc_instruct2 = new GridBagConstraints();
		gbc_instruct2.anchor = GridBagConstraints.SOUTHEAST;
		gbc_instruct2.insets = new Insets(0, 0, 5, 5);
		gbc_instruct2.gridx = 0;
		gbc_instruct2.gridy = 1;
		panel_1.add(instruct2, gbc_instruct2);

		threadInput = new JTextField();
		GridBagConstraints gbc_threadInput = new GridBagConstraints();
		gbc_threadInput.insets = new Insets(0, 0, 5, 5);
		gbc_threadInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_threadInput.gridx = 2;
		gbc_threadInput.gridy = 1;
		panel_1.add(threadInput, gbc_threadInput);
		threadInput.setColumns(10);

		this.btnClear = new JButton("Clear");
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.anchor = GridBagConstraints.NORTH;
		gbc_btnClear.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnClear.insets = new Insets(0, 0, 0, 5);
		gbc_btnClear.gridx = 0;
		gbc_btnClear.gridy = 2;
		panel_1.add(btnClear, gbc_btnClear);

		this.btnCalc = new JButton("CALCULATE!");
		GridBagConstraints gbc_btnCalc = new GridBagConstraints();
		gbc_btnCalc.anchor = GridBagConstraints.NORTH;
		gbc_btnCalc.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCalc.gridwidth = 2;
		gbc_btnCalc.gridx = 1;
		gbc_btnCalc.gridy = 2;
		panel_1.add(btnCalc, gbc_btnCalc);

		JLabel lblPrimeNumbersCalculation = new JLabel("Prime Numbers Calculation");
		lblPrimeNumbersCalculation.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblPrimeNumbersCalculation.setBounds(143, 6, 218, 16);
		contentPane.add(lblPrimeNumbersCalculation);

		this.setVisible(true);

	}

	public void addSubmitListener(ActionListener event) {
		btnCalc.addActionListener(event);
	}

	public void addClearListener(ActionListener event) {
		btnClear.addActionListener(event);
	}
	
	/* Need to implement */
	public boolean hasEmptyField() {
		boolean hasEmptyField = false;
		if (numInput.getText().equals("") || threadInput.getText().equals("")) hasEmptyField = true;
		return hasEmptyField;
		
	}
	
	public JTextField getInput() {
		return GUI.numInput;
	}
	
	public JTextField getThreadsInput() {
		return GUI.threadInput;
	}
	
	public static class SubmitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int num = Integer.parseInt(numInput.getText());
				int threads = Integer.parseInt(threadInput.getText());
				Controller control = new Controller(num,threads);
			}
			catch (Exception exception) {
				String string = "";
				if (numInput.getText().equals("") || threadInput.getText().equals("")){
					string += "\"Missing Input!\\n\";";
					if (numInput.getText().equals("")) string += "* Missing number\n";
					if (threadInput.getText().equals("")) string+= "* Missing threads number\n";
				}
				else {
					string += "Invalid input!";
				}
				exception.printStackTrace();
			}
		}
	}
	
	public static class ClearListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			numInput.setText("");
			threadInput.setText("");
		}
	}
}



