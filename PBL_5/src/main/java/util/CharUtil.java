package util;

public class CharUtil {
	public static String replaceCommaAtEnd(String str) {

		if (str != null && !str.isEmpty() && str.charAt(str.length() - 1) == ',') {

			return str.substring(0, str.length() - 1) + ".";
		}
		return str;
	}
}
