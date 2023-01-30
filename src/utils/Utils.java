package utils;

public class Utils {

	public static String applicationName() {
		StackTraceElement[] stackTraceElements = new Exception().getStackTrace();
		return stackTraceElements[0].getModuleName().replaceAll("\\..*", "");
	}
}
