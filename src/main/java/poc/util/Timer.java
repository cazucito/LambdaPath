package poc.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Utility class for time-related operations.
 *
 * @author cazucito
 */
public class Timer {

	/**
	 * Pauses the current thread for the given number of milliseconds.
	 *
	 * @param milliseconds duration to pause
	 */
	public static void pause(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (Exception ex) {
			Printer.print(MessageType.EXCEPTION, ex.toString());
		}
	}

	/**
	 * Pauses the current thread for a random duration within the given range.
	 *
	 * @param msMin minimum milliseconds
	 * @param msMax maximum milliseconds
	 */
	public static void pause(int msMin, int msMax) {
		try {
			Thread.sleep(ThreadLocalRandom.current().nextInt(msMin, msMax));
		} catch (Exception ex) {
			Printer.print(MessageType.EXCEPTION, ex.toString());
		}
	}
}