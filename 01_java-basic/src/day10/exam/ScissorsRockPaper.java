package day10.exam;

import java.util.Random;

public class ScissorsRockPaper implements Game {
	final static int SCISSOR = 1;
	final static int ROCK = 2;
	final static int PAPER = 3;

	private Random r = null;

	public ScissorsRockPaper() {
		r = new Random();
	}

	@Override
	public int startGame(int you) {
		int me = r.nextInt(3) + 1;
		String result = null;
		switch (you) {
		case SCISSOR:
			if (me == you)
				result = TIE;
			else if (me == ROCK)
				result = WIN;
			else
				result = LOSE;
			break;
		case ROCK:
			if (me == you)
				result = TIE;
			else if (me == SCISSOR)
				result = LOSE;
			else
				result = WIN;
			break;
		case PAPER:
			if (me == you)
				result = TIE;
			else if (me == ROCK)
				result = LOSE;
			else
				result = WIN;
			break;
		default:
			System.out.println("이상한것 내지 마세요");
			break;
		}

		return result.compareTo(WIN) == 0 ? 1 : 0;
	}

}
