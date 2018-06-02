import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * 
 */

/**
 * @author ozavraham
 *
 */
public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
		
		JLabel lblIsItA = new JLabel("Is it a Prime Number?");
		lblIsItA.setBounds(17, 6, 165, 16);
		panel.add(lblIsItA);
		
		JLabel timeLabel = new JLabel("Time Elapsed:");
		timeLabel.setBounds(17, 33, 87, 16);
		panel.add(timeLabel);
		
		JLabel threadsLabel = new JLabel("Threads used:");
		threadsLabel.setBounds(17, 61, 88, 16);
		panel.add(threadsLabel);
		
		JLabel result = new JLabel("result");
		result.setBounds(201, 6, 202, 16);
		panel.add(result);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(201, 33, 61, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(201, 61, 61, 16);
		panel.add(lblNewLabel_3);
		
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
		
		JLabel lblNewLabel = new JLabel("Enter a natural number to find the prime factors:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.NORTH;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 0;
		panel_1.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel numOfThreads = new JLabel("Enter number of threads to use:");
		GridBagConstraints gbc_numOfThreads = new GridBagConstraints();
		gbc_numOfThreads.anchor = GridBagConstraints.SOUTHEAST;
		gbc_numOfThreads.insets = new Insets(0, 0, 5, 5);
		gbc_numOfThreads.gridx = 0;
		gbc_numOfThreads.gridy = 1;
		panel_1.add(numOfThreads, gbc_numOfThreads);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.anchor = GridBagConstraints.NORTH;
		gbc_btnClear.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnClear.insets = new Insets(0, 0, 0, 5);
		gbc_btnClear.gridx = 0;
		gbc_btnClear.gridy = 2;
		panel_1.add(btnClear, gbc_btnClear);
		
		JButton btnNewButton = new JButton("CALCULATE!");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		panel_1.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblPrimeNumbersCalculation = new JLabel("Prime Numbers Calculation");
		lblPrimeNumbersCalculation.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblPrimeNumbersCalculation.setBounds(143, 6, 218, 16);
		contentPane.add(lblPrimeNumbersCalculation);
		
		this.setVisible(true);
	}
}
