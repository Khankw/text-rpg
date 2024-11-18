package textrpg;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Output {
	private Output() {
	}

	private static Output instance = new Output();

	public static Output getInstance() {
		return instance;
	}

	private final String ESCAPE = "\033[";
	private final int FGCOLOR = 3;
	private final int FGBLIGHT = 9;
	private final int BGCOLOR = 4;
	private final int BGBLIGHT = 10;
	private final String RGB = "8;2;";
	private final String END = "m";
	private final String RESET = "\033[0m";

	private BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
	private StringBuffer str = new StringBuffer();

	public void add(String msg) {
		str.append(msg);
	}

	public void add(int num) {
		str.append(num);
	}

	public void add(String msg, IndexColor color) {
		addColor(color);
		str.append(msg);
	}

	public void add(int num, IndexColor color) {
		addColor(color);
		str.append(num);
	}

	public void add(String msg, IndexColor fColor, IndexColor bColor) {
		addColor(fColor, bColor);
		str.append(msg);
	}

	public void add(int num, IndexColor fColor, IndexColor bColor) {
		addColor(fColor, bColor);
		str.append(num);
	}

	public void add(String msg, int r, int g, int b) {
		addColor(r, g, b);
		str.append(msg);
	}

	public void add(int num, int r, int g, int b) {
		addColor(r, g, b);
		str.append(num);
	}

	public void add(String msg, int fR, int fG, int fB, int bR, int bG, int bB) {
		addColor(fR, fG, fB, bR, bG, bB);
		str.append(msg);
	}

	public void add(int num, int fR, int fG, int fB, int bR, int bG, int bB) {
		addColor(fR, fG, fB, bR, bG, bB);
		str.append(num);
	}

	public void addReset(String msg, IndexColor color) {
		add(msg, color);
	}

	public void addReset(int num, IndexColor color) {
		add(num, color);
	}

	public void addReset(String msg, IndexColor fColor, IndexColor bColor) {
		add(msg, fColor, bColor);
		resetColor();
	}

	public void addReset(int num, IndexColor fColor, IndexColor bColor) {
		add(num, fColor, bColor);
		resetColor();
	}

	public void addReset(String msg, int r, int g, int b) {
		add(msg, r, g, b);
		resetColor();
	}

	public void addReset(int num, int r, int g, int b) {
		add(num, r, g, b);
		resetColor();
	}

	public void addReset(String msg, int fR, int fG, int fB, int bR, int bG, int bB) {
		add(msg, fR, fG, fB, bR, bG, bB);
		resetColor();
	}

	public void addReset(int num, int fR, int fG, int fB, int bR, int bG, int bB) {
		add(num, fR, fG, fB, bR, bG, bB);
		resetColor();
	}

	public void addColor(IndexColor color) {
		str.append(ESCAPE);
		if (color.ordinal() < 8) {
			str.append(FGCOLOR);
		} else {
			str.append(FGBLIGHT);
		}
		str.append(color.ordinal() % 8);
		str.append(END);
	}

	public void addColor(IndexColor fColor, IndexColor bColor) {
		str.append(ESCAPE);
		if (fColor.ordinal() < 8) {
			str.append(FGCOLOR);
		} else {
			str.append(FGBLIGHT);
		}
		str.append(fColor.ordinal() % 8);
		str.append(";");
		if (bColor.ordinal() < 8) {
			str.append(BGCOLOR);
		} else {
			str.append(BGBLIGHT);
		}
		str.append(bColor.ordinal() % 8);
		str.append(END);
	}

	public void addColor(int r, int g, int b) {
		str.append(ESCAPE);
		str.append(FGCOLOR);
		str.append(RGB);
		str.append(r);
		str.append(";");
		str.append(g);
		str.append(";");
		str.append(b);
		str.append(END);
	}

	public void addColor(int fR, int fG, int fB, int bR, int bG, int bB) {
		str.append(ESCAPE);
		str.append(FGCOLOR);
		str.append(RGB);
		str.append(fR);
		str.append(";");
		str.append(fG);
		str.append(";");
		str.append(fB);
		str.append(";");
		str.append(BGCOLOR);
		str.append(RGB);
		str.append(bR);
		str.append(";");
		str.append(bG);
		str.append(";");
		str.append(bB);
		str.append(END);
	}

	public void inputColor() {
		resetColor();
		str.append(ESCAPE);
		str.append(FGCOLOR);
		str.append(RGB);
		str.append("0;200;125");
		str.append(END);
		print();
	}

	public void resetColor() {
		str.append(RESET);
	}

	public void addLine() {
		str.append("\n");
	}

	public void print(String msg) {
		str.append(msg);
		print();
	}

	public void print(int num) {
		str.append(num);
		print();
	}

	public void println() {
		str.append("\n");
		print();
	}

	public void println(String msg) {
		str.append(msg);
		str.append("\n");
		print();
	}

	public void println(int num) {
		str.append(num);
		str.append("\n");
		print();
	}

	public void print() {
		try {
			bufferedWriter.append(str);
			str.setLength(0);
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
