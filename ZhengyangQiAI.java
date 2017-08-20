/*
 * hw4
 * Name: Zhengyang Qi
 * SID: 204296544
 */


/*
 * Class to implement an ai that plays a move based on current situation
 */
public class ZhengyangQiAI implements CFAI {

	@Override
	public int nextMove(CFGame g) {
		// Get current state
		int[][] current = g.getState();
		
		// If the AI is the red player
		if(g.isRedTurn() == true){
			/*
			 // find row three in a streak possible
			  for(int r = 0; r < 6;r++){
				  for(int c = 0; c < 5; c++ ){
					  if(current[c][r] == 1 && current[c][r] == current[c+1][r] && current[c][r] == current[c+2][r]){
						  if(c==0&&current[c+3][r]==0){return (c+4);}
						  else if(c !=0 && c!=4 && current[c-1][r] ==0){return c;}
						  else if(c !=0 && c!=4 && current[c+3][r] ==0){return c+4;}
						  else if( c==4 && current[c-1][r] ==0){ return c;}
					  }
				  }
			  }
			  
			  // find row "xx x" and "x xx" possible
			  for(int r = 0; r < 6; r++){ 
				  for(int c = 0; c <4; c++){
					  if(current[c][r]== 1 && current[c][r] ==current[c+1][r] &&current[c][r] ==current[c+3][r]&&current[c+2][r]==0){return c+3;}
				  }
				  for(int c = 2; c <6; c++){
					  if(current[c][r]== 1 && current[c][r] ==current[c+1][r] &&current[c][r] ==current[c-2][r]&&current[c-1][r]==0){ return c;}
				  }
			  }
			  
			  //find column possible
			 for(int c = 0; c < 7; c++){
				 for(int r = 5; r > 2; r--){
					 if(current[c][r] == 1 && current[c][r]==current[c][r-1]&&current[c][r]==current[c][r-2] &&current[c][r-3]==0){
						 return c+1;
					 }
				 }
			 }
			 
			 
			 //check "/"
			 if(current[0][3] ==1 && current[0][3] == current[1][2] && current[1][2]==current[2][1] && current[3][0] == 0){return 4;}
			 if(current[0][3] ==0 && current[2][1] == current[1][2] && current[2][1]==current[3][0] && current[3][0] == 1){return 1;}
			 if(current[0][4] ==1 && current[0][4] == current[1][3] && current[1][3]==current[2][2] && current[3][1] == 0){return 4;}
			 if(current[0][4] ==0 && current[1][3] == current[2][2] && current[3][1]==current[2][2] && current[3][1] == 1){return 1;}
			 if(current[0][4] ==-1 && current[1][3] == current[2][2] && current[3][1]==current[2][2] && current[3][1] == 1 && current[4][0] ==0){return 5;}
			 if(current[1][3] ==0 && current[3][1] == current[2][2] && current[4][0]==current[3][1] && current[3][1] == 1 && current[4][0] ==0){return 2;}
			 if(current[2][5] ==1 && current[2][5] == current[3][4] && current[3][4]==current[4][3] && current[5][2] == 0){return 6;}
			 if(current[3][4] ==0 && current[4][3] == current[5][2] && current[5][2]==current[6][1] && current[6][1] == 1){return 4;}
			 if(current[2][5] ==-1 && current[3][4] == current[4][3] && current[4][3]==current[5][2] && current[5][2] == 1 && current[6][1] ==0){return 7;}
			 if(current[2][5] ==0 && current[3][4] == current[4][3] && current[4][3]==current[5][2] && current[5][2] == 1){return 3;}
			 if(current[3][5] ==1 && current[3][5] == current[4][4] && current[4][4]==current[5][3] && current[6][2] == 0){return 7;}
			 if(current[3][5] ==0 && current[4][4] == current[5][3] && current[5][3]==current[6][2] && current[6][2] == 1){return 4;}
			 for(int c = 0; c<4;c++){
				 if(c == 0&&current[0][5]==1&&current[0][5]==current[1][4]&&current[1][4]==current[2][3]&&current[3][2]==0){return 4;}
				 else if(c == 3&&current[3][2]==1&&current[3][2]==current[4][1]&&current[4][1]==current[5][0]&&current[2][3]==0){return 3;}
				 else if(c ==1 || c==2){ 
				 	if(current[c][5-c]==1 &&current[c][5-c]==current[c+1][4-c]&&current[c][5-c]==current[c+2][3-c]&&current[c-1][6-c]==0){return c;}
				 	else if(current[c][5-c]==1 &&current[c][5-c]==current[c+1][4-c]&&current[c][5-c]==current[c+2][3-c]&&current[c-1][6-c]==-1&&current[c+3][2-c]==0){ return (c+4);}
				 }
			 }
			 for(int c = 1; c<5;c++){
				 if(c == 1&&current[1][5]==1&&current[1][5]==current[2][4]&&current[2][4]==current[3][3]&&current[4][2]==0){return 5;}
				 else if(c == 4&&current[4][2]==1&&current[4][2]==current[5][1]&&current[5][1]==current[6][0]&&current[3][3]==0){return 4;}
				 else if(c ==3 || c==2){ 
				 	if(current[c][6-c]==1 &&current[c][6-c]==current[c+1][5-c]&&current[c][6-c]==current[c+2][4-c]&&current[c-1][7-c]==0){return c;}
				 	else if(current[c][5-c]==1 &&current[c][5-c]==current[c+1][4-c]&&current[c][5-c]==current[c+2][3-c]&&current[c-1][6-c]==-1&&current[c+3][2-c]==0){ return (c+4);}
				 }
			 }
			 
			 //check "\"
			 if(current[0][2] ==1 && current[0][2] == current[1][3] && current[1][3]==current[2][4] && current[3][5] == 0){return 4;}
			 if(current[0][2] ==0 && current[2][4] == current[1][3] && current[2][4]==current[3][5] && current[3][5] == 1){return 1;}
			 if(current[0][1] ==1 && current[0][1] == current[1][2] && current[1][2]==current[2][3] && current[3][4] == 0){return 4;}
			 if(current[1][2] ==0 && current[2][3] == current[3][4] && current[3][4]==current[4][5] && current[3][4] == 1){return 2;}
			 if(current[4][5] ==-1 && current[1][2] == current[2][3] && current[3][4]==current[2][3] && current[3][4] == 1 && current[0][1] ==0){return 1;}
			 if(current[4][5] ==0 && current[1][2] == current[2][3] && current[2][3]==current[3][4] && current[3][4] == 1){return 5;}
			 if(current[3][0] ==1 && current[3][0] == current[4][1] && current[4][1]==current[5][2] && current[6][3] == 0){return 7;}
			 if(current[3][0] ==0 && current[4][1] == current[5][2] && current[5][2]==current[6][3] && current[6][3] == 1){return 4;}
			 if(current[6][4] ==-1 && current[3][1] == current[4][2] && current[4][2]==current[5][3] && current[5][3] == 1 && current[2][0] ==0){return 3;}
			 if(current[6][4] ==0 && current[3][1] == current[4][2] && current[4][2]==current[5][3] && current[5][3] == 1){return 7;}
			 if(current[6][4] ==1 && current[6][4] == current[5][3] && current[5][3]==current[4][2] && current[3][1] == 0){return 4;}
			 if(current[5][3] ==0 && current[2][0] == current[3][1] && current[3][1]==current[4][2] && current[4][2] == 1){return 6;}
			 for(int c = 0; c<4;c++){
				 if(c == 0&&current[0][0]==1&&current[0][0]==current[1][1]&&current[1][1]==current[2][2]&&current[3][3]==0){return 4;}
				 else if(c == 3&&current[3][3]==1&&current[3][3]==current[4][4]&&current[4][4]==current[5][5]&&current[2][2]==0){return 3;}
				 else if(c ==1 || c==2){ 
				 	if(current[c][c]==1 &&current[c+1][c+1]==current[c][c]&&current[c+2][c+2]==current[c][c]&&current[c+3][c+3]==0){return (c+4);}
				 	else if(current[c][c]==1 &&current[c+1][c+1]==current[c][c]&&current[c+2][c+2]==current[c][c]&&current[c+3][c+3]==-1&&current[c-1][c-1]==0){return c;}
				 }
			 }
			 for(int c = 1; c<5;c++){
				 if(c == 1&&current[1][0]==1&&current[1][0]==current[2][1]&&current[2][1]==current[3][2]&&current[4][3]==0){return 5;}
				 else if(c == 4&&current[4][3]==1&&current[4][3]==current[5][4]&&current[5][4]==current[6][5]&&current[3][2]==0){return 4;}
				 else if(c ==3 || c==2){ 
				 	if(current[c][c-1]==1 &&current[c][c-1]==current[c+1][c]&&current[c][c-1]==current[c+2][c+1]&&current[c+3][c+2]==0){return (c+4);}
				 	else if(current[c][c-1]==1 &&current[c][c-1]==current[c+1][c]&&current[c][c-1]==current[c+2][c+1]&&current[c+3][c+2]==-1&&current[c-1][c-2]==0){return c;}
				 }
			 }
			
			//Block the opponent
			 
			// find row three in a streak possible
			  for(int r = 0; r < 6;r++){
				  for(int c = 0; c < 5; c++ ){
					  if(current[c][r] == -1 && current[c][r] == current[c+1][r] && current[c][r] == current[c+2][r]){
						  if(c==0&&current[c+3][r]==0){return (c+4);}
						  else if(c !=0 && c!=4 && current[c-1][r] ==0){return c;}
						  else if(c !=0 && c!=4 && current[c+3][r] ==0){return c+4;}
						  else if( c==4 && current[c-1][r] ==0){ return c;}
					  }
				  }
			  }
			  
			  // find row "xx x" and "x xx" possible
			  for(int r = 0; r < 6; r++){ 
				  for(int c = 0; c <4; c++){
					  if(current[c][r]== -1 && current[c][r] ==current[c+1][r] &&current[c][r] ==current[c+3][r] && current[c+2][r] ==0){return c+3;}
				  }
				  for(int c = 2; c <6; c++){
					  if(current[c][r]== -1 && current[c][r] ==current[c+1][r] &&current[c][r] ==current[c-2][r] && current[c-1][r]==0){ return c;}
				  }
			  }
			  
			  //find column possible
			 for(int c = 0; c < 7; c++){
				 for(int r = 5; r > 2; r--){
					 if(current[c][r] == -1 && current[c][r]==current[c][r-1]&&current[c][r]==current[c][r-2] &&current[c][r-3]==0){
						 return c+1;
					 }
				 }
			 }
			 
			 //check "/"
			 if(current[0][3] ==-1 && current[0][3] == current[1][2] && current[1][2]==current[2][1] && current[3][0] == 0){return 4;}
			 if(current[0][3] ==0 && current[2][1] == current[1][2] && current[2][1]==current[3][0] && current[3][0] == -1){return 1;}
			 if(current[0][4] ==-1 && current[0][4] == current[1][3] && current[1][3]==current[2][2] && current[3][1] == 0){return 4;}
			 if(current[0][4] ==0 && current[1][3] == current[2][2] && current[3][1]==current[2][2] && current[3][1] == -1){return 1;}
			 if(current[0][4] == 1 && current[1][3] == current[2][2] && current[3][1]==current[2][2] && current[3][1] == -1 && current[4][0] ==0){return 5;}
			 if(current[1][3] ==0 && current[3][1] == current[2][2] && current[4][0]==current[3][1] && current[3][1] == -1 && current[4][0] ==0){return 2;}
			 if(current[2][5] ==-1 && current[2][5] == current[3][4] && current[3][4]==current[4][3] && current[5][2] == 0){return 6;}
			 if(current[3][4] ==0 && current[4][3] == current[5][2] && current[5][2]==current[6][1] && current[6][1] == -1){return 4;}
			 if(current[2][5] == 1 && current[3][4] == current[4][3] && current[4][3]==current[5][2] && current[5][2] == -1 && current[6][1] ==0){return 7;}
			 if(current[2][5] ==0 && current[3][4] == current[4][3] && current[4][3]==current[5][2] && current[5][2] == -1){return 3;}
			 if(current[3][5] ==-1 && current[3][5] == current[4][4] && current[4][4]==current[5][3] && current[6][2] == 0){return 7;}
			 if(current[3][5] ==0 && current[4][4] == current[5][3] && current[5][3]==current[6][2] && current[6][2] == -1){return 4;}
			 for(int c = 0; c<4;c++){
				 if(c == 0&&current[0][5]==-1&&current[0][5]==current[1][4]&&current[1][4]==current[2][3]&&current[3][2]==0){return 4;}
				 else if(c == 3&&current[3][2]==-1&&current[3][2]==current[4][1]&&current[4][1]==current[5][0]&&current[2][3]==0){return 3;}
				 else if(c ==1 || c==2){ 
				 	if(current[c][5-c]==-1 &&current[c][5-c]==current[c+1][4-c]&&current[c][5-c]==current[c+2][3-c]&&current[c-1][6-c]==0){return c;}
				 	else if(current[c][5-c]==-1 &&current[c][5-c]==current[c+1][4-c]&&current[c][5-c]==current[c+2][3-c]&&current[c-1][6-c]==-1&&current[c+3][2-c]==0){ return (c+4);}
				 }
			 }
			 for(int c = 1; c<5;c++){
				 if(c == 1&&current[1][5]==-1&&current[1][5]==current[2][4]&&current[2][4]==current[3][3]&&current[4][2]==0){return 5;}
				 else if(c == 4&&current[4][2]==-1&&current[4][2]==current[5][1]&&current[5][1]==current[6][0]&&current[3][3]==0){return 4;}
				 else if(c ==3 || c==2){ 
				 	if(current[c][6-c]==-1 &&current[c][6-c]==current[c+1][5-c]&&current[c][6-c]==current[c+2][4-c]&&current[c-1][7-c]==0){return c;}
				 	else if(current[c][5-c]==-1 &&current[c][5-c]==current[c+1][4-c]&&current[c][5-c]==current[c+2][3-c]&&current[c-1][6-c]==1&&current[c+3][2-c]==0){ return (c+4);}
				 }
			 }
			 
			 //check "\"
			 if(current[0][2] ==-1 && current[0][2] == current[1][3] && current[1][3]==current[2][4] && current[3][5] == 0){return 4;}
			 if(current[0][2] ==0 && current[2][4] == current[1][3] && current[2][4]==current[3][5] && current[3][5] == -1){return 1;}
			 if(current[0][1] ==-1 && current[0][1] == current[1][2] && current[1][2]==current[2][3] && current[3][4] == 0){return 4;}
			 if(current[1][2] ==0 && current[2][3] == current[3][4] && current[3][4]==current[4][5] && current[3][4] == -1){return 2;}
			 if(current[4][5] == 1 && current[1][2] == current[2][3] && current[3][4]==current[2][3] && current[3][4] == -1 && current[0][1] ==0){return 1;}
			 if(current[4][5] ==0 && current[1][2] == current[2][3] && current[2][3]==current[3][4] && current[3][4] == -1){return 5;}
			 if(current[3][0] ==-1 && current[3][0] == current[4][1] && current[4][1]==current[5][2] && current[6][3] == 0){return 7;}
			 if(current[3][0] ==0 && current[4][1] == current[5][2] && current[5][2]==current[6][3] && current[6][3] == -1){return 4;}
			 if(current[6][4] == 1 && current[3][1] == current[4][2] && current[4][2]==current[5][3] && current[5][3] == -1 && current[2][0] ==0){return 3;}
			 if(current[6][4] ==0 && current[3][1] == current[4][2] && current[4][2]==current[5][3] && current[5][3] == -1){return 7;}
			 if(current[6][4] == -1 && current[6][4] == current[5][3] && current[5][3]==current[4][2] && current[3][1] == 0){return 4;}
			 if(current[5][3] ==0 && current[2][0] == current[3][1] && current[3][1]==current[4][2] && current[4][2] == -1){return 6;}
			 for(int c = 0; c<4;c++){
				 if(c == 0&&current[0][0]== -1&&current[0][0]==current[1][1]&&current[1][1]==current[2][2]&&current[3][3]==0){return 4;}
				 else if(c == 3&&current[3][3]== -1&&current[3][3]==current[4][4]&&current[4][4]==current[5][5]&&current[2][2]==0){return 3;}
				 else if(c ==1 || c==2){ 
				 	if(current[c][c]== -1 &&current[c+1][c+1]==current[c][c]&&current[c+2][c+2]==current[c][c]&&current[c+3][c+3]==0){return (c+4);}
				 	else if(current[c][c]== -1 &&current[c+1][c+1]==current[c][c]&&current[c+2][c+2]==current[c][c]&&current[c+3][c+3]==-1&&current[c-1][c-1]==0){return c;}
				 }
			 }
			 for(int c = 1; c<5;c++){
				 if(c == 1&&current[1][0]== -1&&current[1][0]==current[2][1]&&current[2][1]==current[3][2]&&current[4][3]==0){return 5;}
				 else if(c == 4&&current[4][3]== -1&&current[4][3]==current[5][4]&&current[5][4]==current[6][5]&&current[3][2]==0){return 4;}
				 else if(c ==3 || c==2){ 
				 	if(current[c][c-1]== -1 &&current[c][c-1]==current[c+1][c]&&current[c][c-1]==current[c+2][c+1]&&current[c+3][c+2]==0){return (c+4);}
				 	else if(current[c][c-1]== -1 &&current[c][c-1]==current[c+1][c]&&current[c][c-1]==current[c+2][c+1]&&current[c+3][c+2]==1&&current[c-1][c-2]==0){return c;}
				 }
			 }
			*/
			 // basic strategy
			 for(int c = 0; c < 7; c++){
					if(current[c][5] ==0){return (c+1);}
					if (current[c][5] !=0 && current[c][4] ==0){return (c+1);}
					if (current[c][5] !=0 && current[c][4] !=0 &&current[c][3] ==0){return (c+1);}
					if (current[c][5] !=0 && current[c][4] !=0 &&current[c][3] ==1 && current[c][2]==0){return (c+1);}
					if (current[c][5] !=0 && current[c][4] !=0 &&current[c][3] ==1 && current[c][2]==1 && current[c][1] ==0){return (c+1);}
					if (current[c][5] !=0 && current[c][4] !=0 &&current[c][3] ==1 && current[c][2]==1 && current[c][1] ==1 && current[c][0]==0){return (c+1);}				 
				 }		
			

		}//end of red
		
		// if AI is black
		else if(g.isRedTurn() == false){
			/*
			// find row three in a streak possible
			   for(int r = 0; r < 6;r++){
				  for(int c = 0; c < 5; c++ ){
					  if(current[c][r] == -1 && current[c][r] == current[c+1][r] && current[c][r] == current[c+2][r]){
						  if(c==0&&current[c+3][r]==0){return (c+4);}
						  else if(c !=0 && c!=4 && current[c-1][r] ==0){return c;}
						  else if(c !=0 && c!=4 && current[c+3][r] ==0){return c+4;}
						  else if( c==4 && current[c-1][r] ==0){ return c;}
					  }
				  }
			  }
			  
			  // find row "xx x" and "x xx" possible
			  for(int r = 0; r < 6; r++){ 
				  for(int c = 0; c <4; c++){
					  if(current[c][r]== -1 && current[c][r] ==current[c+1][r] &&current[c][r] ==current[c+3][r] && current[c+2][r] ==0){return c+3;}
				  }
				  for(int c = 2; c <6; c++){
					  if(current[c][r]== -1 && current[c][r] ==current[c+1][r] &&current[c][r] ==current[c-2][r] && current[c-1][r]==0){ return c;}
				  }
			  }
			  
			  //find column possible
			 for(int c = 0; c < 7; c++){
				 for(int r = 5; r > 2; r--){
					 if(current[c][r] == -1 && current[c][r]==current[c][r-1]&&current[c][r]==current[c][r-2] &&current[c][r-3]==0){
						 return c+1;
					 }
				 }
			 }
			 
			 //check "/"
			 if(current[0][3] ==-1 && current[0][3] == current[1][2] && current[1][2]==current[2][1] && current[3][0] == 0){return 4;}
			 if(current[0][3] ==0 && current[2][1] == current[1][2] && current[2][1]==current[3][0] && current[3][0] == -1){return 1;}
			 if(current[0][4] ==-1 && current[0][4] == current[1][3] && current[1][3]==current[2][2] && current[3][1] == 0){return 4;}
			 if(current[0][4] ==0 && current[1][3] == current[2][2] && current[3][1]==current[2][2] && current[3][1] == -1){return 1;}
			 if(current[0][4] == 1 && current[1][3] == current[2][2] && current[3][1]==current[2][2] && current[3][1] == -1 && current[4][0] ==0){return 5;}
			 if(current[1][3] ==0 && current[3][1] == current[2][2] && current[4][0]==current[3][1] && current[3][1] == -1 && current[4][0] ==0){return 2;}
			 if(current[2][5] ==-1 && current[2][5] == current[3][4] && current[3][4]==current[4][3] && current[5][2] == 0){return 6;}
			 if(current[3][4] ==0 && current[4][3] == current[5][2] && current[5][2]==current[6][1] && current[6][1] == -1){return 4;}
			 if(current[2][5] == 1 && current[3][4] == current[4][3] && current[4][3]==current[5][2] && current[5][2] == -1 && current[6][1] ==0){return 7;}
			 if(current[2][5] ==0 && current[3][4] == current[4][3] && current[4][3]==current[5][2] && current[5][2] == -1){return 3;}
			 if(current[3][5] ==-1 && current[3][5] == current[4][4] && current[4][4]==current[5][3] && current[6][2] == 0){return 7;}
			 if(current[3][5] ==0 && current[4][4] == current[5][3] && current[5][3]==current[6][2] && current[6][2] == -1){return 4;}
			 for(int c = 0; c<4;c++){
				 if(c == 0&&current[0][5]==-1&&current[0][5]==current[1][4]&&current[1][4]==current[2][3]&&current[3][2]==0){return 4;}
				 else if(c == 3&&current[3][2]==-1&&current[3][2]==current[4][1]&&current[4][1]==current[5][0]&&current[2][3]==0){return 3;}
				 else if(c ==1 || c==2){ 
				 	if(current[c][5-c]==-1 &&current[c][5-c]==current[c+1][4-c]&&current[c][5-c]==current[c+2][3-c]&&current[c-1][6-c]==0){return c;}
				 	else if(current[c][5-c]==-1 &&current[c][5-c]==current[c+1][4-c]&&current[c][5-c]==current[c+2][3-c]&&current[c-1][6-c]==-1&&current[c+3][2-c]==0){ return (c+4);}
				 }
			 }
			 for(int c = 1; c<5;c++){
				 if(c == 1&&current[1][5]==-1&&current[1][5]==current[2][4]&&current[2][4]==current[3][3]&&current[4][2]==0){return 5;}
				 else if(c == 4&&current[4][2]==-1&&current[4][2]==current[5][1]&&current[5][1]==current[6][0]&&current[3][3]==0){return 4;}
				 else if(c ==3 || c==2){ 
				 	if(current[c][6-c]==-1 &&current[c][6-c]==current[c+1][5-c]&&current[c][6-c]==current[c+2][4-c]&&current[c-1][7-c]==0){return c;}
				 	else if(current[c][5-c]==-1 &&current[c][5-c]==current[c+1][4-c]&&current[c][5-c]==current[c+2][3-c]&&current[c-1][6-c]==1&&current[c+3][2-c]==0){ return (c+4);}
				 }
			 }
			 
			 //check "\"
			 if(current[0][2] ==-1 && current[0][2] == current[1][3] && current[1][3]==current[2][4] && current[3][5] == 0){return 4;}
			 if(current[0][2] ==0 && current[2][4] == current[1][3] && current[2][4]==current[3][5] && current[3][5] == -1){return 1;}
			 if(current[0][1] ==-1 && current[0][1] == current[1][2] && current[1][2]==current[2][3] && current[3][4] == 0){return 4;}
			 if(current[1][2] ==0 && current[2][3] == current[3][4] && current[3][4]==current[4][5] && current[3][4] == -1){return 2;}
			 if(current[4][5] == 1 && current[1][2] == current[2][3] && current[3][4]==current[2][3] && current[3][4] == -1 && current[0][1] ==0){return 1;}
			 if(current[4][5] ==0 && current[1][2] == current[2][3] && current[2][3]==current[3][4] && current[3][4] == -1){return 5;}
			 if(current[3][0] ==-1 && current[3][0] == current[4][1] && current[4][1]==current[5][2] && current[6][3] == 0){return 7;}
			 if(current[3][0] ==0 && current[4][1] == current[5][2] && current[5][2]==current[6][3] && current[6][3] == -1){return 4;}
			 if(current[6][4] == 1 && current[3][1] == current[4][2] && current[4][2]==current[5][3] && current[5][3] == -1 && current[2][0] ==0){return 3;}
			 if(current[6][4] ==0 && current[3][1] == current[4][2] && current[4][2]==current[5][3] && current[5][3] == -1){return 7;}
			 if(current[6][4] == -1 && current[6][4] == current[5][3] && current[5][3]==current[4][2] && current[3][1] == 0){return 4;}
			 if(current[5][3] ==0 && current[2][0] == current[3][1] && current[3][1]==current[4][2] && current[4][2] == -1){return 6;}
			 for(int c = 0; c<4;c++){
				 if(c == 0&&current[0][0]== -1&&current[0][0]==current[1][1]&&current[1][1]==current[2][2]&&current[3][3]==0){return 4;}
				 else if(c == 3&&current[3][3]== -1&&current[3][3]==current[4][4]&&current[4][4]==current[5][5]&&current[2][2]==0){return 3;}
				 else if(c ==1 || c==2){ 
				 	if(current[c][c]== -1 &&current[c+1][c+1]==current[c][c]&&current[c+2][c+2]==current[c][c]&&current[c+3][c+3]==0){return (c+4);}
				 	else if(current[c][c]== -1 &&current[c+1][c+1]==current[c][c]&&current[c+2][c+2]==current[c][c]&&current[c+3][c+3]==-1&&current[c-1][c-1]==0){return c;}
				 }
			 }
			 for(int c = 1; c<5;c++){
				 if(c == 1&&current[1][0]== -1&&current[1][0]==current[2][1]&&current[2][1]==current[3][2]&&current[4][3]==0){return 5;}
				 else if(c == 4&&current[4][3]== -1&&current[4][3]==current[5][4]&&current[5][4]==current[6][5]&&current[3][2]==0){return 4;}
				 else if(c ==3 || c==2){ 
				 	if(current[c][c-1]== -1 &&current[c][c-1]==current[c+1][c]&&current[c][c-1]==current[c+2][c+1]&&current[c+3][c+2]==0){return (c+4);}
				 	else if(current[c][c-1]== -1 &&current[c][c-1]==current[c+1][c]&&current[c][c-1]==current[c+2][c+1]&&current[c+3][c+2]==1&&current[c-1][c-2]==0){return c;}
				 }
			 }
			 
			 //block opponent
			// find row three in a streak possible
			  for(int r = 0; r < 6;r++){
				  for(int c = 0; c < 5; c++ ){
					  if(current[c][r] == 1 && current[c][r] == current[c+1][r] && current[c][r] == current[c+2][r]){
						  if(c==0&&current[c+3][r]==0){return (c+4);}
						  else if(c !=0 && c!=4 && current[c-1][r] ==0){return c;}
						  else if(c !=0 && c!=4 && current[c+3][r] ==0){return c+4;}
						  else if( c==4 && current[c-1][r] ==0){ return c;}
					  }
				  }
			  }
			  
			  // find row "xx x" and "x xx" possible
			  for(int r = 0; r < 6; r++){ 
				  for(int c = 0; c <4; c++){
					  if(current[c][r]== 1 && current[c][r] ==current[c+1][r] &&current[c][r] ==current[c+3][r]&&current[c+2][r]==0){return c+3;}
				  }
				  for(int c = 2; c <6; c++){
					  if(current[c][r]== 1 && current[c][r] ==current[c+1][r] &&current[c][r] ==current[c-2][r]&&current[c-1][r]==0){ return c;}
				  }
			  }
			  
			  //find column possible
			 for(int c = 0; c < 7; c++){
				 for(int r = 5; r > 2; r--){
					 if(current[c][r] == 1 && current[c][r-1] == 1&&current[c][r-2]==1 &&current[c][r-3]==0){
						 return c+1;
					 }
				 }
			 }
			 
			 //check "/"
			 if(current[0][3] ==1 && current[0][3] == current[1][2] && current[1][2]==current[2][1] && current[3][0] == 0){return 4;}
			 if(current[0][3] ==0 && current[2][1] == current[1][2] && current[2][1]==current[3][0] && current[3][0] == 1){return 1;}
			 if(current[0][4] ==1 && current[0][4] == current[1][3] && current[1][3]==current[2][2] && current[3][1] == 0){return 4;}
			 if(current[0][4] ==0 && current[1][3] == current[2][2] && current[3][1]==current[2][2] && current[3][1] == 1){return 1;}
			 if(current[0][4] ==-1 && current[1][3] == current[2][2] && current[3][1]==current[2][2] && current[3][1] == 1 && current[4][0] ==0){return 5;}
			 if(current[1][3] ==0 && current[3][1] == current[2][2] && current[4][0]==current[3][1] && current[3][1] == 1 && current[4][0] ==0){return 2;}
			 if(current[2][5] ==1 && current[2][5] == current[3][4] && current[3][4]==current[4][3] && current[5][2] == 0){return 6;}
			 if(current[3][4] ==0 && current[4][3] == current[5][2] && current[5][2]==current[6][1] && current[6][1] == 1){return 4;}
			 if(current[2][5] ==-1 && current[3][4] == current[4][3] && current[4][3]==current[5][2] && current[5][2] == 1 && current[6][1] ==0){return 7;}
			 if(current[2][5] ==0 && current[3][4] == current[4][3] && current[4][3]==current[5][2] && current[5][2] == 1){return 3;}
			 if(current[3][5] ==1 && current[3][5] == current[4][4] && current[4][4]==current[5][3] && current[6][2] == 0){return 7;}
			 if(current[3][5] ==0 && current[4][4] == current[5][3] && current[5][3]==current[6][2] && current[6][2] == 1){return 4;}
			 for(int c = 0; c<4;c++){
				 if(c == 0&&current[0][5]==1&&current[0][5]==current[1][4]&&current[1][4]==current[2][3]&&current[3][2]==0){return 4;}
				 else if(c == 3&&current[3][2]==1&&current[3][2]==current[4][1]&&current[4][1]==current[5][0]&&current[2][3]==0){return 3;}
				 else if(c ==1 || c==2){ 
				 	if(current[c][5-c]==1 &&current[c][5-c]==current[c+1][4-c]&&current[c][5-c]==current[c+2][3-c]&&current[c-1][6-c]==0){return c;}
				 	else if(current[c][5-c]==1 &&current[c][5-c]==current[c+1][4-c]&&current[c][5-c]==current[c+2][3-c]&&current[c-1][6-c]==-1&&current[c+3][2-c]==0){ return (c+4);}
				 }
			 }
			 for(int c = 1; c<5;c++){
				 if(c == 1&&current[1][5]==1&&current[1][5]==current[2][4]&&current[2][4]==current[3][3]&&current[4][2]==0){return 5;}
				 else if(c == 4&&current[4][2]==1&&current[4][2]==current[5][1]&&current[5][1]==current[6][0]&&current[3][3]==0){return 4;}
				 else if(c ==3 || c==2){ 
				 	if(current[c][6-c]==1 &&current[c][6-c]==current[c+1][5-c]&&current[c][6-c]==current[c+2][4-c]&&current[c-1][7-c]==0){return c;}
				 	else if(current[c][5-c]==1 &&current[c][5-c]==current[c+1][4-c]&&current[c][5-c]==current[c+2][3-c]&&current[c-1][6-c]==-1&&current[c+3][2-c]==0){ return (c+4);}
				 }
			 }
			 
			 //check "\"
			 if(current[0][2] ==1 && current[0][2] == current[1][3] && current[1][3]==current[2][4] && current[3][5] == 0){return 4;}
			 if(current[0][2] ==0 && current[2][4] == current[1][3] && current[2][4]==current[3][5] && current[3][5] == 1){return 1;}
			 if(current[0][1] ==1 && current[0][1] == current[1][2] && current[1][2]==current[2][3] && current[3][4] == 0){return 4;}
			 if(current[1][2] ==0 && current[2][3] == current[3][4] && current[3][4]==current[4][5] && current[3][4] == 1){return 2;}
			 if(current[4][5] ==-1 && current[1][2] == current[2][3] && current[3][4]==current[2][3] && current[3][4] == 1 && current[0][1] ==0){return 1;}
			 if(current[4][5] ==0 && current[1][2] == current[2][3] && current[2][3]==current[3][4] && current[3][4] == 1){return 5;}
			 if(current[3][0] ==1 && current[3][0] == current[4][1] && current[4][1]==current[5][2] && current[6][3] == 0){return 7;}
			 if(current[3][0] ==0 && current[4][1] == current[5][2] && current[5][2]==current[6][3] && current[6][3] == 1){return 4;}
			 if(current[6][4] ==-1 && current[3][1] == current[4][2] && current[4][2]==current[5][3] && current[5][3] == 1 && current[2][0] ==0){return 3;}
			 if(current[6][4] ==0 && current[3][1] == current[4][2] && current[4][2]==current[5][3] && current[5][3] == 1){return 7;}
			 if(current[6][4] ==1 && current[6][4] == current[5][3] && current[5][3]==current[4][2] && current[3][1] == 0){return 4;}
			 if(current[5][3] ==0 && current[2][0] == current[3][1] && current[3][1]==current[4][2] && current[4][2] == 1){return 6;}
			 for(int c = 0; c<4;c++){
				 if(c == 0&&current[0][0]==1&&current[0][0]==current[1][1]&&current[1][1]==current[2][2]&&current[3][3]==0){return 4;}
				 else if(c == 3&&current[3][3]==1&&current[3][3]==current[4][4]&&current[4][4]==current[5][5]&&current[2][2]==0){return 3;}
				 else if(c ==1 || c==2){ 
				 	if(current[c][c]==1 &&current[c+1][c+1]==current[c][c]&&current[c+2][c+2]==current[c][c]&&current[c+3][c+3]==0){return (c+4);}
				 	else if(current[c][c]==1 &&current[c+1][c+1]==current[c][c]&&current[c+2][c+2]==current[c][c]&&current[c+3][c+3]==-1&&current[c-1][c-1]==0){return c;}
				 }
			 }
			 for(int c = 1; c<5;c++){
				 if(c == 1&&current[1][0]==1&&current[1][0]==current[2][1]&&current[2][1]==current[3][2]&&current[4][3]==0){return 5;}
				 else if(c == 4&&current[4][3]==1&&current[4][3]==current[5][4]&&current[5][4]==current[6][5]&&current[3][2]==0){return 4;}
				 else if(c ==3 || c==2){ 
				 	if(current[c][c-1]==1 &&current[c][c-1]==current[c+1][c]&&current[c][c-1]==current[c+2][c+1]&&current[c+3][c+2]==0){return (c+4);}
				 	else if(current[c][c-1]==1 &&current[c][c-1]==current[c+1][c]&&current[c][c-1]==current[c+2][c+1]&&current[c+3][c+2]==-1&&current[c-1][c-2]==0){return c;}
				 }
			 }
			 */
			 //basic strategy
			 for(int c = 0; c < 7; c++){
					if(current[c][5] ==0){return (c+1);}
					if (current[c][5] !=0 && current[c][4] ==0){return (c+1);}
					if (current[c][5] !=0 && current[c][4] !=0 &&current[c][3] ==0){return (c+1);}
					if (current[c][5] !=0 && current[c][4] !=0 &&current[c][3] == -1 && current[c][2]==0){return (c+1);}
					if (current[c][5] !=0 && current[c][4] !=0 &&current[c][3] == -1 && current[c][2]==-1 && current[c][1] ==0){return (c+1);}
					if (current[c][5] !=0 && current[c][4] !=0 &&current[c][3] == -1 && current[c][2]==-1 && current[c][1] ==-1 && current[c][0]==0){return (c+1);}				 
				 }	 
			
		}
		
		return 0;
	}

	@Override
	public String getName() {
		String name = "Zhengyang Qi’s AI";
		return name;
	}

}
