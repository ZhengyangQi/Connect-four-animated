/*
 * hw4
 * Name: Zhengyang Qi
 * SID: 204296544
 */
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
 * Class generates human vs ai and ai vs ai GUIs
 */
public class GUICF extends CFGame  {
	// Paramters
	private String  result = "";
	private JFrame frame;
	private JLabel[][] slots;
	public JButton[] buttons;
	
	/*
	 * Constructor sets up and starts a human vs. AI game, where the red player (the player who goes first) 
	 * is randomly decided.
	 */
	public GUICF (CFAI ai){	
		// Generate frame and buttons
		frame = new JFrame("Connect Four");
		 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        Container panel = frame.getContentPane();	        
	        panel.setLayout(new GridLayout(7,7));        
	        slots = new JLabel[7][6];
	        buttons = new JButton[7];
	        
	        // Create buttons
	        for (int i = 0; i < 7; ++i){
	        	buttons[i] = new JButton("" + (i+1));
	        	// Add your listener
	        	buttons[i].addActionListener(new humanPlayListener(i+1,ai));
	        	panel.add(buttons[i]);  	
	        }
	        
	        // Create slots
	        for (int column = 0; column < 6; column++) {
	            for (int row = 0; row < 7; row++) {
	                slots[row][column] = new JLabel();
	                slots[row][column].setHorizontalAlignment(SwingConstants.CENTER);
	                slots[row][column].setBorder(new javax.swing.border.LineBorder(Color.black));
	                panel.add(slots[row][column]);
	            }
	        }
	        
	        frame.setSize(700,600);
	        frame.setVisible(true);
	        
	        // Random assign orders
	        java.util.Random rand = new java.util.Random();
	        int randomNum = rand.nextInt(2);
	        if(randomNum == 1){
				while(!(super.play(ai.nextMove(this)))){}
				updateBoard();
	        }

	}
	
	/*
	 * Constructor with two inputs to sets up and starts a AI vs. AI game, where the red player (the player who goes first)
	 *  is randomly decided.
	 */
	public GUICF(CFAI ai1, CFAI ai2){
		// Generate frame and buttons and Arraylist for players
		ArrayList<CFAI> players = new ArrayList<CFAI>();
		players.add(ai1);
		players.add(ai2);
		java.util.Collections.shuffle(players);	
		
		frame = new JFrame("Connect Four");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	    JPanel panel1 = new JPanel();
	    JPanel panel2 = new JPanel();
	    panel2.setLayout(new GridLayout(6,7));        
        slots = new JLabel[7][6];
	    frame.getContentPane().add(panel1, BorderLayout.NORTH);
	    frame.getContentPane().add(panel2, BorderLayout.CENTER);

	    // Create Button
	    JButton next = new JButton("next");
	    next.addActionListener(new aiPlayerListener(players.get(0),players.get(1)));
	    panel1.add(next, BorderLayout.CENTER); 
	    
	    // Create slots
	    for (int column = 0; column < 6; column++) {
            for (int row = 0; row < 7; row++) {
                slots[row][column] = new JLabel();
                slots[row][column].setHorizontalAlignment(SwingConstants.CENTER);
                slots[row][column].setBorder(new javax.swing.border.LineBorder(Color.black));
                panel2.add(slots[row][column]);
            }
        }
        
        frame.setSize(700, 600);
		frame.setVisible(true);
		
		
	}
	
	/*
	 * ActionListener for human vs ai constructor
	 */
	private class humanPlayListener implements ActionListener{
		private int col;
		private CFAI ai;
		
		/*
		 * Constructor
		 */
		public humanPlayListener(int column, CFAI aiIn){
			col = column;
			ai = aiIn;
		}
		
		@Override
		public void actionPerformed(ActionEvent e){	
			updateBoard();
			// human player make a move
			play(col);
			updateBoard();
			// Check gameover
			if(isGameOver() == true){
				 if(winner()==1){
					JOptionPane.showMessageDialog(frame,"Red win!"); 
					frame.dispose();
					return;
					}
				 if(winner()==-1){
					JOptionPane.showMessageDialog(frame,"Black win!"); 
					frame.dispose();
					return;
					}
				 if(winner()==0){
					JOptionPane.showMessageDialog(frame,"Draw!"); 
					frame.dispose();
					return;
					}
			}
			// ai makes a move
			play(ai.nextMove(GUICF.this));
			updateBoard();
			// Check gameover
			if(isGameOver() == true){
				 if(winner()==1){
					JOptionPane.showMessageDialog(frame,"Red win!"); 
					frame.dispose();
					return;
					}
				 if(winner()==-1){
					JOptionPane.showMessageDialog(frame,"Black win!"); 
					frame.dispose();
					return;
					}
				 if(winner()==0){
					JOptionPane.showMessageDialog(frame,"Draw!"); 
					frame.dispose();
					return;
					}
			}		
		}
	}// end of humanPlayerListener
	
	/*
	 * ActionListener for ai vs ai constructor
	 */
	public class aiPlayerListener implements ActionListener{
		private CFAI ai1;
		private CFAI ai2;
		boolean flag = false;
		/*
		 * Constructor for the ai vs ai game
		 */
		public aiPlayerListener(CFAI aiIn1,CFAI aiIn2){
			ai1 = aiIn1;
			ai2 = aiIn2;
		}
		
		@Override
		public void actionPerformed(ActionEvent e){
			if(flag == true){
			// First ai makes a move
			play(ai1.nextMove(GUICF.this));
			// Show current board
			updateBoard();
			
			// Check win
			if(isGameOver() == true){
				 if(winner()==1){
					JOptionPane.showMessageDialog(frame,"Red win!"); 
					frame.dispose();
					return;
					}
				 if(winner()==-1){
					JOptionPane.showMessageDialog(frame,"Black win!"); 
					frame.dispose();
					return;
					}
				 if(winner()==0){
					JOptionPane.showMessageDialog(frame,"Draw!"); 
					frame.dispose();
					return;
					}
				}
			flag = !flag;
			}
			
			else{
			// Second ai makes a move
			play(ai2.nextMove(GUICF.this));
			// Show current board
			updateBoard();
			// Check win
			if(isGameOver() == true){
				 if(winner()==1){
					JOptionPane.showMessageDialog(frame,"Red win!"); 
					frame.dispose();
					return;
					}
				 if(winner()==-1){
					JOptionPane.showMessageDialog(frame,"Black win!"); 
					frame.dispose();
					return;
					}
				 if(winner()==0){
					JOptionPane.showMessageDialog(frame,"Draw!"); 
					frame.dispose();
					return;
					}			 
				}
			flag = !flag;
			}
		}
	}
	
	/*
	 * Function to update the current board GUI
	 */
	public void updateBoard(){
		// Get current board
    	int[][] current = getState();
    	// Update colors
    	for(int r = 0; r < 6; ++r){
    		for (int c =0; c <7; ++c){
    			if(current[c][r] == 1){
    				slots[c][r].setOpaque(true);
    				slots[c][r].setBackground(Color.RED);
    			}
    			if(current[c][r] == -1){
    				slots[c][r].setOpaque(true);
    				slots[c][r].setBackground(Color.BLACK);
    			}
    		}
    	}
    }

}
