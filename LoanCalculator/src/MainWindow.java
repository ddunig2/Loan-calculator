import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainWindow {

	private JFrame frmLoanCalculator;
	private JTextField txtAmount;
	private JPanel panel_1;
	private JTextField txtRate;
	private JPanel panel_2;
	private JTextField txtTY;
	private JPanel panel_3;
	private JTextField txtTM;
	private JLabel lblOutput;
	private JLabel lblLine;
	private JLabel lblPrincipleAmount;
	private JLabel lblTotalIntrest;
	private JLabel lblPa;
	private JLabel lblTi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmLoanCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoanCalculator = new JFrame();
		frmLoanCalculator.setTitle("Loan Calculator");
		frmLoanCalculator.setBounds(100, 100, 583, 423);
		frmLoanCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoanCalculator.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Loan Amount", TitledBorder.LEFT,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 24, 174, 61);
		frmLoanCalculator.getContentPane().add(panel);
		panel.setLayout(null);

		txtAmount = new JTextField();
		txtAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					if(c == KeyEvent.VK_PERIOD) {
						if(txtAmount.getText().contains(".")) {
							e.consume();
						}else {
							
						}
					}else {
						e.consume();
					}
					
				}
			}
		});
		txtAmount.setBounds(10, 21, 152, 27);
		panel.add(txtAmount);
		txtAmount.setColumns(10);

		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Intrest rate per year",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 96, 174, 61);
		frmLoanCalculator.getContentPane().add(panel_1);

		txtRate = new JTextField();
		txtRate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					if(c == KeyEvent.VK_PERIOD) {
						if(txtRate.getText().contains(".")) {
							e.consume();
						}else {
							
						}
					}else {
						e.consume();
					}
					
				}
			}
		});
		txtRate.setColumns(10);
		txtRate.setBounds(10, 21, 152, 27);
		panel_1.add(txtRate);

		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Loan term in years",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 168, 174, 61);
		frmLoanCalculator.getContentPane().add(panel_2);

		txtTY = new JTextField();
		txtTY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE && txtTY.getText().equals("")) {

				} else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					String month = (txtTY.getText());
					month = month.substring(0, month.length() - 1);
					if(!month.equals("")) {
						txtTM.setText(Double.parseDouble(month) * 12.0 + "");
					}
					else {
						txtTM.setText("");
					}
					
				} else {
					char c = e.getKeyChar();
					if(txtTY.getText().contains(".") && c=='.') {
						return;
					}
					if(Character.isDigit(c)) {
						String month = (txtTY.getText() + c);
						txtTM.setText(Double.parseDouble(month) * 12 + "");
					}
					
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					if(c == KeyEvent.VK_PERIOD) {
						if(txtTY.getText().contains(".")) {
							e.consume();
						}else {
							
						}
					}else {
						e.consume();
					}
					
				}
			}
		});
		txtTY.setColumns(10);
		txtTY.setBounds(10, 21, 152, 27);
		panel_2.add(txtTY);

		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Loan term in months",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 240, 174, 61);
		frmLoanCalculator.getContentPane().add(panel_3);

		txtTM = new JTextField();
		txtTM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE && txtTM.getText().equals("")) {

				} else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					String month = (txtTM.getText());
					month = month.substring(0, month.length() - 1);
					if(!month.equals("")) {
						txtTY.setText(Double.parseDouble(month) / 12.0 + "");
					}
					else {
						txtTY.setText("");
					}
					
				} else {
					char c = e.getKeyChar();
					if(txtTM.getText().contains(".") && c=='.') {
						return;
					}
					if(Character.isDigit(c)) {
						String month = (txtTM.getText() + c);
						txtTY.setText(Double.parseDouble(month) / 12 + "");
					}
					
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					if(c == KeyEvent.VK_PERIOD) {
						if(txtTY.getText().contains(".")) {
							e.consume();
						}else {
							
						}
					}else {
						e.consume();
					}
				}
			}
		});
		txtTM.setColumns(10);
		txtTM.setBounds(10, 21, 152, 27);
		panel_3.add(txtTM);

		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread t1 = new Thread(new Runnable() {
					@Override
					public void run() {
						if(txtAmount.equals("")) {
							return;
						}
						if(txtRate.equals("")) {
							return;
						}
						if(txtRate.equals("") && txtRate.equals("")) {
							return;
						}
						double p = Double.parseDouble(txtAmount.getText());
						double rt = Double.parseDouble(txtRate.getText());
						double n = Double.parseDouble(txtTM.getText());
						double monthlyP = calculation(p, rt, n);
						double interest = Math.round(((monthlyP*n) - p)*100.00)/100.00;
						pretyPrint(monthlyP,p,interest);
					}
				});
				t1.start();

			}
		});
		btnNewButton.setBounds(10, 312, 174, 35);
		frmLoanCalculator.getContentPane().add(btnNewButton);

		JLabel lblOr = new JLabel("> OR");
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOr.setBounds(194, 218, 46, 35);
		frmLoanCalculator.getContentPane().add(lblOr);

		lblOutput = new JLabel("");
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblOutput.setBounds(276, 24, 246, 71);
		frmLoanCalculator.getContentPane().add(lblOutput);

		lblLine = new JLabel();
		lblLine.setBounds(276, 96, 246, 14);
		frmLoanCalculator.getContentPane().add(lblLine);
		
		lblPrincipleAmount = new JLabel("Principle Amount: ");
		lblPrincipleAmount.setBounds(276, 121, 117, 36);
		frmLoanCalculator.getContentPane().add(lblPrincipleAmount);
		
		lblTotalIntrest = new JLabel("Total interest:");
		lblTotalIntrest.setBounds(276, 182, 117, 36);
		frmLoanCalculator.getContentPane().add(lblTotalIntrest);
		
		lblPa = new JLabel();
		lblPa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPa.setBounds(403, 121, 119, 36);
		frmLoanCalculator.getContentPane().add(lblPa);
		
		lblTi = new JLabel();
		lblTi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTi.setBounds(403, 182, 119, 36);
		frmLoanCalculator.getContentPane().add(lblTi);
	}

	public void pretyPrint(double price, double principalD, double interestD) {
		String priceS = "$ " + price;
		String principal = "$ " + principalD;
		String interest = "$ " + interestD;
		lblPa.setText("");
		lblTi.setText("");
		lblLine.setText("");
		lblOutput.setText("");
		for (int i = 0; i < priceS.length(); i++) {
			lblOutput.setText(lblOutput.getText() + priceS.substring(i, i + 1));
			pause(50);
		}
		String line = "__________Monthly payment__________";
		for (int i = 0; i < line.length(); i++) {
			lblLine.setText(lblLine.getText() + line.substring(i, i+1));
			pause(10);
		}
		for (int i = 0; i < principal.length(); i++) {
			lblPa.setText(lblPa.getText() + principal.substring(i, i+1));
			pause(10);
		}
		for (int i = 0; i < interest.length(); i++) {
			lblTi.setText(lblTi.getText() + interest.substring(i, i+1));
			pause(10);
		}
		
	}

	public double calculation(double p, double rt, double n) {
		double r = (rt/100)/12;
		double a = (p*(r*(Math.pow((1+r), n))))/(Math.pow((1+r), n) - 1);
		return Math.round(a*100)/100.00;
	}

	public void pause(int millis) {
		try {
			Thread.sleep(millis);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
