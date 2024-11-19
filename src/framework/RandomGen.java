package framework;

import java.util.Random;

public class RandomGen {
	private RandomGen() {
	}

	private static RandomGen instance = new RandomGen();

	public static RandomGen getInstance() {
		return instance;
	}

	private Random ran = new Random();

	public int get(int length) {
		return ran.nextInt(length);
	}

	public int get(int start, int end) {
		return ran.nextInt(end - start + 1) + start;
	}
}
