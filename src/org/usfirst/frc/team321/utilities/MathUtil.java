package org.usfirst.frc.team321.utilities;

public class MathUtil {
	
	/**
	 * Keeps a number in a clamp of a set minimum and set maximum
	 * 
	 * <p>If a number is above a set maximum, it returns the maximum.
	 * <p>If a number is below a set minimum, it returns the minimum.
	 * <p>If a number is between the minimum and maximum, it returns the number.
	 * 
	 * @param val  a number being checked
	 * @param min  the minimum number of the clamp
	 * @param max  the maximum number of the clamp
	 * @return     a number depending on whether it falls between the clamp
	 */
	public static <T extends Comparable<T>> T clamp(T val, T min, T max) {
		if (val.compareTo(min) < 0) {
		    return min;
		} else if (val.compareTo(max) > 0) {
		    return max;
		} else {
		    return val;
		}
	}
	
	/**
	 * Returns the square root of a number.
	 * 
	 * <p>If the number is negative, it will get the square root
	 * of the positive number multiplied with a negative sign.
	 * 
	 * @param num  the number being square rooted
	 * @return     the square root of a number with its sign
	 */
	public static double sqrtKeepSign(double num) {
		if (num < 0) {
			return -Math.sqrt(Math.abs(num));
		} else {
			return Math.sqrt(num);
		}
	}
	
	/**
	 * Returns a number squared.
	 * 
	 * <p>If the number is negative, it will return the number 
	 * squared multiplied by -1.
	 * 
	 * @param num  the number being squared
	 * @return     the number squared with its sign
	 */
	public static double squareKeepSign(double num) {
		if (num < 0) {
			return -num * num;
		} else {
			return num * num;
		}
	}
}