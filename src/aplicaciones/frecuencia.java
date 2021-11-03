package aplicaciones;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Aplicación que dado un string recibido por su entrada estandar, cuenta la frecuencia de cada vocal
 * 
 * @author Manu Fdez H
 *
 */
public class frecuencia {

	public static void main(String[] args) {

		InputStreamReader input = new InputStreamReader(System.in);

		BufferedReader bufferInput = new BufferedReader(input);

		String cadenaRecibida = bufferInput.lines().reduce((l, a) -> l += a).get();

		char[] vocales = { 'a', 'e', 'i', 'o', 'u' };
		int[] frec = { 0, 0, 0, 0, 0 };

		char[] cadenaChars = cadenaRecibida.toCharArray();

		for (int i = 0; i < cadenaChars.length; i++) {
			for (int j = 0; j < vocales.length; j++) {

				if (cadenaChars[i] == vocales[j]) {
					frec[j]++;
					break;
				}
			}
		}

		System.out.println(Arrays.toString(frec));
	}

}
