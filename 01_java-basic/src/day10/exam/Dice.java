package day10.exam;

import java.util.Random;

public class Dice implements Game{
	private Random r = null;
	public Dice() {
		r = new Random();
	}
	@Override
	public int startGame(int you) {
		int me = r.nextInt(6) + 1;
		String result = null;
		if(me == you)
			result = WIN;
		else
			result = LOSE;
		
		return result.compareTo(WIN) == 0 ? 1 : 0;
	}

}
