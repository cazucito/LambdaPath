package poc.util;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Utility class for formatted console output.
 *
 * @author cazucito
 */
public class Printer {

	private final static String fmtHeader  = "||:::::::|%70s ||%n||:::::::|%70s ||%n||:::::::|%70s ||%n";
	private final static String fmtFooter  = "||:::::::|%70s ||%n||:::::::|%70s ||%n||:::::::|%70s ||%n";
	private final static String fmtTitle   = "||:::::::| :::::::::::::::%54s ||%n";
	private final static String fmtSubtitle = "         | ---------------%54s  |%n";
	private final static String fmtMessage  = "         | %-70s |%n";
	private final static String fmtInfo     = "     info| %-70s |%n";
	private final static String fmtLogicError = "      bug| %-70s |%n";
	private final static String fmtMessageOk  = "       ok| %-70s |%n";
	private final static String fmtException  = "       ex| %-70s |%n";
	private final static String fmtError      = "    error| %-70s |%n";
	private final static String fmtDebug      = "    debug| %-70s |%n";
	private static boolean debug = false;

	/**
	 * Enables debug output.
	 */
	public static void enableDebug() {
		Printer.debug = true;
	}

	/**
	 * Disables debug output.
	 */
	public static void disableDebug() {
		Printer.debug = false;
	}

	/**
	 * Returns whether debug mode is enabled.
	 *
	 * @return true if debug is enabled
	 */
	public static boolean isDebugEnabled() {
		return debug;
	}

	/**
	 * Prints a collection of strings.
	 *
	 * @param collection the collection to print
	 */
	public static void print(Collection<String> collection) {
		StringBuilder sb = new StringBuilder();
		try {
			sb.append("<");
			for (String str : collection) {
				sb.append(" " + str);
				Timer.pause(100);
			}
			sb.append(" >");
		} catch (Exception ex) {
			Printer.print(MessageType.EXCEPTION, ex.toString());
		} finally {
			Printer.print(MessageType.DEBUG, "finally: " + sb.toString());
		}
	}

	/**
	 * Prints an Integer/String map.
	 *
	 * @param map the map to print
	 */
	public static void print(Map<Integer, String> map) {
		StringBuilder sb = new StringBuilder();
		try {
			sb.append("<");
			for (Integer k : map.keySet()) {
				sb.append(" " + k + "/" + map.get(k));
				Timer.pause(100);
			}
			sb.append(" >");
		} catch (Exception ex) {
			Printer.print(MessageType.EXCEPTION, ex.toString());
		} finally {
			Printer.print(MessageType.DEBUG, "finally: " + sb.toString());
		}
	}

	/**
	 * Prints a formatted message to the console.
	 *
	 * @param type     message type
	 * @param messages message content
	 */
	public static void print(MessageType type, String... messages) {
		String fmt = "";
		List<String> msg = new ArrayList<String>(Arrays.asList(messages));
		switch (type) {
		case HEADER:
			msg.add(0, "=====================================================================");
			msg.add("---------------------------------------------------------------------");
			fmt = fmtHeader;
			break;
		case FOOTER:
			msg.add("=====================================================================");
			msg.add(0, "---------------------------------------------------------------------");
			msg.set(1, "Java " + System.getProperty("java.version") + " | " + LocalDate.now().getYear());
			fmt = fmtFooter;
			break;
		case TITLE:
			fmt = fmtTitle;
			break;
		case SUBTITLE:
			fmt = fmtSubtitle;
			break;
		case MESSAGE:
			fmt = fmtMessage;
			break;
		case MESSAGE_OK:
			fmt = fmtMessageOk;
			break;
		case INFO:
			fmt = fmtInfo;
			break;
		case LOGIC_ERROR:
			StringBuilder sb = new StringBuilder(Thread.currentThread().getName());
			sb.append("> ");
			sb.append(msg.get(0));
			msg.set(0, sb.toString());
			fmt = fmtLogicError;
			break;
		case EXCEPTION:
			sb = new StringBuilder(Thread.currentThread().getName());
			sb.append("> ");
			sb.append(msg.get(0));
			msg.set(0, sb.toString());
			fmt = fmtException;
			break;
		case ERROR:
			sb = new StringBuilder(Thread.currentThread().getName());
			sb.append("> ");
			sb.append(msg.get(0));
			msg.set(0, sb.toString());
			fmt = fmtError;
			break;
		case DEBUG:
			sb = new StringBuilder(Thread.currentThread().getName());
			sb.append("> ");
			StringBuilder truncated = new StringBuilder("");
			if (msg.get(0).length() > 50) {
				truncated.append((msg.get(0)).substring(0, 48)).append(" ...");
				sb.append(truncated);
			} else {
				sb.append(msg.get(0));
			}
			msg.set(0, (sb.toString()));
			fmt = fmtDebug;
			if (!debug) {
				return;
			}
			break;
		}
		System.out.format(fmt, msg.toArray());
	}
}
