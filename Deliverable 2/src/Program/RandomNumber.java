package Program;

import java.util.Random;

/**
 *
 * @author Jingyi Lin (jil173)
 */

public class RandomNumber {
	public int seed;
	public int count;
	Random generator = new Random(seed);
        
	public RandomNumber(int seed, int count){
		this.seed = seed;
		this.count = count;
	}
	
        //  Generate random numbers.
	public int generateNumber(){
		return generator.nextInt(count);
	}
}
