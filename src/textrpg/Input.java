package textrpg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input {
	private Input() {
	}

	private static Input instance = new Input();

	public static Input getInstance() {
		return instance;
	}

	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	private Output out = Output.getInstance();

	public String input() {
		try {
			out.inputColor();
			String input = bufferedReader.readLine();
			out.resetColor();
			return input;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String input(String msg) {
		out.print(msg + " : ");
		return input();
	}

	public int input(String msg, int defaultNum) {
		try {
			int num = Integer.parseInt(input());
			return num;
		} catch (Exception e) {
			out.add("숫자만 입력가능.", IndexColor.RED);
			;
		}
		return defaultNum;
	}
}
