import java.awt.*;
import javax.swing.*;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

/**
 * OOP2 - Exercise 6
 * Prime Number Calculation with Related threads
 * Name: Oz Avraham ID: 2030709867
 * Name: Aviram Boniel ID: 305509770
 */

/* Building the frame using Window Builder */
public class GUI extends JFrame {

	protected JPanel contentPane;
	protected static JTextField numInput;
	protected static JTextField threadInput;
	protected JButton btnCalc;
	protected JButton btnClear;

	public static JLabel result;
	public static JLabel timeStamp;
	public static JTextArea textArea;

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

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(6, 29, 438, 138);
		contentPane.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{208, 95, 115, 0};
		gbl_panel_1.rowHeights = new int[]{26, 32, 29, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		JLabel instruct1 = new JLabel("Enter the number you desire to check:");
		GridBagConstraints gbc_instruct1 = new GridBagConstraints();
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
		gbc_instruct2.gridwidth = 2;
		gbc_instruct2.anchor = GridBagConstraints.SOUTH;
		gbc_instruct2.insets = new Insets(0, 0, 5, 5);
		gbc_instruct2.gridx = 0;
		gbc_instruct2.gridy = 1;
		panel_1.add(instruct2, gbc_instruct2);

		threadInput = new JTextField();
		GridBagConstraints gbc_threadInput = new GridBagConstraints();
		gbc_threadInput.insets = new Insets(0, 0, 5, 0);
		gbc_threadInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_threadInput.gridx = 2;
		gbc_threadInput.gridy = 1;
		panel_1.add(threadInput, gbc_threadInput);
		threadInput.setColumns(10);

		this.btnClear = new JButton("Clear");
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.anchor = GridBagConstraints.NORTH;
		gbc_btnClear.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnClear.insets = new Insets(0, 0, 5, 5);
		gbc_btnClear.gridx = 0;
		gbc_btnClear.gridy = 2;
		panel_1.add(btnClear, gbc_btnClear);

		this.btnCalc = new JButton("CALCULATE!");
		GridBagConstraints gbc_btnCalc = new GridBagConstraints();
		gbc_btnCalc.insets = new Insets(0, 0, 5, 0);
		gbc_btnCalc.anchor = GridBagConstraints.NORTH;
		gbc_btnCalc.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCalc.gridwidth = 2;
		gbc_btnCalc.gridx = 1;
		gbc_btnCalc.gridy = 2;
		panel_1.add(btnCalc, gbc_btnCalc);

		JLabel answerLabel = new JLabel("Is it a Prime Number?");
		GridBagConstraints gbc_answerLabel = new GridBagConstraints();
		gbc_answerLabel.insets = new Insets(0, 0, 5, 5);
		gbc_answerLabel.gridx = 0;
		gbc_answerLabel.gridy = 3;
		panel_1.add(answerLabel, gbc_answerLabel);

		result = new JLabel("");
		GridBagConstraints gbc_result = new GridBagConstraints();
		gbc_result.insets = new Insets(0, 0, 5, 5);
		gbc_result.gridx = 1;
		gbc_result.gridy = 3;
		panel_1.add(result, gbc_result);

		JLabel timeLabel = new JLabel("Time Elapsed:");
		GridBagConstraints gbc_timeLabel = new GridBagConstraints();
		gbc_timeLabel.insets = new Insets(0, 0, 0, 5);
		gbc_timeLabel.gridx = 0;
		gbc_timeLabel.gridy = 4;
		panel_1.add(timeLabel, gbc_timeLabel);

		timeStamp = new JLabel("");
		GridBagConstraints gbc_timeStamp = new GridBagConstraints();
		gbc_timeStamp.insets = new Insets(0, 0, 0, 5);
		gbc_timeStamp.gridx = 1;
		gbc_timeStamp.gridy = 4;
		panel_1.add(timeStamp, gbc_timeStamp);

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(6, 169, 438, 86);

		/* Adding ScrollPane to the TextArea */
		textArea = new JTextArea();
		textArea.setBounds(6, 6, 426, 74);
		JScrollPane scroll = new JScrollPane(textArea);
		panel.add(scroll, BorderLayout.CENTER);
		contentPane.add(panel);

		JLabel lblPrimeNumbersCalculation = new JLabel("Prime Numbers Calculation");
		lblPrimeNumbersCalculation.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblPrimeNumbersCalculation.setBounds(143, 6, 218, 16);
		contentPane.add(lblPrimeNumbersCalculation);

		this.setVisible(true);
	}

	/* Adding Submit Listener to the calculation button */
	public void addSubmitListener(ActionListener event) {
		btnCalc.addActionListener(event);
	}

	/* Adding Clear Listener to the calculation button */
	public void addClearListener(ActionListener event) {
		btnClear.addActionListener(event);
	}

	/* Checking if some information is missing */
	public static boolean hasEmptyField() {
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

	/* Implement listener to the Calculation button */
	public static class SubmitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				GUI.textArea.setText("");
				int num = Integer.parseInt(numInput.getText());
				int threads = Integer.parseInt(threadInput.getText());
				Controller control = new Controller(num,threads);
			}
			/* Handel exceptions */
			catch (Exception exception) {
				String string = "";
				if (GUI.hasEmptyField()){
					string += "Missing Input!\n";
					if (numInput.getText().equals("")) string += "* Missing number\n";
					if (threadInput.getText().equals("")) string+= "* Missing threads number\n";
					JOptionPane.showMessageDialog(null, string);
				}
				else {
					string += "Invalid input!";
					JOptionPane.showMessageDialog(null, string);
				}
				exception.printStackTrace();
			}
		}
	}

	/* Implement listener to the Clear button */
	public static class ClearListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			numInput.setText("");
			threadInput.setText("");
			result.setText("");
			timeStamp.setText("");
			GUI.textArea.setText("");
		}
	}
}



