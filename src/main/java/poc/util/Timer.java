package poc.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase de utilidad para operaciones relacionadas con el tiempo.
 *
 * @author cazucito
 */
public class Timer {

	/**
	 * Pausa el hilo actual durante el número de milisegundos indicado.
	 *
	 * @param milliseconds duración de la pausa en milisegundos
	 */
	public static void pause(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (Exception ex) {
			Printer.print(MessageType.EXCEPTION, ex.toString());
		}
	}

	/**
	 * Pausa el hilo actual durante un tiempo aleatorio dentro del rango indicado.
	 *
	 * @param msMin milisegundos mínimos de pausa
	 * @param msMax milisegundos máximos de pausa
	 */
	public static void pause(int msMin, int msMax) {
		try {
			Thread.sleep(ThreadLocalRandom.current().nextInt(msMin, msMax));
		} catch (Exception ex) {
			Printer.print(MessageType.EXCEPTION, ex.toString());
		}
	}
}