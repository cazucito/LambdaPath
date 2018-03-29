package poc.util;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Utilería para la impresión de mensajes
 * 
 * @author cazucito
 *
 */
public class Impresor {

	private final static String formatoEncabezado = "||:::::::|%70s ||%n||:::::::|%70s ||%n||:::::::|%70s ||%n";
	private final static String formatoPie = "||:::::::|%70s ||%n||:::::::|%70s ||%n||:::::::|%70s ||%n";
	private final static String formatoTitulo = "||:::::::| :::::::::::::::%54s ||%n";
	private final static String formatoSubtitulo = "         | ---------------%54s  |%n";
	private final static String formatoMensaje = "         | %-70s |%n";
	private final static String formatoInfo = "     info| %-70s |%n";
	private final static String formatoErrorLogico = "      bug| %-70s |%n";
	private final static String formatoMensajeOK = "       ok| %-70s |%n";
	private final static String formatoExcepcion = "       ex| %-70s |%n";
	private final static String formatoError = "    error| %-70s |%n";
	private final static String formatoDepuracion = "    debug| %-70s |%n";
	private static boolean depuracion = false;

	/**
	 * Habilita mensajes de depuración
	 */
	public static void habilitaDepuracion() {
		Impresor.depuracion = true;
	}

	/**
	 * Deshabilita mensajes de depuración
	 */
	public static void deshabilitaDepuracion() {
		Impresor.depuracion = false;
	}

	/**
	 * Bandera para indicar está en modo de depuración
	 * 
	 * @return
	 */
	public static boolean isDepuracion() {
		return depuracion;
	}

	/**
	 * Imprime una colección de referencias a objetos tipo String
	 * 
	 * @param coleccion
	 *            La colección a imprimir
	 */
	public static void imprime(Collection<String> coleccion) {
		StringBuilder sb = new StringBuilder();
		try {
			sb.append("<");
			for (String str : coleccion) {
				sb.append(" " + str);
				Temporizador.pausar(100);
			}
			sb.append(" >");
		} catch (Exception ex) {
			Impresor.muestraEnConsola(TipoMensajes.EXCEPCION, ex.toString());
		} finally {
			Impresor.muestraEnConsola(TipoMensajes.DEPURACION, "finally: " + sb.toString());
		}
	}

	/**
	 * Imprime un mapa de Integer / String
	 * 
	 * @param mapa
	 *            El mapa a imprimir
	 */
	public static void imprime(Map<Integer, String> mapa) {
		StringBuilder sb = new StringBuilder();
		try {
			sb.append("<");
			for (Integer k : mapa.keySet()) {
				sb.append(" " + k + "/" + mapa.get(k));
				Temporizador.pausar(100);
			}
			sb.append(" >");
		} catch (Exception ex) {
			Impresor.muestraEnConsola(TipoMensajes.EXCEPCION, ex.toString());
		} finally {
			Impresor.muestraEnConsola(TipoMensajes.DEPURACION, "finally: " + sb.toString());
		}
	}

	/**
	 * 
	 */
	public static void muestraEnConsola(TipoMensajes _tipoMensaje, String... mensajes) {
		String tipoMensaje = "";
		List<String> msj = new ArrayList<String>(Arrays.asList(mensajes));
		switch (_tipoMensaje) {
		case ENCABEZADO:
			msj.add(0, "=====================================================================");
			msj.add("---------------------------------------------------------------------");
			tipoMensaje = formatoEncabezado;
			break;
		case PIE:
			msj.add("=====================================================================");
			msj.add(0, "---------------------------------------------------------------------");
			msj.set(1, "Java " + System.getProperty("java.version") + " | " + LocalDate.now().getYear());
			tipoMensaje = formatoPie;
			break;
		case TITULO:
			tipoMensaje = formatoTitulo;
			break;
		case SUBTITULO:
			tipoMensaje = formatoSubtitulo;
			break;
		case MENSAJE:
			tipoMensaje = formatoMensaje;
			break;
		case MENSAJE_OK:
			tipoMensaje = formatoMensajeOK;
			break;
		case INFO:
			tipoMensaje = formatoInfo;
			break;
		case ERROR_LOGICO:
			StringBuilder sb = new StringBuilder(Thread.currentThread().getName());
			sb.append("> ");
			sb.append(msj.get(0));
			msj.set(0, sb.toString());
			tipoMensaje = formatoErrorLogico;
			break;
		case EXCEPCION:
			sb = new StringBuilder(Thread.currentThread().getName());
			sb.append("> ");
			sb.append(msj.get(0));
			msj.set(0, sb.toString());
			tipoMensaje = formatoExcepcion;
			break;
		case ERROR:
			sb = new StringBuilder(Thread.currentThread().getName());
			sb.append("> ");
			sb.append(msj.get(0));
			msj.set(0, sb.toString());
			tipoMensaje = formatoError;
			break;
		case DEPURACION:
			sb = new StringBuilder(Thread.currentThread().getName());
			sb.append("> ");
			StringBuilder strCol = new StringBuilder("");
			if (msj.get(0).length() > 50) {
				strCol.append((msj.get(0)).substring(0, 48)).append(" ...");
				sb.append(strCol);
			} else {
				sb.append(msj.get(0));
			}
			msj.set(0, (sb.toString()));
			tipoMensaje = formatoDepuracion;
			if (!depuracion) {
				return;
			}
			break;
		}
		System.out.format(tipoMensaje, msj.toArray());
	}
}
