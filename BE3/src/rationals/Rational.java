package rationals;

import java.util.Objects;

public class Rational {

	private int num;
	private int denom;

	public Rational(int num, int denom) {
		this.num = (int) num/gcd(num, denom);
		this.denom = (int) denom/gcd(num, denom);
	}

	public Rational(int nb) {
		this.num = nb;
		this.denom = 1;
	}

	public int getNum() {
		return num;
	}

	public int getDenom() {
		return denom;
	}

	@Override
	public String toString() {
		if (denom != 1) {
			return num + "/" + denom;
		} else {
			return num + "";
		}
	}

	/**
	 * Converts "1/3" or "4" to the corresponding rational.
	 */
	static public Rational parseRational(String s) {
		if (s.contains("/")) {
			String[] fraction = s.split("/");
			int num = Integer.parseInt(fraction[0]);
			int denom = Integer.parseInt(fraction[1]);
			return new Rational(num, denom);
		} else {
			int num = Integer.parseInt(s);
			return new Rational(num);
		}
	}

	private int gcd(int a, int b) {
		int t;
		while (b != 0) {
			t = b;
			b = a%b;
			a = t;
		}
		return a;
	}
}
