package utils;

import java.text.DecimalFormat;

public class Utils {
	
	private static final String PONTO =".";
	private static final String VIRGULA = ",";

	public static Double readableFileSize(Long size) {
	    if(size <= 0) return 0D;
	    int digitGroups = (int) (Math.log10(size)/Math.log10(1024));
	    String formatado = new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups));
	    return Double.parseDouble(formatado.replaceAll(VIRGULA, PONTO));
	}

}
