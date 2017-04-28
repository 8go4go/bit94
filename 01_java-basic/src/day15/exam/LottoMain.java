package day15.exam;

import java.io.IOException;

public class LottoMain {
	public static void main(String[] args) throws IOException {
		LottoService l = new LottoService("data/lotto.txt");
		l.service();
	}
}
