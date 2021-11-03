package aplicaciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Aplicación que genera cadenas de caracteres aleatorios, con una longuitud
 * maxima de 20 caracteres.
 * 
 * @author Manu Fdez H
 *
 */
public class cadenas {

	public static void main(String[] args) {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader bufferInput = new BufferedReader(input);
		boolean badInput = false;
		
		int numCadenas = 1;
		do {
			try {
				numCadenas = Integer.parseInt(bufferInput.readLine());
				badInput = false;
			} catch (NumberFormatException | IOException e) {
				badInput = true;
				System.err.println("ERROR: introduce un numero entero");
			}
		} while (badInput);
		
		char[] abc = "abcdefghijklmnopqerstuvwxyz".toCharArray();
		int abcLen = abc.length;
		Random rand = new Random();
		for (int i = 0; i < numCadenas; i++) {

			int len = rand.nextInt(20);
			String out = "";
			for (int j = 0; j < len; j++) {
				int pos = rand.nextInt(abcLen);
				out += String.valueOf(abc[pos]);
			}
			System.out.println(out);

		}

	}
}
