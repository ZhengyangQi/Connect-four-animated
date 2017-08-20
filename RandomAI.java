/*
 * hw4
 * Name: Zhengyang Qi
 * SID: 204296544
 */
import java.util.Random;

/*
 * Class to implement a AI that plays random column each step
 */
public class RandomAI implements CFAI {

	@Override
	public int nextMove(CFGame g) {
		//System.out.println("random work");
		int result = 0;
		int[][] current = g.getState();
		while(true){
			Random generator = new Random();
			int col = generator.nextInt(7);
			if(current[col][0] == 0){
				result = col + 1;
				break;
			}	
		}	
		return result;
	}

	@Override
	public String getName() {
		String name = "Random Player";
		return name;
	}

}
