import java.util.Random;
import java.util.Scanner;

/*
 * Abstract class for the Connect Four game basics
 */
public abstract class CFGame {
  //state[i][j]= 0 means the i,j slot is empty
  //state[i][j]= 1 means the i,j slot has red
  //state[i][j]=-1 means the i,j slot has black
  private final int[][] state;
  private boolean isRedTurn;
  private boolean isDraw = false;
  
  // Initializer block to create a game structure
  {
    state = new int[7][6];
    for (int i=0; i<7; i++)
      for (int j=0; j<6; j++)
        state[i][j] = 0;
    isRedTurn = true; //red goes first
  }
    
  // Return the current state
  public int[][] getState() {
    int[][] ret_arr = new int[7][6];
    for (int i=0; i<7; i++)
      for (int j=0; j<6; j++)
        ret_arr[i][j] = state[i][j];
    return ret_arr;
  }
  
  // Return the current turn
  public boolean isRedTurn() {
    return isRedTurn;
  }
  
  /*
   * Function to make a the next move
   * @column is the column to choose
   * @return true if it is a valid move
   */
  public boolean play(int column) {
	  boolean flag = false;
	  // Invalid moves
	  if(!(column >=1 && column <=7)){
		  flag = false;
	  }
	  else if(state[column - 1][0] != 0){
		  flag = false;
	  }
	  // Valid moves
	  else{
	  // Check all elements in the column
      for(int i = 0; i < 6; i++){
    	  // Find the first nonzero slot in the column
    	  if(state[column -1][i] != 0){
    		  if(isRedTurn == true){
    			  state[column-1][i-1] = 1;
    	    	  isRedTurn = !isRedTurn;
    			  return true;
    		  }
    		  else if(isRedTurn == false){
    			  state[column-1][i-1] = -1;
    	    	  isRedTurn = !isRedTurn;
    			  return true;
    		  }
    	  }
    	  
      }
      
      // If the column is empty
      if(isRedTurn == true){
    	  state[column-1][5] = 1;
    	  isRedTurn = !isRedTurn;
    	  flag = true;
      }
      else if(isRedTurn == false){
    	  state[column-1][5] = -1;
    	  isRedTurn = !isRedTurn;
    	  flag = true;
      }
	  }
      return flag;
  }
  
  /*
   * Function to check whether the game is over
   * @return true if the game has a winner or it is a draw
   */
  public boolean isGameOver() {
	  // Initialize a flag
	 boolean flag = false; 
	  
	 // Check rows to find winner
	 for(int i = 0; i < 6; i++ ){
		 // Initialize a counter
		 int streak = 0;
		 // Compare each column in the row
		 for(int j = 1; j < 7; j++){
			 if(state[j][i] == state[j -1][i] && state[j][i] != 0){ streak++;}
			 else{ streak = 0;}
			 //found winner
			 if (streak == 3){
				 flag = true;
				 return flag;
			 }
		 }
	 }
	 
	 // Check column to find winner
	 for(int i = 0; i < 7; i++){
		 // Initialize a counter
		 int streak = 0;
		 // Compare each row along this column
		 for(int j = 1; j < 6; j++){
			 if(state[i][j] == state[i][j-1] && state[i][j] != 0){ streak++;}
			 else{ streak = 0;}
			 
			 //found winner
			 if (streak == 3){
				 flag = true;
				 return flag;
			 }
		 }		 
	 }
	 
	 // Check diagonal "\" upper part to find winner
	 for (int c = 0; c < 7; c++){
		 int streak = 0;
		 for(int r = 1; r < 6; ++r){
			 if(c + r > 6 || r >5){ break;}
			 if(state[c + r][r] ==state[c+r-1][r-1] && state[c+r][r] != 0){streak++;}
			 else{streak = 0;}
			 if(streak == 3){
				 flag = true;
				 return flag;
			 }
		 }
	 }
	 
	 // Check diagonal "\" lower part to find winner
	 for(int r = 0; r<6; r++){
		 int streak = 0;
		 for(int c = 1; c < 7; c++){
			 if(c + r > 5 || c >5) { break;}
			 if(state[c-1][r+c-1] == state[c][r + c] && state[c][c+r] != 0){streak++;}
			 else{streak = 0;}
			 if(streak == 3){
				 flag = true;
				 return flag;
			 }
		 }
	 }

	 // Check diagonal "/"  to find winner
	 int streak = 0;
		int c = 3, r = 0;
		while(c > 0 && r <3){
			if(state[c][r] != 0 && state[c][r] == state[c-1][r+1]){streak++;}
			else{streak = 0;}
			if(streak == 3){flag = true; return flag;}
			c--;r++;
		}
	 
	  streak = 0;
		 c = 4; r = 0;
		while(c > 0 && r <4){
			if(state[c][r] != 0 && state[c][r] == state[c-1][r+1]){streak++;}
			else{streak = 0;}
			if(streak == 3){flag = true; return flag;}
			c--;r++;
		}

	  streak = 0;
		 c = 5; r = 0;
		while(c > 0 && r <5){
			if(state[c][r] != 0 && state[c][r] == state[c-1][r+1]){streak++;}
			else{streak = 0;}
			if(streak == 3){flag = true; return flag;}
			c--;r++;
		}
		
	  streak = 0;
		 c = 6; r = 0;
		while(c > 1 && r <5){
			if(state[c][r] != 0 && state[c][r] == state[c-1][r+1]){streak++;}
			else{streak = 0;}
			if(streak == 3){flag = true; return flag;}
			c--;r++;
		}
		
	 streak = 0;
	 c = 6; r = 2;
	 while(c > 3 && r <5){
		if(state[c][r] != 0 && state[c][r] == state[c-1][r+1]){streak++;}
		else{streak = 0;}
		if(streak == 3){flag = true; return flag;}
		c--;r++;
	}
	
	streak = 0;
	c= 6; r =1;
	while(c>2 && r< 5){
		if(state[c][r] != 0 && state[c][r] == state[c-1][r+1]){streak++;}
		else{streak = 0;}

		if(streak == 3){flag = true; return flag;}
		c--;r++;
	}	 
	
	 // Check the draw case
	flag = true;
	  for(int i = 0; i < 6; i++){
		  for(int j = 0; j < 7; j++){
			  if(state[j][i] == 0){flag = false; break;}
		  }
	  }  
	 
    return flag;
  }
  
  /*
   *  Function to get the winner for the game
   *  @return 0 means draw, 1 means red wins, return -1 means black wins
   */
  public int winner() {
	  int result = 0;
	  if(isDraw == true){result= 0;}
	  else if(isRedTurn == true){result =  -1;}
	  else if(isRedTurn == false){result = 1;}
	  return result;
  }
  
}// End of class