import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class GUIDemo {
	private int c=0;
	private JFrame frame;
	private JTextField tfbase;
	private JTextField tfheight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIDemo window = new GUIDemo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lb1 = new JLabel("Hi");
		lb1.setHorizontalAlignment(SwingConstants.CENTER);
		lb1.setBounds(160, 0, 101, 71);
		frame.getContentPane().add(lb1);
		
		JButton btn1 = new JButton("Click here");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c++;
				if (c%2==1)
				{
					lb1.setText("Jason");
				}
				else
				{
					lb1.setText("Hi");
				}
				
				
			}
		});
		btn1.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btn1);
		
		JLabel lblEnterBase = new JLabel("Enter base");
		lblEnterBase.setBounds(67, 45, 83, 55);
		frame.getContentPane().add(lblEnterBase);
		
		JLabel lblEnterHeight = new JLabel("Enter height");
		lblEnterHeight.setBounds(287, 48, 101, 48);
		frame.getContentPane().add(lblEnterHeight);
		
		tfbase = new JTextField();
		tfbase.setBounds(48, 96, 86, 20);
		frame.getContentPane().add(tfbase);
		tfbase.setColumns(10);
		
		tfheight = new JTextField();
		tfheight.setBounds(274, 96, 86, 20);
		frame.getContentPane().add(tfheight);
		tfheight.setColumns(10);
		
		JLabel lbarea = new JLabel("");
		lbarea.setBounds(258, 190, 46, 14);
		frame.getContentPane().add(lbarea);
		
		JButton btnCalculateArea = new JButton("Calculate Area");
		btnCalculateArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int v=Integer.parseInt(tfbase.getText());
				int j=Integer.parseInt(tfheight.getText());
				Integer r=v*j;
				lbarea.setText(r.toString());
			}
		});
		btnCalculateArea.setBounds(174, 156, 89, 23);
		frame.getContentPane().add(btnCalculateArea);
	}
}
