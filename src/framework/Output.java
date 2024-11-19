package framework;

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

	public Output add(Object obj) {
		str.append(obj.toString());
		return this;
	}

	public Output add(Object obj, IndexColor color) {
		addColor(color);
		str.append(obj.toString());
		return this;
	}

	public Output add(Object obj, IndexColor fColor, IndexColor bColor) {
		addColor(fColor, bColor);
		str.append(obj.toString());
		return this;
	}

	public Output add(Object obj, int r, int g, int b) {
		addColor(r, g, b);
		str.append(obj.toString());
		return this;
	}

	public Output add(Object obj, int fR, int fG, int fB, int bR, int bG, int bB) {
		addColor(fR, fG, fB, bR, bG, bB);
		str.append(obj.toString());
		return this;
	}

	public Output addReset(Object obj, IndexColor color) {
		add(obj, color);
		resetColor();
		return this;
	}

	public Output addReset(Object obj, IndexColor fColor, IndexColor bColor) {
		add(obj, fColor, bColor);
		resetColor();
		return this;
	}

	public Output addReset(Object obj, int r, int g, int b) {
		add(obj, r, g, b);
		resetColor();
		return this;
	}

	public Output addReset(Object obj, int fR, int fG, int fB, int bR, int bG, int bB) {
		add(obj, fR, fG, fB, bR, bG, bB);
		resetColor();
		return this;
	}

	public Output addColor(IndexColor color) {
		str.append(ESCAPE);
		if (color.ordinal() < 8) {
			str.append(FGCOLOR);
		} else {
			str.append(FGBLIGHT);
		}
		str.append(color.ordinal() % 8).append(END);
		return this;
	}

	public Output addColor(IndexColor fColor, IndexColor bColor) {
		str.append(ESCAPE);
		if (fColor.ordinal() < 8) {
			str.append(FGCOLOR);
		} else {
			str.append(FGBLIGHT);
		}
		str.append(fColor.ordinal() % 8).append(";");
		if (bColor.ordinal() < 8) {
			str.append(BGCOLOR);
		} else {
			str.append(BGBLIGHT);
		}
		str.append(bColor.ordinal() % 8).append(END);
		return this;
	}

	public Output addColor(int r, int g, int b) {
		str.append(ESCAPE).append(FGCOLOR).append(RGB);
		str.append(r).append(";").append(g).append(";").append(b).append(END);
		return this;
	}

	public Output addColor(int fR, int fG, int fB, int bR, int bG, int bB) {
		str.append(ESCAPE).append(FGCOLOR).append(RGB);
		str.append(fR).append(";").append(fG).append(";").append(fB).append(";");
		str.append(BGCOLOR).append(RGB);
		str.append(bR).append(";").append(bG).append(";").append(bB).append(END);
		return this;
	}

	public Output resetColor() {
		str.append(RESET);
		return this;
	}

	public Output addLine() {
		str.append("\n");
		return this;
	}

	public void inputColor() {
		resetColor();
		str.append(ESCAPE).append(FGCOLOR).append(RGB);
		str.append("0;200;125").append(END);
		print();
	}

	public Output print(String msg) {
		str.append(msg);
		print();
		return this;
	}

	public Output print(int num) {
		str.append(num);
		print();
		return this;
	}

	public Output println() {
		str.append("\n");
		print();
		return this;
	}

	public Output println(Object obj) {
		str.append(obj.toString()).append("\n");
		print();
		return this;
	}

	public void printErr(Object obj) {
		add(obj, IndexColor.RED);
		resetColor();
		print();
	}

	public void printErrln(Object obj) {
		add(obj, IndexColor.RED);
		resetColor();
		println();
	}

	public Output print() {
		try {
			bufferedWriter.append(str);
			str.setLength(0);
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}

	@Override
	public String toString() {
		return str.toString();
	}
}
