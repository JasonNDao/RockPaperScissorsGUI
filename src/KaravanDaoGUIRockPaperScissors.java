//Luke Karavan and Jason Dao Mod 7 AP Computer Science
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.Font;



public class KaravanDaoGUIRockPaperScissors {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KaravanDaoGUIRockPaperScissors window = new KaravanDaoGUIRockPaperScissors();
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
	int wins,losses,ties,playerPick,computerPick;                  //Instance Variables
	public KaravanDaoGUIRockPaperScissors() {                      //Initialize Values
		initialize();
		wins=0;
		losses=0;
		ties=0;
		playerPick=0;
		computerPick=0;
	}
	public void setPlayer(int p)									//Sends input from user to main
	{
		playerPick=p;
	}
	private String convert(int x)                                   //Converts random number to what Computer chooses
	{
		computerPick=x;
		if (computerPick==1)
		{
			return "The computer chose paper.";
		}
		else if (computerPick==2)
		{
			return "The computer chose rock.";
		}
		else 
		{
			return "The computer chose scissors.";
		}
	}
	public String getComp()											//Sets and prints out Computer's choice
	{
		int s=(int)(Math.random()*3)+1;
		return convert(s);
	}
	public String determineWinner()                                //Compares Player's and Computer's choice to choose winner
	{
		if (playerPick == computerPick)
		{
			ties++;
			return "The player chose the same as the computer.";
		} 
		else if ((playerPick == 2 && computerPick==1) || (playerPick==1 && computerPick==3) || (playerPick==3 && computerPick==2))
		{
			losses++;
			return "Computer wins this round.";
		}
		else
		{
			wins++;
			return "Player wins this round.";
		}
	}
	public String Stats()											//Prints out Player's win-loss-tie record
	{
		return "Wins: " + wins + "      " + "Losses: " + losses + "\t"+ "      " + "Ties: " + ties;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 462, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNkkn = new JLabel("");
		lblNkkn.setBounds(193, 56, 46, 14);
		frame.getContentPane().add(lblNkkn);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Rock");
		rdbtnNewRadioButton.setBounds(153, 73, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
	
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Paper");
		rdbtnNewRadioButton_1.setBounds(153, 99, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Scissors");
		rdbtnNewRadioButton_2.setBounds(153, 127, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JLabel lblChooseRockPaper = new JLabel("Choose rock, paper, scissors, or quit");
		lblChooseRockPaper.setBounds(70, 23, 267, 48);
		lblChooseRockPaper.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblChooseRockPaper);
		
		JRadioButton rdbtnQuit = new JRadioButton("Quit");
		rdbtnQuit.setBounds(152, 156, 109, 23);
		frame.getContentPane().add(rdbtnQuit);
		
		JLabel lblabel1 = new JLabel("");
		lblabel1.setBounds(35, 221, 363, 23);
		lblabel1.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblabel1);
		
		JLabel lblabel2 = new JLabel("");
		lblabel2.setBounds(35, 243, 373, 23);
		lblabel2.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblabel2);
		
		JLabel lblabel3 = new JLabel("");
		lblabel3.setBounds(22, 265, 386, 23);
		lblabel3.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblabel3);
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnQuit);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(137, 185, 102, 23);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {					
							int number=0;
						     //Input
							String j=getComp();			                              //gets computer's choice
							if(rdbtnNewRadioButton.isSelected())                      //if rock is chosen
							{
								number=2;
								setPlayer(number);                                    //sends choice to methods
								String l=determineWinner();                           //gets winner
								String x="The player chose rock.";
								lblabel1.setText(x);                                  //displays player's choice
								lblabel2.setText(j);                                  //displays computer's choice
								lblabel3.setText(l);                                  //determines winner
							}
							else if(rdbtnNewRadioButton_1.isSelected())               //if paper is chosen
							{
								number=1;
								setPlayer(number);                                    //sends choice to methods
								String l=determineWinner();                           //gets winner
								lblabel1.setText("The player chose paper.");          //displays player's choice
								lblabel2.setText(j);                                  //displays computer's choice
								lblabel3.setText(l);                                  //determines winner
							}
							else if(rdbtnNewRadioButton_2.isSelected())               //if scissors is chosen
							{	
								number=3;
								setPlayer(number);                                    //sends choice to methods
								String l=determineWinner();                           //gets winner
								lblabel1.setText("The player chose scissors.");       //displays player's choice     
								lblabel2.setText(j);                                  //displays computer's choice
								lblabel3.setText(l);                                  //determines winner
							}
							else if (rdbtnQuit.isSelected())																				
							{
								String r=Stats();	                                   //gets win-loss-tie
								lblabel1.setText(r);                                   //displays records
								lblabel2.setText("");
								lblabel3.setText("");
								btnPlay.setEnabled(false);                             //stops player from playing
							}		
							group.clearSelection();                                    //clears choice
		}				
		});
		frame.getContentPane().add(btnPlay);	
		
		JLabel lblRockPaperScissors = new JLabel("Rock, Paper, Scissors Game");
		lblRockPaperScissors.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		lblRockPaperScissors.setBounds(35, 11, 328, 32);
		lblRockPaperScissors.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblRockPaperScissors);
		}
	}

