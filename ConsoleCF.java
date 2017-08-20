/*
 * hw4
 * Name: Zhengyang Qi
 * SID: 204296544
 */
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Class to generate a game console between ai or human and ai
 */
public class ConsoleCF extends CFGame {
	// private fields
	private ArrayList<CFAI> players = new ArrayList<CFAI>(2);
	private String  result = "";
	
	/*
	 * Private class for a human player
	 */
	private class HumanPlayer implements CFAI {
		@Override
		public int nextMove(CFGame g) {
			int[][] current = g.getState();
			for (int row = 0; row < 6; ++row) {
		          System.out.print("| ");
		          for (int col = 0; col < 7; ++col)
		        	  if(current[col][row]==-1)
		              System.out.print(current[col][row] + "| ");
		        	  else{System.out.print(current[col][row] + " | ");}
		          System.out.println();
		      }
			System.out.println("Make a move from 1 - 7");
			Scanner input = new Scanner(System.in);
			int column = input.nextInt();
			

			return column;
		}
		
		
		@Override
		public String getName() {
			String name = "Human Player";
			return name;
		}
		
	}// End of private class
	
	/*
	 * Constructor with human vs AI
	 */
	public ConsoleCF(CFAI ai){
		HumanPlayer human = new HumanPlayer();
		players.add(ai);
		players.add(human);
		// Shuffle the order to play
		java.util.Collections.shuffle(players);	
	}
	
	/*
	 * Constructor of AI vs AI
	 */
	public ConsoleCF (CFAI ai1 , CFAI ai2){
		players.add(ai1);
		players.add(ai2);
		// Shuffle the order to play
		java.util.Collections.shuffle(players);	
	}
	
	/*
	 * Function to implement rules and check win
	 */
	public void play (){
		while(true){
			// First player makes the move
			while(!(super.play(players.get(0).nextMove(this)))){}
			// Check win
			if(super.isGameOver() == true){
				 if(super.winner()==1){result = players.get(0).getName();}
				 if(super.winner()==-1){result = players.get(1).getName();}
				 if(super.winner()==0){result = "draw";}
				break;
			}
			// Second player makes the move
			while(!(super.play(players.get(1).nextMove(this)))){}
			if(super.isGameOver() == true){
				 if(super.winner()==1){result = players.get(0).getName();}
				 if(super.winner()==-1){result = players.get(1).getName();}
				 if(super.winner()==0){result = "draw";}
				break;
			}		
		}	
	}
	
	// Return the game result
	public String getWinner (){
		return result;
	}
	

}
