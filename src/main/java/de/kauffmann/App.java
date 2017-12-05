package de.kauffmann;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Das ist die Klasse app
 */
public class App 
{
	/**
	 * Kommentare
	 */
    public static void main( String[] args )
    {
    	BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String s = keyboard.readLine();
			
			System.out.println(s.toUpperCase());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
