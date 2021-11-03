package aplicaciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Lanza entre 10 y 20 procesos "cadenas", preguntando por entrada estandar
 * cuantos procesos exactos quiere lanzar.
 * 
 * @author Manu Fdez H
 *
 */
public class generador {

	public static void main(String[] args) {

		InputStreamReader input = new InputStreamReader(System.in);

		BufferedReader bufferInput = new BufferedReader(input);
		boolean badInput = false;
		int numInstancias = 0;
		int numCadenas = 0;
		do {
			try {
				System.out.print("Cuantos procesos cadenas quieres? (entre 10 y 20) ");
				numInstancias = Integer.parseInt(bufferInput.readLine());
				if (numInstancias < 10)
					numInstancias = 10;
				if (numInstancias > 20)
					numInstancias = 20;

				System.out.print("Cuantas cadenas por proceso? ");
				numCadenas = Integer.parseInt(bufferInput.readLine());
				badInput = false;

			} catch (NumberFormatException | IOException e1) {
				badInput = true;
				System.err.println();
				System.err.println("DEBE SER UN NUMERO");
			}
		} while (badInput);
		for (int i = 0; i < numInstancias; i++) {
			try {

				Process p = Runtime.getRuntime().exec("javac -cp src src\\aplicaciones\\cadenas.java");
				p = Runtime.getRuntime().exec("java -cp src aplicaciones/cadenas");

				Writer w = new OutputStreamWriter(p.getOutputStream(), "UTF-8");
				w.write(String.valueOf(numCadenas));
				w.close();

				BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()));
				output.lines().forEach(System.out::println);

			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

	}

}
